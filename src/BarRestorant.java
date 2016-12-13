import javax.swing.JFrame;

import restorant.Table;
import menagment.DatabaseCreator;
import UI.Tables;

public class BarRestorant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Tables tables = new Tables();
		tables.setDefaultCloseOperation(
		JFrame.EXIT_ON_CLOSE );
		tables.setSize( 350, 150 );
		tables.setVisible( true );
		*/
		
		Table tavoline = new Table();
		tavoline.merrPorosi("Kola", 3, 100);
		tavoline.merrPorosi("kafe", 2, 70);
		tavoline.nxirrFatur();
	}

}
