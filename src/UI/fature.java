package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/*****************************************
 * Dritarja qe perdoret per te paraqitur informacion te ndryshime
 * Si fatura dhe raport.
 * Konstruktori merr si parameter tekstin qe do te paraqitet
 * 
 * @author Ameljo Gjoni
 *
 */

public class fature extends JFrame {

	private JPanel contentPane;
	private String informacion;
	
	public fature(String text) 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnMbyll = new JButton("Mbyll");
		btnMbyll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		contentPane.add(btnMbyll, BorderLayout.SOUTH);
		this.informacion = text;
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(informacion);
		contentPane.add(textPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}
