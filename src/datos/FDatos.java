package datos;

import equipo0_dominio.Cita;
import equipo0_dominio.Expediente;
import equipo0_dominio.Paciente;
import equipo0_dominio.TrabajadorSalud;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alfonso Felix
 */
class FDatos implements IDatos {

    private static EntityManager em;
    private static PacientesRep pacientesRep;
    private static TrabSaludRep trabSaludRep;
    private static CitasRep citasRep;
    private static ExpedientesRep expRep;

    /**
     * Método para obtener el entidad que conecta a la base de datos.
     *
     * @return Entidad manejadora de la base de datos.
     */
    private static EntityManager getEntityManager() {
        if (FDatos.em == null) {
            EntityManagerFactory managerFactory
                    = Persistence.createEntityManagerFactory("Equipo0_LogicaServiciosComunesPU");
            FDatos.em = managerFactory.createEntityManager();
        }
        return FDatos.em;
    }

    public static PacientesRep getPacientesRep() {
        if (pacientesRep == null) {
            pacientesRep = new PacientesRep(getEntityManager(), Paciente.class);
        }
        return pacientesRep;
    }

    public static TrabSaludRep getTrabSaludRep() {
        if (trabSaludRep == null) {
            trabSaludRep = new TrabSaludRep(getEntityManager(), TrabajadorSalud.class);
        }
        return trabSaludRep;
    }

    public static CitasRep getCitasRep() {
        if (citasRep == null) {
            citasRep = new CitasRep(getEntityManager(), Cita.class);
        }
        return citasRep;
    }

    public static ExpedientesRep getExpRep() {
        if (expRep == null) {
            expRep = new ExpedientesRep(getEntityManager());
        }
        return expRep;
    }

    public FDatos() {
        getEntityManager();
    }

    @Override
    public boolean autenticarPaciente(String username, String password) {
        return getPacientesRep().autenticarPaciente(username, password);
    }

    @Override
    public Paciente obtenerDatosPaciente(String username) {
        return getPacientesRep().obtenerDatosPaciente(username);
    }

    @Override
    public boolean actualizarTokenFirebasePaciente(String username, String tokenFirebase) {
        return getPacientesRep().actualizarTokenFirebasePaciente(username, tokenFirebase);
    }

    @Override
    public boolean autenticarTrabSalud(String username, String password) {
        return getTrabSaludRep().autenticarTrabSalud(username, password);
    }

    @Override
    public TrabajadorSalud obtenerDatosTrabSalud(String username) {
        return getTrabSaludRep().obtenerDatosTrabajadorSalud(username);
    }

    @Override
    public String obtenerTokenFirebase(String username) {
        return getPacientesRep().obtenerTokenFirebase(username);
    }

    @Override
    public Cita obtenerCita(int idCita) {
        return getCitasRep().buscar(idCita);
    }

    @Override
    public List<Cita> obtenerCitas(int idTrabSalud) {
        return getCitasRep().consultarCitasProximas(idTrabSalud);
    }

    @Override
    public Expediente obtenerExpediente(int idPaciente) {
        return getExpRep().consultarExpediente(idPaciente);
    }

    @Override
    public void apruebaExpedienteCita(int idCita) {
        getCitasRep().apruebaExpedienteCita(idCita);
    }

    
}
