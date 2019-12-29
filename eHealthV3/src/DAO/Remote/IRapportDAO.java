package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Rapport;
import Entities.Service;

import javax.ejb.Remote;

@Remote
public interface IRapportDAO extends IGenericDAO<Rapport> {
}
