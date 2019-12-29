package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.Consultation;

import javax.ejb.Remote;

@Remote
public interface IConsultationDAO extends IGenericDAO<Consultation> {
}
