package guidemo;

import java.awt.event.*;

import javax.swing.*;


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
		// register listener
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// set look-and-feel
				try {
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					System.out.println(PlafFrame.this.getClass().getName());
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
		// TODO Auto-generated method stub

	}

}
