/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.FactoryDatos;
import datos.IDatos;
import equipo0_dominio.Cita;
import equipo0_dominio.SolicitudExpediente;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
class FNegociosCitas implements INegociosCitas {
    
    private static CtrlNotificacion ctrlNotificacion;
    private static CtrlCitas ctrlCitas;
    private static IDatos datos;
    
    private static IDatos getDatos() {
        if (datos == null) {
            datos = FactoryDatos.getFachada();
        }
        return datos;
    }
    
    public static CtrlCitas getCtrlCitas() {
        if (ctrlCitas == null) {
            ctrlCitas = new CtrlCitas(getDatos());
        }
        return ctrlCitas;
    }
    
    public static CtrlNotificacion getCtrlNotificacion() {
        
        if (ctrlNotificacion == null) {
            ctrlNotificacion = new CtrlNotificacion(getDatos());
        }
        
        return ctrlNotificacion;
    }
    
    @Override
    public String enviarNotificacionPaciente(SolicitudExpediente solicitud) {
        return getCtrlNotificacion().enviarNotificacionPaciente(solicitud);
    }
    
    @Override
    public List<Cita> obtenerCitas(int idTrabSalud) {
        return getCtrlCitas().obtenerCitasProximas(idTrabSalud);
    }
    
    @Override
    public boolean consultaAprobacionExpediente(int idCita) {
        return getCtrlCitas().obtenerAprobacionExpediente(idCita);
    }
    
    @Override
    public void aprobarExpedienteCita(int idCita) {
        getCtrlCitas().aprobarExpedienteCita(idCita);
    }
}
