package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.FicheMedical;

import javax.ejb.Remote;

@Remote
public interface IFicheMedicalDAO extends IGenericDAO<FicheMedical> {
}
