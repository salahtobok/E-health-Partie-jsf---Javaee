package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IFicheMedicalDAOLocal;
import Entities.FicheMedical;

import javax.ejb.Stateless;

@Stateless(name = "FicheMedicalDAOImplEJB")
public class FicheMedicalDAODAOImplBean extends GenericFacade<FicheMedical> implements IFicheMedicalDAOLocal {
    public FicheMedicalDAODAOImplBean() {
    }
}
