package Converter;


import Enumeration.EtatCompte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("etatCompteConverter")
public class EtatCompteConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {


        System.out.println("Enooo " +o.toString());

        if (o == null)
            return "";

        return String.valueOf(((EtatCompte)o).toString());

    }
}
