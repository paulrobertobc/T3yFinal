
package model;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author PAUL
 */
public class Venta implements Comportamiento<ArrayList<String>>{
    private ArrayList<ArrayList<String>> lasVentas;
    public LocalDateTime fecha;
    public Cliente comprador;
    public int ID;

    public Venta() {
        lasVentas = new ArrayList<>();
    }

    public Venta(int ID, ArrayList<String> listaVenta, LocalDateTime fecha, Cliente comprador) {
        lasVentas.add(new ArrayList<>(listaVenta));
        this.fecha = fecha;
        this.comprador = comprador;
        this.ID = ID;
    }

    public ArrayList<ArrayList<String>> getLasVentas() {
        return lasVentas;
    }

    public void setLasVentas(ArrayList<ArrayList<String>> lasVentas) {
        this.lasVentas = lasVentas;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public void agregarVentayFecha(int ID, ArrayList<String> listaVenta, LocalDateTime fecha, Cliente comprador){
        lasVentas.add(new ArrayList<>(listaVenta));
        this.fecha = fecha;
        this.comprador = comprador;
        this.ID = ID;
    }
    public String getNombre(){
        return comprador.getNombre();
    }
    public String getDNI(){
        return comprador.getDNI();
    }
    @Override
    public void agregar(ArrayList<String> listaVenta) {
        lasVentas.add(new ArrayList<>(listaVenta));
    }

    @Override
    public ArrayList<ArrayList<String>> obtenerTodo() {
        return lasVentas;
    }
    
    public ArrayList<ArrayList<String>> getVentas() {
        return lasVentas;
    }
    public void guardarBoleta() {
        try {
            JFileChooser explorador = new JFileChooser();
            explorador.setDialogTitle("Emitir boleta como...");
            explorador.setSelectedFile(new File("Boleta_" + fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt"));
            int userSelection = explorador.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File archivo = explorador.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                    bw.write("===== BOLETA DE VENTA =====");
                    bw.newLine();
                    bw.write("Fecha: " + fecha);
                    bw.newLine();
                    bw.write("Cliente: " + comprador.getNombre() + " " + comprador.getApellido());
                    bw.newLine();
                    bw.write("DNI: " + comprador.getDNI());
                    bw.newLine();
                    bw.write("Teléfono: " + comprador.getTelefono());
                    bw.newLine();
                    bw.write("Email: " + comprador.getEmail());
                    bw.newLine();
                    bw.write("=============================");
                    bw.newLine();
                    for (ArrayList<String> lista : lasVentas) {
                        for (String productoComprado : lista) {
                            bw.write(productoComprado);
                            bw.newLine();
                        }
                        bw.newLine();
                    }
                    bw.write("=============================");
                    bw.newLine();
                    bw.write("Total: S/ " + comprador.total);
                    bw.newLine();
                    bw.write("Gracias por su compra.");
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(null, "✅ Venta guardada en:\n" + archivo.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "❌ Error\nNo se guardó la venta.");
            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al guardar el archivo: " + e.getMessage());
        }
    }
}
