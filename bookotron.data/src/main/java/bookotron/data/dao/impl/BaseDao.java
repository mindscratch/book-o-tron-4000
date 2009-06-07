package bookotron.data.dao.impl;

import bookotron.data.dao.IBaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository  // this provides Spring's exception translation
public class BaseDao<T> implements IBaseDao<T> {

    // http://static.springframework.org/spring/docs/2.5.x/reference/orm.html#orm-jpa-straight
    @PersistenceContext
    private EntityManager em;

    // type of class being persisted
    private Class<T> persistentClass;

    // the name of the table for the entity
    private String tableName;

    // findAll query
    private Query findAll;

    public BaseDao() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        init();
    }

    /**
     * By allowing the class type be passed in, this dao can be created via Spring without the need to create a bunch
     * of classes which simply extend BaseDao and provide a type via annotations.
     * @param persistentClass
     */
    public BaseDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        init();
    }

    protected void init() {
        initTableName();
    }

    protected void initTableName() {
        Table table = persistentClass.getAnnotation(Table.class);
        if (table == null) {
            throw new RuntimeException("Expected " + Table.class.getName() + " annotation on class " + persistentClass.getName());
        }
        tableName = table.name();
    }

    /**
     * Creates a {@code javax.persistence.Query} used to find all instances of {@code T}.  It checks for a
     * @{code NamedQuery} annotation whose name ends in "findAll" (case insensitive).
     *
     * This implementation does not support the {@code javax.persistence.NamedQueries} annotation.
     */
    protected void initFindAllQuery() {
        // check for the annotation, it's used if the name ends in 'findAll' (case-insensitive)
        final NamedQuery nq = persistentClass.getAnnotation(NamedQuery.class);
        if (nq != null) {
            if (nq.name() != null && nq.name().toLowerCase().endsWith("findall")) {
                findAll = em.createNamedQuery(nq.name());
            }
        }

        if (findAll == null) {
            findAll = em.createQuery("SELECT X FROM " + tableName + " X");
        }
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
        if (findAll == null) {
            initFindAllQuery();
        }

        List results = findAll.getResultList();
        if (results != null) {
            return (List<T>) results;
        }
        return null;
    }

    @Transactional
    public T find(long id) {
        return em.find(persistentClass, id);
    }
}