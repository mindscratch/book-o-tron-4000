package bookotron.model.entity.publisher;

import bookotron.model.entity.IEntity;
import bookotron.model.entity.content.IContent;

import java.util.Collection;

/**
 * Date: May 19, 2009
 * Time: 10:18:45 PM
 */
public interface IPublisher extends IEntity {

    String getName();
    void setName(String value);

    String getWebsite();
    void setWebsite(String value);

    Collection<IContent> getContent();
    void setContent(Collection<IContent> content);
}
