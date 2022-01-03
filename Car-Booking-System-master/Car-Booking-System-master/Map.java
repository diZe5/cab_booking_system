import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Map extends Applet
{
	int mx=100,my=250;
	Graphics g1;
	String msg;
	public void init()
	{
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