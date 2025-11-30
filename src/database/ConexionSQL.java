/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PAUL
 */




public class ConexionSQL {

    private static final String URL =
        "jdbc:sqlserver://localhost:1433;"
      + "databaseName=RestauranteDB;"
      + "encrypt=false;";
    
    private static final String USER = "sa";
    private static final String PASS = "12345";

    public static Connection conectar() {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a SQL Server");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
        return cn;
    }
}





