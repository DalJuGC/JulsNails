package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int codigo;
    private String nombre;
    private String telefono;
    private String domicilio;

    public Cliente() {

    }

    //Constructor
    public Cliente(int codigo, String nombre, String telefono, String domicilio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getDomicilio(){
        return domicilio;
    }

    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
}