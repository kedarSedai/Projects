package Service;

import DBConnection.DBConnection;
import Model.College;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //INSERT USER:
    public void insertUser(College college) {
        String query = "insert into user(userName, password, location)" + "values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, college.getUserName());
            preparedStatement.setString(2, college.getPassword());
            preparedStatement.setString(3, college.getLocation());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //DELETE USER:
    public void deleteUser(int id) {
        String query = "delete from user where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE USER:
    public void editUser(int id, College college) throws SQLException {

        String query = "update from user set userName=?, password=?, location=?" + "where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        preparedStatement.setString(1, college.getUserName());
        preparedStatement.setString(2, college.getPassword());
        preparedStatement.setString(3, college.getLocation());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();

    }

    //LOGIN USER:
    public College loginUser(String userName, String password) {
        String query = "select * from user where userName=? and password=? ";

        PreparedStatement preparedStatement = new DBConnection().getStatement(query);


        College college = null;

        try {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                college = new College();

                college.setId(resultSet.getInt("id"));
                college.setUserName(resultSet.getString("userName"));
                college.setPassword(resultSet.getString("password"));
                college.setLocation(resultSet.getString("location"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return college;

    }

    public List<College> getUserList() {

        ArrayList<College> collegeList = new ArrayList<>();

        String query = "select * from user";
        System.out.println(query);
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        System.out.println(preparedStatement);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                College college = new College();

                college.setId(resultSet.getInt("id"));
                college.setUserName(resultSet.getString("userName"));
                college.setPassword(resultSet.getString("password"));
                college.setLocation(resultSet.getString("location"));

                collegeList.add(college);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return collegeList;
    }

}
