package Http.Controller.Report;


import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.OperationDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import DBUtil.MedicalStaff.ReportDBUtil;
import Entities.Consigne;
import Entities.Operation;
import Entities.Patient;
import Entities.Rapport;
import Handler.PropertiesHandler;
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
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReportMedicalStaffViewScopedController implements Serializable {

    @EJB
    ReportDBUtil reportDBUtil;

    @EJB
    OperationDBUtil operationDBUtil;

    List<Operation> operations;


    private int operationSelectedId;


    private Rapport newRapport;

    private Rapport selectedRapport;

    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        operations = operationDBUtil.loadMyOperationList();

        newRapport = reportDBUtil.createFakeRapport();

    }



    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (reportDBUtil.updateRapport(selectedRapport))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void create() {

        newRapport.setIdRapport(0);

        for (Operation operation : operations) {
            if (operation.getIdOperation() == operationSelectedId) {
                newRapport.setOperation(operation);
            }
        }

        newRapport.setDateRapport(new Date());

        if (reportDBUtil.createRapport(newRapport))
            showInfo(successMsg);
        else
            showError(failMsg);

    }

    public void delete() {
        if (reportDBUtil.deleteRapport(selectedRapport))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Rapport getSelectedRapport() {
        return selectedRapport;
    }

    public void setSelectedRapport(Rapport selectedRapport) {
        this.selectedRapport = selectedRapport;
    }

    public int getOperationSelectedId() {
        return operationSelectedId;
    }

    public void setOperationSelectedId(int operationSelectedId) {
        this.operationSelectedId = operationSelectedId;
    }

    public Rapport getNewRapport() {
        return newRapport;
    }

    public void setNewRapport(Rapport newRapport) {
        this.newRapport = newRapport;
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
            newRapport.setAttachement(bytes);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Téléchargement réussi", event.getFile().getFileName() + " is uploaded."));
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public StreamedContent getAttachment(String assurace_number, String creation_date, byte[] attachment){
        InputStream stream = new ByteArrayInputStream(attachment);
        return new DefaultStreamedContent(stream,"application/pdf","La fiche medical : "+creation_date
                +"Id patient : "+assurace_number+".pdf");
    }



}
