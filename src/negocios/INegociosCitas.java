/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import equipo0_dominio.Cita;
import equipo0_dominio.SolicitudExpediente;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
public interface INegociosCitas {
    public String enviarNotificacionPaciente(SolicitudExpediente solicitud);
    public List<Cita> obtenerCitas(int idTrabSalud);
    public boolean consultaAprobacionExpediente(int idCita);
    public void aprobarExpedienteCita(int idCita);
}
