import java.math.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.lang.Math;
public class CabAssn {
	
	static int[] x= new int[25];
	static int[] y=new int[25];
	static double[] rating=new double[25];
	static int[] phoneno = new int[25];
	static String[] names= new String[25];
	static String[] id = new  String[25];
	static double min=10000 ;
	static boolean[] available= new boolean[25];
	static int index,itr=0;
	static double dist;
	static int nocabs=0;
	static int[] nooftrips=new int[25];
	public static void allotDetails()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			Statement stmt=con.createStatement();
			String sql1="Select * from driverdetails  ";
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next())
				{
				x[itr] = rs.getInt("Location_X");
				System.out.println(x[itr]+"in while");
				y[itr]= rs.getInt("Location_Y");
		        names[itr] = rs.getString("Driver_Name");
				id[itr] = rs.getString("Vehicle_No");
		        nooftrips[itr] = rs.getInt("No_of_Trips");
		        //Date dateCreated = rs.getDate("date_created");
		        available[itr] = rs.getBoolean("is_Available");
		        phoneno[itr] = rs.getInt("Phno");
		        rating[itr]=Double.parseDouble(rs.getString("Rating"));
		        System.out.println(x[itr]+"siddhu "+y[itr]+" "+names[itr]+" "+id[itr]+" "+rating[itr]);
		        itr++;
				}
				stmt.close();
			
		     }
		catch(Exception e)
			{System.out.println("Exception"+e);}
	}

	
	
	public static void minDist()
	{
		Place.getiloc();
		System.out.println("in mindist");
		Place.getdloc();
		for(int i=0;i<25;i++)
		{
			if(available[i])
			{
			dist =Math.sqrt( ((Place.ix - x[i])*(Place.ix - x[i]) + (Place.iy - y[i])*(Place.iy - y[i])));
			System.out.println(dist+" "+x[i]);
			if(dist<min )
			{
				
				min=dist;
				index=i;
				
			}
			if(dist==min)
			{
				if(rating[index]<rating[i])
				{
					index=i;
				}
			}
			}
		}
		if(min==10000)
		{
			JOptionPane.showMessageDialog(null, "Sorry,No Nearby Cabs Available.Try After Some Time");
			nocabs=1;
		}
		System.out.println(min);
	}
	/*public static void main(String args[])
	{
		allotDetails();
		minDist();
		System.out.println(index);
	}*/
	
	

}
