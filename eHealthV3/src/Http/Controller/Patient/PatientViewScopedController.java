package Http.Controller.Patient;


import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Patient;
import Handler.PropertiesHandler;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import java.io.Serializable;


@ManagedBean
@ViewScoped
public class PatientViewScopedController implements Serializable{

    @EJB
    PatientDBUtil patientDBUtil ;

    private Patient selectedPatient;

    private Patient newPatient;

    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");


    @PostConstruct
    public void init() {
        newPatient = patientDBUtil.createFakePatient() ;
    }



    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public Patient getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(Patient newPatient) {
        this.newPatient = newPatient;
    }


    public void create() {

        newPatient.setIdPatient(0);
        newPatient.getCompte().setIdCompte(0);
        newPatient.getDossierMedical().setIdDossierMedical(0);
        newPatient.setLesOperations(null);




        if (patientDBUtil.createPatient(newPatient))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (patientDBUtil.updatePatient(selectedPatient))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void delete() {
        if (patientDBUtil.deletePatient(selectedPatient))
            showInfo(successMsg);
        else
            showError(failMsg);
    }



    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
