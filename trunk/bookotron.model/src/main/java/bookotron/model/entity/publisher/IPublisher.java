package bookotron.model.entity.publisher;

import bookotron.model.entity.IEntity;

/**
 * Date: May 19, 2009
 * Time: 10:18:45 PM
 */
public interface IPublisher extends IEntity {

    String getName();
    void setName(String value);

    String getWebsite();
    void setWebsite(String value);

}
