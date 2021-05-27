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
    private static INegociosAuthPac fachadaAuthPac;
    private static INegociosCitas fachadaCitas;
    private static INegociosAuthTrabSalud fachadaAuthTrabSalud;
    private static INegociosExp fachadaExp;
    
    public static INegociosAuthPac getFachadaAuthPac(){
        if(fachadaAuthPac==null){
            fachadaAuthPac=new FNegociosAuthPac();
        }
        return fachadaAuthPac;
    }
    
    public static INegociosCitas getFachadaCitas(){
        if(fachadaCitas==null){
            fachadaCitas=new FNegociosCitas();
        }
        return fachadaCitas;
    }

    public static INegociosAuthTrabSalud getFachadaAuthTrabSalud() {
        if(fachadaAuthTrabSalud==null){
            fachadaAuthTrabSalud=new FNegociosAuthTrabSalud();
        }
        return fachadaAuthTrabSalud;
    }
    
    public static INegociosExp getFachadaExpedientes(){
        if(fachadaExp==null){
            fachadaExp=new FNegociosExp();
        }
        return fachadaExp;
    }
}
