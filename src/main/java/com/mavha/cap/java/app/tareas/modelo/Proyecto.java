/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.modelo;

import java.util.List;

/**
 *
 * @author martdominguez
 */
public class Proyecto {
    private Integer idProyecto;
    private Integer horasPresupuestadas;
    private Double costo;
    private List<Tarea> tareas;    
    private Usuario lider;
    
    

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getHorasPresupuestadas() {
        return horasPresupuestadas;
    }

    public void setHorasPresupuestadas(Integer horasPresupuestadas) {
        this.horasPresupuestadas = horasPresupuestadas;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Usuario getLider() {
        return lider;
    }

    public void setLider(Usuario lider) {
        this.lider = lider;
    }
    

    
    
}
