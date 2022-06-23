import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.awt.event.InputMethodListener;
import java.text.DecimalFormat;
import java.awt.event.InputMethodEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;    

public class Screen_Payment extends JFrame implements ActionListener {


	private JFrame frmUkmClinicManagement;
	private Controller controller;
	private JPanel contentPane;
	private JTextField txt_pay;
	private Date date = new Date();
	private JButton btn_payment, btn_addPrescription;
	private JLabel lbl_pay, lbl_totalamount;
	private JComboBox cmb_payment;
	private Double totalamount = 250.00 ;
	private Double change = 0.00;
	
	private JTable table;
	String header[]= new String[]{"Items Name", "Item Quantity", "Price per Item(RM)", "Subtotal(RM)"};
	DefaultTableModel dtm;
	private JTextField txt_nursename;
	private JTextField txt_drname;
	private JTextField txt_custname;
	private JTextField txt_mc;
	private JTextField txt_MCdays;
	private JLabel lbl_dateconsulting;
	private JTextField txt_dateconsulting;
	private boolean prescriptionAdded = false;
	DecimalFormat df = new DecimalFormat("#0.00");   
	
	public void run(Controller controller) {
		this.controller = controller;
		frmUkmClinicManagement.setVisible(true); 
		frmUkmClinicManagement.setResizable(false);
		frmUkmClinicManagement.setLocationRelativeTo(null);
	}
		
	public Screen_Payment() {
		initialize();
	}
	
	private void initialize() {
		frmUkmClinicManagement = new JFrame();
		frmUkmClinicManagement.getContentPane().setBackground(Color.DARK_GRAY);
		frmUkmClinicManagement.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmUkmClinicManagement.setBounds(100, 100, 1194, 713);
		frmUkmClinicManagement.setTitle("UKM Clinic Management System - Payment");
		frmUkmClinicManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUkmClinicManagement.getContentPane().setLayout(null);
		dtm = new DefaultTableModel(header,0);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 1160, 105);
		frmUkmClinicManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 1140, 85);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 1120, 65);
		panel_1.add(panel_2);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(444, 0, 257, 63);
		panel_2.add(lblPayment);
		lblPayment.setFont(new Font("Helvetica", Font.BOLD, 58));
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 563, 1160, 103);
		frmUkmClinicManagement.getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.DARK_GRAY);
		panel_8.setBounds(10, 10, 1140, 83);
		panel_7.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 10, 1120, 63);
		panel_8.add(panel_9);
				
		btn_payment = new JButton("Complete Payment");
		btn_payment.setBounds(456, 10, 228, 43);
		panel_9.add(btn_payment);
		btn_payment.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 105, 1160, 448);
		frmUkmClinicManagement.getContentPane().add(panel_3);
		panel_3.setLayout(null);
								
		JLabel lblYourReceipt = new JLabel("Your receipt:");
		lblYourReceipt.setBounds(750, 10, 234, 37);
		panel_3.add(lblYourReceipt);
		lblYourReceipt.setFont(new Font("Helvetica", Font.BOLD, 22));
		
		JLabel lblTotalAmount = new JLabel("Total Amount:");
		lblTotalAmount.setBounds(732, 341, 181, 37);
		panel_3.add(lblTotalAmount);
		lblTotalAmount.setFont(new Font("Helvetica", Font.BOLD, 23));
		
		lbl_totalamount = new JLabel("0.00");
		lbl_totalamount.setBounds(912, 341, 199, 37);
		panel_3.add(lbl_totalamount);
		lbl_totalamount.setForeground(Color.BLUE);
		lbl_totalamount.setFont(new Font("Helvetica", Font.BOLD, 23));
		
		txt_pay = new JTextField();
		txt_pay.setBounds(549, 388, 136, 37);
		panel_3.add(txt_pay);
		txt_pay.setFont(new Font("Helvetica", Font.PLAIN, 16));
		txt_pay.setColumns(10);
		
		lbl_pay = new JLabel("(Please enter the cash payment)");
		lbl_pay.setBounds(695, 388, 348, 37);
		panel_3.add(lbl_pay);
		lbl_pay.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		txt_MCdays = new JTextField("-");
		txt_MCdays.setBounds(231, 211, 215, 33);
		panel_3.add(txt_MCdays);
		txt_MCdays.setHorizontalAlignment(SwingConstants.CENTER);
		txt_MCdays.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_MCdays.setEditable(false);
		txt_MCdays.setColumns(10);
		
		txt_dateconsulting = new JTextField("-");
		txt_dateconsulting.setBounds(231, 249, 262, 33);
		panel_3.add(txt_dateconsulting);
		txt_dateconsulting.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dateconsulting.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_dateconsulting.setEditable(false);
		txt_dateconsulting.setColumns(10);
		
		lbl_dateconsulting = new JLabel("Date of Consulting:");
		lbl_dateconsulting.setBounds(38, 245, 149, 37);
		panel_3.add(lbl_dateconsulting);
		lbl_dateconsulting.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JLabel lbl_MCdays = new JLabel("Days of MC:");
		lbl_MCdays.setBounds(38, 207, 193, 37);
		panel_3.add(lbl_MCdays);
		lbl_MCdays.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JLabel lbl_datetitle = new JLabel("Transaction Date:");
		lbl_datetitle.setBounds(57, 10, 156, 37);
		panel_3.add(lbl_datetitle);
		lbl_datetitle.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		JLabel lbl_date = new JLabel(date.toString());
		lbl_date.setBounds(211, 10, 351, 37);
		panel_3.add(lbl_date);
		lbl_date.setFont(new Font("Helvetica", Font.PLAIN, 16));
		
		JLabel lbl_nurse = new JLabel("Nurse Name:");
		lbl_nurse.setBounds(68, 51, 130, 37);
		panel_3.add(lbl_nurse);
		lbl_nurse.setFont(new Font("Helvetica", Font.PLAIN, 17));
		
		txt_nursename = new JTextField();
		txt_nursename.setBounds(196, 51, 215, 37);
		panel_3.add(txt_nursename);
		txt_nursename.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nursename.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_nursename.setColumns(10);
		
		JLabel lbl_dr = new JLabel("Doctor Name:");
		lbl_dr.setBounds(38, 96, 193, 37);
		panel_3.add(lbl_dr);
		lbl_dr.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JLabel lbl_customer = new JLabel("Customer Name:");
		lbl_customer.setBounds(38, 132, 166, 37);
		panel_3.add(lbl_customer);
		lbl_customer.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JLabel lbl_mc = new JLabel("Medical certificate(MC):");
		lbl_mc.setBounds(38, 168, 193, 37);
		panel_3.add(lbl_mc);
		lbl_mc.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		txt_drname = new JTextField("-");
		txt_drname.setBounds(231, 100, 215, 33);
		panel_3.add(txt_drname);
		txt_drname.setHorizontalAlignment(SwingConstants.CENTER);
		txt_drname.setEditable(false);
		txt_drname.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_drname.setColumns(10);
		
		txt_custname = new JTextField("-");
		txt_custname.setBounds(231, 136, 215, 33);
		panel_3.add(txt_custname);
		txt_custname.setHorizontalAlignment(SwingConstants.CENTER);
		txt_custname.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_custname.setEditable(false);
		txt_custname.setColumns(10);
		
		txt_mc = new JTextField("-");
		txt_mc.setBounds(231, 172, 215, 33);
		panel_3.add(txt_mc);
		txt_mc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mc.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_mc.setEditable(false);
		txt_mc.setColumns(10);
		
		btn_addPrescription = new JButton("Add Prescription Details");
		btn_addPrescription.setBounds(127, 310, 251, 52);
		panel_3.add(btn_addPrescription);
		btn_addPrescription.setBackground(Color.GREEN);
		btn_addPrescription.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblSelectThePayment = new JLabel("Select the payment method:");
		lblSelectThePayment.setBounds(56, 388, 261, 37);
		panel_3.add(lblSelectThePayment);
		lblSelectThePayment.setFont(new Font("Dialog", Font.BOLD, 17));
		
		cmb_payment = new JComboBox();
		cmb_payment.setBounds(300, 388, 168, 37);
		panel_3.add(cmb_payment);
		cmb_payment.setFont(new Font("Helvetica", Font.PLAIN, 16));
		cmb_payment.addItem("Cash");
		cmb_payment.addItem("Credit Cards");
		cmb_payment.addItem("Panel/Insurance");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(536, 43, 575, 298);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 278);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Helvetica", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		cmb_payment.addActionListener(this);
		
		btn_addPrescription.addActionListener(this);
		btn_payment.addActionListener(this);
	}

	public void EndViewPayment() {
		frmUkmClinicManagement.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(cmb_payment.getSelectedItem().toString().trim().equals("Credit Cards") ||
			       cmb_payment.getSelectedItem().toString().trim().equals("Panel/Insurance")) {
        	lbl_pay.setVisible(false);
        	txt_pay.setVisible(false);
        	txt_pay.setText("");
		}
		if(cmb_payment.getSelectedItem().toString().trim().equals("Cash")){
	        	lbl_pay.setVisible(true);
	        	txt_pay.setVisible(true);
		}
		
		if(obj == btn_addPrescription) {
			if(controller.CheckIsEmptyPrescription()==true) {
				JOptionPane.showMessageDialog(null, "There is no prescription at the moment! Please go make a prescription first!" );
			}else if(controller.CheckIsEmptyPrescription() == false) {
				dtm.setRowCount(0);
				Object[]a = {"Consultant Fees", "1", String.valueOf(controller.getPrescription().getConsultantFees()), String.valueOf(controller.getPrescription().getConsultantFees())};
				dtm.addRow(a);
				prescriptionAdded = true;
				txt_drname.setText(controller.getPrescription().getDocName());
				txt_custname.setText(controller.getPrescription().getCustname());
				txt_dateconsulting.setText(controller.getPrescription().getDate().toString());
					if(controller.getPrescription().getMcProvided()==true) {
						txt_mc.setText("Yes");
						txt_MCdays.setText( Integer.toString(controller.getPrescription().getMcDays()) );
					}else {
						txt_mc.setText("None");
					}
				
				for(int i=0; i<controller.getSizeMedicationConsultant(); i++) {
					controller.ViewPaymentJtable(i);
				}
				Double TotalAmount = 0.00;
				for(int i =0; i< dtm.getRowCount(); i++) {
					TotalAmount += Double.parseDouble((String) dtm.getValueAt(i, 3));
				}
				lbl_totalamount.setText(df.format(TotalAmount));
				displayPrescriptionAdded();
				
			}
		}else if(obj == btn_payment) {
			if(prescriptionAdded==true) {
				int paymentMethod= cmb_payment.getSelectedIndex();
				if(controller.CheckOverallPayment(paymentMethod, txt_nursename.getText(), txt_pay.getText().toString(), lbl_totalamount.getText().toString())==true) {
					displayPaymentDone();
					controller.ClearPrescription();
					controller.ClearMedicationConsultant();
					EndViewPayment();	
				}
			
			}else {
				displayNoPrescriptionAdded();
			}
		}
	}
	
	public void displayNotEnoughCash() {
		txt_pay.setText("");
		JOptionPane.showMessageDialog(null, "Sorry, Your cash is not enough for the payment!");
	}
	
	public void displayInvalidNurseName() {
		txt_nursename.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Nurse Name. Please try again.", "Error", 0 );
	}
	
	public void displayNoPrescriptionAdded() {
		JOptionPane.showMessageDialog(null, "You didn't add an prescription. Please add the Prescription details!", "Error", 0 );
	}
	
	public void displayPrescriptionAdded() {
		JOptionPane.showMessageDialog(null, "Prescription added succesful!");
	}
	
	public void displayPaymentDone() {
		JOptionPane.showMessageDialog(null, "Payment done successful !!");
	}
}
