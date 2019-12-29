package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IAlerteDAOLocal;
import Entities.Alerte;

import javax.ejb.Stateless;

@Stateless(name = "AlerteDAOImplEJB")
public class AlerteDAOImplBean extends GenericFacade<Alerte> implements IAlerteDAOLocal {
    public AlerteDAOImplBean() {
    }
}
