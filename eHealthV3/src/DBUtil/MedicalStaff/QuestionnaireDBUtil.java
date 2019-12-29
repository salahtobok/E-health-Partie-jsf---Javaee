package DBUtil.MedicalStaff;

import DAO.Local.IQuestionnaireDAOLocal;
import Entities.Questionnaire;
import SessionUtil.SessionUtils;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class QuestionnaireDBUtil {



    @EJB
    IQuestionnaireDAOLocal iQuestionnaireDAOLocal ;


    Faker faker = new Faker();

    public List<Questionnaire> loadQuestionnaireList() {


        try {

            System.out.println("HHHHHHHHHHHHHHHHHH");

            int medcineId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();
            List<Questionnaire> questionnaires= iQuestionnaireDAOLocal.myQuestionnaire(medcineId);

            System.out.println("HHHHHHHHHHHHHHHHHH"+questionnaires.size());

//            return iQuestionnaireDAOLocal.myQuestionnaire(medcineId);
            return questionnaires;

        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }






    //*Creation patien methods*//
    public boolean createQuestionnaire(Questionnaire questionnaire) {
        try {

            iQuestionnaireDAOLocal.create(questionnaire);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Questionnaire createFakeQuestionnaire() {


        try {

           return new Questionnaire();
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateQuestionnaire(Questionnaire selectedQuestionnaire) {
        try {


            iQuestionnaireDAOLocal.edit(selectedQuestionnaire);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteQuestionnaire(Questionnaire selectedQuestionnaire) {
        try {
            iQuestionnaireDAOLocal.remove(selectedQuestionnaire);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

//*Creation patien methods*//




}

