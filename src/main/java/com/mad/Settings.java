package com.mad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPasswordField;

public class Settings {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtPhoneNum;
	private Account user = DataStore.getInstance().getCurrentUser();
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("NETFLIX");
		lblLogo.setForeground(Color.RED);
		lblLogo.setFont(new Font("Gotham", Font.PLAIN, 60));
		lblLogo.setBounds(22, 0, 278, 71);
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				MainMenu.main(null);
			}
		});
		frame.getContentPane().add(lblLogo);
		
		JLabel lblTitle = new JLabel("ACCOUNT");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Gotham Black", Font.PLAIN, 20));
		lblTitle.setBounds(32, 67, 126, 48);
		frame.getContentPane().add(lblTitle);
		
		JLabel lbltitle1 = new JLabel("Username :");
		lbltitle1.setForeground(Color.WHITE);
		lbltitle1.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lbltitle1.setBounds(32, 125, 126, 19);
		frame.getContentPane().add(lbltitle1);
		
		JLabel lblPassword = new JLabel("Old Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblPassword.setBounds(32, 154, 126, 19);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblEmail.setBounds(32, 211, 126, 19);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(32, 240, 126, 19);
		frame.getContentPane().add(lblPhoneNumber);
		
		txtUsername = new JTextField();
		txtUsername.setText(String.valueOf(user.getUsername()));
		txtUsername.setBounds(168, 125, 186, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(String.valueOf(user.getEmail()));
		txtEmail.setColumns(10);
		txtEmail.setBounds(168, 212, 186, 19);
		frame.getContentPane().add(txtEmail);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setText(String.valueOf(user.getPhoneNum()));
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBounds(168, 242, 186, 19);
		frame.getContentPane().add(txtPhoneNum);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBackground(Color.RED);
		JLabel lblNotice = new JLabel("");
		lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotice.setBounds(444, 499, 330, 71);
		frame.getContentPane().add(lblNotice);
		lblNotice.setForeground(Color.WHITE);
		lblNotice.setBackground(Color.BLACK);
		btnNewButton.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				 	String username = txtUsername.getText();
				    String oldPassword = String.valueOf(txtOldPassword.getPassword());
				    String newPassword = String.valueOf(txtNewPassword.getPassword());
				    String PhoneNum = txtPhoneNum.getText();
				    String email = txtEmail.getText();
				    
				    if (username.equals("") || oldPassword.equals("")|| newPassword.equals("")) {
				    	lblNotice.setText("<html> No username or password entered. </html>");
						frame.repaint();
				    }
				    else {
				            if (CryptographyService.getHash(oldPassword).equals(user.getPassword())){
				            	lblNotice.setText("<html> Change successfully </html>");
								frame.repaint();
				            	user.setUsername(username);
				            	user.setPassword(oldPassword,newPassword);
				            	user.setEmail(email);
				            	user.setPhoneNum(PhoneNum);
				            }
				            else {
				            	lblNotice.setText("<html> Old password does not match. Please try again. </html>");
								frame.repaint();
				            }
				
			}}}
		);
		btnNewButton.setBounds(1171, 635, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblNewPassword.setBounds(32, 182, 126, 19);
		frame.getContentPane().add(lblNewPassword);
		
		txtOldPassword = new JPasswordField();
		txtOldPassword.setBounds(168, 156, 186, 19);
		frame.getContentPane().add(txtOldPassword);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setBounds(168, 183, 186, 19);
		frame.getContentPane().add(txtNewPassword);
	}
}
