package Http.Controller.MedicalStaff;


import DBUtil.Admin.MedicalStaffDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Medecin;
import Entities.Patient;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@RequestScoped
public class MedicalStaffRequestScopedController implements Serializable{


    @EJB
    MedicalStaffDBUtil medicalStaffDBUtil ;



    private List<Medecin> medecins ;
    private List<Medecin> filteredMedecins ;


    @PostConstruct
    public void init() {
        }


    public List<Medecin> getMedecins() {


        medecins =medicalStaffDBUtil.loadMedecinList();

        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    public List<Medecin> getFilteredMedecins() {
        return filteredMedecins;
    }

    public void setFilteredMedecins(List<Medecin> filteredMedecins) {
        this.filteredMedecins = filteredMedecins;
    }
}
