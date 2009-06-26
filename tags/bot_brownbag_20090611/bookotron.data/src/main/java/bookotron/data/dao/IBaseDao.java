package bookotron.data.dao;

import java.util.List;
import java.io.Serializable;

public interface IBaseDao<T> {

    public T insert(T t);

    public T update(T t);

    public void remove(T t);

    public List<T> findAll();

    /**
     * Retrieves an item of type <code>T</code> whose ID equals the given <code>id</code>.
     *
     * @param id    the ID of the entity to be retrieved
     *
     * @return  the item
     *
     * @throws bookotron.model.exception.EntityNotFoundException if no item is found with the given <code>id</code>
     */
    public T find(long id);
}