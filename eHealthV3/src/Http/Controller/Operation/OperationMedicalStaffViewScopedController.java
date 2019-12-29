package Http.Controller.Operation;


import DBUtil.Admin.ConsigneDBUtil;
import DBUtil.MedicalStaff.OperationDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.*;
import Entities.Embeddable.KeyOperation;
import Handler.PropertiesHandler;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class OperationMedicalStaffViewScopedController implements Serializable {

    @EJB
    OperationDBUtil operationDBUtil;

    @EJB
    PatientDBUtil patientDBUtil;

    private Operation newOperation;
    private List<Patient> patients ;

    private Operation selectedOperation;


    private String selectedPatientId;

    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        newOperation = operationDBUtil.createFakeOperation() ;

        patients = patientDBUtil.loadPatientList();
    }

    public Operation getSelectedOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(Operation selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

//    public void send() {
////        showInfo("Updated :"+selectedPatient.getIdPatient());
//        if (operationDBUtil.se(selectedConsigne))
//            showInfo(successMsg);
//        else
//            showError(failMsg);
//    }


    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (operationDBUtil.updateOperation(selectedOperation))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void create() {

        for (Patient patient : patients) {

            if (patient.getIdPatient() == Integer.valueOf(selectedPatientId)) {

                ComptePersonneMedical comptePersonneMedical = (ComptePersonneMedical) SessionUtils.getUserAccount();
                Service serviceMedicalStaff =  comptePersonneMedical.getMedecin().getService();
                Medecin medecin =  comptePersonneMedical.getMedecin();
                KeyOperation keyOperation = new KeyOperation();
                newOperation.setService(serviceMedicalStaff);
                newOperation.setMedecin(medecin);
                newOperation.setPatient(patient);
                keyOperation.setDateOperation(new Date());

                newOperation.setKeyOperation(keyOperation);

            }
        }

        newOperation.setLesConsignes(null);
        newOperation.setLesRapports(null);
        newOperation.setLesQuestionnaire(null);

        newOperation.setIdOperation(0);
        if (operationDBUtil.createOperation(newOperation))
            showInfo(successMsg);
        else
            showError(failMsg);

    }
    public void delete() {
        if (operationDBUtil.deleteOperation(selectedOperation))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public Operation getNewOperation() {
        return newOperation;
    }

    public void setNewOperation(Operation newOperation) {
        this.newOperation = newOperation;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public String getSelectedPatientId() {
        return selectedPatientId;
    }

    public void setSelectedPatientId(String selectedPatientId) {
        this.selectedPatientId = selectedPatientId;
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
