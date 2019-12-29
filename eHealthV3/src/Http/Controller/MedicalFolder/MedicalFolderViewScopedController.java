package Http.Controller.MedicalFolder;


import DBUtil.MedicalStaff.MedicalFolderDBUtil;
import Entities.DossierMedical;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MedicalFolderViewScopedController implements Serializable {

    @EJB
    MedicalFolderDBUtil medicalFolderDoctorDBUtil;


    private DossierMedical selectedDossierMedical;





    public DossierMedical getSelectedDossierMedical() {
        return selectedDossierMedical;
    }

    public void setSelectedDossierMedical(DossierMedical selectedDossierMedical) {
        this.selectedDossierMedical = selectedDossierMedical;
    }




    public void update(DossierMedical dossierMedical) {
        this.selectedDossierMedical = dossierMedical;
//        showInfo("Updated :"+selectedPatient.getIdPatient());
//        if (MedicalFolderDBUtil.updatePatient(selectedPatient))
        showInfo("Updated");
//        else
//            showError("Error de mise a jour ");
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
