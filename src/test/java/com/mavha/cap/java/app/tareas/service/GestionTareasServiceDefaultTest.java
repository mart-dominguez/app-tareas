/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import com.mavha.cap.java.app.tareas.dao.ProyectoDao;
import com.mavha.cap.java.app.tareas.dao.ProyectoDaoJPA;
import com.mavha.cap.java.app.tareas.dao.TareaDao;
import com.mavha.cap.java.app.tareas.dao.TareaDaoJPA;
import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
/**
 *
 * @author mdominguez
 */

import org.mockito.junit.MockitoJUnitRunner; 
@RunWith(MockitoJUnitRunner.class)
public class GestionTareasServiceDefaultTest {
    
    @Mock TareaDaoJPA tareaDao;
    @Mock ProyectoDaoJPA proyectoDao;
    @Mock ArrayList<Tarea> pendientes;

  
    @InjectMocks
    private  GestionTareasServiceDefault classUnderTest;
    Proyecto p;
    Tarea t;
    Usuario user;

    public GestionTareasServiceDefaultTest() {
        
    }
    
    @Before
    public void setUp() {
        p = new Proyecto();
        t = new Tarea();
        user = new Usuario();
        GrupoUsuario gu = new GrupoUsuario();
        user.setGrupo(gu);
        t.setUsuario(user);
        
        Mockito.doNothing().when(proyectoDao).asignarTarea(p, t);
        
        p.setCosto(1000.0);
        p.setHorasPresupuestadas(100);
        
        user.setSalarioHora(20.0);
        t.setDuracionHoras(10);
        user.getGrupo().setIdGrupoUsuario(3);

        when(pendientes.size()).thenReturn(3);
        when(tareaDao.tareasPendientes(t.getUsuario())).thenReturn(pendientes);
        when(proyectoDao.presupuestoConsumido(p)).thenReturn(790.0);
        when(proyectoDao.horasConsumidas(p)).thenReturn(89);

    }
    
    @After
    public void tearDown() {
        p = null;
        t = null;
        user = null;
        GrupoUsuario gu = null;
    }

    /**
     * Test of agregarTarea method, of class GestionTareasServiceDefault.
     */
    @Test
    public void testAgregarTarea() {
        classUnderTest.agregarTarea(p, t);
        verify(proyectoDao).asignarTarea(p, t);
    }
    
    @Test
    public void testAgregarTareaSiNoHayPresupuesto() {
        user.setSalarioHora(21.5);
        classUnderTest.agregarTarea(p, t);
        verify(proyectoDao,never()).asignarTarea(p, t);
    }

    @Test
    public void testAgregarTareaSiNoHayTiempo() {
        t.setDuracionHoras(20);
        // salario...
        classUnderTest.agregarTarea(p, t);
        verify(proyectoDao,never()).asignarTarea(p, t);
    }

    @Test
    public void testAgregarTareaSiNoEsDeveloper() {
        t.getUsuario().getGrupo().setIdGrupoUsuario(99);
        classUnderTest.agregarTarea(p, t);
        verify(proyectoDao,never()).asignarTarea(p, t);
    }

    
    @Test
    public void testAgregarTareaSiMuchasTareasAbiertas() {
        when(pendientes.size()).thenReturn(4);
        classUnderTest.agregarTarea(p, t);
        verify(proyectoDao,never()).asignarTarea(p, t);
    }

}
