package modelo;
import java.io.Serializable;
public class Empleado implements Serializable{
    private static final long seralVersionUID =1L;
    private int Codigo;
    private String Nombre;
    private String Cargo;
    private String Telefono;
    private String Domicilio;
    private String Fech_Con;

    public Empleado(){
    }

    public Empleado(int Codigo, String Nombre, String Cargo, String Telefono, String Domicilio, String Fech_Con){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Telefono = Telefono;
        this.Domicilio = Domicilio;
        this.Fech_Con = Fech_Con;
    }

    public Empleado(String Nombre, String Cargo, String Telefono, String Domicilio, String Fech_Con){
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Telefono = Telefono;
        this.Domicilio = Domicilio;
        this.Fech_Con = Fech_Con;
    }

    public Empleado(int Codigo){
        this.Codigo = Codigo;
    }

    public int getCodigo(){
        return Codigo;
    }

    public void setCodigo(int Codigo){
        this.Codigo = Codigo;
    }

    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getCargo(){
        return Cargo;
    }

    public void setCargo(String Cargo){
        this.Cargo = Cargo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDomicilio(){
        return Domicilio;
    }

    public void setDomicilio(String Domicilio){
        this.Domicilio = Domicilio;
    }

    public String getFech_Con(){
        return Fech_Con;
    }

    public void setFech_Con(String Fech_Con){
        this.Fech_Con = Fech_Con;
    }

    @Override
    public String toString(){
        return "Empleado{" + "Codigo=" + Codigo + ",Nombre=" + Nombre + ",Cargo=" + Cargo + ",Telefono=" + Telefono + ",Domicilio=" + Domicilio + ",Fech_Con=" + Fech_Con + "}";
    }
}
