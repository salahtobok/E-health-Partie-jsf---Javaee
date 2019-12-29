package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IConsultationDAOLocal;
import Entities.Consultation;

import javax.ejb.Stateless;

@Stateless(name = "ConsultationDAOImplEJB")
public class ConsultationDAOImplBean extends GenericFacade<Consultation> implements IConsultationDAOLocal {
    public ConsultationDAOImplBean() {
    }
}
