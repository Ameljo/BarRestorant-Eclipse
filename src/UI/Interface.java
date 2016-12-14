package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.BevelBorder;

import java.awt.Component;

import menagment.Exctrator;
import menagment.Formatter;
import menagment.Raport;
import restorant.Table;
import net.miginfocom.swing.MigLayout;

import java.awt.Font;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


public class Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 611);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(25, 97, 531, 401);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		
	
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tavolinat");
		lblNewLabel.setBounds(25, 48, 499, 37);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.ITALIC, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnDil = new JButton("Dil");
		btnDil.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		btnDil.setBackground(Color.ORANGE);
		btnDil.setBounds(732, 563, 90, 28);
		contentPane.add(btnDil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY, 3));
		panel_1.setBounds(568, 97, 243, 401);
		contentPane.add(panel_1);
		
		/***********************
		 * Butoni qe tregon raportin mujor
		 * 
		 * Hap nje intance te re fature duke marre si parameter
		 * raportin mujor.
		 * Ameljo Gjoni
		 */
		JButton btnPrintoRaportinMujor = new JButton("Printo raportin mujor");
		btnPrintoRaportinMujor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Raport raport = new Raport();
				
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
		            {
		                if ("Nimbus".equals(info.getName())) 
		                {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (Exception ex)
			 {
		        	ex.printStackTrace();
			 }

		        java.awt.EventQueue.invokeLater(new Runnable() 
		        {
		            public void run() 
		            {
		            	new fature(raport.getRaportMujor()).setVisible(true);;
		            }
		        });
			}
		});
		panel_1.add(btnPrintoRaportinMujor);
		
		
		
		/*************************
		 * Button qe tregon raportin ditor
		 * Vepron ne menyre te ngjashme me butonin e raportit
		 * mujor
		 * 
		 * Ameljo Gjoni
		 */
		JButton btnPrintoRaportinDitor = new JButton("Printo raportin ditor");
		btnPrintoRaportinDitor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				Raport raport = new Raport();
				
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
		            {
		                if ("Nimbus".equals(info.getName())) 
		                {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (Exception ex)
			 {
		        	ex.printStackTrace();
			 }

		        java.awt.EventQueue.invokeLater(new Runnable() 
		        {
		            public void run() 
		            {
		            	new fature(raport.getRaportDitor()).setVisible(true);;
		            }
		        });
			}
		});
		panel_1.add(btnPrintoRaportinDitor);
		
		JLabel lblNewLabel_1 = new JLabel("Menaxhimi");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(568, 57, 243, 28);
		contentPane.add(lblNewLabel_1);
		
		
		/******
		 * Krijimi i butonave te tavolinave
		 * 
		 * Ameljo gjoni
		 */
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		ArrayList<Table> tables = new Exctrator().getTables();
		
		//Listener per marrjen e porosis.
		//Sherben per te hapur nderfaqene  produkteve
		ActionListener takeOrder = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 try {
			            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			                if ("Nimbus".equals(info.getName())) {
			                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                    break;
			                }
			            }
			        } catch (Exception ex)
				 {
			        	ex.printStackTrace();
				 }

			        java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			            	JButton btn = (JButton) e.getSource();
			            	int tabNumber = Integer.parseInt(btn.getActionCommand());
			                new tableUI((JButton) e.getSource(), tables.get(tabNumber) ).setVisible(true);
			            }
			        });
			}
			
		};
		
		for (int i = 0; i < tables.size(); i++)
		{
			buttons.add(new JButton(tables.get(i).getNumer() + ""));
			buttons.get(i).setActionCommand(i + "");
			buttons.get(i).setForeground(new Color(0, 0, 0));
			buttons.get(i).setBackground(Color.GREEN);
			buttons.get(i).addActionListener(takeOrder);
			panel.add(buttons.get(i));
		}
		
	}
}
