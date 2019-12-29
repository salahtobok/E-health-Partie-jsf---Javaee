package DAO.Local;

import DAO.Remote.IServiceUrgenceDAO;
import Entities.ServiceUrgence;

import javax.ejb.Remote;

@Remote
public interface IServiceUrgenceDAOLocal extends IServiceUrgenceDAO {
}
