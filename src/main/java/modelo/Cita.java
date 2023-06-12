package modelo;

import java.io.Serializable;
import java.sql.*;

public class Cita implements Serializable {
    private int codigo;
    private int cod_cliente;
    private Date fecha;
    private Time horario;
    private int cod_tratamiento;
    private int cod_promocion;
    private Boolean cancelar;


    //Constructor
    public Cita(int codigo, int cod_cliente, Date fecha, Time horario, int cod_tratamiento, int cod_promocion, Boolean cancelar){
        this.codigo = codigo;
        this.cod_cliente = cod_cliente;
        this.fecha = fecha;
        this.horario = horario;
        this.cod_tratamiento = cod_tratamiento;
        this.cod_promocion = cod_promocion;
        this.cancelar = cancelar;
    }

    public Cita(int codigo, Date fecha, Time horario, Boolean cancelar){
        this.codigo = codigo;
        this.fecha = fecha;
        this.horario = horario;
        this.cancelar = cancelar;
    }

    public Cita(int cod_cliente, Date fecha, Time horario, int cod_tratamiento, int cod_promocion){
        this.cod_cliente = cod_cliente;
        this.fecha = fecha;
        this.horario = horario;
        this.cod_tratamiento = cod_tratamiento;
        this.cod_promocion = cod_promocion;
    }

    //Getters y Setters
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCod_cliente(){
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente){
        this.cod_cliente = cod_cliente;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Time getHorario(){
        return horario;
    }

    public void setHorario(Time horario){
        this.horario = horario;
    }

    public int getCod_tratamiento(){
        return cod_tratamiento;
    }

    public void setCod_tratamiento(int cod_tratamiento){
        this.cod_tratamiento = cod_tratamiento;
    }

    public int getCod_promocion(){
        return cod_promocion;
    }

    public void setCod_promocion(int cod_promocion){
        this.cod_promocion = cod_promocion;
    }

    public Boolean getCancelar(){
        return cancelar;
    }

    public void setCancelar(Boolean cancelar){
        this.cancelar = cancelar;
    }
}