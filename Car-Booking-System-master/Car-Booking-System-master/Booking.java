import java.awt.EventQueue;
import javax.swing.*;

import java.awt.Button;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Booking {

	private JFrame frame2;
	sai s=new sai();

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking window = new Booking();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Booking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame2.getContentPane().setLayout(springLayout);
		
		JButton button = new JButton("Book a CAB");
		springLayout.putConstraint(SpringLayout.NORTH, button, 32, SpringLayout.NORTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, 52, SpringLayout.WEST, frame2.getContentPane());
		Image img2=new ImageIcon(this.getClass().getResource("vw-beetle-icon.png")).getImage();
		button.setIcon(new ImageIcon(img2));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(s.walletbal+" booking");

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					Statement stmt=con.createStatement();
					String sql="Select * from userdetails  where User_ID='"+sai.username2+"'  ";
					ResultSet rs=stmt.executeQuery(sql);
					
					if(rs.next())
						{
						Driver.onatrip=rs.getBoolean("onatrip");
						}
				}
				catch(Exception be)
				{
					System.out.println(be);
				}
				if(Driver.onatrip)
				{
					JOptionPane.showMessageDialog(null, "you are already on trip.cannot book another cab!!!");
				}
				else
				{
					if(s.walletbal >= 300)
					{
						frame2.dispose();
						//Place p= new Place();
						Place.open();
					}
					else 
					{
						frame2.dispose();
						EmptyWallet.empty();
					}
				}
				
				
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		frame2.getContentPane().add(button);
		
		JButton button_1 = new JButton("Wallet Balance");
		springLayout.putConstraint(SpringLayout.WEST, button_1, 52, SpringLayout.WEST, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_1, -155, SpringLayout.EAST, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, -13, SpringLayout.NORTH, button_1);
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, button_1);
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 83, SpringLayout.NORTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -140, SpringLayout.SOUTH, frame2.getContentPane());
		Image img3=new ImageIcon(this.getClass().getResource("wallet.png")).getImage();
		button_1.setIcon(new ImageIcon(img3));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				//Wallet bal=new Wallet();
				Wallet.open();
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 16));
		Image img5=new ImageIcon(this.getClass().getResource("wallet.png")).getImage();
		button_1.setIcon(new ImageIcon(img5));
		
		frame2.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("ADD Money to Wallet");
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 17, SpringLayout.SOUTH, button_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_2, -82, SpringLayout.SOUTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button_2, 52, SpringLayout.WEST, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_2, -155, SpringLayout.EAST, frame2.getContentPane());
		Image img4=new ImageIcon(this.getClass().getResource("Money-2-icon.png")).getImage();
		button_2.setIcon(new ImageIcon(img4));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				AddingMoney.open();
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 16));
		frame2.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Logout");
		springLayout.putConstraint(SpringLayout.NORTH, button_3, -57, SpringLayout.SOUTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button_3, -192, SpringLayout.EAST, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button_3, -26, SpringLayout.SOUTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_3, -45, SpringLayout.EAST, frame2.getContentPane());
		Image img69=new ImageIcon(this.getClass().getResource("Apps-session-logout-icon.png")).getImage();
		button_3.setIcon(new ImageIcon(img69));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				sai.open();
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 16));
		frame2.getContentPane().add(button_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, frame2.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, frame2.getContentPane());
		Image img8=new ImageIcon(this.getClass().getResource("inter2.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img8));
		frame2.getContentPane().add(lblNewLabel);
	}

}
