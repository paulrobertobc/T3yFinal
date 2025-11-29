
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

    public Controller() {
        this.listaClientes = new ArrayList<>();
        this.listaMeseros = new ArrayList<>();
        this.listaCocineros = new ArrayList<>();
        this.listaCajeros = new ArrayList<>();
        this.listaVenta = new ArrayList<>();
        listaClientes.add(new Cliente("Perico", "de los palotes", "68635652", "987546324","perico@gmail.com"));
        listaClientes.add(new Cliente("Fulano", "de tal", "68634652", "987546324","fulano@gmail.com"));
        listaClientes.add(new Cliente("Anita", "la huerfanita", "68634562", "987546324","huerfanita@gmail.com"));
        listaClientes.add(new Cliente("Don", "nadie", "68634565", "987546324","don_nadie@gmail.com"));
        listaCocineros.add(new Empleado(1024, "Cocinero","Lelo", "garcía", "68634565", "987546324","lalo@gmail.com"));
        listaCocineros.add(new Empleado(1024, "Cocinero", "Merlo", "Rodriguez", "12345678", "987435675", "merloro@gmail.com"));
        listaMeseros.add(new Empleado(900, "Mesero","Homero", "de la iliada", "68634565", "987546324","homero_iliada@gmail.com"));
        listaMeseros.add(new Empleado(3000,"Mesero","Adam Paul", "B C", "68634565", "987546324","adampaul@gmail.com"));
        listaMeseros.add(new Empleado(3000,"Mesero","Lalo", "embalo", "68634565", "987546324","lalobalo@gmail.com"));
        listaCajeros.add(new Empleado(1024, "Cajero","Lucho", "barrios", "68634565", "987546324","lucho_b@gmail.com"));
        listaCajeros.add(new Empleado(1024, "Cajero","Reyna", "escalante", "68634565", "987546324","reyna_lante@gmail.com"));
        listaCajeros.add(new Empleado(1024, "Cajero","Lucia", "merlina", "68634565", "987546324","luchaMer_b@gmail.com"));
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
                        if (partes.length == 8) {
                            Empleado emp = new Empleado(Double.parseDouble(partes[6]),partes[5],partes[0],partes[1],partes[2],partes[3],partes[4]);
                            emp.setAtendidos(Integer.parseInt(partes[7]));
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
}
