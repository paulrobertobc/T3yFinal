
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

    public Cliente(int ID, double total, String Nombre, String Apellido, String DNI, String Telefono, String Email) {
        super(ID,Nombre, Apellido, DNI, Telefono, Email);
        this.total = total;
    }

    public Cliente(int ID, String Nombre, String Apellido, String DNI, String Telefono, String Email) {
        super(ID, Nombre, Apellido, DNI, Telefono, Email);
        this.total = 0;
    }
    
    public void agregarCompra(ArrayList<String> listaVenta) {
        lasCompras.add(new ArrayList<>(listaVenta));
    }
}
