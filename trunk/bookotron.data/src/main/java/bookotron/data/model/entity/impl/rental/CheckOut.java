package bookotron.data.model.entity.impl.rental;

import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.content.IContent;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.content.AbstractContent;

import javax.persistence.*;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "CHECK_OUT")
public class CheckOut extends AbstractEntity implements ICheckOut {

    private IContent content;
    private Date dueDate;

    @JoinColumn(name = "CONTENT")
    public IContent getContent() {
        return content;
    }

    public void setContent(IContent content) {
        this.content = content;
    }

    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}