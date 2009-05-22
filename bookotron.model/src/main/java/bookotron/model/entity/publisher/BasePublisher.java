package bookotron.model.entity.publisher;

import bookotron.model.entity.AbstractEntity;

/**
 * Date: May 21, 2009
 * Time: 10:26:44 PM
 */
public class BasePublisher extends AbstractEntity implements IPublisher {
    private String name;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
