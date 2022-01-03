import java.awt.EventQueue;
import javax.swing.*;

import java.sql.*;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;


public class U_R {

	private JFrame frame;
	int count=0;
	String msg1;
	int x=0;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					U_R window = new U_R();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		
		
		public static void main(String args[]) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						U_R window = new U_R();
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
	public U_R() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setForeground(new Color(255, 51, 102));
		frame.setBounds(100, 100, 461, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("User Name");
		label.setForeground(new Color(240, 230, 140));
		
		label.setBounds(74, 30, 81, 24);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(label);
		
		TextField username = new TextField();
		username.setBounds(183, 30, 213, 22);
		frame.getContentPane().add(username);
		String varname = username.getText().toString();
		
		JLabel label_1 = new JLabel("User ID");
		label_1.setForeground(new Color(240, 230, 140));
		label_1.setBounds(86, 59, 57, 22);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(label_1);
		
		TextField userid = new TextField();
		userid.setBounds(183, 60, 213, 22);
		frame.getContentPane().add(userid);
		
		JLabel label_2 = new JLabel("Phone Number");
		label_2.setForeground(new Color(240, 230, 140));
		label_2.setBounds(60, 88, 110, 23);
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(label_2);
		
		TextField phno = new TextField();
		phno.setBounds(183, 89, 213, 22);
		frame.getContentPane().add(phno);
		
		JLabel label_3 = new JLabel("Email ID");
		label_3.setForeground(new Color(240, 230, 140));
		label_3.setBounds(84, 117, 57, 24);
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(label_3);
		
		TextField email = new TextField();
		email.setBounds(183, 118, 213, 22);
		frame.getContentPane().add(email);
		
		JLabel label_4 = new JLabel("Password");
		label_4.setForeground(new Color(240, 230, 140));
		label_4.setBounds(78, 146, 76, 24);
		label_4.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(label_4);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(183, 147, 213, 22);
		frame.getContentPane().add(password);
		
		
		Button button = new Button("REGISTER");
		button.setBounds(213, 205, 63, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					Statement stmt2=con2.createStatement();
					String sql="Select * from userdetails where User_ID='"+userid.getText()+"'   ";
					ResultSet rs2=stmt2.executeQuery(sql);
					
					if(rs2.next())
						{
						JOptionPane.showMessageDialog(null, "User ID already exists .try anoher one");
						}
					else
					{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					String query=" insert into userdetails(User_name,User_ID,Password,Email_ID,Phone_Number)  values(?,?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(query);
					for(int i=0;i<email.getText().length();i++)
					{
						if(email.getText().charAt(i)=='@')
							count++;
					}
					if(count==0)
						 msg1 = "Enter Valid Email" ;
					else {
					stmt.setString(1,username.getText());
					stmt.setString(2,userid.getText());
					stmt.setString(3,password.getText());
					stmt.setString(4,email.getText());
					stmt.setString(5,phno.getText());
					stmt.execute();
					x=stmt.executeUpdate();
					con.close();
					}
					
					if(x>0)
						{
						JOptionPane.showMessageDialog(null,"Registration successful"
								+ ""
								+ "Login to continue");
						frame.dispose();
						sai.open();
						}
					else
						JOptionPane.showMessageDialog(null,msg1);
						con.close();
					}
					}
				    
				catch(Exception me)
					{JOptionPane.showMessageDialog(null,"Registation successful.login to continue");
					
					}

		}
	});
		frame.getContentPane().add(button);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(364, 249, 65, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				sai.open();
				
			}
		});
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img3=new ImageIcon(this.getClass().getResource("backg.png.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(0, 0, 445, 295);
		frame.getContentPane().add(lblNewLabel);
	}
}



