package modelo;

import java.io.Serializable;

public class Tratamiento implements Serializable {
    private int codigo;
    private String nombre;
    private Float precio;
    private int cod_empleado;

    public Tratamiento(){
    }

    //Constructor
    public Tratamiento(int codigo, String nombre, Float precio, int cod_empleado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cod_empleado = cod_empleado;
    }

    public Tratamiento(String nombre, Float precio, int cod_empleado){
        this.nombre = nombre;
        this.precio = precio;
        this.cod_empleado = cod_empleado;
    }

    public Tratamiento(int codigo){
        this.codigo = codigo;
    }

    public Tratamiento(String nombre) {
        this.nombre = nombre;
    }

    //Getter y Setters
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

    public Float getPrecio(){
        return precio;
    }

    public void setPrecio(Float precio){
        this.precio = precio;
    }

    public int getCod_empleado(){
        return cod_empleado;
    }

    public void setCod_empleado(int cod_empleado){
        this.cod_empleado = cod_empleado;
    }
}