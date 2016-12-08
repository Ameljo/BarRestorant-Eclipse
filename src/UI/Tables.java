package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Tables extends JFrame
{
	private JList colorJList; // lista qe porosite e tavolines
	private JList copyJList; // list ku do kopjohen emrat e produkteve
	private JButton copyJButton; // butoni qe kopjon emrat e produkteve
	private static final String[] produkte = { "Pica", "Spageti", "Rizoto",
	"Peshk", "Mish" , "Cola", "Fanta", "Bravo", "Vere", "Birre" 
	};
	
	
	// Konstruktori i Tabeles
	
	public void Tabeles()
	{
    super( "Bar Restorant" );
    setLayout( new FlowLayout());
	colorJList = new JList( produkte );
	
	colorJList.setVisibleRowCount( 4 );
	colorJList.setSelectionMode(
	ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
	add( new JScrollPane( colorJList ) );
	copyJButton = new JButton( "Shfaq produktet" );
	
	copyJButton.addActionListener(
	new ActionListener() // klasa e brendshme anonime
	{
	// mbajtja e butonit
	public void actionPerformed( ActionEvent event )
	{
	// shtimi i ngjyres ne copyJList
	copyJList.setListData( colorJList.getSelectedValuesList().toArray() );
	}
	}
	
	);
	
	add( copyJButton );
	copyJList = new JList();
	copyJList.setVisibleRowCount( 5 );
	copyJList.setFixedCellWidth( 100 );
	copyJList.setFixedCellHeight( 15 );
	copyJList.setSelectionMode(
	ListSelectionModel.SINGLE_INTERVAL_SELECTION );
	add( new JScrollPane( copyJList ) );
	}
	}