package DAO.Local;

import DAO.Remote.IAlerteDAO;
import DAO.Remote.IMessageDAO;

import javax.ejb.Local;

@Local
public interface IMessageDAOLocal extends IMessageDAO {
}
