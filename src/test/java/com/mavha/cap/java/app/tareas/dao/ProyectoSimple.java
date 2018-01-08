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
public class ProyectoSimple extends ProyectoComplejo{

    @Override
    public boolean matches(Proyecto p) {
        return !super.matches(p);
    }
}
