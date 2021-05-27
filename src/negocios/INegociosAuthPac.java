package negocios;

import equipo0_dominio.Paciente;
import java.util.Date;

/**
 *
 * @author Alfonso Felix
 */
public interface INegociosAuthPac {
    public String iniciarSesion(String username, String password);
    public boolean validarAutenticacion(String token);
    public Paciente obtenerDatosPaciente(String username);
    public boolean actualizarTokenFirebase(String username, String tokenFirebase);
    
    
}
