package guidemo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class ButtonFrameAnon extends JFrame {

	private JPanel panel;
	private JPanel secondpanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrameAnon()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		panel = new JPanel();
		secondpanel = new JPanel();
		
		// create buttons
		makeButton("Yellow", Color.YELLOW);
		makeButton("Blue", Color.BLUE);
		makeButton("Red", Color.RED);
		
		secondpanel.add(new JButton("Hello"));
		secondpanel.add(new JButton("World"));
		
		// add panel to frame
		add(panel, BorderLayout.SOUTH);
		add(secondpanel, BorderLayout.NORTH);
	}
	
	public void makeButton(String name, final Color backgroundColor)
	{
		JButton button = new JButton(name);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.setBackground(backgroundColor);
			}
		}); 
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
				ButtonFrameAnon frame = new ButtonFrameAnon();
				
				System.out.println(frame.getClass().getName() + " " + frame.getName());
				System.out.println(frame.getClass() == ButtonFrameAnon.class);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setTitle("Testing Layout");
				
			}
		});

	}

}
