/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao.integracion;

import com.mavha.cap.java.app.tareas.service.GestionUsuariosService;
import com.mavha.cap.java.app.tareas.service.GestionUsuariosServiceDefault;
import javax.inject.Inject;
import static org.hamcrest.Matchers.empty;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterTester {
    
    @Inject GestionUsuariosService usuariosSrv;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(GestionUsuariosService.class)
                .addClass(GestionUsuariosServiceDefault.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void should_create_greeting() {
        Boolean esValido = usuariosSrv.usuarioValido("martin@mail.com", "ABC123xyz");
        assertTrue(esValido);
        //assertThat(usuariosSrv.getMotivos(), empty());
    }
}
