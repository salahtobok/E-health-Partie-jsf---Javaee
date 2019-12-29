package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.Medecin;

import javax.ejb.Remote;

@Remote
public interface IMedecinDAO extends IGenericDAO<Medecin> {
}
