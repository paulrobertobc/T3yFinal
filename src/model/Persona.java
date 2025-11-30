
package model;

/**
 *
 * @author PAUL
 */
public abstract class Persona {
    protected int ID;
    protected String Nombre;
    protected String Apellido;
    protected String DNI;
    protected String Telefono;
    protected String Email;

    public Persona() {
    }

    public Persona(int ID, String Nombre, String Apellido, String DNI, String Telefono, String Email) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
