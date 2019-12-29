package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Question;
import Entities.Rapport;

import javax.ejb.Remote;

@Remote
public interface IQuestionDAO extends IGenericDAO<Question> {
}
