/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.util;

import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author martdominguez
 */
@FacesConverter("grpUsrConverter")
public class GrupoUsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        GrupoUsuario grupo = new GrupoUsuario();
        grupo.setIdGrupoUsuario(Integer.valueOf(value));
        System.out.println(" retorno "+value);
        return grupo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value==null) return null;
        return ((GrupoUsuario) value).getIdGrupoUsuario().toString();
    }
    
}
