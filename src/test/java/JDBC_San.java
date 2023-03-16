import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_San {

	public static void main(String[] args) throws SQLException {
		// create object for driver
		Driver driver = new Driver();

		// Register the database
		DriverManager.registerDriver(driver);

		// Get connection for the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		// Create statement
		Statement state = con.createStatement();
		String query = "select * from salesandinventory;";

		// execute query
		ResultSet result = state.executeQuery(query);
		ResultSetMetaData rsmd = result.getMetaData();
		int count = rsmd.getColumnCount();
		while (result.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(result.getString(i) + " ");
			}
			System.out.println();

		}
		
		/*query = "insert into student values(5,'Sundeep','BTM','Sandeep',12,'Bengaluru');";
		state.executeUpdate(query);

		query = "select * from student;";

		// execute query
		result = state.executeQuery(query);
		rsmd = result.getMetaData();
		count = rsmd.getColumnCount();
		while (result.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(result.getString(i) + " ");
			}
			System.out.println();

		} */

		con.close();

	}

}
