/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.PistlerDAO;
import entity.Pistler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Burak
 */
@FacesConverter(value = "pistConverter")
public class PistlerConverter implements Converter{
    PistlerDAO pistDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return getPistDAO().idBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Pistler pist = (Pistler)arg2;
        return String.valueOf(pist.getPist_id());
    }

    public PistlerDAO getPistDAO() {
        if (pistDAO == null) {
            pistDAO = new PistlerDAO();
        }
        return pistDAO;
    }

    public void setPistDAO(PistlerDAO pistDAO) {
        this.pistDAO = pistDAO;
    }
    
    
    
}
