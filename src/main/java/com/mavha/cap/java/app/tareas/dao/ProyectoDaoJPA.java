/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mdominguez
 */
@Stateless
public class ProyectoDaoJPA {
        @PersistenceContext(unitName = "tareasPU")
    EntityManager em;
}
