package DAO;

import Entities.Service;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericFacade<T> implements IGenericDAO<T> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    public EntityManager entityManager;

    private Class<T> entityClass;

    public GenericFacade() {

        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        this.entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];

    }

    @Override
    public void create(Object entity) {
            entityManager.persist(entity);
    }

    @Override
    public void edit(Object entity) {
             entityManager.merge(entity);
    }

    @Override
    public void remove(Object entity) {
//        entityManager.merge(entity);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));

        }

    @Override
    public T find(Object id) {
        return entityManager.find(this.entityClass, id);
    }


    @Override
    public List findAll() {

        Query query = entityManager.createQuery("select entity from " + this.entityClass.getSimpleName() + " entity");
        return query.getResultList();
    }

    @Override
    public Long count() {

        Query query = entityManager.createQuery("select count(entity) from " + this.entityClass.getSimpleName() + " entity");

        return (Long) query.getSingleResult();
    }



    @Override
    public T authenticateAdmin(Object login, Object password) {
        Query query =
                entityManager.createQuery("Select c FROM CompteAdministration c WHERE c.login = :login " +
                        "AND c.motDePasse = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return  (T) query.getSingleResult();

    }

    @Override
    public T authenticateMedicalStaff(Object login, Object password) {
        Query query =
                entityManager.createQuery("Select c FROM ComptePersonneMedical c WHERE c.login = :login " +
                        "AND c.motDePasse = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return  (T) query.getSingleResult();

    }

    @Override
    public List<T> myConsigne(Object id) {
        Query query =
                entityManager.createQuery("Select c FROM Consigne c WHERE c.operation.medecin.id = :id");
        query.setParameter("id", id);
        return  query.getResultList();

    }


    @Override
    public List<T> myOperations(Object id) {
        Query query =
                entityManager.createQuery("Select o FROM Operation o WHERE o.medecin.idMedecin = :id ");
        query.setParameter("id", id);
        return  query.getResultList();

    }


    @Override
    public List<T> myQuestion(Object id) {
        Query query =
                entityManager.createQuery("Select q FROM Question q WHERE q.questionnaire.operation.medecin.idMedecin = :id ");
        query.setParameter("id", id);
        return  query.getResultList();

    }


    @Override
    public List<T> myRapport(Object id) {
        Query query =
                entityManager.createQuery("Select r FROM Rapport r WHERE r.operation.medecin.idMedecin = :id ");
        query.setParameter("id", id);
        return  query.getResultList();

    }



    @Override
    public List<T> myQuestionnaire(Object id) {
        Query query =
                entityManager.createQuery("Select q FROM Questionnaire q WHERE q.operation.medecin.idMedecin = :id ");
        query.setParameter("id", id);
        return  query.getResultList();

    }
}