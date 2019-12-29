package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IServiceDAOLocal;
import DAO.Remote.IServiceDAO;
import Entities.Service;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Stateless(name = "ServiceDAOImplEJB")
public class ServiceDAOImplBean extends GenericFacade<Service> implements IServiceDAOLocal,IServiceDAO {
    public ServiceDAOImplBean() {
    }

}
