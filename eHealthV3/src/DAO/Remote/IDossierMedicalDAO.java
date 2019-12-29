package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.DossierMedical;

import javax.ejb.Remote;

@Remote
public interface IDossierMedicalDAO extends IGenericDAO<DossierMedical> {
}
