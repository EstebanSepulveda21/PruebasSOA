/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.estuctural;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Richard
 */
public class Antecedente {
    private String tipoDeCrimen;
    private String detalles;
    private Date fechaDelito;
    private String ciudad;

    public Antecedente() {
    }

    public Antecedente(String tipoDeCrimen, String detalles, Date fechaDelito, String ciudad) {
        this.tipoDeCrimen = tipoDeCrimen;
        this.detalles = detalles;
        this.fechaDelito = fechaDelito;
        this.ciudad = ciudad;
    }
    
    public String getTipoDeCrimen() {
        return tipoDeCrimen;
    }

    public String getDetalles() {
        return detalles;
    }

    public Date getFechaDelito() {
        return fechaDelito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setTipoDeCrimen(String tipoDeCrimen) {
        this.tipoDeCrimen = tipoDeCrimen;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setFechaDelito(Date fechaDelito) {
        this.fechaDelito = fechaDelito;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
