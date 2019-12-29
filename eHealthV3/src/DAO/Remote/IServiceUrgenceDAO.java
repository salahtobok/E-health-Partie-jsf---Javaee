package DAO.Remote;

import DAO.IGenericDAO;
import Entities.ServiceUrgence;

import javax.ejb.Remote;

@Remote
public interface IServiceUrgenceDAO extends IGenericDAO<ServiceUrgence> {
}
