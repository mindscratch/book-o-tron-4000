package bookotron.model.entity.tag;

import bookotron.model.entity.AbstractEntity;

/**
 * Date: May 21, 2009
 * Time: 10:29:49 PM
 */
public class BaseTag extends AbstractEntity implements ITag {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
