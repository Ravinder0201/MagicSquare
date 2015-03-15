package myticTacToe;

import javax.swing.SwingUtilities;

public class TicTacToeApp {

	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new MainJFrame();
			}
		});
	}

}
