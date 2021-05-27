/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import equipo0_dominio.Expediente;

/**
 *
 * @author Alfonso Felix
 */
public interface INegociosExp {
    public Expediente consultarExpediente(int idPaciente);
}
