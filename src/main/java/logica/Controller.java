/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import gui.Cambiable;
import logica.estuctural.Ciudadano;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import logica.estuctural.Antecedente;
import logica.estuctural.Ciudadano.TipoDocumento;
import persistencia.PersistenciaFake;

/**
 *
 * @author Richard
 */
public class Controller {

    private Ciudadano ultimoCiudadano;
    private ArrayList<Cambiable> ventanaEstado;


    public Controller(){
        ventanaEstado = new ArrayList<Cambiable>();
    }

    public void registrarVentaniUwU(Cambiable gui){ventanaEstado.add(gui);}

    public Ciudadano getUltimoCiudadano(){return ultimoCiudadano;}

    public void setUltimoCiudadano(Ciudadano ciudadano){
        this.ultimoCiudadano = ciudadano;
        cambioEstado();
    }

    private void cambioEstado() {
        for(Cambiable gui: ventanaEstado){
            gui.cambio();
        }
    }

    public void datosPrueba()
    {
        setUltimoCiudadano(null);
        PersistenciaFake.datosPrueba();
        cambioEstado();
    }
    
    public void eliminarCiudadano(String cedula, TipoDocumento tipoDocumento)
    {
        Ciudadano persona = PersistenciaFake.getCiudadanoPorCedula(cedula, tipoDocumento);
        ultimoCiudadano = persona;
        PersistenciaFake.deleteCiudadano(persona);
        cambioEstado();
    }
    
    public void agregarCiudadano(String nombre, String apellido, String direccion, Date fecha, String cedula, TipoDocumento tipoDocumento)
    {
        Ciudadano ciudadano = new Ciudadano(nombre, apellido, direccion, fecha, cedula, tipoDocumento);
        ultimoCiudadano=ciudadano;
        PersistenciaFake.addCiudadano(ciudadano);
        cambioEstado();
    }
    
    public Ciudadano darCiudadanoPorCedula(String cedula, TipoDocumento tipoDocumento)
    {
        Ciudadano resultado = PersistenciaFake.getCiudadanoPorCedula(cedula, tipoDocumento);
        if(resultado != null) {
            ultimoCiudadano = resultado;
            cambioEstado();
        }
        return resultado;
    }
    
    public Set<Ciudadano> darCiudadanos()
    {
        return PersistenciaFake.getCiudadanos();
    }
    
    public void actualizarCiudadano(String nombre, String apellido, String direccion, Date fecha, String cedula, TipoDocumento tipoDocumento)throws Exception
    {
        Ciudadano antiguo = darCiudadanoPorCedula(cedula, tipoDocumento);
        if(antiguo != null)
        {
            Ciudadano nuevo = new Ciudadano(nombre, apellido, direccion, fecha, cedula, tipoDocumento);
            PersistenciaFake.updateCiudadano(antiguo, nuevo);
            ultimoCiudadano = nuevo;
            cambioEstado();
        }
        else
        {
            throw new Exception("El ciudadano a actualizar no existe.");
        }
    }
    
    public void aniadirAntecedenteCiudadano(Antecedente ant, String cedula, TipoDocumento tipoDocumento){
        Ciudadano ciudadano = darCiudadanoPorCedula(cedula, tipoDocumento);
        ciudadano.addAntecedente(ant);
        cambioEstado();
    }
    
    public Antecedente darPrimerAntecedente(String cedula, TipoDocumento tipoDocumento){
        
        Ciudadano ciudadano = darCiudadanoPorCedula(cedula, tipoDocumento);
        if(ciudadano != null){
            if(!ciudadano.getAntecedentes().isEmpty())
            for(Antecedente ant : ciudadano.getAntecedentes()){
                return ant;
            }
            else{
                return null;
            }
        }  
        else{
            return null;
        }
        return null;
    }
}
