import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class userinform2 {
	
	int walletbal;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			Statement stmt=con.createStatement();
			String sql="Select * from userdetails";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
				{
					String id=rs.getString("User_ID");
				
					if(user_name)

	}

}
