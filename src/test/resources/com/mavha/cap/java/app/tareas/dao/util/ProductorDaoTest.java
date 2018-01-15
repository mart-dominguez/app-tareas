/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped
@Alternative
public class ProductorDaoTest {
    @Produces 
    @PersistenceContext(unitName="tareasTestPU")
    @DevDB
    EntityManager devDB;
    

}
