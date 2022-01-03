import java.awt.EventQueue;
import java.io.File;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sidd {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
  //  File f=new File(" C:\\Users\\Karthik\\Desktop\\folder2\\siddhu");
	/**
	 * Launch the application.
	 */
    String Username,Password;
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sidd window = new sidd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sidd window = new sidd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*void createFolder()
	{
		if(!f.exists())
		{
			f.mkdirs();
			System.out.println("dgxdgf");
		}
	}*/
	void ReadFile() //throws IOException
	{
		try
		{
			FileReader fr=new FileReader("sidda.txt");
			System.out.println("fileexists");
		}
		catch(FileNotFoundException ex)
		{}
			try
			{
				FileWriter fw=new FileWriter("sidda.txt");
				System.out.println("created");
			}
			catch(IOException ex1)
			{
				System.out.println("exception");	
			}
			
				
			
			
		//}
	}

	/**
	 * Create the application.
	 */
	public sidd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(61, 54, 56, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(61, 90, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(140, 51, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//createFolder();
				ReadFile();
			}
		});
		btnNewButton.setBounds(105, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 87, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				sidd2 s=new sidd2();
				s.open();
			}
		});
		btnNewButton_1.setBounds(287, 203, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
