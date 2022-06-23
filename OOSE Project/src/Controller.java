import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Controller {
	DecimalFormat df = new DecimalFormat("#0.00");   
	Screen_Login screenLogin = new Screen_Login();
	Screen_MainMenu screenMainMenu = new Screen_MainMenu();
	Screen_MedicalStore screenMedicalStore = new Screen_MedicalStore(); 
	Screen_PatientDetails screenPatientDetails = new Screen_PatientDetails();
	Screen_ManageAppointment screenManageAppointment = new Screen_ManageAppointment();
	Screen_Prescription screenPrescription = new Screen_Prescription(); 
	Screen_Payment screenPayment = new Screen_Payment(); 
	private ArrayList<String> doctorName = new ArrayList<>(Arrays.asList("Dr.Muhammad Ali"));
	Clinic clinic = new Clinic ("UKM Clinic Management System");
	
	//Login
	private String username;
	private String password;
	
	//Medical Store Management
	private String id;
	private String name;
	private int quantity;
	private String date;
	private String store;
	
	//Patient Details Management
	private String icNumber;
	private String patientName;
	private String address;
	private int age;
	private String gender;
	private String phoneNumber;
	
	//Appointment Management
	private String PatientName;
	private String DoctorName;
	private String Date ;
	private String Time ;
	private String Memo;
	
	//Prescription & Payment
	private Date datenow;
	
	private ArrayList<Medical>medicalList = clinic.getMedicalList();
	private ArrayList<Patient>patientList = clinic.getPatientList();
	private ArrayList<Appointment>appointmentList = clinic.getAppointmentList();
	private ArrayList<Doctor>doctorList = clinic.getDoctorList();
	private ArrayList<MedicationConsultant>medicationConsultantList = clinic.getMedicationConsultantList();
	private ArrayList<String> doctorNames = new ArrayList<String>();

	/*-------------------------Controller Constructor-------------------------*/
	public Controller(Screen_Login screenLogin) {
	      this.screenLogin = screenLogin;
	}
	public Controller(Screen_MainMenu screenMainMenu) {
	      this.screenMainMenu = screenMainMenu;
	}
	public Controller(Screen_MedicalStore screenMedicalStore) {
	      this.screenMedicalStore = screenMedicalStore;
	}
	public Controller(Screen_PatientDetails screenPatientDetails) {
	      this.screenPatientDetails = screenPatientDetails;
	}
	
	public Controller(Screen_ManageAppointment screenManageAppointment) {
	      this.screenManageAppointment = screenManageAppointment;
	}
	
	public Controller(Screen_Prescription screenPrescription) {
	      this.screenPrescription = screenPrescription;
	}
	
	public Controller(Screen_Payment screenPayment) {
	      this.screenPayment = screenPayment;
	}
	
	/*-------------------------Controller Constructor-------------------------*/

	
	/*----------------------------System Start End----------------------------*/
	//System Start
	public void SystemStart() {
		screenLogin.run(this);
	}
	//System End
	public void SystemEnd() {
		if (screenMainMenu.DisplayAskForLogout() == 0) {
			screenMainMenu.DisplaySuccessfulLogout();
			SystemStart();
		}
		
		else{
			screenMainMenu.DisplayFailLogout();
			screenMainMenu.run(this);
		}
	}
	/*----------------------------System Start End----------------------------*/
	
	
	/*----------------------------------Login----------------------------------*/
	//Login Check UserName and Password
	public void CheckUsernamePassword(String username, String password) {
		this.username = username;
		this.password = password;
		Nurse nurse = clinic.getNurse(username, password);
		
		if (nurse == null) {
			screenLogin.displayInvalidUsernamePassword();
		}
		else {
			screenLogin.displayWelcome(username, clinic.getName());
			screenMainMenu.run(this);
		}
	}
	/*----------------------------------Login----------------------------------*/
	
	
	/*-------------------------Medical Store Management------------------------*/
	//View Medical Store Management
	public void ViewMedicalStore() {
		screenMedicalStore.run(this);
	}
	//End Medical Store Management
	public void EndViewMedicalStore() {
		screenMedicalStore.EndViewMedicalStore();
		screenMedicalStore.dtm.setRowCount(0);
	}
	//Add New Medical
	public void AddNewItem(String id, String name,int quantity, String date, String store) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.store = store;
		
		if(id.equals("") || name.equals("") || date.equals("") || store.equals("")) {
			screenMedicalStore.DisplayFailAddNewItem();
		}
		else {
			screenMedicalStore.DisplaySuccessfulAddNewItem(id,name,quantity,date,store);
			clinic.addMedical(id,name,quantity,date,store);
		}
	}
	//Delete Medical
	public void DeleteItem(String id, String name,int quantity, String date, String store) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.store = store;
		int i=-1;
		i = screenMedicalStore.table.getSelectedRow();
		
		if(id.equals("") || name.equals("") || date.equals("") || store.equals("")) {
			screenMedicalStore.DisplayFailSelectItem() ;
		}
		
		else if(screenMedicalStore.DisplayAskForDeleteItem() == 0) {
			Medical medical = clinic.getMedical(id,name,quantity,date,store);
			
			if(i!=-1) {
				if(medical==null) {
					screenMedicalStore.DisplayFailDeleteItem() ;
				}
				else {
					screenMedicalStore.DisplaySuccessfulDeleteItem();
					clinic.removeMedical(i);
					screenMedicalStore.dtm.removeRow(i);
				}
			}
			else {
				screenMedicalStore.DisplayFailSelectItem() ;
			}
		}
		else {
			screenMedicalStore.DisplayCancelDeleteItem() ;
			screenMedicalStore.run(this);
		}
	}
	//Update Medical
	public void UpdateItem(String id, String name,int quantity, String date, String store) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.store = store;
		int i=-1;
		i = screenMedicalStore.table.getSelectedRow();
		
		if(id.equals("") || name.equals("") || date.equals("") || store.equals("")) {
			screenMedicalStore.DisplayFailSelectItem() ;
		}
		
		else if(screenMedicalStore.DisplayAskForUpdateItem() == 0) {
			if(i!=-1) {
				screenMedicalStore.DisplaySuccessfulUpdateItem();
				clinic.updateMedical(i,id,name,quantity,date,store);
			}
			else {
				screenMedicalStore.DisplayFailSelectItem() ;
			}
		}
		else {
			screenMedicalStore.DisplayCancelUpdateItem() ;
			screenMedicalStore.run(this);
		}
	}
	//Add Medical List into JTable
	public void ViewMedicalJtable() {
		for(int i=0;i<medicalList.size();i++) {
			Object[]a = {medicalList.get(i).getID(),medicalList.get(i).getName(), medicalList.get(i).getQuantity(), medicalList.get(i).getDate(),medicalList.get(i).getStore()};
			screenMedicalStore.dtm.addRow(a);
		}
	}
	//Clear Medical Store Management System Text Box
	public void ClearMedicalTextBox() {
		screenMedicalStore.clear();
	}
	/*-------------------------Medical Store Management------------------------*/
	
	
	/*------------------------Patient Details Management-----------------------*/
	//View Patient Details Management
	public void ViewPatientDetails() {
		screenPatientDetails.run(this);
	}
	//End Patient Details Management
	public void EndViewPatientDetails() {
		screenPatientDetails.EndPatientDetails() ;
		screenPatientDetails.dtm.setRowCount(0);
	}
	//Add New Patient
	public void AddNewPatient(String icNumber,String patientName,String address,int age,String gender,String phoneNumber) {
		this.icNumber = icNumber;
		this.patientName = patientName;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		
		if(icNumber.equals("") || patientName.equals("") || address.equals("") || gender.equals("") || phoneNumber.equals("")) {
			screenPatientDetails.DisplayFailAddNewPatient();
		}
		else {
			screenPatientDetails.DisplaySuccessfulAddNewPatient();
			clinic.addPatient(icNumber,patientName,address,age,gender,phoneNumber);
		}
	}
	//Add Patient List into JTable
	public void ViewPatientJtable() {
		for(int i=0;i<patientList.size();i++) {
			Object[]b = {patientList.get(i).getICNumber(),patientList.get(i).getName(), patientList.get(i).getAddress(), patientList.get(i).getAge(),patientList.get(i).getGender(), patientList.get(i).getPhoneNumber()};
			screenPatientDetails.dtm.addRow(b);
		}
	}
	//Clear Patient Details Management System Text Box
	public void ClearPatientTextBox() {
		screenPatientDetails.clear();
	}
	/*------------------------Patient Details Management-----------------------*/
	
	
	/*------------------------Appointment Management-----------------------*/
	//View Appointment Management
	public void ViewAppointmentManagement() {
		screenManageAppointment.run(this);
	}
	//End Appointment Management
	public void EndViewAppointmentManagement() {
		screenManageAppointment.EndAppointmentManagement() ;
		screenManageAppointment.dtm.setRowCount(0);
	}
	//Add New Appointment
	public void AddNewAppointment(String PatientName, String DoctorName, String Date, String Time, String Memo) {
		this.PatientName = PatientName;
    	this.DoctorName = DoctorName;
    	this.Date = Date;
    	this.Time = Time;
    	this.Memo = Memo;
		
		if(PatientName.equals("") || DoctorName.equals("") || Date.equals("") || Time.equals("") || Memo.equals("")) {
			screenManageAppointment.DisplayFailAddNewAppointment();
		}
		else {
			Appointment appointment = clinic.getAppointment(PatientName, DoctorName, Date, Time, Memo);
			if(appointment != null) {
				screenManageAppointment.DisplayExistAppointment();
			}
			
			else {
				screenManageAppointment.DisplaySuccessfulAddNewAppointment();
				clinic.addAppointment(PatientName, DoctorName, Date, Time, Memo);
			}
		}
	}
	//Add Appointment List into JTable
	public void ViewAppointmentJtable() {
		for(int i=0;i<appointmentList.size();i++) {
			Object[]b = {appointmentList.get(i).getPatientName(),appointmentList.get(i).getDoctorName(), appointmentList.get(i).getDate(), appointmentList.get(i).getTime(),appointmentList.get(i).getMemo()};
			screenManageAppointment.dtm.addRow(b);
		}
	}
	//Clear Appointment Management System Text Box
	public void ClearAppointmentTextBox() {
		screenManageAppointment.clear();
	}
	/*------------------------Appointment Management-----------------------*/
	
	
	/*---------------------------Prescription--------------------------*/
	//Get Doctor Name
	public ArrayList<String> getDoctorNames() {
		if(doctorNames ==null||doctorNames.isEmpty()) {
			for(int i =0; i< doctorList.size();i++) {
				doctorNames.add( doctorList.get(i).getUsername() );
			}
		}
		return (doctorNames);
	} 
	//View Prescription
	public void ViewPrescription() {
		screenPrescription.run(this);
		getDoctorNames();
		//screenPrescription.cmb_doctorname.setModel(new DefaultComboBoxModel<Doctor>(doctorList.toArray(new Doctor[0])));​​​​
		screenPrescription.cmb_doctorname.setModel(new DefaultComboBoxModel<String>(doctorNames.toArray(new String[0])));
	}	
	//End Prescription
	public void EndViewPrescription() {
		screenPrescription.EndViewPrescription();
		screenPrescription.dtm.setRowCount(0);
	}		
	//Check whether a string is valid integer and is greater than or equal to 0.
	public boolean CheckIsValidInteger(String strInteger) {
		if(strInteger.matches("\\d+")==false) {
			return false;
		}
		else if (Integer.parseInt(strInteger) <= 0) {
			return false;
		}
		return true;
	}
	//Check the inputs for add medicine button function.
	public boolean CheckConsultingAddMedicine(String MedName, String MedAmount, String MedUnitPrice) {		
		if( MedName.equals("")) {
			screenPrescription.displayInvalidMedicineName();
			return false;
		}
		
		if( CheckIsValidInteger(MedAmount)==false) {
			screenPrescription.displayInvalidMedicineAmount();
			return false;
		}
		if( CheckIsValidDouble(MedUnitPrice) ==false) {
			screenPrescription.displayInvalidPricePerUnit();
			return false;
		}
		return true;
	}
	//Add MedicationConsultant List into JTable
	public void ViewMedicationConsultantJtable() {
		for(int i=0;i<medicationConsultantList.size();i++) {
		Object[]a = {medicationConsultantList.get(i).getMedicineName(), medicationConsultantList.get(i).getMedicineAmount(), df.format(medicationConsultantList.get(i).getMedicinePrice())};
		screenPrescription.dtm.addRow(a);
		}
	}
	//get the size of MedicationConsultantList
	public int getSizeMedicationConsultant() {
		int i = clinic.getMedicationConsultantList().size(); 
		return i;
	}
	//Check whether MedicationConsultantList is empty.
	public boolean CheckIsEmptyMedicationConsultant() {
		if(clinic.getMedicationConsultantList().isEmpty()==true) {
			return true;
		}else {
			
			return false;
		}
	}
	public void ClearMedicationConsultant() {
		clinic.clearMedicationConsultant();
	}
	//Check overall validation of the consultant. 
	public boolean CheckOverallConsultant(String patientName, String mc, String consultantfee) {
		//Check is patient name is valid string.
		if(patientName.equals("")==true) {
			screenPrescription.displayInvalidPatientName();
			return false;
		}
		//Check is the days for mc is valid integer and is greater than or equal to 0.
		if( CheckIsValidInteger(mc)==false ) {
			screenPrescription.displayInvalidMC();
			return false;				
		}		
		//Check is Consultant fee is valid double.
		try {
	        Double.parseDouble(consultantfee);
	    } catch(Exception e) {
	    	screenPrescription.displayInvalidConsultantFee();
	    	return false;
	    } 			
		return true;
	}
	public void addNewPrescription(Date datenow, String patientName, String doctorName, boolean MC, int McDays, double ConsultantFees) {
		clinic.addPrescription(datenow, patientName, doctorName, MC, McDays, ConsultantFees);
	}
	public void addNewMedicationConsultant(String MedicineName, int MedicineAmount, double MedicinePrice) {
		clinic.addMedicationConsultant(MedicineName, MedicineAmount, MedicinePrice);
	}
	/*---------------------------Prescription--------------------------*/
	
	
	/*---------------------------Payment--------------------------*/
	//View Payment
	public void ViewPayment() {
		screenPayment.run(this);
	}
	//End Payment
	public void EndViewPayment() {
		screenPayment.EndViewPayment();
		screenPayment.dtm.setRowCount(0);
	}
	public Prescription getPrescription() {
		return clinic.getPrescription();
	}
	public void ViewPaymentJtable(int i) {
		int Medamount = medicationConsultantList.get(i).getMedicineAmount();
		double Medprice = medicationConsultantList.get(i).getMedicinePrice();
		double Subtotal = Medamount * Medprice ;
		
			String []a = {medicationConsultantList.get(i).getMedicineName(), String.valueOf(Medamount), String.valueOf(df.format(Medprice)), String.valueOf(df.format(Subtotal))};
			screenPayment.dtm.addRow(a);
	}
	public boolean CheckOverallPayment(int paymentMethod, String nurseName, String payment, String totalPay) {
		//Check is nurse name is valid string.
		if(nurseName.equals("")==true) {
			screenPayment.displayInvalidNurseName();
			return false;
		}
		
		if(paymentMethod == 0) {
			//Convert string payment to double  and catch error if unable to convert.
			try {
				Double val = Double.parseDouble(payment.trim());
				Double valTotal = Double.parseDouble(totalPay.trim());
				//Check is the payment enough.
					if (val < valTotal) {
						screenPayment.displayNotEnoughCash();
						return false;
					} else {
						return true;
					}
			}catch(Exception ie) {
				JOptionPane.showMessageDialog(null, "Invalid Payment Fee.");
						ie.printStackTrace();
						return false;
					}
				}else if(paymentMethod == 1||paymentMethod == 2) {
					return true;
				}
				return true;
			}
	/*---------------------------Payment--------------------------*/
	
	
	/*---------------------------Prescription & Payment--------------------------*/
	//Check whether a string is valid double and is greater than or equal to 0.
	public boolean CheckIsValidDouble(String strDouble) {
		try {		
			if(Double.parseDouble(strDouble)<0) {
				return false;
			}
		}catch(Exception ie) {
			return false;
		}
		return true;
	}
	public void ClearPrescription() {
		clinic.clearPrescription();
	}
	//Check whether prescrioptionList is empty.
	public boolean CheckIsEmptyPrescription() {
		if(clinic.getPrescription() == null) {
			return true;
		}else {
			return false;
		}
	}
	/*---------------------------Prescription & Payment--------------------------*/	
}
