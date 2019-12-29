package Http.Controller.Consgine;


import DBUtil.Admin.ConsigneDBUtil;
import Entities.Consigne;
import Entities.DossierMedical;
import Entities.Patient;
import Enumeration.EtatDossierMedical;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@RequestScoped
public class ConsigneAdministrationRequestScopedController implements Serializable {

    @EJB
    ConsigneDBUtil consigneDBUtil;

    private List<Consigne> consignes;

    private List<Consigne> filteredConsignes ;

//    private List<String> medicalFileStates;




    @PostConstruct
    public void init(){



//        String[] medicalFileStatesData = new String[3];
//        medicalFileStatesData[0] = EtatDossierMedical.ENCOURS.toString();
//        medicalFileStatesData[1] = EtatDossierMedical.ENATTENTE.toString();
//        medicalFileStatesData[2] = EtatDossierMedical.FERME.toString();
//        medicalFileStates= Arrays.asList(medicalFileStatesData);


    }

    public List<Consigne> getConsignes() {
        consignes = consigneDBUtil.loadConsigneList();

        return consignes;
    }

    public void setConsignes(List<Consigne> consignes) {
        this.consignes = consignes;
    }

    public List<Consigne> getFilteredConsignes() {
        return filteredConsignes;
    }

    public void setFilteredConsignes(List<Consigne> filteredConsignes) {
        this.filteredConsignes = filteredConsignes;
    }
}
