package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDAO {

	public void selectAll() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/coursework", "root", "mint");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from address");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String streetAddress = resultSet.getString("street_address");
				String apartmentNumber = resultSet
						.getString("apartment_number");

				System.out.print("id: " + id);
				System.out.print(", streetAddress: " + streetAddress);
				System.out.print(", apartmentNumber: " + apartmentNumber);
				System.out.println();
			}
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
}
