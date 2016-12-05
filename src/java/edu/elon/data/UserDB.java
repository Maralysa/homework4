/* 2016 © Lane Peeler & Jasmine Jones */
package edu.elon.data;

import edu.elon.bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDB {

    public static int insert(User user) throws SQLException {
        
        Connection connection = null;
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO User (firstName, lastName, email, bookTitle, dueDate) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            String url = "jdbc:mysql://localhost:3306/libusers";
            String username = "root";
            String password = "mysqluser";

            connection = DriverManager.getConnection(url, username, password);
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBookTitle());
            ps.setDate(  5, user.getDueDate());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
