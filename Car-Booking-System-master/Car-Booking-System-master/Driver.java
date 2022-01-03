import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Label;
import java.awt.Button;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Driver {

	private JFrame frame;
	static boolean onatrip;
	/**
	 * Launch the application.
	 */
	public static void opentab() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver window = new Driver();
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
	Place pl=new Place();
	public Driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 102));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel label = new JLabel("The Details of the Cab Driver You Hired");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, label, -15, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 65, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1, 34, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Vehicle No");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Fare");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 6, SpringLayout.SOUTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.EAST, label_3, 36, SpringLayout.WEST, label);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Rating");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, label_3);
		springLayout.putConstraint(SpringLayout.EAST, label_4, 0, SpringLayout.EAST, label_1);
		frame.getContentPane().add(label_4);
		
		JButton btnConfirm = new JButton("CONFIRM");
		springLayout.putConstraint(SpringLayout.NORTH, btnConfirm, -50, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnConfirm, 62, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConfirm, -10, SpringLayout.SOUTH, frame.getContentPane());
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirm.setForeground(new Color(0, 0, 0));
		Image img3=new ImageIcon(this.getClass().getResource("Ok-icon (1).png")).getImage();
		btnConfirm.setIcon(new ImageIcon(img3));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   JOptionPane.showMessageDialog(null,"your ride is confirmed!!");
				frame.dispose();
				
				try {
		            Class.forName("com.mysql.jdbc.Driver");
		        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		        	Statement stmt2=con.createStatement();
		        	String query="update  driverdetails set Is_Available=? where Driver_Name=?";
		        	//String query2="update userdetails set onatrip=? where User_ID=?";
		        	PreparedStatement ps2=con.prepareStatement(query);
		        	//PreparedStatement ps3=con.prepareStatement(query2);

		        	ps2.setInt(1,0);
		        	ps2.setString(2,CabAssn.names[CabAssn.index]);
		        	
		        	//ps2.setInt(3, i+1);
		        	//ps2.setBoolean(4, true);
		        	
		        	
		        	ps2.execute();
		        	ps2.executeUpdate();
		        	//con.close();
		        	Class.forName("com.mysql.jdbc.Driver");
		        	Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		        	Statement stmt3=con2.createStatement();
		        	//String query="update  driverdetails set Is_Available=? where Driver_Name=?";
		        	String query2="update userdetails set onatrip=? where User_ID=?";
		        	//PreparedStatement ps2=con.prepareStatement(query);
		        	PreparedStatement ps3=con2.prepareStatement(query2);
		        	ps3.setInt(1, 1);
		        	onatrip=true;
		        	ps3.setString(2, sai.username2);
		        	ps3.execute();
		        	ps3.executeUpdate();
		        	
		            }
		            catch(Exception mye) {
		            	System.out.println(mye);
		            }
				try {
				Thread.sleep(((int)(Place.distance/3))*1000);
				Rating.open();
				}
				catch(Exception te)
				{
					System.out.println(te);
				
				}
			
			}
		});
		frame.getContentPane().add(btnConfirm);
		
		Button button_1 = new Button("Cancel");
		springLayout.putConstraint(SpringLayout.EAST, btnConfirm, -50, SpringLayout.WEST, button_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button_1, -181, SpringLayout.EAST, frame.getContentPane());
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Place.open();
			}
		});
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel(CabAssn.names[CabAssn.index]);
		lblNewLabel.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 45, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, label_1);
		frame.getContentPane().add(lblNewLabel);
		System.out.println(CabAssn.names[CabAssn.index]);
		
		JLabel lblNewLabel_1 = new JLabel(CabAssn.id[CabAssn.index]);
		lblNewLabel_1.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, label_2);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Place.distance/2+"");
		lblNewLabel_2.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, label_3);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(CabAssn.rating[CabAssn.index]+"");
		lblNewLabel_3.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 63, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 28, SpringLayout.EAST, label_4);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -65, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, label_4);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblEstimatedTimeOf = new JLabel("Estimated time of Departure");
		lblEstimatedTimeOf.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblEstimatedTimeOf, 141, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblEstimatedTimeOf, -20, SpringLayout.EAST, frame.getContentPane());
		lblEstimatedTimeOf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.NORTH, lblEstimatedTimeOf, 15, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEstimatedTimeOf, 0, SpringLayout.SOUTH, label_2);
		frame.getContentPane().add(lblEstimatedTimeOf);
		
		JLabel lblNewLabel_4 = new JLabel((int)Place.distance/3+"");
		lblNewLabel_4.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, label_3);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, label);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		Image img5=new ImageIcon(this.getClass().getResource("road.png.jpg")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img5));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 262, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_5);
		System.out.println(CabAssn.index);
	}
}
