/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import equipo0_dominio.TrabajadorSalud;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
public class TrabSaludRep extends BaseRepository{
    
    public TrabSaludRep(EntityManager em, Class cls) {
        super(em, cls);
    }
    
    public boolean autenticarTrabSalud(String username, String password) {
        try {
            em.createNativeQuery(String.format("SELECT id FROM trabajadorsalud p WHERE p.username='%s' AND p.password='%s'", username, password)).getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public TrabajadorSalud obtenerDatosTrabajadorSalud(String username) {
        try {
            List<TrabajadorSalud> lst = em.createNativeQuery(String.format("SELECT id, cedula, lugartrabajo, nombre, primerapellido, segundoapellido FROM trabajadorsalud p WHERE p.username='%s'", username), TrabajadorSalud.class).getResultList();
            return lst.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
