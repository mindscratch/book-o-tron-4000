package bookotron.model.entity.isbn;

import bookotron.model.entity.AbstractEntity;

/**
 * Date: May 21, 2009
 * Time: 10:22:04 PM
 */
public abstract class AbstractISBN extends AbstractEntity implements IISBN {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}