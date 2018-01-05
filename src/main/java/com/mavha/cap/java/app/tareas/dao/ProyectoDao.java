/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.dao;

import com.mavha.cap.java.app.tareas.modelo.Proyecto;
import com.mavha.cap.java.app.tareas.modelo.Tarea;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface ProyectoDao {
   public Proyecto crear(Proyecto p); 

   public Proyecto actualizar(Proyecto p); 
   public void borrar(Integer idP);
   public Proyecto buscar(Integer idP); 
   public List<Proyecto> buscarTodos(); 
   public void asignarTarea(Proyecto p,Tarea t);
   public Double presupuestoConsumido(Proyecto p);
   public Integer horasConsumidas(Proyecto p);
}
