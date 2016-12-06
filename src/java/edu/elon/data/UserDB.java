/* 2016 © Lane Peeler & Jasmine Jones */
package edu.elon.data;

import edu.elon.bean.User;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;

public class UserDB {

    public static int insert(User user) throws SQLException {
        
        Connection connection = null;
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO users (firstName, lastName, email, bookTitle, dueDate) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/libusers";
            String username = "root";
            String password = "mysqluser";

            connection = DriverManager.getConnection(url, username, password);
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBookTitle());
            ps.setDate(5, (Date) user.getDueDate());
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBClose.closePreparedStatement(ps);
            DBClose.closeConnection(connection);
        }
    }
    public static int checkIn(User user) throws SQLException {
        
        Connection connection = null;
        PreparedStatement ps = null;
        
        String query
                = "DELETE FROM users WHERE email=?";
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/libusers";
            String username = "root";
            String password = "mysqluser";

            connection = DriverManager.getConnection(url, username, password);
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBClose.closePreparedStatement(ps);
            DBClose.closeConnection(connection);
        }
    }
    
        public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM users";
        
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/libusers";
            String username = "root";
            String password = "mysqluser";
            connection = DriverManager.getConnection(url, username, password);
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            rs.beforeFirst();
            while (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setBookTitle(rs.getString("bookTitle"));
                user.setDueDate(rs.getDate("dueDate"));
                user.setOverdue(user.reallyOverdue());
                users.add(user);
            }
            return users;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        } finally {
            DBClose.closeResultSet(rs);
            DBClose.closePreparedStatement(ps);
            DBClose.closeConnection(connection);
        }
    }
        public static User getUser(String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM users WHERE email=?";
        
        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/libusers";
            String username = "root";
            String password = "mysqluser";
            
            connection = DriverManager.getConnection(url, username, password);
            
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setBookTitle(rs.getString("bookTitle"));
                user.setDueDate(rs.getDate("dueDate"));
            }
            return user;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        } finally {
            DBClose.closeResultSet(rs);
            DBClose.closePreparedStatement(ps);
            DBClose.closeConnection(connection);
        }
    }
}
