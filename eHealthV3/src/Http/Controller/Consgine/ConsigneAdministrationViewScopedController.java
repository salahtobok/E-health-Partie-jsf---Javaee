package Http.Controller.Consgine;


import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.MedicalFolderDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Consigne;
import Entities.DossierMedical;
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
public class ConsigneAdministrationViewScopedController implements Serializable {

    @EJB
    ConsigneDBUtil consigneDBUtil;

    private Consigne newConsigne;

    private Consigne selectedConsigne;

    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        newConsigne = consigneDBUtil.createFakeConsigne() ;
    }

    public Consigne getSelectedConsigne() {
        return selectedConsigne;
    }

    public void setSelectedConsigne(Consigne selectedConsigne) {
        this.selectedConsigne = selectedConsigne;
    }

    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (consigneDBUtil.updateConsigne(selectedConsigne))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void create() {

        if (consigneDBUtil.createConsigne(newConsigne))
            showInfo(successMsg);
        else
            showError(failMsg);

    }
    public void delete() {
        if (consigneDBUtil.deleteConsigne(selectedConsigne))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public Consigne getNewConsigne() {
        return newConsigne;
    }

    public void setNewConsigne(Consigne newConsigne) {
        this.newConsigne = newConsigne;
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
