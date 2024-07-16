package com.swing;

import javax.swing.*;
import java.awt.*;
public class Panel1 {

	public static void main(String args[]) {
		Panel1 panel1 = new Panel1();
		panel1.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JButton button = new JButton("shock me");
		panel.add(button);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(200, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
