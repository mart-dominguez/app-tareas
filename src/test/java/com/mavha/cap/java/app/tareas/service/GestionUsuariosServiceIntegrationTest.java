/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import com.mavha.cap.java.app.tareas.service.GestionUsuariosService;
import com.mavha.cap.java.app.tareas.service.GestionUsuariosServiceDefault;
import com.mavha.cap.java.app.tareas.service.MotivosError;
import java.io.File;
import javax.inject.Inject;
import static org.hamcrest.Matchers.empty;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GestionUsuariosServiceIntegrationTest {
    
    @Inject GestionUsuariosService usuariosSrv;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                //.addPackages(true,"com.mavha.cap.java.app.tareas.util","com.mavha.cap.java.app.tareas.service","com.mavha.cap.java.app.tareas.modelo","com.mavha.cap.java.app.tareas.dao.util","com.mavha.cap.java.app.tareas.dao","com.mavha.cap.java.app.tareas.controller")
                .addPackages(true,"com.mavha.cap.java.app.tareas.modelo")
                .addClasses(GestionUsuariosService.class,GestionUsuariosServiceDefault.class,MotivosError.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
     
      /*return ShrinkWrap.create(ZipImporter.class, "app-tareas.war").importFrom(new File("target/app-tareas-1.0-SNAPSHOT.war"))
            .as(WebArchive.class);*/
    }

    @Test
    public void should_create_greeting() {
        Boolean esValido = usuariosSrv.usuarioValido("martin@mail.com", "ABC123xyz");
        assertTrue(esValido);
        //assertThat(usuariosSrv.getMotivos(), empty());
    }
}
