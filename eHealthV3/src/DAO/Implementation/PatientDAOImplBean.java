package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IPatientDAOLocal;
import Entities.Patient;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "PatientDAOImplEJB")
public class PatientDAOImplBean extends GenericFacade<Patient> implements IPatientDAOLocal {


    public PatientDAOImplBean() {
    }
}
