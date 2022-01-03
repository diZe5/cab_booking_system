import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class AddingMoney {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingMoney window = new AddingMoney();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	sai s1=new sai();
	
	/**
	 * Create the application.
	 */
	public AddingMoney() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHowMuchMoney = new JLabel("How much money do you want to add");
		lblHowMuchMoney.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHowMuchMoney.setBounds(34, 26, 314, 62);
		frame.getContentPane().add(lblHowMuchMoney);
		
		textField = new JTextField();
		textField.setBounds(34, 91, 107, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Booking.NewScreen();
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(Color.GRAY);
		btnOk.setForeground(new Color(0, 0, 0));
		Image img3=new ImageIcon(this.getClass().getResource("ok-icon2.png")).getImage();
		btnOk.setIcon(new ImageIcon(img3));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(Integer.parseInt(textField.getText())<0)
						{
					       JOptionPane.showMessageDialog(null,"you can not add negative money");
						}
				else
				{
					
					frame.dispose();
					Booking.NewScreen();
				s1.walletbal = s1.walletbal+ Integer.parseInt(textField.getText());
				//System.out.println(s1.walletbal);
				//System.out.println(s1.username2);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
					Statement stmt=con.createStatement();
					String sql="update userdetails set Wallet_bal='"+s1.walletbal+"' where User_ID= '"+sai.username2+"' " ;
					PreparedStatement ps=con.prepareStatement(sql);
					System.out.println(sai.username2);
				//	ps.setInt(1, s1.walletbal);
					//ps.setString(2,sai.username2);
					ps.executeUpdate();
					//ps.executeUpdate();
					//con.close();
					}
				catch(Exception ne)
				{
					System.out.println(ne);
				}
			}
			}
		});
		btnOk.setBounds(157, 144, 89, 33);
		frame.getContentPane().add(btnOk);
	}
}
