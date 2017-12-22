/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author martdominguez
 */
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyecto;

    @Column(name="HORAS_PRESUPUESTADAS")
    private Integer horasPresupuestadas;
    private Double costo;
    @OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas;    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_LIDER")
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

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", horasPresupuestadas=" + horasPresupuestadas + ", costo=" + costo + ", lider=" + lider + '}';
    }
    

    
    
}
