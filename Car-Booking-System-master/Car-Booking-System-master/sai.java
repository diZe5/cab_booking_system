import java.awt.Component;
import java.awt.Image;
import java.awt.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sai {

	private JFrame frame;
	private JTextField user;
	private JLabel lblUserId;
	private JLabel lblPassword;
	private JPasswordField pass;
	static int walletbal;
	static String username2;
	private final JLabel label_1 = new JLabel("");
	private final JLabel lblNewLabel = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sai window = new sai();
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
					sai window = new sai();
					window.frame.setVisible(true);
					//CabR cr= new CabR();
					//cr.run();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sai() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 485, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserId.setBounds(30, 32, 66, 29);
		frame.getContentPane().add(lblUserId);
		
		user = new JTextField();
		user.setBounds(106, 33, 127, 31);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(27, 83, 79, 31);
		frame.getContentPane().add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(106, 85, 127, 31);
		frame.getContentPane().add(pass);
		
		JButton btnLogin = new JButton("Login");
		Image img3=new ImageIcon(this.getClass().getResource("ok-icon2.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img3));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogin.setBounds(88, 164, 100, 29);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					Statement stmt=con.createStatement();
					String sql="Select * from userdetails where User_ID='"+user.getText()+"' and Password = '"+pass.getText().toString()+"'  ";
					ResultSet rs=stmt.executeQuery(sql);
					username2=user.getText();
					if(rs.next())
						{
						JOptionPane.showMessageDialog(null, "Login successful");
						frame.dispose();
						Booking B = new Booking();
						//sai s= new sai();
						B.NewScreen();
						walletbal = rs.getInt(6);
						System.out.println(walletbal);
					//username2=user.getText();
						}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Credentials");
						con.close();
					
				     }
				catch(Exception e)
					{System.out.println("Exception"+e);}
			}
		});
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewUser = new JButton("New User?");
		btnNewUser.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNewUser.setBounds(233, 225, 127, 47);
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
				U_R.open();
				
				
				
			}
		});
		frame.getContentPane().add(btnNewUser);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("kcabs.png.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(254, 32, 208, 148);
		frame.getContentPane().add(label);
		
		
	//	frame.add(new JLabel(new ImageIcon("file:///C:/Users/Karthik/Desktop/download.png")));
		//JImageComponent ic= new JImageComponent("file:///C:/Users/Karthik/Desktop/download.png");
	}
}
