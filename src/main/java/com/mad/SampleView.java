package com.mad;

import javax.swing.*;

/**
 * Sample application view. Put all GUI-related components here.
 */
public class SampleView extends JFrame {

    public SampleView() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);
    }

    public SampleView(String windowName) {
        super(windowName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);
    }
}
