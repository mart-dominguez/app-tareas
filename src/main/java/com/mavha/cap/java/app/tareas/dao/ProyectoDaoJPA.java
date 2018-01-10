/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.dao.util.DevDB;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author mdominguez
 */
@Stateless
public class ProyectoDaoJPA implements ProyectoDao {

    //PersistenceContext(unitName = "tareasPU")
    @Inject @DevDB
    EntityManager em;

    @Override
    public Proyecto crear(Proyecto p) {
        this.em.persist(p);
        this.em.flush();
        this.em.refresh(p);
        return p;
    }

    @Override
    public Proyecto actualizar(Proyecto p) {
        return em.merge(p);
    }

    @Override
    public void borrar(Integer idP) {
        em.remove(em.find(Proyecto.class, idP));
    }

    @Override
    public Proyecto buscar(Integer idP) {
        return em.find(Proyecto.class, idP);
    }

    @Override
    public List<Proyecto> buscarTodos() {
        return em.createQuery("SELECT p FROM Proyecto p ").getResultList();
    }

    @Override
    public void asignarTarea(Proyecto p, Tarea t) {
        System.out.println(p);
        System.out.println(t);
        Proyecto aux = em.find(Proyecto.class,p.getIdProyecto());
        t.setProyecto(aux);
        em.persist(t);
    }    

    @Override
    public Double presupuestoConsumido(Proyecto p) {
        String sql = "SELECT SUM(t.duracionHoras * t.usuario.salarioHora) FROM Tarea t WHERE t.proyecto.idProyecto = :P_ID_PRY ";
        Number resultado = (Number) em.createQuery(sql).setParameter("P_ID_PRY", p.getIdProyecto()).getSingleResult();
        return resultado.doubleValue();
    }

    @Override
    public Integer horasConsumidas(Proyecto p) {
        String sql = "SELECT SUM(t.duracionHoras) FROM Tarea t WHERE t.proyecto.idProyecto = :P_ID_PRY ";
        Number resultado = (Number) em.createQuery(sql).setParameter("P_ID_PRY", p.getIdProyecto()).getSingleResult();
        return resultado.intValue();
    }
    
}
