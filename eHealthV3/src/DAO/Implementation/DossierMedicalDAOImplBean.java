package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IDossierMedicalDAOLocal;
import Entities.DossierMedical;

import javax.ejb.Stateless;

@Stateless(name = "DossierMedicalDAOImplEJB")
public class DossierMedicalDAOImplBean extends GenericFacade<DossierMedical> implements IDossierMedicalDAOLocal {
    public DossierMedicalDAOImplBean() {
    }
}
