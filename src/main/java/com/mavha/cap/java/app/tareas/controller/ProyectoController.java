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

    public ProyectoController() {
        System.out.println(" NUEVO PROYECTO CONTROLLER");
    }
    
    
 
    private Proyecto proyecto;  
    
    @Inject ProyectoDao proyectoDao;
    
    public String nuevo(){
        this.proyecto = new  Proyecto();
        this.proyecto.setCosto(0.0);
        this.proyecto.setHorasPresupuestadas(1);
        return null;
    }
    
    
     public String cancelar(){
         proyecto = null;
         return null;
     }
    
    public String guardar(){
        System.out.println(this.proyecto.toString());
        if(this.proyecto.getIdProyecto()!=null && this.proyecto.getIdProyecto()>0)        this.proyectoDao.crear(proyecto);
        else this.proyectoDao.actualizar(proyecto);
        proyecto = null;
        return "/listaProyectos.xhtml";
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    
}
