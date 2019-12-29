package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Alerte;
import Entities.Message;

import javax.ejb.Remote;

@Remote
public interface IMessageDAO extends IGenericDAO<Message> {

}
