
package model;

/**
 *
 * @author PAUL
 */
public class Empleado extends Persona{
    public double Sueldo;
    public String Tipo;
    public int atendidos;

    public Empleado() {
        atendidos = 0;
    }

    public Empleado(double Sueldo, String Tipo, String Nombre, String Apellido, String DNI, String Telefono, String Email) {
        super(Nombre, Apellido, DNI, Telefono, Email);
        this.Sueldo = Sueldo;
        this.Tipo = Tipo;
        atendidos = 0;
    }
    
    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getAtendidos() {
        return atendidos;
    }

    public void setAtendidos(int atendidos) {
        this.atendidos = atendidos;
    }
}
