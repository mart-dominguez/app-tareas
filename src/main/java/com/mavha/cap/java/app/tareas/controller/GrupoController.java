/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import com.mavha.cap.java.app.tareas.dao.UsuarioDao;
import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
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
@Named("grupoController")
public class GrupoController implements Serializable{
    
    @Inject UsuarioDao userDao;
    
    private List<GrupoUsuario> grupos;
    
    private GrupoUsuario gruposEditar;

    @PostConstruct
    public void inicializar(){
        grupos = userDao.listarGrupos();
    }
    
    public String cancelar(){
        gruposEditar = null;
        return null;
    }
    
    public String nuevoGrupo(){
        gruposEditar = new GrupoUsuario();
        return null;
    }
    
    public String crearGrupo(){
        gruposEditar = userDao.crear(gruposEditar);
        grupos.add(gruposEditar);
        gruposEditar=null;
        return null;
    }

  

    public List<GrupoUsuario> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<GrupoUsuario> usuarios) {
        this.grupos = usuarios;
    }
    
    public GrupoUsuario getGruposEditar() {
        return gruposEditar;
    }

    public void setGruposEditar(GrupoUsuario usuariosEditar) {
        this.gruposEditar = usuariosEditar;
    }

    
    
    
}
