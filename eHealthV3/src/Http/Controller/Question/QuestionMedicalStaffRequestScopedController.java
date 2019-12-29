package Http.Controller.Question;


import DAO.Local.IQuestionDAOLocal;
import DBUtil.Admin.QuestionDBUtil;
import Entities.Question;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class QuestionMedicalStaffRequestScopedController implements Serializable {

    @EJB
    QuestionDBUtil QuestionDBUtil;


    @EJB
    IQuestionDAOLocal iQuestionDAOLocal;

    private List<Question> Questions;

    private List<Question> filteredQuestions ;

//    private List<String> medicalFileStates;




    @PostConstruct
    public void init(){



//        String[] medicalFileStatesData = new String[3];
//        medicalFileStatesData[0] = EtatDossierMedical.ENCOURS.toString();
//        medicalFileStatesData[1] = EtatDossierMedical.ENATTENTE.toString();
//        medicalFileStatesData[2] = EtatDossierMedical.FERME.toString();
//        medicalFileStates= Arrays.asList(medicalFileStatesData);


    }

    public List<Question> getQuestions() {
        Questions = iQuestionDAOLocal.findAll();

        return Questions;
    }

    public void setQuestions(List<Question> Questions) {
        this.Questions = Questions;
    }

    public List<Question> getFilteredQuestions() {
        return filteredQuestions;
    }

    public void setFilteredQuestions(List<Question> filteredQuestions) {
        this.filteredQuestions = filteredQuestions;
    }
}
