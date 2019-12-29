package Helper;


import Enumeration.EtatCompte;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EnumToTextHelper {


    public String getText(EtatCompte etatCompte){

        return etatCompte.toString();
    }

}
