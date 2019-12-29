package DBUtil.Admin;

import DAO.Local.IMedecinDAOLocal;
import DAO.Local.IPatientDAOLocal;
import Entities.*;
import Entities.Embeddable.Adresse;
import Enumeration.EtatCompte;
import Handler.PropertiesHandler;
import Http.Controller.SMTP.SMTPController;
import com.github.javafaker.Faker;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Date;
import java.util.List;

@Singleton
public class MedicalStaffDBUtil {


    @EJB
    IMedecinDAOLocal iMedecinDAOLocal;


    @EJB
    SMTPController smtpController;

    Faker faker = new Faker();

    public List<Medecin> loadMedecinList() {


        try {

            return iMedecinDAOLocal.findAll();
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
        }
        return null;
    }

    //*Creation medecine methods*//
    public boolean createMedecin(Medecin medecin) {
        try {
            medecin.getComptePersonneMedical().setLogin(medecin.getNumeroTelephone());

            iMedecinDAOLocal.create(medecin);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        }
    }


    public Medecin createFakeMedecin() {


        try {


            Adresse adresse = new Adresse();

            ComptePersonneMedical compte = new ComptePersonneMedical();
            compte.setMotDePasse(faker.code().isbnRegistrant().toString());
            compte.setEtatCompte(EtatCompte.ACTIF);


//            Service service = new Service();


            Medecin medecin = new Medecin();

            medecin.setAdresse(adresse);
//            medecin.setService(service);
            medecin.setComptePersonneMedical(compte);
//            medecin.setNumeroTelephone("0648498489");

            compte.setMedecin(medecin);

            return medecin;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }


    public boolean updateMedecin(Medecin selectedMedecin) {
        try {


            iMedecinDAOLocal.edit(selectedMedecin);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }

    public boolean deleteMedecin(Medecin selectedMedecin) {
        try {


            iMedecinDAOLocal.remove(selectedMedecin);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {

        }
    }


}

