package bookotron.data.model.entity.impl;

import bookotron.model.entity.user.IUser;
import bookotron.model.entity.IEntity;
import bookotron.data.model.entity.impl.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * An abstract implementation of {@link bookotron.model.entity.IEntity} which provides a basic implementation.
 *
 * Date: May 21, 2009
 * Time: 10:03:40 PM
 */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractEntity implements IEntity {

    private long id;
    private Date addDate;
    private Date modifyDate;
    private IUser addedBy;
    private IUser modifiedBy;
    private boolean deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ADD_DATE")
    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="MODIFY_DATE")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @OneToOne(targetEntity = User.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public IUser getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(IUser addedBy) {
        this.addedBy = addedBy;
    }

    @OneToOne(targetEntity = User.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public IUser getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(IUser modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name="DELETED", nullable = true)
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (deleted != that.deleted) return false;
        if (id != that.id) return false;
        if (addDate != null ? !addDate.equals(that.addDate) : that.addDate != null) return false;
        if (addedBy != null ? !addedBy.equals(that.addedBy) : that.addedBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (addedBy != null ? addedBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        return result;
    }
}