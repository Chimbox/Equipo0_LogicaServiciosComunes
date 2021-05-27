package negocios;

import equipo0_dominio.Paciente;
import equipo0_dominio.TrabajadorSalud;
import java.util.Date;

/**
 *
 * @author Alfonso Felix
 */
public interface INegociosAuthTrabSalud {
    public String iniciarSesion(String username, String password);
    public boolean validarAutenticacion(String token);
    public TrabajadorSalud obtenerDatosTrabSalud(String username);
    
}
