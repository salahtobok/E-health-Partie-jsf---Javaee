package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IServiceUrgenceDAOLocal;
import Entities.ServiceUrgence;

import javax.ejb.Stateless;

@Stateless(name = "ServiceUrgenceDAOImplEJB")
public class ServiceUrgenceDAOImplBean extends GenericFacade<ServiceUrgence> implements IServiceUrgenceDAOLocal {
    public ServiceUrgenceDAOImplBean() {
    }
}
