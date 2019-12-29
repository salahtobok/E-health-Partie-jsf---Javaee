package Http.Controller.Question;


import DAO.Local.IQuestionnaireDAOLocal;
import DBUtil.MedicalStaff.QuestioMSDBUtil;
import Entities.Question;
import Entities.Questionnaire;
import Handler.PropertiesHandler;
import SessionUtil.SessionUtils;

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
public class QuestionMedicalStaffViewScopedController implements Serializable {

    @EJB
    QuestioMSDBUtil questioMSDBUtil;



    @EJB
    IQuestionnaireDAOLocal iQuestionnaireDAOLocal;


    private Question newQuestion;

    private Question selectedQuestion;


    private List<Questionnaire> questionnaires;

    private int questionnaireSelectedId;
    private String successMsg = PropertiesHandler.getProperty(QuestionMedicalStaffViewScopedController.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(QuestionMedicalStaffViewScopedController.class, "messeges_fr.properties", "failure_update");

    @PostConstruct
    public void init() {
        newQuestion = questioMSDBUtil.createFakeQuestion() ;
    }

    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Question selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }


    public List<Questionnaire> getQuestionnaires() {
        int medcineId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();
        questionnaires = iQuestionnaireDAOLocal.myQuestionnaire(medcineId);
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public void send() {

        for (Questionnaire questionnaire : questionnaires) {

            if (questionnaire.getIdQuestionnaire() == questionnaireSelectedId) {
                selectedQuestion.setQuestionnaire(questionnaire);
            }
        }

//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (questioMSDBUtil.sendQuestion(selectedQuestion))
            showInfo(successMsg);
        else
            showError(failMsg);
    }
    public void update() {
//        showInfo("Updated :"+selectedPatient.getIdPatient());
        if (questioMSDBUtil.updateQuestion(selectedQuestion))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public int getQuestionnaireSelectedId() {
        return questionnaireSelectedId;
    }

    public void setQuestionnaireSelectedId(int questionnaireSelectedId) {
        this.questionnaireSelectedId = questionnaireSelectedId;
    }

    public void create() {

            if (questioMSDBUtil.createQuestion(newQuestion))
            showInfo(successMsg);
        else
            showError(failMsg);

    }
    public void delete() {
        if (questioMSDBUtil.deleteQuestion(selectedQuestion))
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
