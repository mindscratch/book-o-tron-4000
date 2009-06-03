package bookotron.data.dao.impl;

import bookotron.data.dao.IBaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository  // this provides Spring's exception translation
public class BaseDao<T> implements IBaseDao<T> {

    // http://static.springframework.org/spring/docs/2.5.x/reference/orm.html#orm-jpa-straight
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public T insert(T t) {
        em.persist(t);
        return t;
    }

    @Transactional
    public T update(T t) {
        return em.merge(t);
    }

    @Transactional
    public void remove(T t) {
        em.remove(t);
    }

    @Transactional
    public List<T> findAll(Class<T> objectClass) {
        final Query query = em.createQuery("select c from " + objectClass.getSimpleName() + " c");
        List results = query.getResultList();
        if (results != null) {
            return (List<T>) results;
        }
        return null;
    }

    @Transactional
    public T find(Class<T> objectClass, Serializable id) {
        return em.find(objectClass, id);
    }
}