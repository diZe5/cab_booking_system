import java.awt.Graphics;

import javax.swing.JApplet;

public class Map3 extends JApplet {

	/**
	 * Create the applet.
	 */
	public Map3() {
		
		int mx=100,my=250;
		Graphics g1;
		String msg;
		
		
			repaint();
	}
		
		public void paint(Graphics g)
		{
			g.drawString("A*",250,600);
			g.drawString("*B",100,350);
			g.drawString("C*",650,150);
			g.drawString("*D",350,400);
			g.drawString("E*",650,450);
			g.drawString("*F",200,100);
		}
	
}
