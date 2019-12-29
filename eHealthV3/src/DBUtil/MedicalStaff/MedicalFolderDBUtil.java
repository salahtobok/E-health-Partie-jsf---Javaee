package DBUtil.MedicalStaff;

import DAO.Local.IDossierMedicalDAOLocal;
import Entities.DossierMedical;
import Http.Controller.SMTP.SMTPController;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class MedicalFolderDBUtil {


    @EJB
    IDossierMedicalDAOLocal iDossierMedicalDAOLocal;


    @EJB
    SMTPController smtpController;

    Faker faker = new Faker();

    public List<DossierMedical> loadDossierMedicals() {


        try {

            return iDossierMedicalDAOLocal.findAll();
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }

    //*Creation patien methods*//
//    public boolean createPatient(Patient patient) {
//        try {
//            patient.getCompte().setNumeroTelephone(patient.getNumeroTelephone());
//
//            iPatientDAOLocal.create(patient);
//
//            /*Send Verification Code */
//            if (!sendVerificationCode(patient))
//                iPatientDAOLocal.remove(patient);
//            /*Send Verification Code */
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//            System.out.println("Login error -->" + ex.getMessage());
//            return false;
//        } finally {
//        }
//    }
//
//    public boolean updatePatient(Patient selectedPatient) {
//        try {
//
//
//            iPatientDAOLocal.edit(selectedPatient);
//
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//            System.out.println("Login error -->" + ex.getMessage());
//            return false;
//        } finally {
//
//        }
//    }
//
//    public boolean deletePatient(Patient selectedPatient) {
//        try {
//
//
//            iPatientDAOLocal.remove(selectedPatient);
//
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Login error -->" + ex.getMessage());
//            return false;
//        } finally {
//
//        }
//    }

//*Creation patien methods*//


}

