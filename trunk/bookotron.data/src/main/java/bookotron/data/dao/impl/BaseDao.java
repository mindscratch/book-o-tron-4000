package bookotron.data.dao.impl;

import bookotron.data.dao.IBaseDao;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.annotation.Annotation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository  // this provides Spring's exception translation
public class BaseDao<T> implements IBaseDao<T> {

    // http://static.springframework.org/spring/docs/2.5.x/reference/orm.html#orm-jpa-straight
    @PersistenceContext
    private EntityManager em;

    private Class<T> persistentClass;
    private String tableName;

    public BaseDao() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        initTableName();
    }

    public BaseDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        initTableName();
    }

    private void initTableName() {
        Table table = persistentClass.getAnnotation(Table.class);
        if (table == null) {
            throw new RuntimeException("Expected " + Table.class.getName() + " annotation on class " + persistentClass.getName());
        }
        tableName = table.name();
    }

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
    public List<T> findAll() {
        NamedQuery nq = persistentClass.getAnnotation(NamedQuery.class);
        Query q = em.createNamedQuery(nq.name());

        final Query query = em.createQuery("select e from " + persistentClass.getSimpleName() + " e");
        List results = query.getResultList(); //q.getResultList();//
        if (results != null) {
            return (List<T>) results;
        }
        return null;
    }

    @Transactional
    public T find(Serializable id) {
        return em.find(persistentClass, id);
    }
}