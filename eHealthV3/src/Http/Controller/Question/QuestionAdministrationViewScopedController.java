package Http.Controller.Question;


import DBUtil.Admin.QuestionDBUtil;
import DBUtil.MedicalStaff.PatientDBUtil;
import Entities.Question;
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
public class QuestionAdministrationViewScopedController implements Serializable {

    @EJB
    QuestionDBUtil QuestionDBUtil;

    private Question newQuestion;

    private Question selectedQuestion;

    private String successMsg = PropertiesHandler.getProperty(QuestionAdministrationViewScopedController.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(QuestionAdministrationViewScopedController.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        newQuestion = QuestionDBUtil.createFakeQuestion() ;
    }

    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Question selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }

    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (QuestionDBUtil.updateQuestion(selectedQuestion))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void create() {

            if (QuestionDBUtil.createQuestion(newQuestion))
            showInfo(successMsg);
        else
            showError(failMsg);

    }
    public void delete() {
        if (QuestionDBUtil.deleteQuestion(selectedQuestion))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public Question getNewQuestion() {
        return newQuestion;
    }

    public void setNewQuestion(Question newQuestion) {
        this.newQuestion = newQuestion;
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
