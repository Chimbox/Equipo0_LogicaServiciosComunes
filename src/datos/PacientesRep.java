/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import equipo0_dominio.Paciente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class PacientesRep extends BaseRepository {

    public PacientesRep(EntityManager em, Class cls) {
        super(em, cls);
    }

    public boolean autenticarPaciente(String username, String password) {
        try {
            em.createNativeQuery(String.format("SELECT id FROM paciente p WHERE p.username='%s' AND p.password='%s'", username, password)).getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Paciente obtenerDatosPaciente(String username) {
        try {
            List<Paciente> lst = em.createNativeQuery(String.format("SELECT id, curp, fechanacimiento, nombre, primerapellido, segundoapellido, sexo, tutor_id FROM paciente p WHERE p.username='%s'", username), Paciente.class).getResultList();
            return lst.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    public String obtenerTokenFirebase(String username){
        try{
            return obtenerDatosPaciente(username).getTokenFirebase();
        }catch(Exception e){
            
        }
        return null;
    }

    public boolean actualizarTokenFirebasePaciente(String username, String tokenFirebase) {
        try {
            super.ensureTransaction();
            boolean bandera = em.createNativeQuery(String.format("UPDATE paciente p SET p.tokenFirebase='%s' WHERE p.username='%s'", tokenFirebase, username)).executeUpdate() > 0;
            super.commit();
            return bandera;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
