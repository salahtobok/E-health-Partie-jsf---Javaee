package Http.Controller.MedicalFile;


import DBUtil.MedicalStaff.MedicalFileDBUtil;
import Entities.DossierMedical;
import Entities.FicheMedical;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class MedicalFileViewScopedController implements Serializable {

    @EJB
    MedicalFileDBUtil medicalFileMedicalStaffDBUtil;


    private FicheMedical newFicheMedical;


    @PostConstruct
    public void init() {

        newFicheMedical = medicalFileMedicalStaffDBUtil.createFakeMedicalFile();
    }


    public FicheMedical getNewFicheMedical() {
        return newFicheMedical;
    }

    public void setNewFicheMedical(FicheMedical newFicheMedical) {
        this.newFicheMedical = newFicheMedical;
    }


    public void createMedicalFile(DossierMedical selectedDossierMedical) {
        System.out.println("Don " + selectedDossierMedical.getIdDossierMedical());

        newFicheMedical.setIdFicheMedical(0);
        newFicheMedical.setDossierMedical(selectedDossierMedical);
        if (medicalFileMedicalStaffDBUtil.createMedicalFile(newFicheMedical))
            showInfo("Created");
        else
            showError("Error de creation ");
    }


    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void handleFileUpload(FileUploadEvent event) throws Exception {
        try {
            InputStream inputstream;
            byte[] bytes = IOUtils.toByteArray(event.getFile().getInputstream());
            newFicheMedical.setAttachement(bytes);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Téléchargement réussi", event.getFile().getFileName() + " is uploaded."));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public StreamedContent getAttachment(String assurace_number,String creation_date,byte[] attachment){
        InputStream stream = new ByteArrayInputStream(attachment);
        return new DefaultStreamedContent(stream,"application/pdf","La fiche medical : "+creation_date
        +"Id patient : "+assurace_number+".pdf");
    }

}
