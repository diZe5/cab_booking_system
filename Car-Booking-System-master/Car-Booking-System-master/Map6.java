import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Map6 extends JFrame {

	private JPanel contentPane;
 static Graphics g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map6 frame = new Map6();
					frame.setVisible(true);
					// public void paint(Graphics g) {
						  	g.drawString("A*",250,600);
							g.drawString("*B",100,350);
							g.drawString("C*",650,150);
							g.drawString("*D",350,400);
							g.drawString("E*",650,450);
							g.drawString("*F",200,100);
					 //}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Map6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
