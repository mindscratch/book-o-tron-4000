package bookotron.model.entity.rental;

import bookotron.model.entity.IEntity;
import bookotron.model.entity.content.IContent;

import java.util.Set;
import java.util.Date;

public interface ICheckOut extends IEntity {

    IContent getContent();
    void setContent(IContent content);

    Date getDueDate();
    void setDueDate(Date value);
}