import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.TextField;
import java.awt.Button;

public class gcghc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gcghc window = new gcghc();
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
	public gcghc() {
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
		
		TextField textField = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 62, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 186, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		
		Button button = new Button("New button");
		springLayout.putConstraint(SpringLayout.NORTH, button, 49, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, button, 156, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(button);
	}

}
