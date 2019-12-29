package DAO.Implementation;

import DAO.GenericFacade;

import DAO.Local.IComptePersonneMedicalDAOLocal;
import Entities.ComptePersonneMedical;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(name = "ComptePersonneMedicalDAOImplBean")
public class ComptePersonneMedicalDAOImplBean extends GenericFacade<ComptePersonneMedical> implements IComptePersonneMedicalDAOLocal {
    public ComptePersonneMedicalDAOImplBean() {
    }


}
