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
public class FactoryDatos {
    private static IDatos fachada;
    
    public static IDatos getFachada(){
        if(fachada==null){
            fachada=new FDatos();
        }
        return fachada;
    }
}
