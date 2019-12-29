package DAO.Implementation;

import DAO.GenericFacade;
import DAO.Local.IMessageDAOLocal;
import Entities.Message;

import javax.ejb.Stateless;

@Stateless(name = "MessageDAOImplEJB")
public class MessageDAOImplBean extends GenericFacade<Message> implements IMessageDAOLocal {
    public MessageDAOImplBean() {
    }
}
