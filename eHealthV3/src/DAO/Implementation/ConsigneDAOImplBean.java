package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IConsigneDAOLocal;
import Entities.Consigne;

import javax.ejb.Stateless;

@Stateless(name = "ConsigneDAOImplEJB")
public class ConsigneDAOImplBean extends GenericFacade<Consigne> implements IConsigneDAOLocal {
    public ConsigneDAOImplBean() {
    }
}
