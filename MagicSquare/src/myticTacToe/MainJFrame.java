package myticTacToe;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainJFrame extends JFrame {

	private MainPanel mainPanel;
	private Dimension dim;
	
	public MainJFrame() {
		
		//Necessary initializations
		super("TicTacToe");
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
		
		//MainPanel creation and adding it to the MainJFrame
		mainPanel = new MainPanel();
		add(mainPanel);
		
	}
}
