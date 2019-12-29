package Http.Controller.Questionnaire;


import DBUtil.MedicalStaff.OperationDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import DBUtil.MedicalStaff.QuestionnaireDBUtil;
import Entities.Questionnaire;
import Entities.Operation;
import Entities.Patient;
import Handler.PropertiesHandler;

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
public class QuestionnaireMedicalStaffViewScopedController implements Serializable {

    @EJB
    QuestionnaireDBUtil questionnaireDBUtil;


    @EJB
    PatientDBUtil patientDBUtil;

    @EJB
    OperationDBUtil operationDBUtil;



    List<Operation> operations;




    private int operationSelectedId;




    private Questionnaire newQuestionnaire;


    private List<Patient> patients;



    private Questionnaire selectedQuestionnaire;

    private String successMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        operations = operationDBUtil.loadMyOperationList();

        newQuestionnaire = questionnaireDBUtil.createFakeQuestionnaire();

        patients = patientDBUtil.loadPatientList();
    }





    public void update() {


        for (Operation operation : operations) {

            if (operation.getIdOperation() == operationSelectedId) {
                selectedQuestionnaire.setOperation(operation);
            }
        }


        selectedQuestionnaire.setDateQuestionnaire(new Date());


//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (questionnaireDBUtil.updateQuestionnaire(selectedQuestionnaire))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void create() {
        for (Operation operation : operations) {

            if (operation.getIdOperation() == operationSelectedId) {
                newQuestionnaire.setOperation(operation);
            }
        }


        newQuestionnaire.setIdQuestionnaire(0);
        newQuestionnaire.setDateQuestionnaire(new Date());
        if (questionnaireDBUtil.createQuestionnaire(newQuestionnaire))
            showInfo(successMsg);
        else
            showError(failMsg);

    }

    public void delete() {
        if (questionnaireDBUtil.deleteQuestionnaire(selectedQuestionnaire))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public Questionnaire getSelectedQuestionnaire() {
        return selectedQuestionnaire;
    }

    public void setSelectedQuestionnaire(Questionnaire selectedQuestionnaire) {
        this.selectedQuestionnaire = selectedQuestionnaire;
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

    public Questionnaire getNewQuestionnaire() {
        return newQuestionnaire;
    }

    public void setNewQuestionnaire(Questionnaire newQuestionnaire) {
        this.newQuestionnaire = newQuestionnaire;
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
