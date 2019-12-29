package DBUtil.MedicalStaff;

import DAO.Local.IPatientDAOLocal;
import Entities.ComptePatient;
import Entities.DossierMedical;
import Entities.Embeddable.Adresse;
import Entities.Patient;
import Enumeration.EtatCompte;
import Handler.PropertiesHandler;
import Http.Controller.SMTP.SMTPController;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class PatientDBUtil {


    @EJB
    IPatientDAOLocal iPatientDAOLocal;


    @EJB
    SMTPController smtpController;

    Faker faker = new Faker();

    public List<Patient> loadPatientList() {


        try {

            return iPatientDAOLocal.findAll();
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }

    //*Creation patien methods*//
    public boolean createPatient(Patient patient) {
        try {
            patient.getCompte().setLogin(patient.getNumeroTelephone());

            iPatientDAOLocal.create(patient);

            /*Send Verification Code */
            if (!sendVerificationCode(patient)) {
                iPatientDAOLocal.remove(patient);
                throw new Exception();
            }
            /*Send Verification Code */
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Patient createFakePatient() {


        try {


            Adresse adresse = new Adresse();

            ComptePatient compte = new ComptePatient();
            compte.setMotDePasse(faker.code().isbnRegistrant().toString());
            compte.setCode_activation(String.valueOf(faker.random().nextInt(6548, 31654789)));

            compte.setEtatCompte(EtatCompte.NONACTIF);

            DossierMedical dossierMedical = new DossierMedical(new Date());


            Patient patient = new Patient();

            patient.setAdresse(adresse);
            patient.setDossierMedical(dossierMedical);
            patient.setCompte(compte);

            compte.setPatient(patient);
            dossierMedical.setPatient(patient);

            return patient;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }

    public boolean sendVerificationCode(Patient patient) {
        try {
            smtpController.setReceiver_mail(patient.getEmail());

            String code = patient.getCompte().getCode_activation();

            String code_activation = PropertiesHandler.getProperty(PatientDBUtil.class, "messeges_fr.properties", "activation_code");


            //*Send activation code *  //
            smtpController.setEmailSubject(code_activation);
            smtpController.setEmailContent(code_activation +" : "+ code);

            return smtpController.send();
            //*Send activation code *//
        } catch (Exception e) {
            return false;
        }


    }

    public boolean updatePatient(Patient selectedPatient) {
        try {


            iPatientDAOLocal.edit(selectedPatient);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deletePatient(Patient selectedPatient) {
        try {


            iPatientDAOLocal.remove(selectedPatient);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }



}

