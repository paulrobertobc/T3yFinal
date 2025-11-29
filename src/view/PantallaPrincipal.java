
package view;

import controller.Controller;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Empleado;
import model.Inventario;
import model.Producto;
import model.Venta;

public class PantallaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName());

    
    public Controller controlador = new Controller();
    public Inventario elInventario = new Inventario();
    public Venta ventaPrincipal = new Venta();

    
    public PantallaPrincipal() {
        initComponents();
        llenadoTablasGeneral();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosGeneral = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        lbFondoWallpaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        btnImportar = new javax.swing.JMenu();
        btnImportarProductos = new javax.swing.JMenu();
        btnImportarEmpleados = new javax.swing.JMenu();
        btnExportar = new javax.swing.JMenu();
        btnExportarProductos = new javax.swing.JMenu();
        btnExportarEmpleados = new javax.swing.JMenu();
        btnExportarHistorial = new javax.swing.JMenu();
        btnRegistrarVentaMenu = new javax.swing.JMenu();
        btnVentaMenu = new javax.swing.JMenu();
        btnRegistrarProducto = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        btnHistorial = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnEditarProducto = new javax.swing.JMenu();
        btnEditarCliente = new javax.swing.JMenu();
        btnEditarEmpleado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación de gestion de ventas para la polleria El Buen Sabor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "E-mail", "Telefono", "Total gastado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 740, 161));

        tablaProductosGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaProductosGeneral);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 630, 161));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel2.setText("Clientes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Empleados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Sueldo", "Nombre", "Apellido", "DNI", "E-mail", "Telefono", "Total atendidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaEmpleados);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1030, 261));

        lbFondoWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperMenu.jpg"))); // NOI18N
        getContentPane().add(lbFondoWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1060, 770));

        jMenu3.setText("Archivo");

        btnImportar.setText("Importar");

        btnImportarProductos.setText("Importar lista de productos");
        btnImportarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportarProductosMouseClicked(evt);
            }
        });
        btnImportar.add(btnImportarProductos);

        btnImportarEmpleados.setText("Importar lista de empleados");
        btnImportarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportarEmpleadosMouseClicked(evt);
            }
        });
        btnImportar.add(btnImportarEmpleados);

        jMenu3.add(btnImportar);

        btnExportar.setText("Exportar");

        btnExportarProductos.setText("Exportar lista de productos");
        btnExportarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarProductosMouseClicked(evt);
            }
        });
        btnExportar.add(btnExportarProductos);

        btnExportarEmpleados.setText("Exportar lista de empleados");
        btnExportarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarEmpleadosMouseClicked(evt);
            }
        });
        btnExportar.add(btnExportarEmpleados);

        btnExportarHistorial.setText("Exportar historial de ventas");
        btnExportarHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarHistorialMouseClicked(evt);
            }
        });
        btnExportar.add(btnExportarHistorial);

        jMenu3.add(btnExportar);

        jMenuBar1.add(jMenu3);

        btnRegistrarVentaMenu.setForeground(new java.awt.Color(51, 51, 255));
        btnRegistrarVentaMenu.setText("Nueva venta");
        btnRegistrarVentaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarVentaMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnRegistrarVentaMenu);

        btnVentaMenu.setText("Registrar");

        btnRegistrarProducto.setText("Registrar producto");
        btnRegistrarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarProductoMouseClicked(evt);
            }
        });
        btnVentaMenu.add(btnRegistrarProducto);

        jMenu1.setText("Registrar empleado");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        btnVentaMenu.add(jMenu1);

        jMenuBar1.add(btnVentaMenu);

        btnHistorial.setText("Historial");
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnHistorial);

        jMenu2.setText("Editar");

        btnEditarProducto.setText("Editar producto");
        btnEditarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarProductoMouseClicked(evt);
            }
        });
        jMenu2.add(btnEditarProducto);

        btnEditarCliente.setText("Editar cliente");
        btnEditarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarClienteMouseClicked(evt);
            }
        });
        jMenu2.add(btnEditarCliente);

        btnEditarEmpleado.setText("Editar empleado");
        btnEditarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarEmpleadoMouseClicked(evt);
            }
        });
        jMenu2.add(btnEditarEmpleado);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVentaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarVentaMenuMouseClicked
        // TODO add your handling code here:
        RegistroVenta nueva = new RegistroVenta(elInventario, ventaPrincipal, controlador, this);
        nueva.setVisible(true);
    }//GEN-LAST:event_btnRegistrarVentaMenuMouseClicked

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked
        // TODO add your handling code here:
        PantallaHistorial his = new PantallaHistorial(controlador.listaVenta);
        his.setVisible(true);
    }//GEN-LAST:event_btnHistorialMouseClicked

    private void btnRegistrarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarProductoMouseClicked
        // TODO add your handling code here:
        PantallaRegistroProductos prp = new PantallaRegistroProductos(elInventario, this);
        prp.setVisible(true);
    }//GEN-LAST:event_btnRegistrarProductoMouseClicked

    private void btnEditarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarClienteMouseClicked
        // TODO add your handling code here:
        EdicionCliente ec = new EdicionCliente(this, controlador.listaClientes);
        ec.setVisible(true);
    }//GEN-LAST:event_btnEditarClienteMouseClicked

    private void btnEditarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProductoMouseClicked
        // TODO add your handling code here:
        EdicionProducto ep = new EdicionProducto(this, elInventario.listaProductos);
        ep.setVisible(true);
    }//GEN-LAST:event_btnEditarProductoMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        RegistroEmpleado re = new RegistroEmpleado(this, controlador);
        re.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnEditarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoMouseClicked
        // TODO add your handling code here:
        EdicionEmpleado ee = new EdicionEmpleado(this, controlador.listaMeseros, controlador.listaCocineros, controlador.listaCajero);
        ee.setVisible(true);
    }//GEN-LAST:event_btnEditarEmpleadoMouseClicked

    private void btnExportarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarProductosMouseClicked
        // TODO add your handling code here:
        if (elInventario.listaProductos.isEmpty() || elInventario.listaProductos == null){
            JOptionPane.showMessageDialog(null, "Lista de productos vacia.");
            return;
        }
        elInventario.exportarProductos();
    }//GEN-LAST:event_btnExportarProductosMouseClicked

    private void btnImportarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportarEmpleadosMouseClicked
        // TODO add your handling code here:
        controlador.importarEmpleados();
        llenadoTablasGeneral();
    }//GEN-LAST:event_btnImportarEmpleadosMouseClicked

    private void btnImportarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportarProductosMouseClicked
        // TODO add your handling code here:
        elInventario.importarProductos();
        llenadoTablasGeneral();
    }//GEN-LAST:event_btnImportarProductosMouseClicked

    private void btnExportarHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarHistorialMouseClicked
        // TODO add your handling code here:
        if (controlador.listaVenta.isEmpty() || controlador.listaVenta == null){
            JOptionPane.showMessageDialog(null, "Historial de ventas vacio.");
            return;
        }
        controlador.exportarHistorialVentas();
    }//GEN-LAST:event_btnExportarHistorialMouseClicked

    private void btnExportarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarEmpleadosMouseClicked
        // TODO add your handling code here:
        controlador.exportarEmpleados();
    }//GEN-LAST:event_btnExportarEmpleadosMouseClicked

    
    public void llenadoTablasGeneral(){
        DefaultTableModel modelo1 = (DefaultTableModel) tablaClientes.getModel();
        modelo1.setRowCount(0);
        tablaClientes.setDefaultEditor(Object.class, null);
        DefaultTableModel modelo2 = (DefaultTableModel) tablaProductosGeneral.getModel();
        modelo2.setRowCount(0);
        tablaProductosGeneral.setDefaultEditor(Object.class, null);
        DefaultTableModel modelo3 = (DefaultTableModel)tablaEmpleados.getModel();
        modelo3.setRowCount(0);
        tablaEmpleados.setDefaultEditor(Object.class, null);
        for (Cliente c : controlador.listaClientes){
            modelo1.addRow(new Object[]{c.getNombre(), c.getApellido(), c.getDNI(), c.getEmail(), c.getTelefono(), c.total});
        }
        for(Producto p : elInventario.listaProductos){
            modelo2.addRow(new Object[]{p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock()});
        }
        for(Empleado e : controlador.listaMeseros){
            modelo3.addRow(new Object[]{e.getTipo(),e.getSueldo(),e.getNombre(), e.getApellido(), e.getDNI(), e.getEmail(), e.getTelefono(), e.getAtendidos()});
        }
        for (Empleado e : controlador.listaCajero){
            modelo3.addRow(new Object[]{e.getTipo(),e.getSueldo(), e.getNombre(), e.getApellido(), e.getDNI(), e.getEmail(), e.getTelefono(), e.getAtendidos()});
        }
        for(Empleado e : controlador.listaCocineros){
            modelo3.addRow(new Object[]{e.getTipo(),e.getSueldo(),e.getNombre(), e.getApellido(), e.getDNI(), e.getEmail(), e.getTelefono(), e.getAtendidos()});
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnEditarCliente;
    private javax.swing.JMenu btnEditarEmpleado;
    private javax.swing.JMenu btnEditarProducto;
    private javax.swing.JMenu btnExportar;
    private javax.swing.JMenu btnExportarEmpleados;
    private javax.swing.JMenu btnExportarHistorial;
    private javax.swing.JMenu btnExportarProductos;
    private javax.swing.JMenu btnHistorial;
    private javax.swing.JMenu btnImportar;
    private javax.swing.JMenu btnImportarEmpleados;
    private javax.swing.JMenu btnImportarProductos;
    private javax.swing.JMenu btnRegistrarProducto;
    private javax.swing.JMenu btnRegistrarVentaMenu;
    private javax.swing.JMenu btnVentaMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbFondoWallpaper;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaProductosGeneral;
    // End of variables declaration//GEN-END:variables
}
