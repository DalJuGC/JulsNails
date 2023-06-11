package modelo;

import java.io.Serializable;

public class Promocion implements Serializable {
    private int codigo;
    private String nombre;
    private Float precio;
    private Boolean vigencia;

    public Promocion(){

    }

    //Constructor
    public Promocion(int codigo, String nombre, Float precio, Boolean vigencia){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    public Promocion(String nombre) {
        this.nombre = nombre;
    }

    //Getters y Setter
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo( int codigo){
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

    public Boolean getVigencia(){
        return vigencia;
    }

    public void setVigencia(Boolean vigencia){
        this.vigencia = vigencia;
    }
}