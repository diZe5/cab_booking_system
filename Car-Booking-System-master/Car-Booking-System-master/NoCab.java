import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;

public class NoCab {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoCab window = new NoCab();
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
	public NoCab() {
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
		
		Label label = new Label("No Cabs Available Right Now");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, label, 56, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 97, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Sorry For The Inconvience");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 23, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 110, SpringLayout.WEST, frame.getContentPane());
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(label_1);
		
		Button button = new Button("Back");
		springLayout.putConstraint(SpringLayout.WEST, button, 182, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, -45, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(button);
	}

}
