package DAO.Remote;

import DAO.IGenericDAO;
import Entities.CompteAdministration;
import Entities.ComptePatient;

import javax.ejb.Remote;

@Remote
public interface ICompteAdministrationDAO extends IGenericDAO<CompteAdministration> {


}
