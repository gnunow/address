package guidemo;

import java.awt.*;
import javax.swing.*;


public class SimpleFormDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setTitle("The First Simple Frame");
				
				
			}
		});

	}

}


@SuppressWarnings("serial")
class SimpleFrame extends JFrame
{
	//  private static final int DEFAULT_WIDTH = 500;
	//  private static final int DEFAUT_LENGTH = 300; 
	
	public SimpleFrame() 
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setSize(screenWidth/3*2, screenHeight/3*2);
		setLocationByPlatform(true);
		Image img = kit.getImage(getClass().getResource("icon.png"));
		setIconImage(img);
		// add component
		add(new HelloComponent());
		pack();
	}
}


@SuppressWarnings("serial")
class HelloComponent extends JComponent
{
	@Override
	public void paintComponent(Graphics g) 
	{
		g.drawString("Just a Hello World program", 75, 100);
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(300, 200);
	}
}