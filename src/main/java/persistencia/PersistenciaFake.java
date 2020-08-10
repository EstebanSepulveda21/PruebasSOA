/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import logica.estuctural.Antecedente;
import logica.estuctural.Ciudadano;
import logica.estuctural.Ciudadano.TipoDocumento;

/**
 *
 * @author Richard
 */
public class PersistenciaFake {
    private static Set<Ciudadano> ciudadanos = new HashSet<Ciudadano>();;

    public static Set<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }
    public static boolean addCiudadano(Ciudadano ciudadano){
        try {
            ciudadanos.add(ciudadano);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean deleteCiudadano(Ciudadano ciudadano)
    {
        try {
            ciudadanos.remove(ciudadano);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean updateCiudadano(Ciudadano antiguo,Ciudadano nuevo){
        try {
            antiguo.setNombre(nuevo.getNombre());
            antiguo.setApellido(nuevo.getApellido());
            antiguo.setDireccion(nuevo.getDireccion());
            antiguo.setFechaNacimiento(nuevo.getFechaNacimiento());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void datosPrueba()
    {
        Ciudadano ciudadano1 = new Ciudadano("Juan", "Perez", "Yuyaima", Date.valueOf("1998-01-17"), "1234567890", Ciudadano.TipoDocumento.CEDULA_DE_CIUDADANIA);
        Ciudadano ciudadano2 = new Ciudadano("Brayiam", "Marrulma Jr", "el Chamo Bozque", Date.valueOf("2000-01-17"), "1234458792", Ciudadano.TipoDocumento.CEDULA_EXTRANJERA);
        ciudadano2.addAntecedente(new Antecedente("Homicidio", "Fue grabado por 3 camaras del establecimiento", new java.util.Date(), "Imbamgu�"));
        ciudadanos.add(ciudadano1);
        ciudadanos.add(ciudadano2);
    }
    
    public static Ciudadano getCiudadanoPorCedula(String cedula, TipoDocumento tipoDocumento)
    {
        for(Ciudadano people : getCiudadanos()){
            if(people.getCedula().equals(cedula)&& tipoDocumento == people.getTipoDocumento() )
                return people;
        }
        return null;
    }
}
