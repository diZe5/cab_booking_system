import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql
{  private static final String url = "jdbc:mysql://localhost:3306/KUTHUHAL";
   		private static final String user = "root";
   		private static final String password = "root";
   		private static Connection con;
   		private static Statement stmt;
   		private static ResultSet rs; 
   		public static void main(String args[]) 
   		{	
   			//String query = "select username(*) from user";
   			String query = "INSERT INTO KUTHUHAL.user (username,email,password,create_time) \n" + " VALUES (varname, kfhfdiohg, 123,100);";
   			// executing SELECT query
   			try
   			{
   			stmt.executeUpdate(query);
   			}/*try
   			{ 
   				con = DriverManager.getConnection(url, user, password); 
   				stmt = con.createStatement(); // executing SELECT query 
   				rs = stmt.executeQuery(query); 
   				while (rs.next())
   				{
   				 U_R u1= new U_R();
   				char username=u1.varname
   				}
   				
             }*/
   			catch(NullPointerException ne)
   			{}

   			catch (SQLException sqlEx)
   			{ sqlEx.printStackTrace();
   			} finally 
   			{ // try { con.close(); } catch(SQLException se) { /*can't do anything */ } 
   			//try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
   			//try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
   			} 
   			   			//String query = "INSERT INTO user.books (id, name, author) \n" + " VALUES (3, 'Head First Java', 'Kathy Sieara');";
   			// executing SELECT query
   			//stmt.executeUpdate(query);

   			//Re//ad more: https://javarevisited.blogspot.com/2015/06/how-to-connect-to-mysql-database-in-java-jdbc-example.html#ixzz64hsAh6lQ

   			
   		}
}
