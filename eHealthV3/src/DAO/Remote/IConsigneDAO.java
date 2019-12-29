package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.Consigne;

import javax.ejb.Remote;

@Remote
public interface IConsigneDAO extends IGenericDAO<Consigne> {
}
