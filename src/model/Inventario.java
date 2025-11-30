
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author PAUL
 */
public class Inventario implements Comportamiento<Producto>{
    public ArrayList<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(2232, "1 Pollo a la brasa", 65.00, "Rostizados",10 ));
        listaProductos.add(new Producto(42312,"1/2 Pollo a la brasa", 34.00, "Rostizados",20 ));
        listaProductos.add(new Producto(2123,"1/4 Pollo a la brasa", 12.00, "Rostizados",40 ));
        listaProductos.add(new Producto(23321,"Coca cola 3L", 12.00, "Bebidas",10 ));
        listaProductos.add(new Producto(32112,"1/4 Mostrito", 15.00, "Rostizados",10 ));
        listaProductos.add(new Producto(897453,"Bisteck a lo macho", 15.00, "Parrillas",10 ));
        listaProductos.add(new Producto(07213,"Coca cola 1/2 L", 3.5, "Bebidas",40 ));
    }
    
    @Override
    public ArrayList<Producto> obtenerTodo() {
        return listaProductos;
    }
    @Override
    public void agregar(Producto p) {
        listaProductos.add(p);
    }
    public ArrayList<Producto> getListaProductosInven() {
        return listaProductos;
    }
    
    public void setListaProductosInven(ArrayList<Producto> listaProductosInven) {
        this.listaProductos = listaProductosInven;
    }
    public void exportarProductos() {
        JFileChooser explorador = new JFileChooser();
        explorador.setDialogTitle("Guardar lista de productos");

        int seleccion = explorador.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = explorador.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("===== LISTA DE PRODUCTOS =====");
                writer.newLine();
                for (Producto p : listaProductos) {
                    writer.write(p.getNombre()+" | "+p.getCategoria() + " | "+p.getPrecio()+" | "+"Stock: "+ p.getStock());
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(null, "Productos guardados correctamente en:\n" + archivo.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error\nHubieron fallas." + e.getMessage());
            }
        }
    }
    public void importarProductos() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo de productos");

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    if (!linea.trim().isEmpty()) {
                        String[] partes = linea.split("\\|");
                        if (partes.length >= 4) {
                            String nombre = partes[0].trim();
                            String categoria = partes[1].trim();
                            double precio = Double.parseDouble(partes[2].trim());
                            int stock = Integer.parseInt(partes[3].replace("Stock:", "").trim());
                            Producto nuevo = new Producto(2, nombre, precio, categoria, stock);
                            listaProductos.add(nuevo);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Productos importados correctamente desde:\n" + archivo.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al importar productos: " + e.getMessage());
            }
        }
    }
}
