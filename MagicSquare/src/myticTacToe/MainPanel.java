package myticTacToe;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	@SuppressWarnings("unused")
	private JPanel jPanel; 
	private JButton jButton[];
	private JButtonHandler jButtonHandlers[];

	
	private boolean XOs;
	private boolean gameOver;
	
	public MainPanel() {
		
		jPanel = new JPanel();
		jButton = new JButton[9];
		jButtonHandlers = new JButtonHandler[9];
		setLayout(new GridLayout(3,3));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		for (int i=0;i<9;i++){
			jButton[i] = new JButton();
			add(jButton[i]);
			char ch = (char) ('0'+i+1);
			jButton[i].setText(""+ch);
			jButtonHandlers[i] = new JButtonHandler();
			jButton[i].addActionListener(jButtonHandlers[i]);
		}
		XOs = true;
		gameOver = false;	
	}
	
	private class JButtonHandler implements ActionListener {

		private JButton clicked;
		

		public JButtonHandler() {
			
		}

		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(gameOver)
			{
				System.out.println("Game Over!");
				return;
			}
			
			clicked = (JButton) e.getSource();
			
			String zero = "O";
			String cross = "X";
			
			if (XOs)
			{
				clicked.setText(cross);
				System.out.println("cross");
			}
			else
			{
				clicked.setText(zero);
			}


			if(gameCheck())
			{
				gameOver=true;
				if(XOs)
				{
					System.out.println("cross wins");
				}
				else
				{
					System.out.println("zero wins");
				}
			}
			else
			{
				XOs = !XOs;
				System.out.println(XOs);
				if(XOs)
				{
					System.out.println("zero");
				}
				else
				{
					System.out.println("cross");
				}
				
			}
		}
	}
		
	public boolean gameCheck()
	{
		if (jButton[0].getText().equals(jButton[1].getText()) && (jButton[1].getText().equals(jButton[2].getText()))){
			return true;
		}
		else if (jButton[0].getText().equals(jButton[3].getText()) && (jButton[3].getText().equals(jButton[6].getText()))){
			return true;
		}
		else if(jButton[3].getText().equals(jButton[4].getText()) && (jButton[4].getText().equals(jButton[5].getText()))){
			return true;
		}
		else if (jButton[6].getText().equals(jButton[7].getText()) && (jButton[7].getText().equals(jButton[8].getText()))){
			return true;
		}
		else if (jButton[1].getText().equals(jButton[4].getText()) && (jButton[4].getText().equals(jButton[7].getText()))){
			return true;
		}
		else if (jButton[2].getText().equals(jButton[5].getText()) && (jButton[5].getText().equals(jButton[8].getText()))){
			return true;
		}
		else if (jButton[0].getText().equals(jButton[4].getText()) && (jButton[4].getText().equals(jButton[8].getText()))){
			return true;
		}
		else if (jButton[2].getText().equals(jButton[4].getText()) && (jButton[4].getText().equals(jButton[6].getText()))){
			return true;
		}
		
		return false;
	}
}
