package modelo;
import java.io.Serializable;

public class Tratamiento implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Nombre;
    private String Precio;

    public Tratamiento(){
    }

    //Borrar
    public Tratamiento(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Tratamiento(String Nombre, String Precio){
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    //Modificar
    public Tratamiento(int Codigo, String Nombre, String Precio){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = String.valueOf(Nombre);
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
}