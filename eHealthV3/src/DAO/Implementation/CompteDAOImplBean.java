package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.ICompteDAOLocal;
import Entities.ComptePatient;

import javax.ejb.Stateless;

@Stateless(name = "CompteDAOImplEJB")
public class CompteDAOImplBean extends GenericFacade<ComptePatient> implements ICompteDAOLocal {
    public CompteDAOImplBean() {
    }
}
