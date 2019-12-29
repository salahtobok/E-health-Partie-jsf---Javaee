package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IRendezVousDAOLocal;
import Entities.RendezVous;

import javax.ejb.Stateless;

@Stateless(name = "RendezVousDAOImplEJB")
public class RendezVousDAOImplBean extends GenericFacade<RendezVous> implements IRendezVousDAOLocal{
    public RendezVousDAOImplBean() {
    }
}
