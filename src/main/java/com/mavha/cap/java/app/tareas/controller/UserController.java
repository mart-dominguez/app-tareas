/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import com.mavha.cap.java.app.tareas.dao.UsuarioDao;
import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author martdominguez
 */

@ViewScoped
@Named("userController")
public class UserController implements Serializable{
    @Inject UsuarioDao userDao;
    
    private List<Usuario> usuarios;
    
    private Usuario usuarioEditar;
    
    private GrupoUsuario grupoAsignar; 

    @PostConstruct
    public void inicializar(){
        usuarios = userDao.listarUsuarios();
    }
    
    public String cancelar(){
        usuarioEditar = null;
        return null;
    }
    
    public String nuevoUsuario(){
        usuarioEditar = new Usuario();
       // usuarioEditar.setGrupo(new GrupoUsuario());
        return null;
    }
    
    public String crearUsuario(){
        System.out.println(" A VER SI GUARDA .. "+usuarioEditar.toString());
        usuarioEditar = userDao.crear(usuarioEditar);
        usuarios.add(usuarioEditar);
        usuarioEditar=null;
        return null;
    }

  

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuario getUsuarioEditar() {
        return usuarioEditar;
    }

    public void setUsuarioEditar(Usuario usuariosEditar) {
        this.usuarioEditar = usuariosEditar;
    }

    public GrupoUsuario getGrupoAsignar() {
        return grupoAsignar;
    }

    public void setGrupoAsignar(GrupoUsuario grupoAsignar) {
        this.grupoAsignar = grupoAsignar;
    }

    
    
    
}
