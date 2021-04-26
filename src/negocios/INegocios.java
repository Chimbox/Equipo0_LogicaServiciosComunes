package negocios;

import java.util.Date;

/**
 *
 * @author Alfonso Felix
 */
public interface INegocios {
    public String enviarNotificacionPaciente(String token, int idCita, String nombreSolicitante, Date fecha);
}
