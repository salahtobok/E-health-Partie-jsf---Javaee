package Http.Controller.Patient;


import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Patient;
import Enumeration.EtatCompte;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@RequestScoped
public class PatientRequestScopedController implements Serializable{

    @EJB
    PatientDBUtil patientDBUtil ;

    private List<Patient> patients ;
    private List<Patient> filteredPatients ;


    @PostConstruct
    public void init() {
    }


    public List<Patient> getPatients() {
        patients =patientDBUtil.loadPatientList();

        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


    public List<Patient> getFilteredPatients() {
        return filteredPatients;
    }

    public void setFilteredPatients(List<Patient> filteredPatients) {
        this.filteredPatients = filteredPatients;
    }



}
