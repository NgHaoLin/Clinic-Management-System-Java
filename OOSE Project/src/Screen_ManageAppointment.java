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

public class Screen_ManageAppointment extends JFrame implements ActionListener {

	private JFrame frmUkmClinicManagement;
	private Controller controller;
	private JTextField txt_patient;
	private JTextField txt_doctor;
	private JTextField txt_date;
	private JTextField txt_time;
	private JTextField txt_memo;
	private JButton btn_addrecord = new JButton("Add New Record");
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_clear = new JButton("Clear");
	private JTable table;
	String header[]= new String[]{"Patient Number","Doctor Name","Date","Time","Memo"};
	DefaultTableModel dtm;
	

	public void run(Controller controller) {
		this.controller = controller;
		frmUkmClinicManagement.setVisible(true);
		frmUkmClinicManagement.setResizable(false);
		frmUkmClinicManagement.setLocationRelativeTo(null);
		controller.ViewAppointmentJtable();
	}
	
	public Screen_ManageAppointment() {
		initialize();
	}

	private void initialize() {
		frmUkmClinicManagement = new JFrame();
		frmUkmClinicManagement.getContentPane().setForeground(Color.WHITE);
		frmUkmClinicManagement.getContentPane().setBackground(Color.DARK_GRAY);
		frmUkmClinicManagement.setTitle("UKM Clinic Management System - Appointment Management");
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
		
		JLabel lbl_title = new JLabel("Appointment Management");
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
		
		JLabel lbl_patient = new JLabel("Patient Name");
		lbl_patient.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_patient.setBounds(27, 83, 135, 32);
		panel_3.add(lbl_patient);
		
		txt_patient = new JTextField();
		txt_patient.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_patient.setBounds(209, 83, 214, 32);
		panel_3.add(txt_patient);
		txt_patient.setColumns(10);
		
		JLabel lbl_doctor = new JLabel("Doctor Name");
		lbl_doctor.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_doctor.setBounds(27, 126, 135, 32);
		panel_3.add(lbl_doctor);
		
		txt_doctor = new JTextField();
		txt_doctor.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_doctor.setColumns(10);
		txt_doctor.setBounds(209, 126, 214, 32);
		panel_3.add(txt_doctor);
		
		JLabel lbl_date = new JLabel("Date");
		lbl_date.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_date.setBounds(27, 169, 86, 32);
		panel_3.add(lbl_date);
		
		JLabel lbl_time = new JLabel("Time");
		lbl_time.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_time.setBounds(27, 212, 172, 32);
		panel_3.add(lbl_time);
		
		txt_time = new JTextField();
		txt_time.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_time.setColumns(10);
		txt_time.setBounds(209, 212, 214, 32);
		panel_3.add(txt_time);
		
		JLabel lbl_memo = new JLabel("Memo");
		lbl_memo.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_memo.setBounds(27, 255, 86, 32);
		panel_3.add(lbl_memo);
		
		txt_memo = new JTextField();
		txt_memo.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_memo.setColumns(10);
		txt_memo.setBounds(209, 255, 214, 32);
		panel_3.add(txt_memo);
		
		txt_date = new JTextField();
		txt_date.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_date.setColumns(10);
		txt_date.setBounds(209, 168, 214, 32);
		panel_3.add(txt_date);
		
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
				txt_patient.setText(dtm.getValueAt(i,0).toString());
				txt_doctor.setText(dtm.getValueAt(i,1).toString());
				txt_date.setText(dtm.getValueAt(i,2).toString());
				txt_time.setText(dtm.getValueAt(i,3).toString());
				txt_memo.setText(dtm.getValueAt(i,4).toString());
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_exit) {
			controller.EndViewAppointmentManagement();
		}
		
		else if(obj == btn_addrecord) {
			controller.AddNewAppointment(txt_patient.getText(), txt_doctor.getText(), txt_date.getText(), txt_time.getText(), txt_memo.getText());	
			dtm.setRowCount(0);
			controller.ViewAppointmentJtable();
		}
		
		else if(obj == btn_clear) {
			controller.ClearAppointmentTextBox();
		}
	}
	
	public void EndAppointmentManagement() {
		frmUkmClinicManagement.setVisible(false);
	}
	
	public void DisplayFailAddNewAppointment() { 
		JOptionPane.showMessageDialog(null, "Invalid Information! Please Try It Again.", "Error", 0);
	}

	public void DisplaySuccessfulAddNewAppointment() { 
		clear();
		JOptionPane.showMessageDialog(null, "Add Appointment Successful!","Successful", 1);
	}
	
	public void DisplayExistAppointment() { 
		JOptionPane.showMessageDialog(null, "The Doctor's Time And Date Already Book By Others ! Please Try It Again.", "Error", 0);
	}
	
	public void clear() {
		txt_patient.setText("");
		txt_doctor.setText("");
		txt_date.setText("");
		txt_time.setText("");
		txt_memo.setText("");
	}
}