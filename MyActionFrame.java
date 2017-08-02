package guidemo;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class MyActionFrame extends JFrame 
{
	private JPanel panel;
	
	public MyActionFrame()
	{
		setSize(300, 200);
		panel = new JPanel();
		// define actions
		Action yellowAction = new MyColorAction("Yellow", 
												new ImageIcon("yellow-ball.gif"), 
												Color.YELLOW);
		Action blueAction = new MyColorAction("Blue", 
											  new ImageIcon("blue-ball.gif"), 
											  Color.BLUE);
		MyColorAction redAction = new MyColorAction("Red", 
													new ImageIcon("red-ball.gif"), 
													Color.RED);
		
		// add buttons to these actions
		panel.add(new JButton(yellowAction));
		panel.add(new JButton(blueAction));
		panel.add(new JButton(redAction));
		
		// add panel to frame
		add(panel);
		
		// map keystrocks with names
		InputMap imap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		// map names with actions
		ActionMap amap = panel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	class MyColorAction extends AbstractAction
	{
		public MyColorAction(String name, Icon icon, Color c)
		{
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "set pane to color " + name.toLowerCase());
			putValue("color", c);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Color c = (Color) getValue("color");
			panel.setBackground(c);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// create frame
				MyActionFrame frame = new MyActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setTitle("Demo Action");
				frame.addWindowListener(new WindowAdapter() 
				{
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				
			}
		}); 
	}
}
