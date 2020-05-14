/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.TakimKoclariDAO;
import entity.TakimKoclari;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Burak
 */
@FacesConverter(value = "kocConverter")
public class TakimKoclariConverter implements Converter{

    private TakimKoclariDAO kocDAO;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getKocDAO().idBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        TakimKoclari koc = (TakimKoclari)arg2;
        return String.valueOf(koc.getKoc_id());
    }

    public TakimKoclariDAO getKocDAO() {
        if (kocDAO == null) {
            this.kocDAO = new TakimKoclariDAO();
        }
        return kocDAO;
    }

    public void setKocDAO(TakimKoclariDAO kocDAO) {
        this.kocDAO = kocDAO;
    }
    
    
    
}
