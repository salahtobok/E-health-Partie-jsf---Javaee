package DBUtil.MedicalStaff;

import DAO.Local.IConsigneDAOLocal;
import DAO.Local.IOperationDAOLocal;
import Entities.Consigne;
import Entities.Operation;
import SessionUtil.SessionUtils;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class OperationDBUtil {


    @EJB
    IOperationDAOLocal iOperationDAOLocal;


    Faker faker = new Faker();

    public List<Operation> loadOperationList() {


        try {

            return iOperationDAOLocal.findAll();

        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }


    public List<Operation> loadMyOperationList() {


        try {


            int userId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();

            return iOperationDAOLocal.myOperations(userId);

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
    public boolean createOperation(Operation operation) {
        try {

            iOperationDAOLocal.create(operation);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Operation createFakeOperation() {


        try {



            return new Operation();
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateOperation(Operation selectedOperation) {
        try {


            iOperationDAOLocal.edit(selectedOperation);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteOperation(Operation selectedOperation) {
        try {
            iOperationDAOLocal.remove(selectedOperation);
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

