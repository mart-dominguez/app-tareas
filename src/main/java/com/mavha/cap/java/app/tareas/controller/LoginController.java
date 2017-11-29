/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author martdominguez
 */
@SessionScoped
@Named("loginCtrl")
public class LoginController implements Serializable{
    private String correoUsuario;
    private String claveUsuario;

    public String doLogin(){
        if(correoUsuario.length()>5 && claveUsuario.equalsIgnoreCase("1234")) return "inicio.xhtml";
        return null;
    }
    
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
    
    
}
