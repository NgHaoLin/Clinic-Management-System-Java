import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Screen_MainMenu extends JFrame implements ActionListener {

	private JFrame frmClinicManagementSystem;
	private Controller controller;
	private JButton btn_logout, btn_medical, btn_patient, btn_appointment, btn_prescription, btn_payment ;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	public void run(Controller controller) {
		this.controller = controller;
		frmClinicManagementSystem.setVisible(true);
		frmClinicManagementSystem.setResizable(false);
		frmClinicManagementSystem.setLocationRelativeTo(null);
	}

	public Screen_MainMenu() {
		initialize();
	}

	private void initialize() {
		frmClinicManagementSystem = new JFrame();
		frmClinicManagementSystem.getContentPane().setBackground(Color.WHITE);
		frmClinicManagementSystem.getContentPane().setForeground(Color.WHITE);
		frmClinicManagementSystem.setTitle("UKM Clinic Management System - Main Menu");
		frmClinicManagementSystem.setBounds(100, 100, 701, 527);
		frmClinicManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClinicManagementSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 687, 490);
		frmClinicManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 667, 470);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(10, 10, 647, 450);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 10, 627, 430);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_title = new JLabel("UKM Clinic Management System");
		lbl_title.setBounds(41, 40, 548, 35);
		panel_3.add(lbl_title);
		lbl_title.setForeground(Color.DARK_GRAY);
		lbl_title.setBackground(Color.WHITE);
		lbl_title.setFont(new Font("Helvetica", Font.BOLD, 35));
		
		btn_patient = new JButton("Patient Details Management");
		btn_patient.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btn_patient.setBounds(318, 132, 299, 57);
		panel_3.add(btn_patient);
		
		btn_logout = new JButton("Log Out");
		btn_logout.setBounds(318, 286, 299, 52);
		panel_3.add(btn_logout);
		btn_logout.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		btn_appointment = new JButton("Appointment Management");
		btn_appointment.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btn_appointment.setBounds(10, 207, 298, 57);
		panel_3.add(btn_appointment);
		
		btn_medical = new JButton("Medical Store Management");
		btn_medical.setBounds(10, 132, 298, 57);
		panel_3.add(btn_medical);
		btn_medical.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		btn_prescription = new JButton("Prescription");
		btn_prescription.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btn_prescription.setBounds(318, 207, 299, 57);
		panel_3.add(btn_prescription);
		
		btn_payment = new JButton("Payment");
		btn_payment.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btn_payment.setBounds(10, 284, 299, 57);
		panel_3.add(btn_payment);
		btn_medical.addActionListener(this);
		
		btn_logout.addActionListener(this);
		btn_patient.addActionListener(this);
		btn_appointment.addActionListener(this);
		btn_prescription.addActionListener(this);
		btn_payment.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_logout) {
			controller.SystemEnd();
		}
		else if(obj == btn_medical) {
			controller.ViewMedicalStore();
		}
		else if(obj == btn_patient) {
			controller.ViewPatientDetails();
		}
		else if(obj == btn_appointment) {
			controller.ViewAppointmentManagement();
		}
		else if(obj == btn_prescription) {	
			if(controller.CheckIsEmptyPrescription()==true) {
				controller.ViewPrescription();
			}else if(controller.CheckIsEmptyPrescription() == false) {
				JOptionPane.showMessageDialog(null, "Please make the payment first!" );
			}
		}
		else if(obj == btn_payment) {
			if(controller.CheckIsEmptyPrescription()==true) {
				JOptionPane.showMessageDialog(null, "There is no prescription at the moment!" );
			}else if(controller.CheckIsEmptyPrescription() == false) {
				controller.ViewPayment();
			}
		}
	}
	
	public int DisplayAskForLogout() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		return JOptionPane.showConfirmDialog(this,"Are You Sure Want To Log Out?","Log Out",dialogButton);
	}
	
	public void DisplaySuccessfulLogout() {
		JOptionPane.showMessageDialog(null, "Successfully Log Out", "End", 1 );
		frmClinicManagementSystem.setVisible(false);
	}
	
	public void DisplayFailLogout() {
		JOptionPane.showMessageDialog(null, "Fail To Log Out", "Cancel Log Out", 0 );
		frmClinicManagementSystem.setVisible(false);
	}
}
