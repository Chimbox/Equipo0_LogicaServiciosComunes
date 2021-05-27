/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import datos.IDatos;
import equipo0_dominio.Cita;
import equipo0_dominio.Paciente;
import equipo0_dominio.TrabajadorSalud;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
class CtrlTrabSalud {

    private IDatos datos;

    public CtrlTrabSalud(IDatos datos) {
        this.datos=datos;
    }

    public String autenticarTrabSalud(String username, String password){
        if(datos.autenticarTrabSalud(username, password)){
            return crearToken(username);
        }else{
            return null;
        }
    }
    
    public TrabajadorSalud obtenerDatosTrabSalud(String username){
        return datos.obtenerDatosTrabSalud(username);
    }
   
    
    public boolean validarAutenticacion(String token){
        return verificarToken(token);
    }
    
    
    private String crearToken(String user) {
        String token = null;
        try {
            Algorithm algoritmo = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("usuario", user)
                    .sign(algoritmo);
            return token;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return token;
    }
    
    private boolean verificarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0").build();

            DecodedJWT jwt = verifier.verify(token);

            return true;
        } catch (JWTVerificationException ex) {

            return false;

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
}
