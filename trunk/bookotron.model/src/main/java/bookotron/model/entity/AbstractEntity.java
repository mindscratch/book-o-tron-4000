package bookotron.model.entity;

import bookotron.model.entity.user.IUser;

import java.util.Date;

/**
 * An abstract implementation of {@link bookotron.model.entity.IEntity} which provides a basic implementation.
 *
 * Date: May 21, 2009
 * Time: 10:03:40 PM
 */
public abstract class AbstractEntity implements IEntity {

    private long id;
    private Date addDate;
    private Date modifyDate;
    private IUser addedBy;
    private IUser modifiedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public IUser getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(IUser addedBy) {
        this.addedBy = addedBy;
    }

    public IUser getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(IUser modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}