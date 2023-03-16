import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SIP_JDBC_INSERT {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		Statement stmt = con.createStatement();
		String s="INSERT INTO SALESANDINVENTORY VALUES('109','Ali','Khan','18500','2');";
		
		stmt.executeUpdate(s);
		con.close();
		System.out.println("Done");
	}

}
