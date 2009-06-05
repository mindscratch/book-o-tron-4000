package bookotron.data.model.entity.impl.isbn;

import bookotron.model.entity.isbn.IISBN;
import bookotron.model.entity.content.text.ITextContent;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.content.text.AbstractTextContent;

import javax.persistence.*;

/**
 * Date: May 21, 2009
 * Time: 10:22:04 PM
 */
@Entity
@MappedSuperclass
public abstract class AbstractIsbn extends AbstractEntity implements IISBN {
    private String value;
    private ITextContent content;

    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JoinColumn(name = "TXT_CONTENT")
    @ManyToOne(targetEntity = AbstractTextContent.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public ITextContent getTextContent() {
        return content;
    }

    public void setTextContent(ITextContent content) {
        this.content = content;
    }
}