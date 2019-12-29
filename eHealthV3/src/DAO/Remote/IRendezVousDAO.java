package DAO.Remote;

import DAO.IGenericDAO;
import Entities.RendezVous;
import Entities.Service;

import javax.ejb.Remote;

@Remote
public interface IRendezVousDAO extends IGenericDAO<RendezVous> {
}
