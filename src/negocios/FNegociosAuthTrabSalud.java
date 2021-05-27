package negocios;

import datos.FactoryDatos;
import datos.IDatos;
import equipo0_dominio.TrabajadorSalud;

/**
 *
 * @author Alfonso Felix
 */
class FNegociosAuthTrabSalud implements INegociosAuthTrabSalud {

    private static IDatos datos;
    private static CtrlTrabSalud ctrlTrabSalud;

    public static CtrlTrabSalud getCtrlTrabSalud() {
        if (ctrlTrabSalud == null) {
            ctrlTrabSalud = new CtrlTrabSalud(getDatos());
        }
        return ctrlTrabSalud;
    }

    private static IDatos getDatos() {
        if (datos == null) {
            datos = FactoryDatos.getFachada();
        }
        return datos;
    }

    @Override
    public String iniciarSesion(String username, String password) {
        return getCtrlTrabSalud().autenticarTrabSalud(username, password);
    }

    @Override
    public TrabajadorSalud obtenerDatosTrabSalud(String username) {
        return getCtrlTrabSalud().obtenerDatosTrabSalud(username);
    }

    @Override
    public boolean validarAutenticacion(String token) {
        return getCtrlTrabSalud().validarAutenticacion(token);
    }
}