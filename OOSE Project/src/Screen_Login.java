import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class Screen_Login extends JFrame implements ActionListener{

	private JFrame frmClinicManagementSystem;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private Controller controller;

	public void run(Controller controller) {
		this.controller = controller;
		frmClinicManagementSystem.setVisible(true);
		frmClinicManagementSystem.setResizable(false);
		frmClinicManagementSystem.setLocationRelativeTo(null);
	}

	public Screen_Login() {
		initialize();
	}
	
	private void initialize() {
		frmClinicManagementSystem = new JFrame();
		frmClinicManagementSystem.getContentPane().setBackground(Color.WHITE);
		frmClinicManagementSystem.getContentPane().setForeground(Color.BLACK);
		frmClinicManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClinicManagementSystem.setTitle("UKM Clinic Management System - Login");
		frmClinicManagementSystem.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 30));
		frmClinicManagementSystem.setBounds(100, 100, 924, 475);
		frmClinicManagementSystem.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("UKM Clinic Mangement System");
		lbl_title.setForeground(new Color(30, 144, 255));
		lbl_title.setFont(new Font("Helvetica", Font.BOLD, 40));
		lbl_title.setBounds(158, 45, 611, 40);
		frmClinicManagementSystem.getContentPane().add(lbl_title);
		Image Picture = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(299, 108, 590, 261);
		frmClinicManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btn_login = new JButton("Login");
		btn_login.setBounds(438, 197, 108, 39);
		panel.add(btn_login);
		btn_login.setForeground(new Color(0, 0, 0));
		btn_login.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 37, 590, 10);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setBounds(42, 133, 148, 32);
		panel.add(lbl_password);
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setFont(new Font("Helvetica", Font.BOLD, 25));
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(42, 92, 148, 31);
		panel.add(lbl_username);
		lbl_username.setForeground(Color.WHITE);
		lbl_username.setBackground(Color.BLACK);
		lbl_username.setFont(new Font("Helvetica", Font.BOLD, 25));
		
		txt_password = new JPasswordField();
		txt_password.setBounds(200, 133, 346, 32);
		panel.add(txt_password);
		txt_password.setFont(new Font("Helvetica", Font.PLAIN, 25));
		txt_password.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setBounds(200, 91, 346, 32);
		panel.add(txt_username);
		txt_username.setForeground(Color.BLACK);
		txt_username.setFont(new Font("Helvetica", Font.PLAIN, 25));
		txt_username.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(20, 108, 259, 261);
		frmClinicManagementSystem.getContentPane().add(panel_2);
		
		JLabel lbl_picture = new JLabel("");
		panel_2.add(lbl_picture);
		lbl_picture.setForeground(Color.WHITE);
		lbl_picture.setBackground(Color.WHITE);
		lbl_picture.setIcon(new ImageIcon(Picture));
		
		btn_login.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.CheckUsernamePassword(txt_username.getText(),txt_password.getText());
	}
	
	public void displayInvalidUsernamePassword() {
		txt_username.setText("");
		txt_password.setText("");
		JOptionPane.showMessageDialog(null, "Invalid Username or Password. Please try it again.", "Error", 0 );
	}
	
	public void displayWelcome(String username, String clinic) {
		txt_username.setText("");
		txt_password.setText("");
		String welcome = "Good Day " + username + "! Welcome to "+clinic;
		JOptionPane.showMessageDialog(null, welcome, "Successful", 1 );
		frmClinicManagementSystem.setVisible(false);
	}
}