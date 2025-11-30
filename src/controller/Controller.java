
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Empleado;
import model.Venta;

/**
 *
 * @author PAUL
 */
public class Controller{
    public ArrayList<Cliente> listaClientes;
    public ArrayList<Empleado> listaMeseros;
    public ArrayList<Empleado> listaCocineros;
    public ArrayList<Empleado> listaCajeros;
    public ArrayList<Venta> listaVenta;
    public double Capital;

    public Controller() {
        this.listaClientes = new ArrayList<>();
        this.listaMeseros = new ArrayList<>();
        this.listaCocineros = new ArrayList<>();
        this.listaCajeros = new ArrayList<>();
        this.listaVenta = new ArrayList<>();
        listaClientes.add(new Cliente(22121,"Perico", "de los palotes", "68635652", "987546324","perico@gmail.com"));
        listaClientes.add(new Cliente(32312,"Fulano", "de tal", "68634652", "987546324","fulano@gmail.com"));
        listaClientes.add(new Cliente(63442,"Anita", "la huerfanita", "68634562", "987546324","huerfanita@gmail.com"));
        listaClientes.add(new Cliente(54231,"Don", "nadie", "68634565", "987546324","don_nadie@gmail.com"));
        listaCocineros.add(new Empleado(43212, 1024.50, "Cocinero","Lelo", "garcía", "68634565", "987546324","lalo@gmail.com"));
        listaCocineros.add(new Empleado(12312, 1024.50, "Cocinero","Merlo", "Rodriguez", "12345678", "987435675", "merloro@gmail.com"));
        listaMeseros.add(new Empleado(12341, 900.90, "Mesero","Homero", "de la iliada", "68634565", "987546324","homero_iliada@gmail.com"));
        listaMeseros.add(new Empleado(1232, 3000.90,"Mesero","Adam Paul", "B C", "68634565", "987546324","adampaul@gmail.com"));
        listaMeseros.add(new Empleado(4355,3000.90,"Mesero","Lalo", "embalo", "68634565", "987546324","lalobalo@gmail.com"));
        listaCajeros.add(new Empleado(231312, 1024.65, "Cajero","Lucho", "barrios", "68634565", "987546324","lucho_b@gmail.com"));
        listaCajeros.add(new Empleado(23221, 1024.65, "Cajero","Reyna", "escalante", "68634565", "987546324","reyna_lante@gmail.com"));
        listaCajeros.add(new Empleado(23131, 1024.65, "Cajero","Lucia", "merlina", "68634565", "987546324","luchaMer_b@gmail.com"));
    }
    public void agregarAlistaCliente(Cliente e){
        listaClientes.add(e);
    }
    public void agregarAlistaMeseros(Empleado e){
        listaMeseros.add(e);
    }
    public void agregarAlistaCocineros(Empleado e){
        listaCocineros.add(e);
    }
    public void agregarAlistaCajeros(Empleado e){
        listaCajeros.add(e);
    }
    public void agregarAlistaVenta(Venta e){
        listaVenta.add(e);
    }

    public double getCapital() {
        return Capital;
    }

    public void setCapital(double Capital) {
        this.Capital = this.Capital + Capital;
    }
    public ArrayList<Empleado> listaEmpleadoUnificado() {
    ArrayList<Empleado> lista = new ArrayList<>();
    lista.addAll(listaMeseros);
    lista.addAll(listaCocineros);
    lista.addAll(listaCajeros);
    return lista;
    }

    public void exportarHistorialVentas() {
        if (listaVenta == null || listaVenta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas para exportar.");
            return;
        }
        JFileChooser explorador = new JFileChooser();
        explorador.setDialogTitle("Guardar historial de ventas");
        int seleccion = explorador.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = explorador.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                writer.write("===== HISTORIAL DE VENTAS =====");
                writer.newLine();
                writer.newLine();
                for (Venta venta : listaVenta) {
                    writer.write("Fecha: " + venta.getFecha().format(formatoFecha));
                    writer.newLine();
                    writer.write("Productos:");
                    writer.newLine();
                    for (ArrayList<String> lista : venta.getVentas()) {
                        for (String item : lista) {
                            writer.write(" - " + item);
                            writer.newLine();
                        }
                    }
                    writer.write("---------------------------------------");
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(null, "Historial exportado correctamente a:\n" + archivo.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error\nHubieron fallas: " + e.getMessage());
            }
        }
    }
    
    public void exportarEmpleados(){
        ArrayList<Empleado> todos = new ArrayList<>();
        todos.addAll(listaMeseros);
        todos.addAll(listaCocineros);
        todos.addAll(listaCajeros);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar empleados");
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("===== LISTA DE EMPLEADOS =====");
                writer.newLine();
                writer.newLine();
                for (Empleado e : todos) {
                    writer.write(e.getID()+";"+e.getNombre()+";"+e.getApellido()+";"+e.getDNI()+";"+e.getTelefono()+";"+e.getEmail()+";"+e.getTipo()+";"+e.getSueldo()+";"+e.getAtendidos());
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(null, "Empleados exportados correctamente a:\n" + archivo.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al exportar empleados: " + e.getMessage());
            }
        }
    }
    
    public void importarEmpleados() {
        JFileChooser fileChooser = new JFileChooser();fileChooser.setDialogTitle("Selecciona archivo de empleados");
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                linea = reader.readLine();
                if (linea != null && linea.startsWith("====")) {
                    linea = reader.readLine();
                }
                while (linea != null) {
                    if (!linea.trim().isEmpty()) {
                        String[] partes = linea.split(";");
                        if (partes.length < 10) {
                            
                            Empleado emp = new Empleado(Integer.parseInt(partes[0]),Double.parseDouble(partes[7]),partes[6],partes[1],partes[2],partes[3],partes[4],partes[5]);
                            emp.setAtendidos(Integer.parseInt(partes[8]));
                        switch (emp.getTipo().toLowerCase()) {
                            case "mesero":
                            case "meseros":
                                listaMeseros.add(emp);
                                break;
                            case "cocinero":
                            case "cocineros":
                                listaCocineros.add(emp);
                                break;
                            case "cajero":
                            case "cajeros":
                                listaCajeros.add(emp);
                                break;
                            default:
                                System.out.println("Tipo desconocido: " + emp.getTipo());
                                break;
                        }
                    }
                }
                    linea = reader.readLine();
                }
                JOptionPane.showMessageDialog(null, "Empleados importados correctamente desde:\n" + archivo.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error\nHubieron fallas: " + e.getMessage());
            }
        }
    }
    
}
