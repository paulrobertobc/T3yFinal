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

/**
 *
 * @author PAUL
 */


public class ControllerSQL {

    // ---------- CLIENTES ----------
    public void insertarCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO Clientes(nombre, apellido, dni, telefono, email, totalComprado) VALUES(?,?,?,?,?,?)";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setDouble(6, c.total);
            ps.executeUpdate();
        }
    }

    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, dni, telefono, email, totalComprado FROM Clientes";
        try (Connection con = ConexionSQL.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente();
                // Asegúrate que tu clase Cliente tenga setters correspondientes
                //c.setCodigo(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDNI(rs.getString("dni"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.total = rs.getDouble("totalComprado");
                lista.add(c);
            }
        }
        return lista;
    }

    public void actualizarCliente(Cliente c) throws SQLException {
        String sql = "UPDATE Clientes SET nombre=?, apellido=?, dni=?, telefono=?, email=?, totalComprado=? WHERE id=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDNI());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getEmail());
            ps.setDouble(6, c.total);
            //ps.setInt(7, c.getCodigo());
            ps.executeUpdate();
        }
    }

    public void eliminarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE id=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.executeUpdate();
        }
    }

    // ---------- PRODUCTOS ----------
    public void insertarProducto(Producto p) throws SQLException {
    String sql = "INSERT INTO Productos(nombre, categoria, precio, stock) VALUES(?,?,?,?)";
    try (Connection con = ConexionSQL.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getCategoria());
        ps.setDouble(3, p.getPrecio());
        ps.setInt(4, p.getStock());
        ps.executeUpdate();
    }
}


    public List<Producto> listarProductos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, categoria, precio, stock FROM Productos";
        try (Connection con = ConexionSQL.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setID(rs.getInt("id")); // si tenés campo id
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        }
        return lista;
    }

    public void actualizarProducto(Producto p) throws SQLException {
        String sql = "UPDATE Productos SET nombre=?, categoria=?, precio=?, stock=? WHERE id=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getID());
            ps.executeUpdate();
        }
    }

    public void eliminarProducto(int idProducto) throws SQLException {
        String sql = "DELETE FROM Productos WHERE id=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.executeUpdate();
        }
    }

    // ---------- EMPLEADOS ----------
    public void insertarEmpleado(Empleado e) throws SQLException {
        String sql = "INSERT INTO Empleados(nombre, apellido, dni, telefono, email, sueldo, tipo, atendidos) VALUES(?,?,?,?,?,?,?,?)";
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
            ps.executeUpdate();
        }
    }

    public List<Empleado> listarEmpleados() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, dni, telefono, email, sueldo, tipo, atendidos FROM Empleados";
        try (Connection con = ConexionSQL.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Empleado e = new Empleado();
                //e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setDNI(rs.getString("dni"));
                e.setTelefono(rs.getString("telefono"));
                e.setEmail(rs.getString("email"));
                e.setSueldo(rs.getDouble("sueldo"));
                e.setTipo(rs.getString("tipo"));
                e.setAtendidos(rs.getInt("atendidos"));
                lista.add(e);
            }
        }
        return lista;
    }

    public void actualizarEmpleado(Empleado e) throws SQLException {
        String sql = "UPDATE Empleados SET nombre=?, apellido=?, dni=?, telefono=?, email=?, sueldo=?, tipo=?, atendidos=? WHERE id=?";
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
            //ps.setInt(9, e.getId());
            ps.executeUpdate();
        }
    }

    public void eliminarEmpleado(int idEmpleado) throws SQLException {
        String sql = "DELETE FROM Empleados WHERE id=?";
        try (Connection con = ConexionSQL.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEmpleado);
            ps.executeUpdate();
        }
    }

    // ---------- VENTAS (INSERT VENTA + DETALLE + UPDATE STOCK) ----------
    // listaProductosVenta: lista de objetos (productoId, precio, cantidad) o strings parseables.
    public int registrarVenta(Integer clienteId, List<VentaItem> listaProductosVenta, double total) throws SQLException {
        // Retorna id de venta insertada
        String sqlVenta = "INSERT INTO Ventas(clienteId, fecha, total) VALUES(?, ?, ?)";
        String sqlDetalle = "INSERT INTO VentaDetalle(ventaId, productoId, precio, cantidad) VALUES(?, ?, ?, ?)";
        String sqlUpdateStock = "UPDATE Productos SET stock = stock - ? WHERE id = ? AND stock >= ?";

        try (Connection con = ConexionSQL.conectar()) {
            con.setAutoCommit(false); // transacción

            try (PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                psVenta.setObject(1, clienteId); // puede ser null
                psVenta.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                psVenta.setDouble(3, total);
                psVenta.executeUpdate();

                int ventaId;
                try (ResultSet rs = psVenta.getGeneratedKeys()) {
                    if (rs.next()) ventaId = rs.getInt(1);
                    else throw new SQLException("No se recuperó el id de la venta");
                }

                try (PreparedStatement psDet = con.prepareStatement(sqlDetalle);
                     PreparedStatement psUpd = con.prepareStatement(sqlUpdateStock)) {

                    for (VentaItem item : listaProductosVenta) {
                        // 1) insertar detalle
                        psDet.setInt(1, ventaId);
                        psDet.setInt(2, item.getProductoId());
                        psDet.setDouble(3, item.getPrecio());
                        psDet.setInt(4, item.getCantidad());
                        psDet.executeUpdate();

                        // 2) descontar stock (asegurando no quedar negativo)
                        psUpd.setInt(1, item.getCantidad());
                        psUpd.setInt(2, item.getProductoId());
                        psUpd.setInt(3, item.getCantidad());
                        int updated = psUpd.executeUpdate();
                        if (updated == 0) {
                            throw new SQLException("Stock insuficiente para el producto id=" + item.getProductoId());
                        }
                    }
                }

                con.commit();
                return ventaId;
            } catch (Exception ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }
    public int registrarVentaConCliente(Cliente cliente, List<String> listaStringsProductos, double total) throws SQLException {

    System.out.println("Entrando a registrarVentaConCliente...");

    // 1) Insertar cliente
    insertarCliente(cliente);

    // obtener ID generado
    int clienteId = -1;

    String sqlId = "SELECT TOP 1 id FROM Clientes ORDER BY id DESC";
    try (Connection con = ConexionSQL.conectar();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sqlId)) {

        if (rs.next()) clienteId = rs.getInt("id");
        else throw new SQLException("No se pudo obtener ID del cliente.");
    }

    System.out.println("Cliente insertado con ID: " + clienteId);

    // 2) Convertir strings a VentaItem
    List<VentaItem> items = new ArrayList<>();

    for (String item : listaStringsProductos) {
        String[] partes = item.split("\\|");
        String nombreProd = partes[0].trim();

        // Buscar producto
        Producto p = buscarProductoPorNombre(nombreProd);
        if (p == null) throw new SQLException("Producto no encontrado: " + nombreProd);

        items.add(new VentaItem(p.getID(), p.getPrecio(), 1));
    }

    System.out.println("Items creados: " + items.size());

    // 3) Registrar la venta
    int ventaId = registrarVenta(clienteId, items, total);

    System.out.println("Venta registrada con ID: " + ventaId);

    return ventaId;
}

public Producto buscarProductoPorNombre(String nombre) throws SQLException {
    String sql = "SELECT * FROM Productos WHERE nombre = ?";
    try (Connection con = ConexionSQL.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Producto p = new Producto();
            p.setID(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setCategoria(rs.getString("categoria"));
            p.setPrecio(rs.getDouble("precio"));
            p.setStock(rs.getInt("stock"));
            return p;
        }
    }
    return null;
}


    // Clase auxiliar para el detalle de venta
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
}

