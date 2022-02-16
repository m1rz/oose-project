package com.mad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

public class SignIn {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList <Account> check = DataStore.getInstance().getAccounts();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(525, 385, 158, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
	
		txtPassword = new JPasswordField();
		txtPassword.setBounds(525, 416, 158, 19);
		frame.getContentPane().add(txtPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		JLabel lblNotice = new JLabel("");
		lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotice.setBounds(444, 499, 330, 71);
		frame.getContentPane().add(lblNotice);
		lblNotice.setForeground(Color.WHITE);
		lblNotice.setBackground(Color.BLACK);
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = txtUsername.getText();
			    String password = String.valueOf(txtPassword.getPassword());
			    if (username.equals("") || password.equals("")) {
			    	lblNotice.setText("<html> No username or password entered. </html>");
					frame.repaint();
			    }
			    else {
			    
			        for (Account account : check) {
		
			            if (account.getUsername().equals(username) && account.getPassword().equals(CryptographyService.getHash(password))){
			            	DataStore.getInstance().setCurrentUser(account);
			            	frame.dispose();
							// invoke next page class
							MainMenu.main(null);
			            }
			            else {
			            	lblNotice.setText("<html> Username or password does not match. Please try again. </html>");
							frame.repaint();
			            }
			}
		}}});
		btnSignIn.setBackground(Color.RED);
		btnSignIn.setBounds(561, 445, 85, 21);
		frame.getContentPane().add(btnSignIn);
		
		JLabel lblNewLabel = new JLabel("Create an Account?");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				// invoke next page class
				SignUp.main(null);
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(545, 476, 123, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NETFLIX");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Gotham", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(10, 0, 297, 71);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
