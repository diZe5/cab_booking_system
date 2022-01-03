import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Timer {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer window = new Timer();
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
	//public Timer() {
	//	initialize();
	//}

	/**
	 * Initialize the contents of the frame.
	 */
	private Timer() {
		Thread t=new Thread();
		t.start();
		for(int i=0;i<10;i++)
		{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(i+"");
		lblNewLabel.setBounds(147, 88, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		//add(lblNewLabel);
		try {
		t.sleep(1000);
	}
		catch(Exception e){
			
		}
		}}

}
