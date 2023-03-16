import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class HelloWorld {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt =con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT EMP_ID FROM SALESANDINVENTORY;");
		while(rs.next()) {
			int eID=rs.getInt(1);
			System.out.println(eID);
		}
		con.close();
		
	
	
	}

}
