import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;

public class Place {

	private JFrame frame;
	static int ix,iy,dx,dy;
	static String in,des;
	CabAssn ca=new CabAssn();
	static int distance;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Place window = new Place();
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
	public Place() {
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
		
		Button button = new Button("Cancel");
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, button, -52, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, -97, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, -24, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button, -41, SpringLayout.EAST, frame.getContentPane());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Booking.NewScreen();
			}
		});
		frame.getContentPane().add(button);
		Button button_1 = new Button("Search Cabs");
		springLayout.putConstraint(SpringLayout.WEST, button_1, 136, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -58, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_1, 262, SpringLayout.WEST, frame.getContentPane());
		
		
		Label label = new Label("Pickup Point");
		springLayout.putConstraint(SpringLayout.WEST, label, 42, SpringLayout.WEST, frame.getContentPane());
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Destination Point");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 24, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1, 70, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, label_1);
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(label_1);
		
		JList list = new JList();
		frame.getContentPane().add(list);
		
		JList list_1 = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list_1, 25, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.EAST, list_1, -374, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(list_1);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, list_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -10, SpringLayout.EAST, label);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		comboBox.setEditable(true);
		frame.getContentPane().add(comboBox);
		
	
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F"}));
		comboBox_1.setEditable(true);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 10, SpringLayout.WEST, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 0, SpringLayout.SOUTH, list_1);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnMap = new JButton("MAP");
		btnMap.setBackground(Color.WHITE);
		Image img3=new ImageIcon(this.getClass().getResource("map.png")).getImage();
		btnMap.setIcon(new ImageIcon(img3));
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map5 m= new Map5();
				//frame.dispose();
				m.open();
			}
		});
		btnMap.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, btnMap, 44, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, btnMap, 0, SpringLayout.WEST, button_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnMap, -18, SpringLayout.NORTH, button_1);
		springLayout.putConstraint(SpringLayout.EAST, btnMap, 247, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnMap);
		
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in = (String)comboBox.getSelectedItem();
				System.out.println("in place"+in);
				des = (String)comboBox_1.getSelectedItem();
			
			if(Place.in==Place.des)
			{
				JOptionPane.showMessageDialog(button, "Pick-up and Drop locations cannot be same!!!");
			}
			else {
				
			getiloc();
			Place.getdloc();
			CabAssn.allotDetails();
			CabAssn.available[CabAssn.index]=false;
			CabAssn.minDist();
			distance=(int)Math.sqrt(Math.pow((Place.dx-Place.ix),2) + Math.pow((Place.dy-Place.iy),2));
			if(CabAssn.nocabs == 0)
			{
				frame.dispose();
				Driver.opentab();
				
			}}

			
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(button_1);
		
		JLabel label_2 = new JLabel("");
		Image img7=new ImageIcon(this.getClass().getResource("mbg.png.jpg")).getImage();
		label_2.setIcon(new ImageIcon(img7));
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label_2, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_2, 434, SpringLayout.WEST, frame.getContentPane());
		
		springLayout.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label_2);
		
		
		//g.drawString("@@@",10,250);
	}
	
	public static void getiloc()
	{
		System.out.println("00000"+in);
		if(in=="A")
		{
			ix=250  ;
			iy=600  ;
			System.out.println("00000"+ix);
		}
		
		else if(in=="B")
		{
			ix=100  ;
			iy=350  ;
		}
		
		else if(in=="C")
		{
			ix=650;
			iy=150;
		}
		
		else if(in=="D")
		{
			ix=350;
			iy=400;
		}
		
		else if(in=="E")
		{
			ix=650;
			iy=450;
		}
		
		else if(in=="F")
		{
			ix=200;
			iy=100;
		}
		
		
	}
	
	public static void getdloc()
	{
		if(des=="A")
		{
			dx=250  ;
			dy=600  ;
		}
		
		else if(des=="B")
		{
			dx= 100 ;
			dy=  350;
		}
		
		else if(des=="C")
		{
			dx=650;
			dy=450;
		}
		
		else if(des=="D")
		{
			dx=350;
			dy=400;
		}
		
		else if(des=="E")
		{
			dx=650;
			dy=450;
		}
		
		else if(des=="F")
		{
			dx=200;
			dy=100;
		}
		
		
		
	}
}
