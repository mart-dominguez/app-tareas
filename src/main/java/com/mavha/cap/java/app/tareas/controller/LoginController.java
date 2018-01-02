/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import com.mavha.cap.java.app.tareas.dao.UsuarioDao;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
    
    private Usuario usuarioLogueado;
    @Inject UsuarioDao userDao;

    public String doLogin(){
      //  if(correoUsuario.length()>5 && claveUsuario.equalsIgnoreCase("1234")) return "inicio.xhtml";
      try{
          usuarioLogueado= userDao.buscarUsuario(correoUsuario, claveUsuario);
          return "inicio.xhtml";
      }  catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(claveUsuario, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o clave incorrectos!", "Verificar los datos."));
      }
      return null;
    }
    
    public String doLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml";
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
