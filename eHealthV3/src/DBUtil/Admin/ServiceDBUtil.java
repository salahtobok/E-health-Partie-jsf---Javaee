package DBUtil.Admin;

import DAO.Implementation.ServiceDAOImplBean;
import DAO.Local.IServiceDAOLocal;
import Entities.Service;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ServiceDBUtil {


    @EJB
    IServiceDAOLocal iServiceDAOLocal;


    Faker faker = new Faker();

    public List<Service> loadServiceList() {


        try {

            return iServiceDAOLocal.findAll();

        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }


    public List<String> loadServiceNameList() {
        try {
            List<Service> services = loadServiceList();
            List<String> serviceNameList= new ArrayList<String>();

            for (Service service:services){
                serviceNameList.add(service.getNom());
            }
            return serviceNameList;

        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }



    //*Creation patien methods*//
    public boolean createService(Service service) {
        try {

            iServiceDAOLocal.create(service);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Service createFakeService() {


        try {



            return new Service();
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateService(Service selectedService) {
        try {


            iServiceDAOLocal.edit(selectedService);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteService(Service selectedService) {
        try {
            iServiceDAOLocal.remove(selectedService);
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

