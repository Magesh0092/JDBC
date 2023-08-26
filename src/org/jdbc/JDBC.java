package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Magesh@1991");
		
		String query = "select * from employees";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet executeQuery = prepareStatement.executeQuery();
		
		while(executeQuery.next()) {
		String string = executeQuery.getString("first_name");
		String string2 = executeQuery.getString("last_name");
		String string3 = executeQuery.getString("Salary");
		System.out.println(string+"\t    "+string2+"\t"+string3);
		}
	}

}
