package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IMedecinDAOLocal;
import Entities.Medecin;

import javax.ejb.Stateless;

@Stateless(name = "MedecinDAOImplEJB")
public class MedecinDAOImplBean extends GenericFacade<Medecin> implements IMedecinDAOLocal {
    public MedecinDAOImplBean() {
    }
}
