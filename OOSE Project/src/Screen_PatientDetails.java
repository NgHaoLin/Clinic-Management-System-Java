import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Screen_PatientDetails extends JFrame implements ActionListener {

	private JFrame frmUkmClinicManagement;
	private Controller controller;
	private JTextField txt_ic;
	private JTextField txt_name;
	private JTextField txt_address;
	private JTextField txt_age;
	private JTextField txt_gender;
	private JTextField txt_phone;
	private JButton btn_addrecord = new JButton("Add New Record");
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_clear = new JButton("Clear");
	private JTable table;
	String header[]= new String[]{"IC Number","Name","Address","Age","Gender","Phone Number"};
	DefaultTableModel dtm;
	

	public void run(Controller controller) {
		this.controller = controller;
		frmUkmClinicManagement.setVisible(true);
		frmUkmClinicManagement.setResizable(false);
		frmUkmClinicManagement.setLocationRelativeTo(null);
		controller.ViewPatientJtable();
	}
	
	public Screen_PatientDetails() {
		initialize();
	}

	private void initialize() {
		frmUkmClinicManagement = new JFrame();
		frmUkmClinicManagement.getContentPane().setForeground(Color.WHITE);
		frmUkmClinicManagement.getContentPane().setBackground(Color.DARK_GRAY);
		frmUkmClinicManagement.setTitle("UKM Clinic Management System - Patient Details Management");
		frmUkmClinicManagement.setBounds(100, 100, 1190, 669);
		frmUkmClinicManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUkmClinicManagement.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 1156, 105);
		frmUkmClinicManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 10, 1136, 85);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 1116, 65);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_title = new JLabel("Patient Details Management");
		lbl_title.setBounds(185, 0, 775, 65);
		panel_2.add(lbl_title);
		lbl_title.setBackground(Color.WHITE);
		lbl_title.setFont(new Font("Helvetica", Font.BOLD, 58));
		lbl_title.setForeground(Color.DARK_GRAY);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 125, 449, 384);
		frmUkmClinicManagement.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_ic = new JLabel("IC Number");
		lbl_ic.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_ic.setBounds(28, 64, 104, 32);
		panel_3.add(lbl_ic);
		
		txt_ic = new JTextField();
		txt_ic.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_ic.setBounds(210, 64, 214, 32);
		panel_3.add(txt_ic);
		txt_ic.setColumns(10);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_name.setBounds(28, 107, 135, 32);
		panel_3.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_name.setColumns(10);
		txt_name.setBounds(210, 107, 214, 32);
		panel_3.add(txt_name);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_address.setBounds(28, 150, 86, 32);
		panel_3.add(lbl_address);
		
		JLabel lbl_age = new JLabel("Age");
		lbl_age.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_age.setBounds(28, 193, 172, 32);
		panel_3.add(lbl_age);
		
		txt_age = new JTextField();
		txt_age.setText("0");
		txt_age.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_age.setColumns(10);
		txt_age.setBounds(210, 193, 214, 32);
		panel_3.add(txt_age);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_gender.setBounds(28, 236, 86, 32);
		panel_3.add(lbl_gender);
		
		txt_gender = new JTextField();
		txt_gender.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_gender.setColumns(10);
		txt_gender.setBounds(210, 236, 214, 32);
		panel_3.add(txt_gender);
		
		txt_address = new JTextField();
		txt_address.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_address.setColumns(10);
		txt_address.setBounds(210, 149, 214, 32);
		panel_3.add(txt_address);
		
		JLabel lbl_phone = new JLabel("Phone Number");
		lbl_phone.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_phone.setBounds(28, 278, 155, 32);
		panel_3.add(lbl_phone);
		
		txt_phone = new JTextField();
		txt_phone.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_phone.setColumns(10);
		txt_phone.setBounds(210, 278, 214, 32);
		panel_3.add(txt_phone);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(469, 115, 697, 394);
		frmUkmClinicManagement.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(21, 0, 666, 384);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 10, 646, 364);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 646, 364);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Helvetica", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		dtm = new DefaultTableModel(header,0);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 519, 1156, 103);
		frmUkmClinicManagement.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		panel_8.setBounds(10, 10, 1136, 83);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 10, 1116, 63);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		btn_addrecord.setFont(new Font("Helvetica", Font.PLAIN, 18));
		btn_addrecord.setBounds(118, 10, 179, 43);
		panel_9.add(btn_addrecord);
		
		btn_exit.setFont(new Font("Helvetica", Font.PLAIN, 18));
		btn_exit.setBounds(836, 10, 129, 43);
		panel_9.add(btn_exit);
		
		btn_clear.setBounds(666, 10, 129, 43);
		panel_9.add(btn_clear);
		btn_clear.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		btn_exit.addActionListener(this);
		btn_addrecord.addActionListener(this);
		btn_clear.addActionListener(this);
		table.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txt_ic.setText(dtm.getValueAt(i,0).toString());
				txt_name.setText(dtm.getValueAt(i,1).toString());
				txt_address.setText(dtm.getValueAt(i,2).toString());
				txt_age.setText(dtm.getValueAt(i,3).toString());
				txt_gender.setText(dtm.getValueAt(i,4).toString());
				txt_phone.setText(dtm.getValueAt(i,5).toString());
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_exit) {
			controller.EndViewPatientDetails();
		}
		
		else if(obj == btn_addrecord) {
			int age=Integer.parseInt(txt_age.getText());
			controller.AddNewPatient(txt_ic.getText(), txt_name.getText(), txt_address.getText(), age, txt_gender.getText(), txt_phone.getText());	
			dtm.setRowCount(0);
			controller.ViewPatientJtable();
		}
		
		else if(obj == btn_clear) {
			controller.ClearPatientTextBox();
		}
	}
	
	public void EndPatientDetails() {
		frmUkmClinicManagement.setVisible(false);
	}
	
	public void DisplayFailAddNewPatient() { 
		txt_age.setText("0");
		JOptionPane.showMessageDialog(null, "Invalid Information! Please Try It Again.", "Error", 0);
	}

	public void DisplaySuccessfulAddNewPatient() { 
		clear();
		JOptionPane.showMessageDialog(null, "Add New Patient Successful!","Successful", 1);
	}
	
	public void clear() {
		txt_ic.setText("");
		txt_name.setText("");
		txt_address.setText("");
		txt_age.setText("0");
		txt_gender.setText("");
		txt_phone.setText("");
	}
}