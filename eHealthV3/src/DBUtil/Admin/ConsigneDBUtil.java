package DBUtil.Admin;

import DAO.Local.IConsigneDAOLocal;
import DAO.Local.IServiceDAOLocal;
import Entities.Consigne;
import Entities.Service;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ConsigneDBUtil {


    @EJB
    IConsigneDAOLocal iConsigneDAOLocal;


    Faker faker = new Faker();

    public List<Consigne> loadConsigneList() {


        try {

            return iConsigneDAOLocal.findAll();

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
    public boolean sendConsigne(Consigne consigne) {
        try {

            consigne.setIdConsigne(0);
            iConsigneDAOLocal.create(consigne);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    //*Creation patien methods*//
    public boolean createConsigne(Consigne consigne) {
        try {

            iConsigneDAOLocal.create(consigne);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Consigne createFakeConsigne() {


        try {

           return new Consigne();
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateConsigne(Consigne selectedConsigne) {
        try {


            iConsigneDAOLocal.edit(selectedConsigne);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteConsigne(Consigne selectedConsigne) {
        try {
            iConsigneDAOLocal.remove(selectedConsigne);
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

