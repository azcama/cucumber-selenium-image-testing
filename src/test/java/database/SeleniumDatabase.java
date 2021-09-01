package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeleniumDatabase {

	static Connection con = null;

	private static Statement stmt;

	public static String DB_URL = "jdbc:mysql://url.to.connect/db.to.connect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static String DB_USER = "user";
	public static String DB_PASSWORD = "password";

	
	public void setUp() throws Exception {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			stmt = con.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultSet doQuery(String query) throws SQLException {
		return stmt.executeQuery(query);
	}

	public void close() {
		if (con != null) {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
