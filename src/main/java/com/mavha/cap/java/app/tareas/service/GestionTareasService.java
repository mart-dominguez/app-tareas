/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mdominguez
 */

@RequestScoped
public interface GestionTareasService {
    
    /**
     * Una tarea se puede agregar a un  proyecto si y solo si:
     * - la cantidad de horas de la tarea es menor que las horas restantes del proyecto.
     * - el costo de la tarea ( cantidad de horas * salario hora del usuario asignado) es menor que el presupuesto restante del proyecto
     * - el empleado es desarrollador
     * - el empleado no tiene más de 3 tareas sin terminar 
     * @param p
     * @param t 
     */
    public void agregarTarea(Proyecto p, Tarea t);
}
