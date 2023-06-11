package modelo;

import java.io.Serializable;
import java.sql.*;

public class Empleado implements Serializable {
    private int codigo;
    private String nombre;
    private String cargo;
    private String telefono;
    private String domicilio;
    private Date fecha_contrato;

    public Empleado(String nombre){

    }

    //Constructor
    public Empleado(int codigo, String nombre, String cargo, String telefono, String domicilio, Date fecha_contrato){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargo = cargo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.fecha_contrato = fecha_contrato;
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

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
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

    public Date getFecha_contrato(){
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato){
        this.fecha_contrato = fecha_contrato;
    }
}