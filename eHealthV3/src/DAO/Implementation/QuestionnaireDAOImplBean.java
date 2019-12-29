package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IQuestionnaireDAOLocal;
import Entities.Questionnaire;

import javax.ejb.Stateless;

@Stateless(name = "QuestionnaireDAOImplEJB")
public class QuestionnaireDAOImplBean extends GenericFacade<Questionnaire> implements IQuestionnaireDAOLocal {
    public QuestionnaireDAOImplBean() {
    }
}
