package DBUtil.MedicalStaff;

import DAO.Local.IFicheMedicalDAOLocal;
import Entities.DossierMedical;
import Entities.FicheMedical;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Date;

@Singleton
public class MedicalFileDBUtil {


    @EJB
    IFicheMedicalDAOLocal iFicheMedicalDAOLocal;


    public FicheMedical createFakeMedicalFile() {

        try {




            FicheMedical ficheMedical = new FicheMedical(new Date(),new DossierMedical());


            return ficheMedical;
        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }



    //*Creation patien methods*//
    public boolean createMedicalFile(FicheMedical ficheMedical) {
        try {

            iFicheMedicalDAOLocal.create(ficheMedical);


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

