package com.mad;

import java.util.ArrayList;

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

public class SearchController {
    
    private static SearchController instance = null;
    private DataStore ds = null;
    private String keyword;
    private ArrayList<Show> results;

    private SearchController() {
        ds = DataStore.getInstance();
        keyword = null;
        results = null;
    }

    public static SearchController getInstance() {
        if (instance == null) {
            instance = new SearchController();
        }
        return instance;
    }

    public ArrayList<Show> getResults() {
        return results;
    }

    public void setResults(ArrayList<Show> results) {
        this.results = results;
    }

    public void searchFor(String key) {
        results = new ArrayList<>();
        ArrayList<TVSeries> series = ds.getTVSeries();
        ArrayList<Movie> movies = ds.getMovies();

        for (TVSeries show : series) {
            if (show.getTitle().toLowerCase().contains(key)) {
                System.out.println(show.getTitle());
                results.add(show);
            }
        }
        for (Movie show : movies) {
            if (show.getTitle().toLowerCase().contains(key)) {
                System.out.println(show.getTitle());
                results.add(show);
            }
        }
        
    }

    

}
