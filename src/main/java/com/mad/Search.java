package com.mad;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class Search {
    private JFrame frame;
	private DataStore ds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
		ds = DataStore.getInstance();
		initialize();
	}

    private void updateUI(ArrayList<Show> results, JLabel title, JPanel res, JFrame parentFrame) {
        System.out.println("Here " + results.size());
        title.setText("Search Results");

        if (results.size() > 0) {
            res.removeAll();
            for(Show show : results) {
                System.out.println(show.getTitle());
                JLabel entry   = new JLabel();
                entry.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("pics" + File.separator  + show.getShowID() +".jpeg")));
                entry.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        parentFrame.dispose();
                        String[] name = {String.valueOf(show.getShowID())};
                        if (show instanceof Movie) {
                            ViewMovie.main(name);
                        } else if (show instanceof TVSeries) {
                            ViewTV.main(name);
                        }
                        
                        
                    }
                });
                res.add(entry);
            }
        } else {
            title.setText("There are no results.");
        }
        parentFrame.revalidate();
        parentFrame.repaint();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.RED));
		UIManager.put("ScrollBar.track", new ColorUIResource(Color.BLACK));

		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.BLACK);
        JPanel baru = new JPanel(new BorderLayout());
        baru.setBackground(Color.BLACK);
        JPanel terbaru = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        terbaru.setBackground(Color.BLACK);
        JLabel label = new JLabel("");
        label.setFont(new Font("Gotham", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        terbaru.add(label);
        baru.add(terbaru, BorderLayout.NORTH);
        JPanel latest = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        latest.setBackground(Color.BLACK);
        baru.add(latest);
        panel_1.add(baru);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2, BorderLayout.WEST);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.LEFT, 15, 5);
		fl_panel_2.setAlignOnBaseline(true);
		panel_2.setLayout(fl_panel_2);
		

		JLabel netflix = new JLabel("NETFLIX");
		netflix.setVerticalAlignment(SwingConstants.TOP);
		netflix.setHorizontalAlignment(SwingConstants.LEFT);
		netflix.setForeground(Color.RED);
		netflix.setFont(new Font("Gotham", Font.BOLD, 60));
		netflix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				MainMenu.main(null);
			}
		});
		panel_2.add(netflix);
		
		JLabel lblMovies = new JLabel("MOVIES");
		lblMovies.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMovies.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMovies.setForeground(Color.WHITE);
		lblMovies.setFont(new Font("Gotham", Font.PLAIN, 20));
		lblMovies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				MoviesView.main(null);
			}
		});
		lblMovies.setAlignmentY(0.0f);
		lblMovies.setAlignmentX(1.0f);
		panel_2.add(lblMovies);
		
		JLabel lblTvSeries = new JLabel("TV SERIES");
		lblTvSeries.setForeground(Color.GRAY);
		lblTvSeries.setFont(new Font("Gotham", Font.PLAIN, 20));
		lblTvSeries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SeriesView.main(null);
			}
		});
		lblTvSeries.setAlignmentY(0.0f);
		lblTvSeries.setAlignmentX(1.0f);
		panel_2.add(lblTvSeries);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setVgap(10);
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3, BorderLayout.EAST);

        JTextField searchBar = new JTextField();
		searchBar.setHorizontalAlignment(SwingConstants.LEFT);
		searchBar.setBackground(Color.DARK_GRAY);
        searchBar.setForeground(Color.WHITE);
        searchBar.setColumns(30);
		searchBar.setFont(new Font("Gotham", Font.PLAIN, 20));
		searchBar.setAlignmentY(0.0f);
		searchBar.setAlignmentX(1.0f);
        panel_3.add(searchBar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("pics" + File.separator + "searchIcon.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchController.getInstance().searchFor(searchBar.getText());
                updateUI(SearchController.getInstance().getResults(), label, latest, frame);
            }
        });
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("pics" + File.separator + "userIcon.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Settings.main(null);
			}
		});
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN OUT");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Gotham", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SignIn.main(null);
			}
		});
		panel_3.add(lblNewLabel_2);

		ArrayList <Movie> check = ds.getMovies();
		ArrayList <String> category = new ArrayList<String>();

		category.add("RECENT");
		category.add("LATEST");
		category.add("ANIME");
		category.add("K-DRAMA");
		category.add("CARTOON");
		category.add("FAMILY");
		category.add("MUSICAL");
		category.add("COMING SOON");

		JScrollPane scrollPane = new JScrollPane(panel_1);
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){   
			@Override
			protected JButton createDecreaseButton(int orientation) {
				return createZeroButton();
			}

			@Override    
			protected JButton createIncreaseButton(int orientation) {
				return createZeroButton();
			}

			private JButton createZeroButton() {
				JButton jbutton = new JButton();
				jbutton.setPreferredSize(new Dimension(0, 0));
				jbutton.setMinimumSize(new Dimension(0, 0));
				jbutton.setMaximumSize(new Dimension(0, 0));
				return jbutton;
			}
		});

        
		scrollPane.setViewportBorder(null);
		//8 = category.size(); so 8 tu saiz catgory 
		panel_1.setLayout(new GridLayout(8, 0, 0, 0));
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		
		

	}
}
