import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmptyWallet {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void empty() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmptyWallet window = new EmptyWallet();
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
	public EmptyWallet() {
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
		
		Label label = new Label("You dont have minimum wallet balance of 300 Rs.");
		springLayout.putConstraint(SpringLayout.NORTH, label, 39, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, frame.getContentPane());
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Please add money to continue");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 20, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("Add Money");
		springLayout.putConstraint(SpringLayout.NORTH, button, 42, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, button, -60, SpringLayout.EAST, frame.getContentPane());
		Image img10=new ImageIcon(this.getClass().getResource("coin.png")).getImage();
		button.setIcon(new ImageIcon(img10));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddingMoney.open();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Cancel");
		springLayout.putConstraint(SpringLayout.SOUTH, button, -7, SpringLayout.NORTH, button_1);
		springLayout.putConstraint(SpringLayout.NORTH, button_1, -56, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button_1, -102, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -28, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_1, -55, SpringLayout.EAST, frame.getContentPane());
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Booking.NewScreen();
			}
		});
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -274, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, 44, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 24, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, frame.getContentPane());
		Image img=new ImageIcon(this.getClass().getResource("emp1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel);
	}

}
