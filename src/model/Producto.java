
package model;

/**
 *
 * @author PAUL
 */
public class Producto {
    public int ID;
    public String Nombre;
    public double Precio;
    public String Categoria;
    public int Stock;

    public Producto() {
    }

    public Producto(int ID, String Nombre, double Precio, String Categoria, int Stock) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Categoria = Categoria;
        this.Stock = Stock;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
