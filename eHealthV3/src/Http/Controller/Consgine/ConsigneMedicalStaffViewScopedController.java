package Http.Controller.Consgine;


import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.OperationDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Consigne;
import Entities.Operation;
import Entities.Patient;
import Entities.Service;
import Handler.PropertiesHandler;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ConsigneMedicalStaffViewScopedController implements Serializable {

    @EJB
    ConsigneDBUtil consigneDBUtil;

    @EJB
    PatientDBUtil patientDBUtil;

    @EJB
    OperationDBUtil operationDBUtil;

    List<Operation> operations;


    private int operationSelectedId;


    private Consigne newConsigne;
    private List<Patient> patients;

    private Consigne selectedConsigne;

    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        operations = operationDBUtil.loadMyOperationList();

        newConsigne = consigneDBUtil.createFakeConsigne();

        patients = patientDBUtil.loadPatientList();
    }

    public Consigne getSelectedConsigne() {
        return selectedConsigne;
    }

    public void setSelectedConsigne(Consigne selectedConsigne) {
        this.selectedConsigne = selectedConsigne;
    }


    public void send() {


        for (Operation operation : operations) {

            if (operation.getIdOperation() == operationSelectedId) {
                selectedConsigne.setOperation(operation);
            }
        }
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (consigneDBUtil.sendConsigne(selectedConsigne))
            showInfo(successMsg);
        else
            showError(failMsg);
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getOperationSelectedId() {
        return operationSelectedId;
    }

    public void setOperationSelectedId(int operationSelectedId) {
        this.operationSelectedId = operationSelectedId;
    }

    public Consigne getNewConsigne() {
        return newConsigne;
    }

    public void setNewConsigne(Consigne newConsigne) {
        this.newConsigne = newConsigne;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
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
