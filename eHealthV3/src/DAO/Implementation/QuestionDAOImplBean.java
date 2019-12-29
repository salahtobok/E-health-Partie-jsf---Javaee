package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IQuestionDAOLocal;
import Entities.Question;

import javax.ejb.Stateless;

@Stateless(name = "QuestionDAOImplEJB")
public class QuestionDAOImplBean extends GenericFacade<Question> implements IQuestionDAOLocal {
    public QuestionDAOImplBean() {
    }
}
