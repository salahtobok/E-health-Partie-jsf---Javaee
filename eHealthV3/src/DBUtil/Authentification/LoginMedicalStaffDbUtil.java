package DBUtil.Authentification;


import DAO.Implementation.ComptePersonneMedicalDAOImplBean;
import DAO.Local.ICompteAdministrationDAOLocal;
import DAO.Local.IComptePersonneMedicalDAOLocal;
import DAO.Remote.IComptePersonneMedicalDAO;
import Entities.ComptePersonneMedical;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class LoginMedicalStaffDbUtil {

    @EJB
    IComptePersonneMedicalDAOLocal iComptePersonneMedicalDAOLocal ;

    public ComptePersonneMedical authenticate(String login, String password) {
        try {


            return iComptePersonneMedicalDAOLocal.authenticateMedicalStaff(login, password);
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }
}