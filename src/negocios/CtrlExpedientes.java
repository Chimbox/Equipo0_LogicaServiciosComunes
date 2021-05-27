/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.IDatos;
import equipo0_dominio.Expediente;

/**
 *
 * @author Alfonso Felix
 */

class CtrlExpedientes {
    private final IDatos datos;

    public CtrlExpedientes(IDatos datos) {
        this.datos = datos;
    }
    
    public Expediente obtenerExpediente(int idPaciente){
        return datos.obtenerExpediente(idPaciente);
    }
}
