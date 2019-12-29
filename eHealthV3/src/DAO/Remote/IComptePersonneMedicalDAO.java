package DAO.Remote;

import DAO.IGenericDAO;
import Entities.CompteAdministration;
import Entities.ComptePatient;
import Entities.ComptePersonneMedical;

import javax.ejb.Remote;

@Remote
public interface IComptePersonneMedicalDAO extends IGenericDAO<ComptePersonneMedical> {

}
