package modelo;

import java.io.Serializable;

public class Cliente implements Serializable{
    private int Codigo;
    private String Nombre;
    private String Telefono;

    public Cliente(){
    }
    
    public Cliente(int Codigo, String Nombre, String Telefono){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
    }

    public Cliente(int codigo) {
        this.Codigo = Codigo;
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

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString(){
        return "Cliente{" + "Codigo=" + Codigo + ",Nombre=" + Nombre + ",Telefono=" + Telefono + "}";
    }
}