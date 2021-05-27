package negocios;

import datos.FactoryDatos;
import datos.IDatos;
import equipo0_dominio.Paciente;

/**
 *
 * @author Alfonso Felix
 */
class FNegociosAuthPac implements INegociosAuthPac {

    private static IDatos datos;
    private static CtrlPaciente ctrlAuthPaciente;

    public static CtrlPaciente getCtrlAuthPaciente() {
        if (ctrlAuthPaciente == null) {
            ctrlAuthPaciente = new CtrlPaciente(getDatos());
        }
        return ctrlAuthPaciente;
    }

    private static IDatos getDatos() {
        if (datos == null) {
            datos = FactoryDatos.getFachada();
        }
        return datos;
    }

    @Override
    public String iniciarSesion(String username, String password) {
        return getCtrlAuthPaciente().autenticarPaciente(username, password);
    }

    @Override
    public Paciente obtenerDatosPaciente(String username) {
        return getCtrlAuthPaciente().obtenerDatosPaciente(username);
    }

    @Override
    public boolean validarAutenticacion(String token) {
        return getCtrlAuthPaciente().validarAutenticacion(token);
    }

    @Override
    public boolean actualizarTokenFirebase(String username, String tokenFirebase) {
        return getCtrlAuthPaciente().actualizarTokenFirebasePaciente(username, tokenFirebase);
    }
}
