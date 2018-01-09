/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import java.util.List;

/**
 *
 * @author martdominguez
 */
public interface UsuarioDao {
    public Usuario crear(Usuario u);
    public GrupoUsuario crear(GrupoUsuario u);
    public Usuario actualizar(Usuario  id);
    public void eliminarUsuario(Integer  id);
    public void eliminarGrupo(Integer  id);
    
    public Usuario buscarUsuario(Integer  id);
    public GrupoUsuario buscarGrupo(Integer  id);
    
    public void asignar(Integer user,Integer grupo);

    public List<Usuario> listarUsuarios();
    public List<GrupoUsuario> listarGrupos();
    public Usuario buscarUsuario(String nombre, String clave);
    public List<Tarea> tareasPendientes(Usuario u);

    
}
