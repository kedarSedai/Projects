package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    Connection connection = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/college";
            String userName = "root";
            String password = "";
            this.connection = DriverManager.getConnection(url, userName, password);

            System.out.println("Database connected: ");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
    }


    public PreparedStatement getStatement(String query) {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;

    }

}
