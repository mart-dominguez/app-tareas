/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.mockito.internal.matchers.Contains;

/**
 *
 * @author mdominguez
 */
public class GestionUsuariosServiceDefaultTest {
    
    private GestionUsuariosServiceDefault usuariosSrv;
    public GestionUsuariosServiceDefaultTest() {
    }
    
    @Before
    public void setUp() {
        usuariosSrv = new GestionUsuariosServiceDefault();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of usuarioValido method, of class GestionUsuariosServiceDefault.
     */
    @Test
    public void testUsuarioValido() {
        Boolean esValido = usuariosSrv.usuarioValido("martin@mail.com", "ABC123xyz");
        assertTrue(esValido);
        assertThat(usuariosSrv.getMotivos(), empty());
    }

    @Test
    public void testUsuarioNoValidoFaltaNro() {
        Boolean esValido = usuariosSrv.usuarioValido("martin@mail.com", "ABCxyzHyUb");
        assertFalse(esValido);
        assertThat(usuariosSrv.getMotivos(), contains(MotivosError.PASSWORD_SIN_NROS));
    }
    
    @Test
    public void testUsuarioNoValidoClaveCorta() {
        Boolean esValido = usuariosSrv.usuarioValido("martin@mail.com", "ab12FG");
        assertFalse(esValido);
        assertThat(usuariosSrv.getMotivos(), contains(MotivosError.PASSWORD_MUY_CORTA));
    }
    
    @Test
    public void testUsuarioNoValidoClaveSinMinuscula() {
        Boolean esValido = usuariosSrv.usuarioValido("martin@mail.com", "AABBCC12FG");
        assertFalse(esValido);
        MotivosError motivo = usuariosSrv.getMotivos().get(0);
        assertThat(motivo.toString(),startsWith("PASSWORD"));
    }
}
