package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/bookmanager";
    private static String USER = "root";
    private static String PASS = "amataa04";
    // mo ket noi sql
    public static Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }
    // dong ket noi
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try{
                connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    // kiem tra ket noi
    public static void main(String[] args) {
        Connection connection = openConnection();
        if (connection != null) {
            System.out.println("Ket noi thanh cong");
        }
        else{
            System.out.println("Ket noi that bai");
        }
    }
}
