package DAO.Remote;

import DAO.IGenericDAO;
import Entities.Questionnaire;
import Entities.Rapport;

import javax.ejb.Remote;

@Remote
public interface IQuestionnaireDAO extends IGenericDAO<Questionnaire> {
}
