/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import com.mavha.cap.java.app.tareas.dao.ProyectoDao;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mdominguez
 */
@Named("tareaCtrl")
@ViewScoped
public class TareaController implements Serializable{

    private Tarea tarea;
    private Proyecto proyecto;
    
    @Inject
    ListaProyectoController listaProy;

    @Inject
    ProyectoDao pryDao;

    @PostConstruct
    public void init() {
        this.tarea = new Tarea();
        System.out.println(" PROYECTO "+listaProy.getProyectoSeleccionado());
        this.proyecto = listaProy.getProyectoSeleccionado();
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String asignar() {
        pryDao.asignarTarea(this.proyecto, tarea);
        return null;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}
