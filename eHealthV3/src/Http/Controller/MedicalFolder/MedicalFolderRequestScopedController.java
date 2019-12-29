package Http.Controller.MedicalFolder;


import DBUtil.MedicalStaff.MedicalFolderDBUtil;
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
public class MedicalFolderRequestScopedController implements Serializable {

    @EJB
    MedicalFolderDBUtil medicalFolderDoctorDBUtil;

    private List<DossierMedical> dossierMedicals;

    private List<Patient> filteredDossierMedicals ;

    private List<String> medicalFileStates;




    @PostConstruct
    public void init(){



        String[] medicalFileStatesData = new String[3];
        medicalFileStatesData[0] = EtatDossierMedical.ENCOURS.toString();
        medicalFileStatesData[1] = EtatDossierMedical.ENATTENTE.toString();
        medicalFileStatesData[2] = EtatDossierMedical.FERME.toString();
        medicalFileStates= Arrays.asList(medicalFileStatesData);


    }

    public List<DossierMedical> getDossierMedicals() {
        dossierMedicals = medicalFolderDoctorDBUtil.loadDossierMedicals();
        return dossierMedicals;
    }

    public void setDossierMedicals(List<DossierMedical> dossierMedicals) {
        this.dossierMedicals = dossierMedicals;
    }


    public List<Patient> getFilteredDossierMedicals() {
        return filteredDossierMedicals;
    }

    public void setFilteredDossierMedicals(List<Patient> filteredDossierMedicals) {
        this.filteredDossierMedicals = filteredDossierMedicals;
    }


    public List<String> getMedicalFileStates() {
        return medicalFileStates;
    }

    public void setMedicalFileStates(List<String> medicalFileStates) {
        this.medicalFileStates = medicalFileStates;
    }
}
