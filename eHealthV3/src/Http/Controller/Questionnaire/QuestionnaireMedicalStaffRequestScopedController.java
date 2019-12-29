package Http.Controller.Questionnaire;


import DAO.Local.IQuestionDAOLocal;
import DAO.Local.IQuestionnaireDAOLocal;
import DBUtil.MedicalStaff.QuestionnaireDBUtil;
import Entities.Questionnaire;
import Entities.Questionnaire;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class QuestionnaireMedicalStaffRequestScopedController implements Serializable {


    @EJB
    QuestionnaireDBUtil questionnaireDBUtil ;



    @EJB
    IQuestionnaireDAOLocal iQuestionnaireDAOLocal ;



    private List<Questionnaire> questionnaires;

    private List<Questionnaire> filteredQuestionnaire ;

//    private List<String> medicalFileStates;




    @PostConstruct
    public void init(){



//        String[] medicalFileStatesData = new String[3];
//        medicalFileStatesData[0] = EtatDossierMedical.ENCOURS.toString();
//        medicalFileStatesData[1] = EtatDossierMedical.ENATTENTE.toString();
//        medicalFileStatesData[2] = EtatDossierMedical.FERME.toString();
//        medicalFileStates= Arrays.asList(medicalFileStatesData);


    }


    public List<Questionnaire> getQuestionnaires() {

        int medcineId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();
        questionnaires = iQuestionnaireDAOLocal.myQuestionnaire(medcineId);

        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Questionnaire> getFilteredQuestionnaire() {
        return filteredQuestionnaire;
    }

    public void setFilteredQuestionnaire(List<Questionnaire> filteredQuestionnaire) {
        this.filteredQuestionnaire = filteredQuestionnaire;
    }
}
