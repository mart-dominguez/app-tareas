/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.dao.util.DevDB;
import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martdominguez
 */
@Stateless
public class UsuarioDaoJPA implements UsuarioDao {

    //PersistenceContext(unitName = "tareasPU")
    @Inject @DevDB
    EntityManager em;

    @Override
    public Usuario crear(Usuario u) {
        em.persist(u);
        em.flush();
        em.refresh(u);
        return u;
    }

    @Override
    public GrupoUsuario crear(GrupoUsuario u) {
        em.persist(u);
        em.flush();
        em.refresh(u);
        return u;
    }

    @Override
    public Usuario actualizar(Usuario usr) {
        return em.merge(usr);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        this.em.remove(this.em.find(Usuario.class, id));
    }

    @Override
    public void eliminarGrupo(Integer id) {
        this.em.remove(this.em.find(GrupoUsuario.class, id));
    }

    @Override
    public Usuario buscarUsuario(Integer id) {
        return this.em.find(Usuario.class, id)  ;  
    }

    @Override
    public GrupoUsuario buscarGrupo(Integer id) {
        return this.em.find(GrupoUsuario.class, id);
    }

    @Override
    public void asignar(Integer idUsr, Integer idGrupo) {
        Usuario u = this.buscarUsuario(idUsr);
        GrupoUsuario gu = this.buscarGrupo(idGrupo);
        if(u!=null & gu!=null){
            u.setGrupo(gu);
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return em.createQuery("SELECT u FROM Usuario u").getResultList();
    }

    @Override
    public List<GrupoUsuario> listarGrupos() {
        return em.createQuery("SELECT gu FROM GrupoUsuario gu").getResultList();
    }

    @Override
    public Usuario buscarUsuario(String nombre, String clave) {
        Usuario usr = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.clave = :P_CLAVE AND u.mail=:P_MAIL ")
                .setParameter("P_MAIL", nombre)
                .setParameter("P_CLAVE", clave)
                .getSingleResult();
        return usr;
    }

    @Override
    public List<Tarea> tareasPendientes(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
