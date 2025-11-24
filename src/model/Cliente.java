
package model;

import java.util.ArrayList;

/**
 *
 * @author PAUL
 */
public class Cliente extends Persona{
    private ArrayList<ArrayList<String>> lasCompras = new ArrayList<>();
    public double total;

    public Cliente() {
    }

    public Cliente(double total, String Nombre, String Apellido, String DNI, String Telefono, String Email) {
        super(Nombre, Apellido, DNI, Telefono, Email);
        this.total = total;
    }

    public Cliente(String Nombre, String Apellido, String DNI, String Telefono, String Email) {
        super(Nombre, Apellido, DNI, Telefono, Email);
    }
    
    public void agregarCompra(ArrayList<String> listaVenta) {
        lasCompras.add(new ArrayList<>(listaVenta));
    }
}
