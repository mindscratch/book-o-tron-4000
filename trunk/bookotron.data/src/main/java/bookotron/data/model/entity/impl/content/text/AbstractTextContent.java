package bookotron.data.model.entity.impl.content.text;

import bookotron.model.entity.content.text.ITextContent;
import bookotron.data.model.entity.impl.content.AbstractContent;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Date: May 21, 2009
 * Time: 10:16:20 PM
 */
@Entity
@MappedSuperclass
public abstract class AbstractTextContent extends AbstractContent implements ITextContent {
    private int numPages;

    @Column(name="NUM_PAGES")
    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}