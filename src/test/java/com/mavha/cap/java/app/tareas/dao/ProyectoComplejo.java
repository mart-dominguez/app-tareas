/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import org.mockito.ArgumentMatcher;

/**
 *
 * @author mdominguez
 */
public class ProyectoComplejo implements ArgumentMatcher<Proyecto> {

    @Override
    public boolean matches(Proyecto p) {
        return p.getHorasPresupuestadas() > 100 || p.getCosto() > 2000.0;
    }
}
