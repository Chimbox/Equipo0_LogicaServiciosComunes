/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import java.util.Date;

/**
 *
 * @author Alfonso Felix
 */
class FNegocios implements INegocios{

    private static CtrlNotificaciones ctrlNotificaciones;

    private static CtrlNotificaciones getCtrlNotificaciones() {
        if(ctrlNotificaciones==null){
            ctrlNotificaciones=new CtrlNotificaciones();
        }
        return ctrlNotificaciones;
    }
    
    @Override
    public String enviarNotificacionPaciente(String token, int idCita, String nombreSolicitante, Date fecha) {
        return getCtrlNotificaciones().enviarNotificacionPaciente(token, idCita, nombreSolicitante, fecha);
    }
    
}
