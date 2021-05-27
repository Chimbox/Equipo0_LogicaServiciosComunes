/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import equipo0_dominio.Cita;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class CitasRep extends BaseRepository<Cita>{
    
    public CitasRep(EntityManager em, Class cls) {
        super(em, cls);
    }
    
    public List<Cita> consultarCitasProximas(int idTrabSalud){
        return em.createNativeQuery(String.format("SELECT * FROM cita WHERE trabsalud_id=%d AND fecha>=now()", idTrabSalud), Cita.class).getResultList();
    }
    
    public void apruebaExpedienteCita(int idCita){
        System.out.println("aki");
        Cita cita=buscar(idCita);
        cita.setExpedienteAprobado(true);
        guardar(cita);
        System.out.println("se");
    }
}
