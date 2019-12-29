package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Message;
import Entities.Service;
import Entities.ServiceUrgence;

import javax.ejb.Remote;

@Remote
public interface IServiceDAO extends IGenericDAO<Service> {
}
