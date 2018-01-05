/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import com.mavha.cap.java.app.tareas.dao.ProyectoDao;
import com.mavha.cap.java.app.tareas.dao.TareaDao;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import javax.inject.Inject;

/**
 *
 * @author mdominguez
 */
public class GestionTareasServiceDefault implements GestionTareasService {

    @Inject
    TareaDao tareaDao;

    @Inject
    ProyectoDao proyectoDao;

    @Override
    public void agregarTarea(Proyecto p, Tarea t) {
        Double costoTarea = t.getUsuario().getSalarioHora() * t.getDuracionHoras();
        Integer duracionTarea = t.getDuracionHoras();
        Integer tareasSinTerminar = tareaDao.tareasPendientes(t.getUsuario()).size();

        // calcular tiempo restante
        Integer tiempoRestante = p.getHorasPresupuestadas() - proyectoDao.horasConsumidas(p);

        // calcular tiempo restante
        Double presupuestoRestante = p.getCosto() - proyectoDao.presupuestoConsumido(p);
        System.out.println(" horas "+tiempoRestante +" > "+ duracionTarea);
        //if (presupuestoRestante > costoTarea && tiempoRestante >duracionTarea  && t.getUsuario().getGrupo().getIdGrupoUsuario().equals(3) && tareasSinTerminar <= 3) {
        if (presupuestoRestante > costoTarea) {
            if (tiempoRestante > duracionTarea) {
                if (t.getUsuario().getGrupo().getIdGrupoUsuario().equals(3)) {
                    if (tareasSinTerminar <= 3) {
                        proyectoDao.asignarTarea(p, t);
                    } else {
                        System.out.println("Tiene tareas pendientes");
                    }
                } else {
                    System.out.println("NO ES DEVELOPER");
                }
            } else {
                System.out.println("No hay tiempp");
            }
        } else {
            System.out.println("No hay plata");
        }

    }

}
