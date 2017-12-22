/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.util;

import com.mavha.cap.java.app.tareas.modelo.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author martdominguez
 */
@FacesConverter("usrConverter")
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Usuario obj = new Usuario();
        Integer id = Integer.valueOf(value);
        obj.setIdUsuario(id);
        return obj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value==null) return null;
        else return ((Usuario)value).getIdUsuario().toString();
    }
    
    
    
}
