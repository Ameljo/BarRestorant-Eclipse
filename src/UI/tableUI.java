package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class tableUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tableUI frame = new tableUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tableUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(28, 49, 378, 293);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(506, 326, 124, -276);
		getContentPane().add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 354, 378, 54);
		getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Hiq Produkt");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Printo Fature");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pastro Tavolinen");
		panel_1.add(btnNewButton_2);
	}
}
