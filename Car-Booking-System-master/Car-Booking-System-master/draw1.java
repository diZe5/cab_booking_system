import java.awt.*;
import javax.swing.*;



public class draw1 extends JComponent {

	private Graphics2D g2;
	private Image img;
	private int x=0,y=0,oldx=0,oldy=0;
	public void draw1()
	{
		setDoubleBuffered(false);
		for(int i=0;i<10;i++)
		{
			g2.drawLine(oldx, oldy, x, y);
			oldx=x;
			oldy=y;
			x++;
			y++;
		}
	}
	protected void paintComponent(Graphics g)
	{
		if(img==null)
		{
			img=createImage(getSize().width,getSize().height);
			g2 =(Graphics2D) img.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		}
		g.drawImage(img,0,0,null);
		}

	public static void main(String args[])
	{
		draw1 dr=new draw1();
		dr.draw1();
	}
}