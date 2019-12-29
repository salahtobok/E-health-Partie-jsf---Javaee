package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IRapportDAOLocal;
import Entities.Rapport;

import javax.ejb.Stateless;

@Stateless(name = "RapportDAOImplEJB")
public class RapportDAOImplBean extends GenericFacade<Rapport> implements IRapportDAOLocal {
    public RapportDAOImplBean() {
    }
}
