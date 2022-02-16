package com.mad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUp {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JTextField txtProfileName;
	private JTextField txtPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create an Username and password to start");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Gotham", Font.PLAIN, 30));
		lblNewLabel.setBounds(327, 142, 655, 86);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblYourMembership = new JLabel("your membership");
		lblYourMembership.setForeground(Color.WHITE);
		lblYourMembership.setFont(new Font("Gotham", Font.PLAIN, 30));
		lblYourMembership.setBounds(327, 171, 281, 86);
		frame.getContentPane().add(lblYourMembership);
		
		JLabel lblNewLabel_1 = new JLabel("Just a few more steps and you're done!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gotham", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(327, 238, 304, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("We hate paperwork,too.");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Gotham", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(327, 258, 304, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(520, 310, 243, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(520, 339, 243, 19);
		frame.getContentPane().add(txtPassword);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(520, 368, 243, 19);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtProfileName = new JTextField();
		txtProfileName.setText("Profile Name");
		txtProfileName.setColumns(10);
		txtProfileName.setBounds(520, 424, 243, 19);
		frame.getContentPane().add(txtProfileName);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("please do not email me Netflix special offers.");
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBounds(520, 449, 243, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Account newAccount = new Account(txtUsername.getText(),txtPassword.getPassword().toString(),txtEmail.getText(),"Malaysia",txtPhoneNumber.getText());
				DataStore.getInstance().addAccount(newAccount);
				frame.dispose();
				SignIn.main(null);
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(577, 476, 131, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SignIn.main(null);
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(1171, 10, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NETFLIX");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Gotham", Font.PLAIN, 60));
		lblNewLabel_1_2.setBounds(21, 0, 281, 71);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("Phone Number");
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(520, 395, 243, 19);
		frame.getContentPane().add(txtPhoneNumber);
	}
		
	}

