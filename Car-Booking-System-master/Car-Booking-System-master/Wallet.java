import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SpringLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wallet {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wallet window = new Wallet();
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
	public Wallet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton button = new JButton("OK");
		Image img3=new ImageIcon(this.getClass().getResource("ok-icon2.png")).getImage();
		button.setIcon(new ImageIcon(img3));
		//Image img3=new ImageIcon(this.getClass().getResource("ok-icon2.png")).getImage();
		//button.setIcon(new ImageIcon(img3));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Booking.NewScreen();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, button, -74, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button, -191, SpringLayout.EAST, frame.getContentPane());
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("Rs.");
		
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, label, 107, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 105, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(sai.walletbal+"");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.WEST, button, -40, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 41, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.EAST, label_1, 124, SpringLayout.EAST, label);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img7=new ImageIcon(this.getClass().getResource("money1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img7));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 126, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
	}
}
