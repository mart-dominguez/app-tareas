/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public class GestionUsuariosServiceDefault implements GestionUsuariosService {

    private List<MotivosError> motivos;
    
    public GestionUsuariosServiceDefault(){
        this.motivos = new ArrayList<>();
    }
    
    @Override
    public Boolean usuarioValido(String usuario, String clave) {
        if(clave!=null && clave.length()<8) motivos.add(MotivosError.PASSWORD_MUY_CORTA);                
        if(clave!=null && !this.tieneUnNro(clave)) motivos.add(MotivosError.PASSWORD_SIN_NROS);        
        if(clave!=null && !this.tieneUnaMayusucula(clave)) motivos.add(MotivosError.PASSWORD_SIN_MAYUSCULAS);        
        if(clave!=null && !this.tieneUnaMinuscula(clave)) motivos.add(MotivosError.PASSWORD_SIN_MINUSCULA);        
        if(usuario!=null && !usuario.contains("@")) motivos.add(MotivosError.MAIL_INVALIDO);        
        return motivos.isEmpty();
    }
    
    private Boolean tieneUnaMayusucula(String str){
        char[] caracteres = str.toCharArray();
        for(char unChar : caracteres){
            if(Character.isUpperCase(unChar)) return true;
        }
        return false;
    }
    
    private Boolean tieneUnaMinuscula(String str){
        char[] caracteres = str.toCharArray();
        for(char unChar : caracteres){
            if(Character.isLowerCase(unChar)) return true;
        }
        return false;
    }

    private Boolean tieneUnNro(String str){
        char[] caracteres = str.toCharArray();
        for(char unChar : caracteres){
            if(Character.isDigit(unChar) ) return true;
        }
        return false;
    }

    public List<MotivosError> getMotivos() {
        return motivos;
    }

    public void setMotivos(List<MotivosError> motivos) {
        this.motivos = motivos;
    }
 
    
}
