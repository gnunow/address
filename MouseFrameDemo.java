package guidemo;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class MouseFrameDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MouseFrame frame = new MouseFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setTitle("Demo Mouse Event");
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

@SuppressWarnings("serial")
class MouseFrame extends JFrame
{
	public MouseFrame()
	{
		setSize(300, 200);
		add(new MouseComponent());
	}
}

@SuppressWarnings("serial")
class MouseComponent extends JComponent
{
	private static final int SIDELENGTH = 10;
	private ArrayList<Rectangle2D> squares;   // list of squares
	private Rectangle2D current;              // current square
	
	public MouseComponent()
	{
		squares = new ArrayList<Rectangle2D>();
		current = null;
		addMouseListener(new MouseHandler());
	}
	
	// to control repainting
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		// draw all squares
		for (Rectangle2D r : squares)
			g2.draw(r);
	}
	
	public Rectangle2D find(Point2D p) 
	{
		for (Rectangle2D r : squares) {
			if (r.contains(p)) return r;
		}
		return null;
	}
	
	public void add(Point2D p) 
	{
		double x = p.getX();
		double y = p.getY();
		current = new Rectangle2D.Double(x-SIDELENGTH/2, y-SIDELENGTH/2, SIDELENGTH, SIDELENGTH);
		squares.add(current);
		repaint();     // method from Component
	}
	
	public void remove(Rectangle2D r)
	{
		if (r == null) return;
		if (r == current) current = null;
		squares.remove(r);
		repaint();
	}
	
	private class MouseHandler extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent event)
		{
			// add a square
			current = find(event.getPoint());
			if (current == null) add(event.getPoint());
		}
		@Override
		public void mouseClicked(MouseEvent event)
		{
			// remove current square if double-click
			current = find(event.getPoint());
			if (current != null && event.getClickCount() >= 2) remove(current);
		}
	}
}

