package DAO.Local;

import DAO.Remote.IMedecinDAO;
import DAO.Remote.IMessageDAO;

import javax.ejb.Local;

@Local
public interface IMedecinDAOLocal extends IMedecinDAO {
}
