/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martdominguez
 */
public class ProyectoDaoFake extends ProyectoDaoJPA{

    private List<Proyecto> lista;
    
    @Override
    public void asignarTarea(Proyecto p, Tarea t) {
        int indice =lista.indexOf(t);
        if( lista.get(indice).getTareas()==null) lista.get(indice).setTareas(new ArrayList<>());
        lista.get(indice).getTareas().add(t);
    }

    @Override
    public List<Proyecto> buscarTodos() {
        return lista;
    }

    @Override
    public Proyecto buscar(Integer idP) {
        Proyecto p = new Proyecto();
        p.setIdProyecto(idP);
        int indice =lista.indexOf(p);
        return lista.get(indice);
    }

    @Override
    public void borrar(Integer idP) {
        Proyecto p = new Proyecto();
        p.setIdProyecto(idP);
        lista.remove(p);

    }

    @Override
    public Proyecto actualizar(Proyecto p) {
        lista.remove(p);
        lista.add(p);
        return p;
    }

    @Override
    public Proyecto crear(Proyecto p) {
        lista.add(p);
        p.setIdProyecto(999);
        return p;
    }
    
}
