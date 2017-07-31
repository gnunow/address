package guidemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;


public class ButtonFrame extends JFrame {

	private JPanel panel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// create buttons
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		// add buttons to panel
		panel = new JPanel();
		panel.add(redButton);
		panel.add(yellowButton);
		panel.add(blueButton);
		// add panel to frame
		add(panel);
		
		// create listeners
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		// register listeners to buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	// inner class
	private class ColorAction implements ActionListener
	{
		private Color backgroundColor;
		
		public ColorAction(Color c)
		{
			backgroundColor = c; 
		}
		
		@Override
		public void actionPerformed(ActionEvent event)
		{
			panel.setBackground(backgroundColor);
		}
	}
	
	// unit test
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// event dispatch thread
		EventQueue.invokeLater(new Runnable() {
	
			@Override
			public void run() {
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setTitle("The First Simple Frame");
				
			}
		});

	}

}
