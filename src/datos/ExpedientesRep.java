/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import equipo0_dominio.Cita;
import equipo0_dominio.Expediente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class ExpedientesRep extends BaseRepository<Expediente>{
    
    public ExpedientesRep(EntityManager em) {
        super(em, Expediente.class);
    }
    
    public Expediente consultarExpediente(int idPaciente){
        return (Expediente)em.createNativeQuery(String.format("SELECT * FROM expediente WHERE paciente_id=%d", idPaciente), Expediente.class).getSingleResult();
    }
}
