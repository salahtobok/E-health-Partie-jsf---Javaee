package DAO.Remote;

import DAO.IGenericDAO;
import Entities.ComptePatient;

import javax.ejb.Remote;

@Remote
public interface ICompteDAO extends IGenericDAO<ComptePatient> {
}
