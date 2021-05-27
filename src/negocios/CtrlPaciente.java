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
import equipo0_dominio.Expediente;
import equipo0_dominio.Paciente;
import java.util.Date;

/**
 *
 * @author Alfonso Felix
 */
class CtrlPaciente {

    private final IDatos datos;

    public CtrlPaciente(IDatos datos) {
        this.datos=datos;
    }

    public String autenticarPaciente(String username, String password){
        if(datos.autenticarPaciente(username, password)){
            return crearToken(username);
        }else{
            return null;
        }
    }
    
    public Paciente obtenerDatosPaciente(String username){
        return datos.obtenerDatosPaciente(username);
    }
    
    public boolean validarAutenticacion(String token){
        return verificarToken(token);
    }
    
    public String obtenerTokenFirebase(String username){
        return datos.obtenerTokenFirebase(username);
    }
    
    public boolean actualizarTokenFirebasePaciente(String username, String tokenFirebase){
        return datos.actualizarTokenFirebasePaciente(username, tokenFirebase);
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
