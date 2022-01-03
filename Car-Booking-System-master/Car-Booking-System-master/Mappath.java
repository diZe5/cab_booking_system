import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.Math.*;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Mappath extends JPanel {
	int mx=100,my=150;
  public  void paint(Graphics g) {
	  if(Math.abs(mx-Place.dx) >= Math.abs(my-Place.dy)) {	
	  for(int i=0;mx==Place.dx;i++)
		{
			if(mx<Place.dx)
				mx=mx+1;
			else
				mx=mx-1;
			for(int j=0;my==Place.dy;j++)
			{
				if(my<=Place.dy)
				my=my+1;
				else
					my=my-1;
				g.drawString("*",mx,my);
				try{Thread.sleep(2000);}
				catch(Exception e) {};
			}
		}}
	  else if(mx-Place.dx >= my-Place.dy) {	
		  for(int i=0;mx==Place.dx;i++)
			{
				if(mx<Place.dx)
					mx=mx+1;
				else
					mx=mx-1;
				for(int j=0;my==Place.dy;j++)
				{
					if(my<=Place.dy)
					my=my+1;
					else
						my=my-1;
					g.drawString("*",mx,my);
					try{Thread.sleep(2000);}
					catch(Exception e) {};
				}
			}}
	  
					
	  
  }

  public  void open() {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Mappath());
   repaint();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(750,750);
    frame.setVisible(true);
  }
  
  public static void main(String args[]) {
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(new Mappath());
	   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(750,750);
	    frame.setVisible(true);
	  }
	  
  
}
           
         