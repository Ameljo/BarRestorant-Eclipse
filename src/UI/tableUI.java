package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.UIManager;

import restorant.Order;
import restorant.Product;
import restorant.Table;
import menagment.Exctrator;
import menagment.Formatter;
import menagment.Raport;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**********************************
 * 
 * Tabela qe paraqet produktet
 *
 */
public class tableUI extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private Table table;

	/**
	 * Create the frame.
	 */
	public tableUI(JButton btn, Table tbl) 
	{
		button = btn;
		table = tbl;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
getContentPane().setLayout(null);
		contentPane.setLayout(null);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(28, 49, 378, 293);
		getContentPane().add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(0, 4, 0, 0));
		List list = new List();
		list.setBounds(427, 49, 227, 293);
		contentPane.add(list);
		Order order = table.getOrder();
		if (order != null)
		{
			ArrayList<Product> produktet = order.getProducts();
			for(int i = 0; i < produktet.size(); i++)
				list.add(produktet.get(i).getEmri());
		}

		/***
		 * Shto produktet
		 * 
		 * Ameljo Gjoni
		 */
		ArrayList<JButton> produktet = new ArrayList<JButton>();
		ArrayList<Product> prodList = new Exctrator().getProducts();
		ActionListener porosit = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				JButton btn = (JButton) arg0.getSource();
				//Merr emrin e produktit
				String prod = btn.getActionCommand();
				list.add(btn.getActionCommand());
				//Merr produktin duke perdorur metoden ndihmese
				Product prodct = getProd(prodList, prod);
				table.merrPorosi(prodct);
				button.setBackground(Color.RED);
			}
			
		};
		for(int i = 0; i < prodList.size(); i++)
		{
			produktet.add(new JButton(prodList.get(i).getEmri()));
			produktet.get(i).setForeground(new Color(0, 0, 0));
			produktet.get(i).setBackground(Color.GREEN);
			produktet.get(i).setActionCommand(prodList.get(i).getEmri());
			produktet.get(i).addActionListener(porosit);
			buttonsPanel.add(produktet.get(i));
		}
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 354, 378, 54);
		getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Hiq Produkt");
		btnNewButton.addActionListener(new ActionListener() {
			/******************
			 * Heqja e produktit nga lista ne te cilen paraqiten
			 * 
			 * Ameljo Gjoni
			 */
			public void actionPerformed(ActionEvent e) 
			{
				String item = list.getSelectedItem();
				//Paraqit nje mesazh nese nuk ka produktet te zgjedhur
				if (item == null)
				{
					JOptionPane.showMessageDialog(getContentPane(), "Zgjidhni nje produkt!!!");
					return;
				}
				list.remove(item);
				//Hiqe produktin nga porosia
				table.removeOrder(item);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Printo Fature");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Formatter format = new Formatter();
				
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
		            	new fature(format.getFaturFormat(table.getOrder().getProducts())).setVisible(true);;
		            }
		        });
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pastro Tavolinen");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			/*******************
			 * Funksion qe e ben nje tavoline te lire
			 * fshin porosine dhe ndryshon ngjyren e butonit
			 *
			 * Ameljo Gjoni
			 */
			public void actionPerformed(ActionEvent arg0) 
			{
				new Raport().shtoProdukt(table.getOrder().getProducts());
				table.pastroTavoline();
				button.setBackground(Color.GREEN);
				list.removeAll();
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dil");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setBounds(427, 354, 227, 54);
		contentPane.add(btnNewButton_3);
		
	}
	
	
	/**************
	 * Funksion ndihmes qe kerkon dhe kthen nje produkt duke kerkuar
	 * me listen e produkteve me ane te emrit
	 * 
	 *  Ameljo Gjoni
	 * @param prodList
	 * @param name
	 * @return
	 */
	private Product getProd(ArrayList<Product> prodList, String name)
	{
		String emri = "";
		int sasi = 1;
		double cmim = 0;
		
		for(int i = 0; i < prodList.size(); i++)
		{
			if(prodList.get(i).getEmri() == name)
			{
				emri = prodList.get(i).getEmri();
				cmim = prodList.get(i).getCmimi();
			}
		}
		Product temp = new Product(emri, sasi, cmim);
		
		return temp;
	}
}
