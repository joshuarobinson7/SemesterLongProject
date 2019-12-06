/*
Josh Robinson
Semester Long Project
Driver
*/
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Driver extends JFrame{
	public Driver() {
		getContentPane().setLayout(null);
		
		JPanel Side = new JPanel();
		Side.setBounds(10, 11, 105, 222);
		getContentPane().add(Side);
		Side.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		
		btnStart.setBounds(10, 11, 85, 23);
		Side.add(btnStart);
		
		JButton btnNewTower = new JButton("New Tower");
		
		btnNewTower.setBounds(10, 64, 85, 29);
		Side.add(btnNewTower);
		
		Map m1 = new Map();
		m1.setBounds(141, 11, 500, 500);
		getContentPane().add(m1);
		m1.setLayout(null);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m1.fire();
			}
		});
		
		btnNewTower.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m1.createTower();
			}
		});
	}
	public static void main(String[] args) {
		Driver game= new Driver();
		game.setSize(500,500);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	}
}