/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.controller;

import com.mavha.cap.java.app.tareas.dao.ProyectoDao;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author martdominguez
 */

@ViewScoped
@Named("proyectoController")
public class ProyectoController implements Serializable {
 
    private Proyecto proyecto;
    
    @Inject ProyectoDao proyectoDao;
    
    public String nuevo(){
        this.proyecto = new  Proyecto();
        return null;
    }
    
    public String guardar(){
        if(this.proyecto.getIdProyecto()>0)        this.proyectoDao.crear(proyecto);
        else this.proyectoDao.actualizar(proyecto);
        return "listaProyectos";
    }
}
