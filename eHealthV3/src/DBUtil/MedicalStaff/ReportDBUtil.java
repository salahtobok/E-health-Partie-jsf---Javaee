package DBUtil.MedicalStaff;

import DAO.Local.IConsigneDAOLocal;
import DAO.Local.IRapportDAOLocal;
import Entities.Consigne;
import Entities.Rapport;
import SessionUtil.SessionUtils;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class ReportDBUtil {


    @EJB
    IRapportDAOLocal iRapportDAOLocal;


    Faker faker = new Faker();

    public List<Rapport> loadRapportList() {


        try {
            int medcineId = SessionUtils.getUserAccount().getMedecin().getIdMedecin();
            return iRapportDAOLocal.myRapport(medcineId);
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
    public boolean createRapport(Rapport rapport) {
        try {

            iRapportDAOLocal.create(rapport);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Rapport createFakeRapport() {


        try {

            return new Rapport();
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateRapport(Rapport selectedRapport) {
        try {


            iRapportDAOLocal.edit(selectedRapport);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteRapport(Rapport selectedRapport) {
        try {
            iRapportDAOLocal.remove(selectedRapport);
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

