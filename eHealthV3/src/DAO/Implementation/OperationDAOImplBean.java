package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IOperationDAOLocal;
import Entities.Operation;

import javax.ejb.Stateless;

@Stateless(name = "OperationDAOImplEJB")
public class OperationDAOImplBean extends GenericFacade<Operation> implements IOperationDAOLocal {
    public OperationDAOImplBean() {
    }
}
