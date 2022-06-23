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

public class Screen_MedicalStore extends JFrame implements ActionListener {

	private JFrame frmUkmClinicManagement;
	private Controller controller;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_quantity;
	private JTextField txt_date;
	private JTextField txt_store;
	private JButton btn_addrecord = new JButton("Add New Record");
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_clear = new JButton("Clear");
	private JButton btn_delete = new JButton("Delete");
	private JButton btn_update = new JButton("Update");
	JTable table;
	String header[]= new String[]{"Medical ID", "Medical Name", "Quantity", "Date", "Store"};
	DefaultTableModel dtm;

	public void run(Controller controller) {
		this.controller = controller;
		frmUkmClinicManagement.setVisible(true);
		frmUkmClinicManagement.setResizable(false);
		frmUkmClinicManagement.setLocationRelativeTo(null);
		controller.ViewMedicalJtable();
	}
	
	public Screen_MedicalStore() {
		initialize();
	}

	private void initialize() {
		frmUkmClinicManagement = new JFrame();
		frmUkmClinicManagement.getContentPane().setForeground(Color.WHITE);
		frmUkmClinicManagement.getContentPane().setBackground(Color.DARK_GRAY);
		frmUkmClinicManagement.setTitle("UKM Clinic Management System - Medical Store Management");
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
		
		JLabel lbl_title = new JLabel("Medical Store Management");
		lbl_title.setBounds(193, 0, 753, 65);
		panel_2.add(lbl_title);
		lbl_title.setBackground(Color.WHITE);
		lbl_title.setFont(new Font("Helvetica", Font.BOLD, 58));
		lbl_title.setForeground(Color.DARK_GRAY);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 125, 449, 384);
		frmUkmClinicManagement.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_id = new JLabel("Medical ID");
		lbl_id.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_id.setBounds(29, 98, 104, 32);
		panel_3.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_id.setBounds(213, 98, 214, 32);
		panel_3.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lbl_name = new JLabel("Medical Name");
		lbl_name.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_name.setBounds(29, 141, 135, 32);
		panel_3.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_name.setColumns(10);
		txt_name.setBounds(213, 141, 214, 32);
		panel_3.add(txt_name);
		
		JLabel lbl_quantity = new JLabel("Quantity");
		lbl_quantity.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_quantity.setBounds(29, 184, 86, 32);
		panel_3.add(lbl_quantity);
		
		JLabel lbl_date = new JLabel("Date(DD/MM/YY)");
		lbl_date.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_date.setBounds(29, 227, 172, 32);
		panel_3.add(lbl_date);
		
		txt_date = new JTextField();
		txt_date.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_date.setColumns(10);
		txt_date.setBounds(213, 227, 214, 32);
		panel_3.add(txt_date);
		
		JLabel lbl_store = new JLabel("Store");
		lbl_store.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl_store.setBounds(29, 270, 53, 32);
		panel_3.add(lbl_store);
		
		txt_store = new JTextField();
		txt_store.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_store.setColumns(10);
		txt_store.setBounds(213, 270, 214, 32);
		panel_3.add(txt_store);
		
		txt_quantity = new JTextField();
		txt_quantity.setText("1");
		txt_quantity.setFont(new Font("Helvetica", Font.PLAIN, 20));
		txt_quantity.setColumns(10);
		txt_quantity.setBounds(213, 183, 214, 32);
		panel_3.add(txt_quantity);
		
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
		btn_addrecord.setBounds(70, 10, 179, 43);
		panel_9.add(btn_addrecord);
		
		btn_exit.setFont(new Font("Helvetica", Font.PLAIN, 18));
		btn_exit.setBounds(916, 10, 129, 43);
		panel_9.add(btn_exit);
		
		btn_clear.setBounds(319, 10, 129, 43);
		panel_9.add(btn_clear);
		btn_clear.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		btn_delete.setFont(new Font("Helvetica", Font.PLAIN, 18));
		btn_delete.setBounds(717, 10, 129, 43);
		panel_9.add(btn_delete);
		
		btn_update.setFont(new Font("Helvetica", Font.PLAIN, 18));
		btn_update.setBounds(518, 10, 129, 43);
		panel_9.add(btn_update);
		
		btn_exit.addActionListener(this);
		btn_addrecord.addActionListener(this);
		btn_clear.addActionListener(this);
		btn_delete.addActionListener(this);
		btn_update.addActionListener(this);
		table.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txt_id.setText(dtm.getValueAt(i,0).toString());
				txt_name.setText(dtm.getValueAt(i,1).toString());
				txt_quantity.setText(dtm.getValueAt(i,2).toString());
				txt_date.setText(dtm.getValueAt(i,3).toString());
				txt_store.setText(dtm.getValueAt(i,4).toString());
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_exit) {
			controller.EndViewMedicalStore();
		}
		
		else if(obj == btn_addrecord) {
			int quantity=Integer.parseInt(txt_quantity.getText());
			controller.AddNewItem(txt_id.getText(), txt_name.getText(), quantity, txt_date.getText(), txt_store.getText());	
			dtm.setRowCount(0);
			controller.ViewMedicalJtable();
		}
		
		else if(obj == btn_delete) {
			int quantity=Integer.parseInt(txt_quantity.getText());
			controller.DeleteItem(txt_id.getText(), txt_name.getText(), quantity, txt_date.getText(), txt_store.getText());
			dtm.setRowCount(0);
			controller.ViewMedicalJtable();
		}
		
		else if(obj == btn_update) {
			int quantity=Integer.parseInt(txt_quantity.getText());
			controller.UpdateItem(txt_id.getText(), txt_name.getText(), quantity, txt_date.getText(), txt_store.getText());
			dtm.setRowCount(0);
			controller.ViewMedicalJtable();
		}
		
		else if(obj == btn_clear) {
			controller.ClearMedicalTextBox();
			dtm.setRowCount(0);
			controller.ViewMedicalJtable();
		}
	}
	
	public void EndViewMedicalStore() {
		frmUkmClinicManagement.setVisible(false);
	}
	
	public void DisplayFailAddNewItem() { 
		txt_quantity.setText("1");
		JOptionPane.showMessageDialog(null, "Invalid Information! Please Try It Again.", "Error", 0);
	}

	public void DisplaySuccessfulAddNewItem(String id, String name, int quantity, String date, String store) { 
		clear();
		String information = "\nMedical ID: "+id+"\nMedical Name: "+name+"\nQuantity: "+quantity+"\nDate: "+date+"\nStore: "+store;
		JOptionPane.showMessageDialog(null, "Add New Item Successful!\n\nItem Details:"+information, "Successful", 1);
	}
	
	public void DisplayFailDeleteItem() { 
		clear();
		JOptionPane.showMessageDialog(null, "The Item Does Not Exist! Please Try It Again.", "Error", 0);
	}
	
	public void DisplaySuccessfulDeleteItem() { 
		clear();
		JOptionPane.showMessageDialog(null, "Delete Item Successful!", "Successful", 1);
	}
	
	public void DisplaySuccessfulUpdateItem() { 
		clear();
		JOptionPane.showMessageDialog(null, "Update Item Successful!", "Successful", 1);
	}
	
	public void DisplayCancelDeleteItem() { 
		clear();
		JOptionPane.showMessageDialog(null, "Delete Item Fail!", "Cancel", 0);
	}
	
	public void DisplayCancelUpdateItem() { 
		clear();
		JOptionPane.showMessageDialog(null, "Update Item Fail!", "Cancel", 0);
	}
	
	public void DisplayFailSelectItem() { 
		clear();
		JOptionPane.showMessageDialog(null, "Please Select An Item From The Table!", "Error", 0);
	}
	
	public int DisplayAskForDeleteItem() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		return JOptionPane.showConfirmDialog(this,"Are You Sure Want To Delete The Item?","Delete",dialogButton);
	}
	
	public int DisplayAskForUpdateItem() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		return JOptionPane.showConfirmDialog(this,"Are You Sure Want To Update The Item?","Update",dialogButton);
	}
	
	public void clear() {
		txt_id.setText("");
		txt_name.setText("");
		txt_quantity.setText("1");
		txt_date.setText("");
		txt_store.setText("");
	}
}
