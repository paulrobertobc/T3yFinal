/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.ConexionSQL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Empleado;
import model.Producto;
import model.Venta;

/**
 *
 * @author PAUL
 */

public class ControllerSQL {

    // ---------- PRODUCTOS ----------
    public void insertarProducto(Producto p) throws SQLException {
        String sql = "INSERT INTO Productos(Nombre, Precio, Categoria, Stock) VALUES(?,?,?,?)";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getCategoria());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setID(rs.getInt(1));
            }
        }
    }

    public List<Producto> listarProductos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT ID, Nombre, Precio, Categoria, Stock FROM Productos";
        try (Connection con = ConexionSQL.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setID(rs.getInt("ID"));
                p.setNombre(rs.getString("Nombre"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setCategoria(rs.getString("Categoria"));
                p.setStock(rs.getInt("Stock"));
                lista.add(p);
            }
        }
        return lista;
    }

    public void actualizarProducto(Producto p) throws SQLException {
        String sql = "UPDATE Productos SET Nombre=?, Precio=?, Categoria=?, Stock=? WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getCategoria());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getID());
            ps.executeUpdate();
        }
    }

    public void eliminarProducto(int id) throws SQLException {
        String sql = "DELETE FROM Productos WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // ---------- CLIENTES ----------
    public void insertarCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO Clientes(Nombre, Apellido, DNI, Telefono, Email, TotalGastado) VALUES(?,?,?,?,?,?)";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setDouble(6, c.total);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) c.setID(rs.getInt(1));
            }
        }
    }

    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT ID, Nombre, Apellido, DNI, Telefono, Email, TotalGastado FROM Clientes";
        try (Connection con = ConexionSQL.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setID(rs.getInt("ID"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setDNI(rs.getString("DNI"));
                c.setTelefono(rs.getString("Telefono"));
                c.setEmail(rs.getString("Email"));
                c.total = rs.getDouble("TotalGastado");
                lista.add(c);
            }
        }
        return lista;
    }

    public void actualizarCliente(Cliente c) throws SQLException {
        String sql = "UPDATE Clientes SET Nombre=?, Apellido=?, DNI=?, Telefono=?, Email=?, TotalGastado=? WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setDouble(6, c.total);
            ps.setInt(7, c.getID());
            ps.executeUpdate();
        }
    }

    public void eliminarCliente(int id) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // ---------- EMPLEADOS ----------
    public void insertarEmpleado(Empleado e) throws SQLException {
        String sql = "INSERT INTO Empleados(Nombre, Apellido, DNI, Telefono, Email, Sueldo, Tipo, Atendidos) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getDNI());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getEmail());
            ps.setDouble(6, e.getSueldo());
            ps.setString(7, e.getTipo());
            ps.setInt(8, e.getAtendidos());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) e.setID(rs.getInt(1));
            }
        }
    }

    public List<Empleado> listarEmpleados() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT ID, Nombre, Apellido, DNI, Telefono, Email, Sueldo, Tipo, Atendidos FROM Empleados";
        try (Connection con = ConexionSQL.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setID(rs.getInt("ID"));
                e.setNombre(rs.getString("Nombre"));
                e.setApellido(rs.getString("Apellido"));
                e.setDNI(rs.getString("DNI"));
                e.setTelefono(rs.getString("Telefono"));
                e.setEmail(rs.getString("Email"));
                e.setSueldo(rs.getDouble("Sueldo"));
                e.setTipo(rs.getString("Tipo"));
                e.setAtendidos(rs.getInt("Atendidos"));
                lista.add(e);
            }
        }
        return lista;
    }

    public void actualizarEmpleado(Empleado e) throws SQLException {
        String sql = "UPDATE Empleados SET Nombre=?, Apellido=?, DNI=?, Telefono=?, Email=?, Sueldo=?, Tipo=?, Atendidos=? WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getDNI());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getEmail());
            ps.setDouble(6, e.getSueldo());
            ps.setString(7, e.getTipo());
            ps.setInt(8, e.getAtendidos());
            ps.setInt(9, e.getID());
            ps.executeUpdate();
        }
    }

    public void eliminarEmpleado(int id) throws SQLException {
        String sql = "DELETE FROM Empleados WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // ---------- VENTAS ----------
    // VentaItem representa un producto dentro de la venta
    public static class VentaItem {
        private int productoId;
        private double precio;
        private int cantidad;
        public VentaItem(int productoId, double precio, int cantidad) {
            this.productoId = productoId;
            this.precio = precio;
            this.cantidad = cantidad;
        }
        public int getProductoId() { return productoId; }
        public double getPrecio() { return precio; }
        public int getCantidad() { return cantidad; }
    }

    // Registrar venta: inserta Ventas, DetalleVenta y actualiza stock dentro de una transacción
    public int registrarVenta(Integer clienteId, List<VentaItem> items, double total) throws SQLException {
        String sqlVenta = "INSERT INTO Ventas(Fecha, ClienteID, Total) VALUES(?, ?, ?)";
        String sqlDetalle = "INSERT INTO DetalleVenta(VentaID, ProductoID, Cantidad, PrecioUnitario) VALUES(?, ?, ?, ?)";
        String sqlUpdateStock = "UPDATE Productos SET Stock = Stock - ? WHERE ID = ? AND Stock >= ?";

        try (Connection con = ConexionSQL.conectar()) {
            con.setAutoCommit(false);
            int ventaId;
            try (PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                psVenta.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                psVenta.setInt(2, clienteId);
                psVenta.setDouble(3, total);
                psVenta.executeUpdate();
                try (ResultSet rs = psVenta.getGeneratedKeys()) {
                    if (rs.next()) ventaId = rs.getInt(1);
                    else throw new SQLException("No se obtuvo id de venta");
                }
            }

            try (PreparedStatement psDet = con.prepareStatement(sqlDetalle);
                 PreparedStatement psUpd = con.prepareStatement(sqlUpdateStock)) {

                for (VentaItem it : items) {
                    // insertar detalle
                    psDet.setInt(1, ventaId);
                    psDet.setInt(2, it.getProductoId());
                    psDet.setInt(3, it.getCantidad());
                    psDet.setDouble(4, it.getPrecio());
                    psDet.executeUpdate();

                    // actualizar stock (asegura stock suficiente)
                    psUpd.setInt(1, it.getCantidad());
                    psUpd.setInt(2, it.getProductoId());
                    psUpd.setInt(3, it.getCantidad());
                    int updated = psUpd.executeUpdate();
                    if (updated == 0) {
                        con.rollback();
                        throw new SQLException("Stock insuficiente para producto id=" + it.getProductoId());
                    }
                }
            }

            con.commit();
            return ventaId;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    // ---------- METODOS UTILES ----------
    public Producto obtenerProductoPorID(int id) throws SQLException {
        String sql = "SELECT ID, Nombre, Precio, Categoria, Stock FROM Productos WHERE ID=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto();
                    p.setID(rs.getInt("ID"));
                    p.setNombre(rs.getString("Nombre"));
                    p.setPrecio(rs.getDouble("Precio"));
                    p.setCategoria(rs.getString("Categoria"));
                    p.setStock(rs.getInt("Stock"));
                    return p;
                }
            }
        }
        return null;
    }
    public List<Venta> listarVentas() throws SQLException {
    List<Venta> lista = new ArrayList<>();
    String sql = """
        SELECT v.ID, v.Fecha, v.ClienteID, c.Nombre, c.Apellido, v.Total
        FROM Ventas v
        INNER JOIN Clientes c ON v.ClienteID = c.ID
    """;

    try (Connection con = ConexionSQL.conectar();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        
        while (rs.next()) {
            Venta v = new Venta();
            v.setID(rs.getInt("ID"));
            v.setFecha(rs.getTimestamp("Fecha").toLocalDateTime());

            Cliente c = new Cliente();
            c.setID(rs.getInt("ClienteID"));
            c.setNombre(rs.getString("Nombre"));
            c.setApellido(rs.getString("Apellido"));
            v.setComprador(c);

            lista.add(v);
        }
    }
    return lista;
}

}