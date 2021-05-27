/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Alfonso Felix
 */
public class NewClass {
    public static void main(String[] args){
        IDatos datos=FactoryDatos.getFachada();
        
        System.out.println(datos.autenticarPaciente("chimbox", "123"));
        
       // System.out.println(datos.obtenerDatosPaciente("chimbox").getNombre());
    }
}
