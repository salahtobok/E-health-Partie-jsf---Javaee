package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.Operation;

import javax.ejb.Remote;

@Remote
public interface IOperationDAO extends IGenericDAO<Operation> {
}
