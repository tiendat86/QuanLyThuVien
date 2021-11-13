/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tien Dat
 */
public class DAO {
    public static Connection connection;

    public DAO() {
        final String url = "jdbc:mysql://localhost:3306/qlthuvien?autoReconnect=true&useSSL=false";
        final String user = "root";
        final String pass = "710640";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//           DAO.getSQLServerConnection();
    }
//    public static Connection getSQLServerConnection() {
//        String database = "QuanLyNhanVien";
//        String userName = "sa";
//        String password = "abcxyz123!@#";
//        String servername = "DESKTOP-4MNTMT5";
//        int portNumber = 1433;
//
//        return getSQLServerConnection(servername, userName, password, database, portNumber);
//    }
//
//    public static Connection getSQLServerConnection(String serverName, String userName, String password,
//                                                    String databaseName, int portNumber) {
//        SQLServerDataSource dataSource = new SQLServerDataSource();
//        dataSource.setUser(userName);
//        dataSource.setPassword(password);
//        dataSource.setServerName(serverName);
//        dataSource.setPortNumber(portNumber);
//        dataSource.setDatabaseName(databaseName);
//        try {
//            return dataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }  
}
