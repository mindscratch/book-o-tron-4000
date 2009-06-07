package bookotron.data.dao;

import java.util.List;
import java.io.Serializable;

public interface IBaseDao<T> {

    public T insert(T t);

    public T update(T t);

    public void remove(T t);

    public List<T> findAll();

    public T find(long id);
}