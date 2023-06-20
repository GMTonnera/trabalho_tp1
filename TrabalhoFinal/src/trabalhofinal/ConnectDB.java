/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

/**
 *
 * @author Vini
 */
public class ConnectDB {
     public static void connect() throws ClassNotFoundException {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:C:\\trabalho\\TrabalhoFinal\\src\\db\\sinuqueiro.db";  
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) throws ClassNotFoundException {  
        connect();  
    }  
}
