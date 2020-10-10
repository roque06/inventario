/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Date;

/**
 *
 * @author roque
 */
public class feliminar {
    
    private int id ;
    
    private Date fecha;
    
    private String cantidad;
    private String modelo;

    public feliminar() {
    }

    public feliminar(int id, Date fecha, String cantidad, String modelo) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    
    
    
}
