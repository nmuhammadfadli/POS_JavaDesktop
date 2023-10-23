package service;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class connect {
    
    public static connect getInstance() {
        if (instance == null) {
            instance = new connect();
        }
        return instance;
    }
    
    private static connect instance;
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection GetConnection() throws SQLException{
        if (koneksi == null){
            new Driver();
            
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/gbrand","root","");
        }
        return koneksi;
    }  
}