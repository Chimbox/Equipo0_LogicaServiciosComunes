package datos;

import equipo0_dominio.Cita;
import equipo0_dominio.Expediente;
import equipo0_dominio.Paciente;
import equipo0_dominio.TrabajadorSalud;
import java.util.List;


/**
 *
 * @author Alfonso Felix
 */
public interface IDatos {
    public boolean autenticarPaciente(String username, String password);
    public Paciente obtenerDatosPaciente(String username);
    public boolean actualizarTokenFirebasePaciente(String username, String tokenFirebase);
    public boolean autenticarTrabSalud(String username, String password);
    public String obtenerTokenFirebase(String username);
    public Cita obtenerCita(int idCita);
    public List<Cita> obtenerCitas(int idTrabSalud);
    public TrabajadorSalud obtenerDatosTrabSalud(String username);
    public Expediente obtenerExpediente(int idPaciente);
    public void apruebaExpedienteCita(int idCita);
}
