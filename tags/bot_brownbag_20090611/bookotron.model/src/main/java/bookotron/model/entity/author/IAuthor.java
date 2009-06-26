package bookotron.model.entity.author;

import bookotron.model.entity.content.IContent;
import bookotron.model.entity.IEntity;

import java.util.Collection;

/**
 * Someone who has created (i.e. written) content (i.e. Book, PDF, etc).
 *
 * Date: May 19, 2009
 * Time: 10:15:42 PM
 */
public interface IAuthor extends IEntity {

    String getFirstName();
    void setFirstName(String value);

    String getLastName();
    void setLastName(String value);

    Collection<IContent> getAuthored();
    void setAuthored(Collection<IContent> value);
}
