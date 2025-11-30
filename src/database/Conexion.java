/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PAUL
 */
public class Conexion {
    

    private static final String SERVIDOR = "Darwin";  
    private static final String PUERTO = "1433";     
    private static final String NOMBRE_BD = "restaurante_db";
    private static final String USUARIO = "DARWIN\\acost"; 
    private static final String CONTRASEÑA = "";  
    
    private static final String URL = "jdbc:sqlserver://" + SERVIDOR + ":" + PUERTO + ";" +
            "databaseName=" + NOMBRE_BD + ";" +
            "integratedSecurity=true;" +  
            "encrypt=false;" +
            "trustServerCertificate=true";
    

    private static Connection conexion = null;
    

    private Conexion() {
    }
    

    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL);
            }
            return conexion;
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, 
                "ERROR: Driver de SQL Server no encontrado\n" +
                "Agrégalo a Libraries en NetBeans",
                "Error de Driver", 
                JOptionPane.ERROR_MESSAGE);
            return null;
            
        } catch (SQLException e) {
            String mensaje = "❌ Error de conexión: ";
            
            if (e.getMessage().contains("Login failed")) {
                mensaje += "Usuario o contraseña incorrectos";
            } else if (e.getMessage().contains("Cannot open database")) {
                mensaje += "La base de datos '" + NOMBRE_BD + "' no existe";
            } else if (e.getMessage().contains("connection")) {
                mensaje += "No se puede conectar al servidor";
            } else {
                mensaje += e.getMessage();
            }
            
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
            }
        } catch (SQLException e) {
            
        }
    }
    

    public static boolean verificarConexion() {
        try {
            return conexion != null && !conexion.isClosed() && conexion.isValid(2);
        } catch (SQLException e) {
            return false;
        }
    }
    

    public static String getInfoConexion() {
        try {
            if (verificarConexion()) {
                return "Conectado a: " + conexion.getMetaData().getURL() + "\n" +
                       "Usuario: " + conexion.getMetaData().getUserName() + "\n" +
                       "Driver: " + conexion.getMetaData().getDriverName() + " " +
                       conexion.getMetaData().getDriverVersion() + "\n" +
                       "Producto: " + conexion.getMetaData().getDatabaseProductName() + " " +
                       conexion.getMetaData().getDatabaseProductVersion();
            } else {
                return "No hay conexión activa";
            }
        } catch (SQLException e) {
            return "Error al obtener información: " + e.getMessage();
        }
    }
    

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("PROBANDO CONEXIÓN A SQL SERVER");
        System.out.println("==========================================");
        System.out.println("Servidor: " + SERVIDOR);
        System.out.println("Puerto: " + PUERTO);
        System.out.println("Base de datos: " + NOMBRE_BD);
        System.out.println("Usuario: " + USUARIO);
        System.out.println("------------------------------------------");
        
        Connection conn = getConexion();
        
        if (conn != null) {
            System.out.println("\n CONEXIÓN EXITOSA");
            System.out.println("\n" + getInfoConexion());
            cerrarConexion();
        } else {
            System.out.println("\n CONEXIÓN FALLIDA");
            System.out.println("Revisa los mensajes de error arriba");
        }
        
        System.out.println("\n==========================================");
    }
}