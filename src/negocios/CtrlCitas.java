/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.IDatos;
import equipo0_dominio.Cita;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
class CtrlCitas {

    private final IDatos datos;

    public CtrlCitas(IDatos datos) {
        this.datos = datos;
    }

    public List<Cita> obtenerCitasProximas(int idTrabSalud) {
        return datos.obtenerCitas(idTrabSalud);
    }
    
    public boolean obtenerAprobacionExpediente(int idCita){
        return datos.obtenerCita(idCita).isExpedienteAprobado();
    }
    
    public void aprobarExpedienteCita(int idCita){
        datos.apruebaExpedienteCita(idCita);
    }
}
