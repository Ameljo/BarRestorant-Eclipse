package UI;

import javax.swing.JFrame;

public class Tavolinat 
{
	public static void main( String[] args )
	{
	Tables tables = new Tables();
	tables.setDefaultCloseOperation(
	JFrame.EXIT_ON_CLOSE );
	tables.setSize( 350, 150 );
	tables.setVisible( true );
	}
	}