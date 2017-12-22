/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import com.mavha.cap.java.app.tareas.dao.ProyectoDao;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mdominguez
 */
@ViewScoped
@Named("listaProyectoController")
public class ListaProyectoController implements Serializable{
    private List<Proyecto> proyectos;
    
    private Proyecto proyectoSeleccionado;

    public ListaProyectoController() {
        System.out.println(" NUEVO LISTA ! ! ! ! PROYECTO CONTROLLER");
    }
    
    
    @Inject ProyectoDao dao;
    
    @PostConstruct
    public void init(){
        this.proyectos = dao.buscarTodos();
        
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }
    
    
    
}
