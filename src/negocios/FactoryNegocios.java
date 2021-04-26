/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

/**
 *
 * @author Alfonso Felix
 */
public class FactoryNegocios {
    private static INegocios fachada;
    
    public static INegocios getFachada(){
        if(fachada==null){
            fachada=new FNegocios();
        }
        return fachada;
    }
}
