/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cap.java.app.tareas.util;

import com.mavha.cap.java.app.tareas.modelo.GrupoUsuario;
import java.util.HashMap;
import java.util.Map;
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

    private Map<Integer,GrupoUsuario> grupos;
    
    public GrupoUsuarioConverter(){
        System.out.println(" CONSTRUCTOR CONVERTER ");
        this.grupos = new HashMap<>();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        GrupoUsuario grupo = null;
        Integer idGrupo = Integer.valueOf(value);
        grupo = this.grupos.get(idGrupo) ;
        if(grupo==null) {
            grupo = new GrupoUsuario();
            grupo.setIdGrupoUsuario(idGrupo);
        }
        
        
        System.out.println(" retorno "+grupo.toString());
        return grupo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println(" retorno as string "+value);
        GrupoUsuario gu = null;
        if (value==null) return null;
        else{
            gu = (GrupoUsuario) value;
            if(!grupos.containsKey(gu.getIdGrupoUsuario())) grupos.put(gu.getIdGrupoUsuario(), gu);
        }
        return gu.getIdGrupoUsuario().toString();
    }
    
    
    
}
