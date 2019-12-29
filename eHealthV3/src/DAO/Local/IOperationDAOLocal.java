package DAO.Local;

import DAO.Remote.IMessageDAO;
import DAO.Remote.IOperationDAO;

import javax.ejb.Local;

@Local
public interface IOperationDAOLocal extends IOperationDAO {
}
