package DBUtil.Admin;

import DAO.Local.IConsigneDAOLocal;
import DAO.Local.IQuestionDAOLocal;
import DAO.Local.IQuestionnaireDAOLocal;
import Entities.Consigne;
import Entities.Question;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class QuestionDBUtil {


    @EJB
    IQuestionDAOLocal iQuestionDAOLocal;



    Faker faker = new Faker();

    public List<Question> loadQuestionList() {


        try {

            return iQuestionDAOLocal.findAll();

        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }


//    public List<String> loadServiceNameList() {
//        try {
//            List<Service> services = loadServiceList();
//            List<String> serviceNameList= new ArrayList<String>();
//
//            for (Service service:services){
//                serviceNameList.add(service.getNom());
//            }
//            return serviceNameList;
//
//        } catch (Exception ex) {
//            System.out.println("Login error -->" + ex.getMessage());
//        } finally {
//        }
//        return null;
//    }






    //*Creation patien methods*//
    public boolean createQuestion(Question question) {
        try {

            iQuestionDAOLocal.create(question);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Question createFakeQuestion() {


        try {

           return new Question();
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateQuestion(Question selectedQuestion) {
        try {


            iQuestionDAOLocal.edit(selectedQuestion);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteQuestion(Question selectedQuestion) {
        try {
            iQuestionDAOLocal.remove(selectedQuestion);
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

