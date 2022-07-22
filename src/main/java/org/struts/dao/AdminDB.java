package org.struts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDB {

    public static Connection getConnection() throws Exception {
        String connectionUrl = "jdbc:sqlserver://t3nt4c135.database.windows.net:1433;database=demo;user=t3nt4c135@t3nt4c135;password=Inthemix1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            return DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
            return null;
        }
    }

    // Create in database
    public void registerUser(String username, String email, int age, String password) {
        String connectionUrl = "jdbc:sqlserver://t3nt4c135.database.windows.net:1433;database=demo;user=t3nt4c135@t3nt4c135;password=Inthemix1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        System.out.println(username + ": 1");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");

                String sql = "";
                sql = new StringBuilder().append("INSERT users (username, email, age, password) ")
                        .append("VALUES (?, ?, ?, ?);")
                        .toString();
                try (PreparedStatement statement = connection.prepareStatement(sql)) {

                    // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    statement.setString(1, username);
                    statement.setString(2, email);
                    statement.setInt(3, age);
                    statement.setString(4, password);
                    int rowsAffected = statement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted");
                }
                connection.close();
                System.out.println("All done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    // Read saved user from database
    public ResultSet readUser() throws SQLException, Exception {
        ResultSet rs = null;
        try {
            String sql = "SELECT username, email, age, password FROM users;";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }

}
