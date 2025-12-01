package controller;

import database.Conexion;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Empleado;
import model.Producto;
import model.Venta;

public class ControllerSQL {

    public void insertarProducto(Producto p) throws SQLException {
        String sql = "INSERT INTO productos(nombre, precio, categoria, stock) VALUES(?,?,?,?)";
        
        try (Connection con = Conexion.getConexion();
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
        String sql = "SELECT id_producto, nombre, precio, categoria, stock FROM productos";
        
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Producto p = new Producto();
                p.setID(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCategoria(rs.getString("categoria"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        }
        return lista;
    }

    public void actualizarProducto(Producto p) throws SQLException {
        String sql = "UPDATE productos SET nombre=?, precio=?, categoria=?, stock=? WHERE id_producto=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setString(3, p.getCategoria());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getID());
            ps.executeUpdate();
        }
    }

    public void insertarCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes(nombre, apellido, dni, telefono, email, total_compras) VALUES(?,?,?,?,?,?)";
        
        try (Connection con = Conexion.getConexion();
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
        String sql = "SELECT id_cliente, nombre, apellido, dni, telefono, email, total_compras FROM clientes";
        
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setID(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDNI(rs.getString("dni"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.total = rs.getDouble("total_compras"); // Mapeo correcto
                lista.add(c);
            }
        }
        return lista;
    }

    public void actualizarCliente(Cliente c) throws SQLException {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, dni=?, telefono=?, email=?, total_compras=? WHERE id_cliente=?";
        
        try (Connection con = Conexion.getConexion();
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

    public void insertarEmpleado(Empleado e) throws SQLException {
        String sql = "INSERT INTO empleados(nombre, apellido, dni, telefono, email, sueldo, tipo_empleado, clientes_atendidos) VALUES(?,?,?,?,?,?,?,?)";
        
        try (Connection con = Conexion.getConexion();
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
        String sql = "SELECT id_empleado, nombre, apellido, dni, telefono, email, sueldo, tipo_empleado, clientes_atendidos FROM empleados";
        
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setID(rs.getInt("id_empleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setDNI(rs.getString("dni"));
                e.setTelefono(rs.getString("telefono"));
                e.setEmail(rs.getString("email"));
                e.setSueldo(rs.getDouble("sueldo"));
                e.setTipo(rs.getString("tipo_empleado"));
                e.setAtendidos(rs.getInt("clientes_atendidos"));
                lista.add(e);
            }
        }
        return lista;
    }

    public void actualizarEmpleado(Empleado e) throws SQLException {
        String sql = "UPDATE empleados SET nombre=?, apellido=?, dni=?, telefono=?, email=?, sueldo=?, tipo_empleado=?, clientes_atendidos=? WHERE id_empleado=?";
        
        try (Connection con = Conexion.getConexion();
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

    public static class VentaItem {
        private int productoId;
        private String nombreProducto; 
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

    public int registrarVenta(Integer clienteId, List<VentaItem> items, double total) throws SQLException {
        String sqlVenta = "INSERT INTO ventas(fecha_venta, id_cliente, total) VALUES(?, ?, ?)";
        
        String sqlDetalle = "INSERT INTO detalle_ventas(id_venta, id_producto, nombre_producto, cantidad, precio_unitario, subtotal) VALUES(?, ?, ?, ?, ?, ?)";
        
        String sqlUpdateStock = "UPDATE productos SET stock = stock - ? WHERE id_producto = ? AND stock >= ?";
        
        String sqlGetNombre = "SELECT nombre FROM productos WHERE id_producto = ?";

        try (Connection con = Conexion.getConexion()) {
            con.setAutoCommit(false); 
            int ventaId = 0;
            
            try (PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                psVenta.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                psVenta.setInt(2, clienteId);
                psVenta.setDouble(3, total);
                psVenta.executeUpdate();
                
                try (ResultSet rs = psVenta.getGeneratedKeys()) {
                    if (rs.next()) ventaId = rs.getInt(1);
                    else throw new SQLException("No se pudo obtener el ID de la venta.");
                }
            }

            try (PreparedStatement psDet = con.prepareStatement(sqlDetalle);
                 PreparedStatement psUpd = con.prepareStatement(sqlUpdateStock);
                 PreparedStatement psNombre = con.prepareStatement(sqlGetNombre)) {

                for (VentaItem it : items) {
                    
                    String nombreProd = "Producto";
                    psNombre.setInt(1, it.getProductoId());
                    try(ResultSet rsNombre = psNombre.executeQuery()){
                        if(rsNombre.next()) nombreProd = rsNombre.getString("nombre");
                    }

                    psDet.setInt(1, ventaId);
                    psDet.setInt(2, it.getProductoId());
                    psDet.setString(3, nombreProd); // nombre_producto
                    psDet.setInt(4, it.getCantidad());
                    psDet.setDouble(5, it.getPrecio());
                    psDet.setDouble(6, it.getPrecio() * it.getCantidad()); // subtotal
                    psDet.executeUpdate();

                    psUpd.setInt(1, it.getCantidad());
                    psUpd.setInt(2, it.getProductoId());
                    psUpd.setInt(3, it.getCantidad());
                    int updated = psUpd.executeUpdate();
                    
                    if (updated == 0) {
                        con.rollback(); 
                        throw new SQLException("Stock insuficiente para producto ID=" + it.getProductoId());
                    }
                }
            }

            con.commit(); 
            return ventaId;
            
        } catch (SQLException ex) {
            throw ex; 
        }
    }

    public List<Venta> listarVentas() throws SQLException {
        List<Venta> lista = new ArrayList<>();
        String sql = """
            SELECT v.id_venta, v.fecha_venta, v.id_cliente, c.nombre, c.apellido, v.total
            FROM ventas v
            INNER JOIN clientes c ON v.id_cliente = c.id_cliente
        """;

        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Venta v = new Venta();
                v.setID(rs.getInt("id_venta"));
                v.setFecha(rs.getTimestamp("fecha_venta").toLocalDateTime());

                Cliente c = new Cliente();
                c.setID(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                v.setComprador(c);
                v.setTotal(rs.getDouble("total")); 

                lista.add(v);
            }
        }
        return lista;
    }
}