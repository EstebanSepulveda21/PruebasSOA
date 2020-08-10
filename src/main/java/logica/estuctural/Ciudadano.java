/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.estuctural;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Richard
 */
public class Ciudadano {
   
    
    String nombre;
    String apellido;
    String direccion;
    Date fechaNacimiento;
    String cedula;
    Set<Antecedente> antecedentes;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String apellido, String direccion, Date fechaNacimiento, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        antecedentes = new HashSet<Antecedente>();
    }
    
    public Ciudadano(String nombre, String apellido, String direccion, String fechaNacimiento, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        setFechaNacimiento(fechaNacimiento);
        this.cedula = cedula;
        antecedentes = new HashSet<Antecedente>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public Set<Antecedente> getAntecedentes() {
        return antecedentes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = java.sql.Date.valueOf(fechaNacimiento);
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setAntecedentes(Set<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }
    
    public boolean addAntecedente(Antecedente antecedente)
    {
        try {
            antecedentes.add(antecedente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deleteAllAntecedentes()
    {
        antecedentes = new HashSet<Antecedente>();
    }
    
    public boolean tieneAntecedente()
    {
       return !antecedentes.isEmpty();
    }
    
    public boolean equals(Object objeto)
    {
        if(objeto==null)
            return false;
        Ciudadano ciudadano = (Ciudadano)objeto;
        if(this.getCedula().equals(ciudadano.getCedula()))
            return true;
        else
            return false;
    }
    
    public int hashCode(){
        return this.getCedula().hashCode();
    }
}
