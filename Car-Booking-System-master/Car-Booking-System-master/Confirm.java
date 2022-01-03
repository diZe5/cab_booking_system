import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Confirm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm window = new Confirm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Confirm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		Label label = new Label("Your Ride is Confirmed");
		springLayout.putConstraint(SpringLayout.NORTH, label, 31, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 101, SpringLayout.WEST, frame.getContentPane());
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Your Ride is on its Way");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 62, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label_1);
		//Mappath.open();
		
		JButton btnMap = new JButton("MAP");
		springLayout.putConstraint(SpringLayout.WEST, btnMap, 177, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnMap, 72, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, btnMap, 301, SpringLayout.WEST, frame.getContentPane());
		Image img3=new ImageIcon(this.getClass().getResource("map.png")).getImage();
		btnMap.setIcon(new ImageIcon(img3));
		springLayout.putConstraint(SpringLayout.NORTH, btnMap, 31, SpringLayout.SOUTH, label_1);
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mappath ma=new Mappath();
				ma.setVisible(true);
				
			}
		});
		frame.getContentPane().add(btnMap);
	}
}
