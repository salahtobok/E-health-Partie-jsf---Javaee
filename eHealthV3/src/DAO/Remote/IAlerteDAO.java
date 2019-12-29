package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.Patient;

import javax.ejb.Remote;

@Remote
public interface IAlerteDAO extends IGenericDAO<Alerte> {
}
