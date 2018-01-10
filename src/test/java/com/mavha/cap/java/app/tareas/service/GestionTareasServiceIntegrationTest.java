/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.service;

import com.mavha.cap.java.app.tareas.dao.ProyectoDao;
import com.mavha.cap.java.app.tareas.dao.UsuarioDao;
import com.mavha.cap.java.app.tareas.dao.util.DevDB;
import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import com.mavha.cap.java.app.tareas.modelo.Usuario;
import com.mavha.cap.java.app.tareas.service.GestionUsuariosService;
import com.mavha.cap.java.app.tareas.service.GestionUsuariosServiceDefault;
import com.mavha.cap.java.app.tareas.service.MotivosError;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
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
public class GestionTareasServiceIntegrationTest {
    
    @Inject GestionTareasService tareasSrv;

    @Inject ProyectoDao proyectoDao;
    
    @Inject UsuarioDao usuarioDao;

    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                //.addPackages(true,"com.mavha.cap.java.app.tareas.util","com.mavha.cap.java.app.tareas.service","com.mavha.cap.java.app.tareas.modelo","com.mavha.cap.java.app.tareas.dao.util","com.mavha.cap.java.app.tareas.dao","com.mavha.cap.java.app.tareas.controller")
                .addPackages(true,"com.mavha.cap.java.app.tareas.modelo","com.mavha.cap.java.app.tareas.dao")
                .addClasses(GestionTareasService.class,GestionTareasServiceDefault.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
     
      /*return ShrinkWrap.create(ZipImporter.class, "app-tareas.war").importFrom(new File("target/app-tareas-1.0-SNAPSHOT.war"))
            .as(WebArchive.class);*/
    }
    
    
    @Test
    public void addTarea(){
        Usuario u = usuarioDao.buscarUsuario(1);
        Proyecto p = proyectoDao.buscar(1);
        Tarea t1 = new Tarea();
        t1.setDescripcion("TAREA test");
        t1.setTitulo("DO ALGO");
        t1.setDuracionHoras(10);
        t1.setUsuario(u);        
        
        List<Tarea> pendientes = usuarioDao.tareasPendientes(u);
        assertThat("Tiene menos de 3 pendientes", pendientes.size(), lessThan(4));
        
        Double presupConsumido = proyectoDao.presupuestoConsumido(p);
        assertThat("Hay presupuesto", presupConsumido, is(0.0));

        Integer hsConsumidas = proyectoDao.horasConsumidas(p);
        assertThat("Hay horas", hsConsumidas, is(0));
        
        Integer tareas = p.getTareas().size();
        tareasSrv.agregarTarea(p, t1);
       
        Proyecto proyectoConNuevaTarea = proyectoDao.buscar(1);
        assertThat("Tarea nueva agregada", proyectoConNuevaTarea.getTareas().size(), is(tareas+1));
    }

}
