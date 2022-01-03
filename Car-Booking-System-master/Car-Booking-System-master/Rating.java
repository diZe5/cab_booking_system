import java.awt.EventQueue;
import java.lang.*;
import java.lang.Math.*;
import java.lang.Math.*;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Rating {

	private JFrame frame;
	double rat,rat2;
	

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rating window = new Rating();
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
	public Rating() {
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
		
		Label label = new Label("Thanks for the Ride");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, label, 33, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 65, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Rate the Ride out of 5");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 36, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Your Current Balance");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 32, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().add(label_2);
		
		Button button = new Button("OK");
		springLayout.putConstraint(SpringLayout.NORTH, button, -50, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, -148, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button, -73, SpringLayout.EAST, frame.getContentPane());
		button.setFont(new Font("Cambria", Font.BOLD, 14));
		frame.getContentPane().add(button);
		
		TextField textField = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 37, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.EAST, textField, 71, SpringLayout.EAST, label_1);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, label);
		Image img3=new ImageIcon(this.getClass().getResource("emoji.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		frame.getContentPane().add(lblNewLabel);
		
		sai.walletbal=sai.walletbal-(int)CabAssn.dist/2;
		JLabel lblNewLabel_1 = new JLabel(sai.walletbal+"");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, label_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 6, SpringLayout.EAST, label_2);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Click here to LogOut !");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -5, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -23, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 25, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, -104, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 33, SpringLayout.SOUTH, label_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -10, SpringLayout.EAST, frame.getContentPane());
		Image img=new ImageIcon(this.getClass().getResource("namo2.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_3);
		/*private static BigDecimal truncateDecimal(double x,int nod)
		{
			
		}*/
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Double.parseDouble(textField.getText())>5)
				{
					JOptionPane.showMessageDialog(textField, "rating should be less than 5");
				}
				else {
				rat2=(CabAssn.nooftrips[CabAssn.index]*CabAssn.rating[CabAssn.index]+rat)/(CabAssn.nooftrips[CabAssn.index]+1);
				//rat2=Math.round(rat2*100)/100;
				System.out.println(rat2);
				frame.dispose();
				rat=Double.parseDouble(textField.getText());
				
			
		
		try {
		//updating driver details...
		 Class.forName("com.mysql.jdbc.Driver");
	     Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		 Statement stmt3=con2.createStatement();
     	 String query2="update  driverdetails set Is_Available=?,No_of_trips=?,Rating=?,Location_X=?,Location_Y=? where Driver_Name=?";
     	 PreparedStatement ps3=con2.prepareStatement(query2);
     	 

     	ps3.setInt(1,1);
     	//DecimalFormat df=newDecimalFormat("#.###");
     String rat3=String.format("%.3g%n",rat2);
     System.out.println("in updating "+ rat3);
     	ps3.setString(3,rat3);
     	ps3.setString(6,CabAssn.names[CabAssn.index]);
     	ps3.setInt(2,CabAssn.nooftrips[CabAssn.index]+1 );
     	ps3.setInt(4,Place.dx);
     	ps3.setInt(5,Place.dy);
     	ps3.execute();
     	ps3.executeUpdate();
     	
     	//updating user details....
     	 Class.forName("com.mysql.jdbc.Driver");
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		 Statement stmt=con.createStatement();
     	 String query="update  userdetails set onatrip=?,Wallet_bal=?  where User_ID=?";
     	 PreparedStatement ps=con.prepareStatement(query);
     	 System.out.println("in updating user details");
     	 
     	ps.setInt(1,0);
     	Driver.onatrip=false;
     	ps.setInt(2,sai.walletbal);
     	ps.setString(3,sai.username2);
     	
     	ps.execute();
     	ps.executeUpdate();
     	con2.close();
     	
		}
		catch(Exception re)
		{
			System.out.println(re);
		}
			}
			}
		});
		
	}
}
