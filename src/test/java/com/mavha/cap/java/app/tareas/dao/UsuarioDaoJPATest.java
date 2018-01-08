/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author mdominguez
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioDaoJPATest {
   
    @Mock EntityManager em;
    
    @InjectMocks UsuarioDaoJPA daoJpa;
   
    public UsuarioDaoJPATest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAsignarUsuarioGrupo(){
        Usuario usr = Mockito.mock(Usuario.class);
        GrupoUsuario  gu = new GrupoUsuario();
        when(em.find(Usuario.class, 2)).thenReturn(usr);  
        when(em.find(GrupoUsuario.class, 4)).thenReturn(gu);          
        daoJpa.asignar(2, 4);
        verify(usr,atLeastOnce()).setGrupo(gu);
    }
}
