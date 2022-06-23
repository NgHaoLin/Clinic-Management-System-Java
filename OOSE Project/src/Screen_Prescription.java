import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.Color;
import java.util.*;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Screen_Prescription extends JFrame implements ActionListener {

	private Controller controller;
	private JFrame frmUkmClinicManagement;
	private JTextField txt_day;
	private JTextField txt_fee;
	private JTextField txt_medamount;
	private JTextField txt_medname;
	private JTextField txt_patientname; 
	private JTextField txt_priceperunit;
	private JButton btn_complete, btn_AddMedicine, btn_ClearAllMedicine, btn_exit;
	JComboBox cmb_doctorname;
	private JRadioButton rbtn_MC;
	private Date datenow = new Date();
	private DecimalFormat df = new DecimalFormat("#0.00");   
	private JTable table;
	String header[]= new String[]{"Medicine Name", "Amount needed", "Price per unit(RM)"};
	DefaultTableModel dtm;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	
	public void run(Controller controller) {
		this.controller = controller;
		frmUkmClinicManagement.setVisible(true);
		frmUkmClinicManagement.setResizable(false);
		frmUkmClinicManagement.setLocationRelativeTo(null);
		controller.ViewMedicationConsultantJtable();	
	}
	
	public Screen_Prescription() {
		initialize();
	}
	
	private void initialize() {
		frmUkmClinicManagement = new JFrame();
		frmUkmClinicManagement.getContentPane().setBackground(Color.DARK_GRAY);
		frmUkmClinicManagement.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmUkmClinicManagement.setBounds(100, 100, 1158, 782);
		frmUkmClinicManagement.setTitle("UKM Clinic Management System - Prescription");
		frmUkmClinicManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUkmClinicManagement.getContentPane().setLayout(null);
		
		JLabel lbl_dr = new JLabel("Doctor Name:");
		lbl_dr.setBounds(80, 178, 170, 37);
		lbl_dr.setFont(new Font("Helvetica", Font.PLAIN, 17));
		frmUkmClinicManagement.getContentPane().add(lbl_dr);
		
		JLabel lblSelectYourMedicine = new JLabel("Select your medicine here:");
		lblSelectYourMedicine.setBounds(47, 295, 288, 37);
		lblSelectYourMedicine.setFont(new Font("Helvetica", Font.BOLD, 18));
		frmUkmClinicManagement.getContentPane().add(lblSelectYourMedicine);
		
		JLabel lblDoThePatient = new JLabel("Do the patient need medical certificate?");
		lblDoThePatient.setBounds(47, 425, 396, 37);
		lblDoThePatient.setFont(new Font("Helvetica", Font.BOLD, 18));
		frmUkmClinicManagement.getContentPane().add(lblDoThePatient);
		
		rbtn_MC = new JRadioButton("Yes");
		rbtn_MC.setBackground(Color.WHITE);
		rbtn_MC.setBounds(47, 469, 79, 37);
		rbtn_MC.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(rbtn_MC.isSelected()==true) {
	            	txt_day.setText("1");
		            txt_day.setEditable(true);
	            }else {
	            	txt_day.setText("");
		            txt_day.setEditable(false);
	            }
	            
	        }
	    });
		rbtn_MC.setFont(new Font("Helvetica", Font.PLAIN, 16));
		frmUkmClinicManagement.getContentPane().add(rbtn_MC);
		
		JLabel lbl_dr_1 = new JLabel("Patient Name:");
		lbl_dr_1.setBounds(80, 226, 150, 37);
		lbl_dr_1.setFont(new Font("Helvetica", Font.PLAIN, 17));
		frmUkmClinicManagement.getContentPane().add(lbl_dr_1);
		
		JLabel lblConsultantDetails = new JLabel("Please fill in your consultant details:");
		lblConsultantDetails.setBounds(41, 130, 367, 37);
		lblConsultantDetails.setFont(new Font("Helvetica", Font.BOLD, 18));
		frmUkmClinicManagement.getContentPane().add(lblConsultantDetails);
		
		JLabel lblHowMuchIs = new JLabel("How much is the consultant fees?");
		lblHowMuchIs.setBounds(47, 520, 350, 37);
		lblHowMuchIs.setFont(new Font("Helvetica", Font.BOLD, 18));
		frmUkmClinicManagement.getContentPane().add(lblHowMuchIs);
		
		txt_fee = new JTextField();
		txt_fee.setBounds(222, 561, 150, 35);
		txt_fee.setFont(new Font("Helvetica", Font.PLAIN, 16));
		txt_fee.setColumns(10);
		frmUkmClinicManagement.getContentPane().add(txt_fee);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Medicine Name:");
		lblNewLabel_1_1.setBounds(37, 327, 147, 37);
		lblNewLabel_1_1.setFont(new Font("Helvetica", Font.PLAIN, 16));
		frmUkmClinicManagement.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Amount needed:");
		lblNewLabel_1_1_1.setBounds(194, 327, 122, 37);
		lblNewLabel_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 16));
		frmUkmClinicManagement.getContentPane().add(lblNewLabel_1_1_1);
		
		txt_medamount = new JTextField();
		txt_medamount.setBounds(194, 367, 112, 35);
		txt_medamount.setFont(new Font("Helvetica", Font.PLAIN, 15));
		txt_medamount.setColumns(10);
		frmUkmClinicManagement.getContentPane().add(txt_medamount);
		
		txt_medname = new JTextField();
		txt_medname.setBounds(26, 367, 145, 35);
		txt_medname.setFont(new Font("Helvetica", Font.PLAIN, 15));
		txt_medname.setColumns(10);
		frmUkmClinicManagement.getContentPane().add(txt_medname);
		
		txt_patientname = new JTextField();
		txt_patientname.setBounds(226, 225, 269, 39);
		txt_patientname.setFont(new Font("Helvetica", Font.PLAIN, 16));
		txt_patientname.setColumns(10);
		frmUkmClinicManagement.getContentPane().add(txt_patientname);
		
		cmb_doctorname = new JComboBox();
		cmb_doctorname.setBackground(Color.WHITE);
		cmb_doctorname.setBounds(227, 177, 268, 39);
		cmb_doctorname.setFont(new Font("Helvetica", Font.PLAIN, 16));
		frmUkmClinicManagement.getContentPane().add(cmb_doctorname);
		
		txt_priceperunit = new JTextField();
		txt_priceperunit.setBounds(326, 367, 123, 35);
		txt_priceperunit.setFont(new Font("Helvetica", Font.PLAIN, 15));
		txt_priceperunit.setColumns(10);
		frmUkmClinicManagement.getContentPane().add(txt_priceperunit);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price per unit (RM):");
		lblNewLabel_1_1_1_1.setBounds(326, 327, 149, 37);
		lblNewLabel_1_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 16));
		frmUkmClinicManagement.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lbl_consultantfeeamount = new JLabel("Enter amount (RM):");
		lbl_consultantfeeamount.setBounds(47, 556, 162, 37);
		lbl_consultantfeeamount.setFont(new Font("Dialog", Font.PLAIN, 16));
		frmUkmClinicManagement.getContentPane().add(lbl_consultantfeeamount);
		dtm = new DefaultTableModel(header,0);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 1124, 100);
		panel.setBackground(Color.WHITE);
		frmUkmClinicManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 10, 1104, 80);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 1084, 60);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prescription");
		lblNewLabel.setBounds(400, 0, 343, 60);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 58));
		
		btn_exit = new JButton("Exit");
		btn_exit.setBounds(10, 10, 113, 40);
		panel_2.add(btn_exit);
		btn_exit.setFont(new Font("Dialog", Font.PLAIN, 19));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 636, 1124, 99);
		frmUkmClinicManagement.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(10, 10, 1104, 79);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 10, 1084, 59);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		btn_complete = new JButton("Complete Consulting");
		btn_complete.setBounds(452, 10, 241, 39);
		panel_5.add(btn_complete);
		btn_complete.setFont(new Font("Helvetica", Font.PLAIN, 19));
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(623, 120, 511, 506);
		frmUkmClinicManagement.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		panel_6 = new JPanel();
		panel_6.setBounds(10, 51, 491, 392);
		panel_7.add(panel_6);
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 471, 372);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Helvetica", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblMedicineList = new JLabel("The Medicine List:");
		lblMedicineList.setBounds(10, 10, 234, 37);
		panel_7.add(lblMedicineList);
		lblMedicineList.setFont(new Font("Helvetica", Font.BOLD, 18));
		
		btn_ClearAllMedicine = new JButton("Clear All Medicine");
		btn_ClearAllMedicine.setBounds(151, 453, 226, 43);
		panel_7.add(btn_ClearAllMedicine);
		btn_ClearAllMedicine.setForeground(Color.RED);
		btn_ClearAllMedicine.setBackground(Color.LIGHT_GRAY);
		btn_ClearAllMedicine.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(10, 120, 615, 506);
		frmUkmClinicManagement.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		btn_AddMedicine = new JButton("Add Medicine");
		btn_AddMedicine.setBounds(460, 228, 139, 47);
		panel_8.add(btn_AddMedicine);
		btn_AddMedicine.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		txt_day = new JTextField();
		txt_day.setBounds(126, 352, 96, 36);
		panel_8.add(txt_day);
		txt_day.setEditable(false);
		txt_day.setFont(new Font("Helvetica", Font.PLAIN, 16));
		txt_day.setColumns(10);
		
		JLabel lbl_mcday = new JLabel("(If yes, how many days does he/she needed?)");
		lbl_mcday.setBounds(232, 348, 367, 37);
		panel_8.add(lbl_mcday);
		lbl_mcday.setFont(new Font("Helvetica", Font.PLAIN, 17));
		
		btn_AddMedicine.addActionListener(this);
		btn_ClearAllMedicine.addActionListener(this);
		btn_complete.addActionListener(this);
		btn_exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_AddMedicine) {
			if( controller.CheckConsultingAddMedicine(txt_medname.getText(), txt_medamount.getText(), txt_priceperunit.getText()) ==true ) {
		
					int medamount = Integer.parseInt(txt_medamount.getText());
					double priceperunit = Double.parseDouble(txt_priceperunit.getText() );
					controller.addNewMedicationConsultant(txt_medname.getText(), medamount, priceperunit);
					dtm.setRowCount(0);
					controller.ViewMedicationConsultantJtable();
					txt_medname.setText("");
					txt_medamount.setText("");
					txt_priceperunit.setText("");
			}
		}else if(obj == btn_exit){
			if(controller.CheckIsEmptyMedicationConsultant()==false) {
				controller.ClearMedicationConsultant();
				dtm.setRowCount(0);
				controller.ViewMedicationConsultantJtable();
			}
			if(controller.CheckIsEmptyPrescription()==false) {
				controller.ClearPrescription();
			}
			controller.EndViewPrescription();
		}else if(obj == btn_ClearAllMedicine) {
				if(controller.CheckIsEmptyMedicationConsultant()==false) {
					controller.ClearMedicationConsultant();
					dtm.setRowCount(0);
					controller.ViewMedicationConsultantJtable();
				}
		}else if(obj == btn_complete) {
			//When MC is provided.
			if(rbtn_MC.isSelected()==true) {
				if(controller.CheckOverallConsultant(txt_patientname.getText(), txt_day.getText(), txt_fee.getText()) == true) {  
					controller.addNewPrescription(datenow, txt_patientname.getText(), cmb_doctorname.getSelectedItem().toString(), rbtn_MC.isSelected(), Integer.valueOf(txt_day.getText()), Double.valueOf(txt_fee.getText()));
					displayConsultantConfirmed();
					EndViewPrescription();
				}	

				//When MC is not provided.
			}else {
					if(controller.CheckOverallConsultant(txt_patientname.getText(), "1", txt_fee.getText()) == true) {
						controller.addNewPrescription(datenow, txt_patientname.getText(), cmb_doctorname.getSelectedItem().toString(), rbtn_MC.isSelected(), 1, Double.valueOf(txt_fee.getText()));
						displayConsultantConfirmed();
						EndViewPrescription();
					}
				}
			}
		}
	
	public void EndViewPrescription() {
		frmUkmClinicManagement.setVisible(false);
	}
	
	
	public void displayInvalidMedicineName() {
		txt_medname.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Medicine Name. Please try again.", "Error", 0 );
	}
	
	public void displayInvalidMedicineAmount() {
		txt_medamount.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Amount needed. Please try again.", "Error", 0 );
	}
	
	public void displayInvalidPricePerUnit() {
		txt_priceperunit.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Price per Unit. Please try again.", "Error", 0 );
	}
	
	public void displayRepeated(){
		txt_medname.setText("");
		JOptionPane.showMessageDialog(null, "This medicine is repeated! Please clear all or add another type of medicine.", "Error", 0 );
	}
	
	public void displayInvalidPatientName() {
		txt_patientname.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Patient Name. Please try again.", "Error", 0 );
	}
	
	public void displayInvalidConsultantFee(){
		txt_fee.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Consultant fees! Please try again.", "Error", 0 );
	}
	
	public void displayInvalidMC(){
		txt_day.setText("");
		JOptionPane.showMessageDialog(null, "Invalid days for MC! Please try again.", "Error", 0 );
	}
	
	public void displayConsultantConfirmed(){
		JOptionPane.showMessageDialog(null, "Consultant done! Redirecting to Payment Page at the Counter.");
	}
}
