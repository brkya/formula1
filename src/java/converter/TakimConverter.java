/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.TakimlarDAO;
import entity.Takimlar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Burak
 */
@FacesConverter(value = "takimConverter")
public class TakimConverter implements Converter{
    TakimlarDAO takimDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return getTakimDAO().idBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Takimlar takim = (Takimlar)arg2;
        return String.valueOf(takim.getTakim_id());
    }

    public TakimlarDAO getTakimDAO() {
        if (takimDAO == null) {
            takimDAO = new TakimlarDAO();
        }
        return takimDAO;
    }

    public void setTakimDAO(TakimlarDAO takimDAO) {
        this.takimDAO = takimDAO;
    }
    
    
    
}
