package Http.Controller.Consgine;


import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.MyConsigneDBUtil;
import Entities.Consigne;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ConsigneMedicalStaffRequestScopedController implements Serializable {

    @EJB
    MyConsigneDBUtil myConsigneDBUtil;

    @EJB
    ConsigneDBUtil consigneDBUtil;

    private List<Consigne> myConsignes;

    private List<Consigne> filteredmyConsignes ;


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


    public List<Consigne> getMyConsignes() {
        myConsignes = myConsigneDBUtil.loadConsigneList();
        return myConsignes;
    }

    public void setMyConsignes(List<Consigne> myConsignes) {
        this.myConsignes = myConsignes;
    }

    public List<Consigne> getFilteredmyConsignes() {
        return filteredmyConsignes;
    }

    public void setFilteredmyConsignes(List<Consigne> filteredmyConsignes) {
        this.filteredmyConsignes = filteredmyConsignes;
    }
}
