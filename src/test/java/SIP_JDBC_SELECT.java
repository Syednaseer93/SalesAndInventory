import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SIP_JDBC_SELECT {
	public static void main(String[] args) throws SQLException {
		//Establish or Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		//Create a statement
		Statement stmt = con.createStatement();
		String s="SELECT * FROM SALESANDINVENTORY;";
		
		//Execute the statement or Query and store it in result set
		ResultSet rs=stmt.executeQuery(s);
		
			while(rs.next()) {
			int eid=rs.getInt("EMP_ID");
			String fname=rs.getString("FNAME");
			int sal=rs.getInt("SALARY");
			
			System.out.println(eid+" | "+fname+" | "+sal);
		}
		//Close a connection
		con.close();
		System.out.println("Done");
	}
}
