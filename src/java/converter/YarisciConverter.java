/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.YariscilarDAO;
import entity.Yariscilar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Burak
 */
@FacesConverter(value = "yarisciConverter")
public class YarisciConverter implements Converter {

    YariscilarDAO yarisciDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getYarisciDAO().idBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Yariscilar yarisci =(Yariscilar)arg2;
        return String.valueOf(yarisci.getYarisci_id());
    }

    public YariscilarDAO getYarisciDAO() {
        if (yarisciDAO == null) {
            this.yarisciDAO = new YariscilarDAO();
        }
        return yarisciDAO;
    }

    public void setYarisciDAO(YariscilarDAO yarisciDAO) {
        this.yarisciDAO = yarisciDAO;
    }

}
