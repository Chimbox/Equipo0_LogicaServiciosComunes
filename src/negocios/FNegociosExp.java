/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.FactoryDatos;
import datos.IDatos;
import equipo0_dominio.Expediente;

/**
 *
 * @author Alfonso Felix
 */
class FNegociosExp implements INegociosExp{

    private static IDatos datos;
    private static CtrlExpedientes ctrlExp;

    private static IDatos getDatos() {
        if (datos == null) {
            datos = FactoryDatos.getFachada();
        }
        return datos;
    }
    
    private static CtrlExpedientes getCtrlExp(){
        if(ctrlExp==null){
            ctrlExp=new CtrlExpedientes(getDatos());
        }
        return ctrlExp;
    }
    
    @Override
    public Expediente consultarExpediente(int idPaciente) {
        return getCtrlExp().obtenerExpediente(idPaciente);
    }
}
