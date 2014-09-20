package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO {

	public void selectAll() throws ClassNotFoundException, SQLException {
		initializeDriver();
		try (Connection connection = connectToDatabase()){
			PreparedStatement statement = connection
					.prepareStatement("select * from address");
			printResults(statement);
		}
	}

	public void selectAllBasedOnCity(String inputCity)
			throws ClassNotFoundException, SQLException {
		initializeDriver();
		try (Connection connection = connectToDatabase()){
			String queryString = "select * from address where city=?";
			PreparedStatement statement = connection
					.prepareStatement(queryString);
			statement.setString(1, inputCity);
			printResults(statement);
		} 
	}

	private void initializeDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	private Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/coursework", "root", "mint");
	}

	private void printResults(PreparedStatement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String streetAddress = resultSet.getString("street_address");
			String apartmentNumber = resultSet.getString("apartment_number");
			String city = resultSet.getString("city");

			System.out.print("id: " + id);
			System.out.print(", streetAddress: " + streetAddress);
			System.out.print(", apartmentNumber: " + apartmentNumber);
			System.out.print(", city: " + city);
			System.out.println();
		}
	}

}
