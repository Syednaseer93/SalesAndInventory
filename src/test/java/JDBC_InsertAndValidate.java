import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import com.mysql.cj.jdbc.Driver;

public class JDBC_InsertAndValidate {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		Statement stmt = con.createStatement();
		String s="INSERT INTO SALESANDINVENTORY VALUES('109','Ali','Khan','18500','2');";
		int result = stmt.executeUpdate(s);
		if(result==1) {
			System.out.println();
		}
		else {
			System.err.println();
		}
		con.close();
		System.out.println("Done");
	}

}
