package com.mad;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ViewTV {

	private JFrame frame;
	private TVSeries tvseries;
	private DataStore ds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTV window = new ViewTV(args[0]);
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
	public ViewTV(String showID) {
		initialize(showID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String showID) {
		ds = DataStore.getInstance();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel netflix = new JLabel("NETFLIX");
		netflix.setVerticalAlignment(SwingConstants.TOP);
		netflix.setHorizontalAlignment(SwingConstants.LEFT);
		netflix.setForeground(Color.RED);
		netflix.setFont(new Font("Gotham", Font.BOLD, 60));
		netflix.setBounds(10, 10, 266, 67);
		netflix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				MainMenu.main(null);
			}
		});
		frame.getContentPane().add(netflix);
		
		JLabel lblMovies = new JLabel("MOVIES");
		lblMovies.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMovies.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMovies.setForeground(Color.WHITE);
		lblMovies.setFont(new Font("Gotham", Font.PLAIN, 20));
		lblMovies.setAlignmentY(0.0f);
		lblMovies.setAlignmentX(1.0f);
		lblMovies.setBounds(291, 47, 82, 23);
		lblMovies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				MoviesView.main(null);
			}
		});
		frame.getContentPane().add(lblMovies);
		
		JLabel lblTvSeries = new JLabel("TV SERIES");
		lblTvSeries.setForeground(Color.WHITE);
		lblTvSeries.setFont(new Font("Gotham", Font.PLAIN, 20));
		lblTvSeries.setAlignmentY(0.0f);
		lblTvSeries.setAlignmentX(1.0f);
		lblTvSeries.setBounds(388, 47, 108, 23);
		lblTvSeries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SeriesView.main(null);
			}
		});
		frame.getContentPane().add(lblTvSeries);
		
		
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tvseries = ds.getTVSeriesByID(Integer.parseInt(showID));
		
		System.out.println(showID);
		JLabel TV   = new JLabel();
		TV.setBounds(27, 160, 167, 251);
		TV.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("pics" + File.separator  + showID +".jpeg")));
		frame.getContentPane().add(TV);
		
		JLabel labelID = new JLabel("ID: " + showID);
		labelID.setForeground(Color.WHITE);
		labelID.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelID.setBounds(229, 160, 167, 30);
		frame.getContentPane().add(labelID);
		
		JLabel labelTitle = new JLabel("<html>" +"Title: " + tvseries.getTitle() + "</html>");
		labelTitle.setForeground(Color.WHITE);
		labelTitle.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelTitle.setBounds(229, 206, 341, 30);
		frame.getContentPane().add(labelTitle);
		
		JLabel labelCat = new JLabel("<html>" +"Category: " + tvseries.getCategory() + "</html>");
		labelCat.setForeground(Color.WHITE);
		labelCat.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelCat.setBounds(229, 252, 295, 30);
		frame.getContentPane().add(labelCat);
		
		JLabel labelGenre = new JLabel("<html>" +"Genre: " + tvseries.getGenre() + "</html>");
		labelGenre.setForeground(Color.WHITE);
		labelGenre.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelGenre.setBounds(534, 252, 266, 30);
		frame.getContentPane().add(labelGenre);
		
		JLabel labelRate = new JLabel("Rating: " + String.valueOf(tvseries.getRate()) +"/10");
		labelRate.setForeground(Color.WHITE);
		labelRate.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelRate.setBounds(229, 300, 233, 30);
		frame.getContentPane().add(labelRate);
		
		JLabel labelEpisode = new JLabel("Episodes: " + String.valueOf(tvseries.getEpisode()));
		labelEpisode.setForeground(Color.WHITE);
		labelEpisode.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelEpisode.setBounds(534, 292, 208, 30);
		frame.getContentPane().add(labelEpisode);
		
		JLabel labelDesc = new JLabel("<html>" + tvseries.getDescription() + "</html>");
		labelDesc.setVerticalAlignment(SwingConstants.TOP);
		labelDesc.setHorizontalAlignment(SwingConstants.LEFT);
		labelDesc.setForeground(Color.WHITE);
		labelDesc.setFont(new Font("Gotham", Font.PLAIN, 20));
		labelDesc.setBounds(229, 386, 1027, 70);
		frame.getContentPane().add(labelDesc);
		
		JLabel lblNewLabel = new JLabel("Description: ");
		lblNewLabel.setFont(new Font("Gotham", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(229, 350, 137, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Gotham", Font.BOLD, 25));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(10, 87, 114, 30);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SeriesView.main(null);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_Acc = new JLabel("");
		label_Acc.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("pics" + File.separator + "userIcon.png")));
		label_Acc.setHorizontalAlignment(SwingConstants.RIGHT);
		label_Acc.setBounds(1129, 33, 40, 40);
		label_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Settings.main(null);
			}
		});
		frame.getContentPane().add(label_Acc);
		
		JLabel label_SignOut = new JLabel("SIGN OUT");
		label_SignOut.setVerticalAlignment(SwingConstants.BOTTOM);
		label_SignOut.setHorizontalAlignment(SwingConstants.CENTER);
		label_SignOut.setForeground(Color.WHITE);
		label_SignOut.setFont(new Font("Gotham", Font.BOLD, 15));
		label_SignOut.setBounds(1179, 44, 77, 17);
		label_SignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SignIn.main(null);
			}
		});
		frame.getContentPane().add(label_SignOut);
		
		JLabel label_Search = new JLabel("");
		label_Search.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("pics" + File.separator + "searchIcon.png")));
		label_Search.setForeground(Color.WHITE);
		label_Search.setBounds(1071, 29, 48, 48);
		label_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Search.main(null);
			}
		});
		frame.getContentPane().add(label_Search);
		
		
		
	}

}
