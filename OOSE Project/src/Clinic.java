import java.util.ArrayList;
import java.util.Date;

public class Clinic {
	private String name;
	private Date datenow;
	private ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
	private ArrayList<Medical> medicalList = new ArrayList<Medical>();
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();
	private ArrayList<MedicationConsultant> medicationConsultantList = new ArrayList<MedicationConsultant>();
	
	public Clinic(String name) {
		this.name = name;
		
		Nurse nurse1 = new Nurse("Ng Hao Lin", "123456");
		Nurse nurse2 = new Nurse("Lim Zi Sin", "123456");
		Nurse nurse3 = new Nurse("Choo Zhe Lim", "123456");
		Nurse nurse4 = new Nurse("Tan Jing Xuan", "123456");
		
		nurseList.add(nurse1);
		nurseList.add(nurse2);
		nurseList.add(nurse3);
		nurseList.add(nurse4);
		
		Medical medical1 = new Medical("M001", "Paracetamol", 3, "31/01/2021", "Store A");
		Medical medical2 = new Medical("M002", "Neurontin", 4, "01/02/2021", "Store B");
		Medical medical3 = new Medical("M003", "Lipitor", 5, "01/02/2021", "Store A");
		Medical medical4 = new Medical("M004", "Glucophage", 6, "02/02/2021", "Store B");
		
		medicalList.add(medical1);
		medicalList.add(medical2);
		medicalList.add(medical3);
		medicalList.add(medical4);
		
		Patient patient1 = new Patient("890606-07-5547","Robin Yap","No.56,Lorong Harmoni 18,Taman Harmoni,14000 Bukit Mertajam",45,"Male","017-55445568");
		Patient patient2 = new Patient("991010-08-5555","James Rip","No.57,Lorong Harmoni 17,Taman Tidak Harmoni,14300 Nibong Tebal",50,"Male","012-3456789");
		
		patientList.add(patient1);
		patientList.add(patient2);
		
		Appointment appointment1 = new Appointment("Tan Ken Chun", "Doctor Wong", "15/02/2021", "08:00", "Fever");
		appointmentList.add(appointment1);
		
		Doctor doctor1 = new Doctor("Dr.Muhammad Ali");
		Doctor doctor2 = new Doctor("Dr.Zamri Bin Abu");
		doctorList.add(doctor1);
		doctorList.add(doctor2);
	}
	
	//Clinic Name
	public String getName() {
		return name;
	}
	
	//Get Nurse Information
	public Nurse getNurse(String username, String password) {
		for (Nurse nurse : nurseList) {
			if (nurse.getUsername().equals(username) && nurse.getPassword().equals(password))
				return nurse;
		}
		return null;
	}
	
	//Get Medical Information
	public Medical getMedical(String id, String name, int quantity, String date, String store) {
		for (Medical medical : medicalList) {
			if (medical.getID().equals(id) && medical.getName().equals(name) && medical.getQuantity()==quantity && medical.getDate().equals(date) && medical.getStore().equals(store))
				return medical;
		}
		return null;
	}
	
	//Add Medical to MedicalList
	public void addMedical(String id, String name, int quantity, String date, String store) {	
		medicalList.add(new Medical(id, name, quantity, date, store));
	}
	
	//Remove Medical from MedicalList
	public void removeMedical(int i) {	
		medicalList.remove(i);
	}
	
	//Update Medical from MedicalList
		public void updateMedical(int i, String id, String name, int quantity, String date, String store) {	
			medicalList.set(i, new Medical(id, name, quantity, date, store));
		}
	
	//Get Medical List
	public ArrayList<Medical> getMedicalList() {
		return medicalList;
	}
	
	//Add Patient to PatientList
	public void addPatient(String icNumber,String name,String address,int age,String gender,String phoneNumber) {	
		patientList.add(new Patient(icNumber, name, address, age, gender, phoneNumber));
	}
	
	//Get Patient List
	public ArrayList<Patient> getPatientList() {
		return patientList;
	}
	
	//Add Appointment to AppointmentList
	public void addAppointment(String PatientName, String DoctorName, String Date, String Time, String Memo) {	
		appointmentList.add(new Appointment(PatientName, DoctorName, Date, Time, Memo));
	}
	
	//Get Appointment List
	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}
	
	//Get Appointment Information
	public Appointment getAppointment(String PatientName, String DoctorName, String Date, String Time, String Memo) {
		for (Appointment appointment : appointmentList) {
			if (appointment.getDoctorName().equals(DoctorName) && appointment.getDate().equals(Date) && appointment.getTime().equals(Time))
				return appointment;
		}
		return null;
	}
	
	//Get Doctor Information
	public ArrayList<Doctor> getDoctorList() {
		return (doctorList);
	}
		
	//Add Prescription to PrescriptionList
	public void addPrescription(Date datenow, String patientName, String doctorName, boolean MC, int McDays, double ConsultantFees) {
		prescriptionList.add(new Prescription(datenow,patientName,doctorName,MC,McDays,ConsultantFees));
	}
		
	//Add Payment to PaymentList
	public void addMedicationConsultant(String MedicineName, int MedicineAmount, double MedicinePrice) {
		medicationConsultantList.add(new MedicationConsultant(MedicineName, MedicineAmount, MedicinePrice));
	}
		
	public Prescription getPrescription() {
		if(!prescriptionList.isEmpty()) {
		return prescriptionList.get(0);
		}else {
			return null;
		}
	}
		
	//Clear the list of prescription.
	public void clearPrescription() {
		prescriptionList.clear();
	}
		
	public ArrayList<MedicationConsultant> getMedicationConsultantList() {
		return medicationConsultantList;
	}

	//Clear the list of medication consultant.
	public void clearMedicationConsultant() {
		medicationConsultantList.clear();
	}
}