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
    //me salen errorres por montones
    private static final String URL = 
        "jdbc:sqlserver://localhost:1433;"
        + "databaseName=SistemaVentasDB;"
        + "encrypt=true;"
        + "trustServerCertificate=true;";

    private static final String USER = "sa";
    private static final String PASS = "P@ssw0rd123";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}


