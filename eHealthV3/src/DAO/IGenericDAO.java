package DAO;

import Entities.ComptePersonneMedical;
import Entities.Service;

import java.util.List;

public interface IGenericDAO<T> {

    void create(T entity);
    void edit(T entity);
    void remove(T entity);
    T find(Object id);
    List<T> findAll();
    List<T> myOperations(Object id);
    Long count();
    T authenticateAdmin(Object login, Object password);
    T authenticateMedicalStaff(Object login,Object password);
    List<T> myConsigne(Object id);
    List<T> myQuestion(Object id);
    List<T> myQuestionnaire(Object id);
    List<T> myRapport(Object id);

}
