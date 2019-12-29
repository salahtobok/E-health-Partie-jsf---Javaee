package DBUtil.Authentification;


import DAO.Implementation.CompteAdministrationDAOImplBean;
import DAO.Local.ICompteAdministrationDAOLocal;
import DAO.Local.IComptePersonneMedicalDAOLocal;
import DAO.Remote.ICompteAdministrationDAO;
import Entities.CompteAdministration;

import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class LoginAdministrationDbUtil {

    @EJB
    ICompteAdministrationDAOLocal iCompteAdministrationDAOLocal ;


    public CompteAdministration authenticate(String login, String password) {
        try {
            return iCompteAdministrationDAOLocal.authenticateAdmin(login, password);
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
        }
    }
}