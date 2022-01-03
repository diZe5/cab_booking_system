import java.sql.*;

import javax.swing.JOptionPane;

import java.lang.*;
import java.lang.Math;

public class CabR  {
  // Thread t;
   public static void main (String args[]) {
	for(int j=0;j<10;j++)
	{
		
        for(int i=0;i<25;i++)
        {
            int max = 700; 
            int min = 50; 
            int range = max - min + 1;

            int x= (int)(Math.random() * range) + min;
            int y= (int)(Math.random() * range) + min;
            System.out.println(x + " "+y);
            try {
            Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        	Statement stmt2=con.createStatement();
        	String query="update  driverdetails set Location_X=?,Location_Y =? where SlNo=?";
        	PreparedStatement ps2=con.prepareStatement(query);

        	ps2.setInt(1,x);
        	ps2.setInt(2,y);
        	ps2.setInt(3, i+1);
        	//ps2.setBoolean(4, true);
        	//System.out.println(x + " "+y);
        	
        	ps2.execute();
        	ps2.executeUpdate();
            }
            catch(Exception mye) {
            	//System.out.println(mye);
            }
           
	
        }
	   
         try {
        	 
            Thread.sleep(300000);
         } catch (Exception ex) {
        	 //System.out.println(ex);
         }
         JOptionPane.showMessageDialog(null, "CABS REDISTRIBUTING");
	}
   }

  
}