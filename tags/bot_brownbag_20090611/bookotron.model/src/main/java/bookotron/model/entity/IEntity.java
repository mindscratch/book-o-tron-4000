package bookotron.model.entity;

import bookotron.model.entity.user.IUser;

import java.util.Date;
import java.io.Serializable;

/**
 * The root interface for all entity-like objects.
 *
 * Date: May 19, 2009
 * Time: 10:04:44 PM
 */
public interface IEntity extends Serializable {
    long getId();
    void setId(long value);

    Date getAddDate();
    void setAddDate(Date value);

    Date getModifyDate();
    void setModifyDate(Date value);

    IUser getAddedBy();
    void setAddedBy(IUser value);

    IUser getModifiedBy();
    void setModifiedBy(IUser value);

    /**
     * Returns whether or not the entity was deleted.  Our current strategy is to not delete items from the database
     * but instead to mark it as deleted.
     *
     * @return  {@code true} if it was deleted, {@code false} otherwise.
     */
    boolean isDeleted();
    void setDeleted(boolean deleted);
}