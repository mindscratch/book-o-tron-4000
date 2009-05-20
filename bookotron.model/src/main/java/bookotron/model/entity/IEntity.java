package bookotron.model.entity;

import bookotron.model.entity.user.IUser;

import java.util.Date;

/**
 * The root interface for all entity-like objects.
 *
 * Date: May 19, 2009
 * Time: 10:04:44 PM
 */
public interface IEntity {
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
}