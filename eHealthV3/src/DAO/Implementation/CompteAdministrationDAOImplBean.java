package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.ICompteAdministrationDAOLocal;
import DAO.Local.ICompteDAOLocal;
import DAO.Remote.ICompteAdministrationDAO;
import Entities.CompteAdministration;
import Entities.ComptePatient;
import Entities.ComptePersonneMedical;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "CompteAdministrationDAOImplBean")
public class CompteAdministrationDAOImplBean extends GenericFacade<CompteAdministration> implements ICompteAdministrationDAOLocal {
    public CompteAdministrationDAOImplBean() {
    }


}