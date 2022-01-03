import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map5 extends JPanel {

  public void paint(Graphics g) {
	  	g.drawString("|A|🏁📍",250,600);
		g.drawString("|B|🏁📍",100,350);
		g.drawString("|C|🏁📍",650,150);
		g.drawString("|D🏁|📍",350,400);
		g.drawString("|E|🏁📍",650,450);
		g.drawString("|F|🏁📍",200,100);
		CabAssn.allotDetails();
		for(int i=0;i<25;i++)
		{
			if(CabAssn.available[i])
				g.drawString("🚕",CabAssn.x[i],CabAssn.y[i]);
		}
  }

  public static void open() {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Map5());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(750,750);
    frame.setVisible(true);
  }
}
           
         