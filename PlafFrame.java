package guidemo;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class PlafFrame extends JFrame {

	private JPanel panel;
	
	public PlafFrame() 
	{
		panel = new JPanel();
		// for each look-and-feel make a button
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos)
			makeButton(info.getName(), info.getClassName());
		// add panel to frame
		this.add(panel);
		this.pack();
	}
	
	private void makeButton(String name, final String plafName)
	{
		JButton button = new JButton(name);
		panel.add(button);
		// register listener
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// set look-and-feel
				try {
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					System.out.println(this.getClass().getName());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				PlafFrame frame = new PlafFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setTitle("Demo Look-and-Feel");
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
