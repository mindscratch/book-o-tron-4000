package bookotron.data.model.entity.impl.content.text.book;

import bookotron.model.entity.content.text.book.IBookTextContent;
import bookotron.model.entity.isbn.IISBN;
import bookotron.data.model.entity.impl.content.text.AbstractTextContent;
import bookotron.data.model.entity.impl.isbn.AbstractIsbn;

import javax.persistence.*;
import java.util.Collection;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Date: May 21, 2009
 * Time: 10:19:17 PM
 */
@Entity
@Table(name="BOOK")
@XStreamAlias("Book")
public class BookTextContent extends AbstractTextContent implements IBookTextContent {

    private Collection<IISBN> isbns;
    private String edition;

    @JoinColumn(name="ISBNS")
    @OneToMany(targetEntity = AbstractIsbn.class, cascade = CascadeType.ALL)
    public Collection<IISBN> getISBNs() {
        return isbns;
    }

    public void setISBNs(Collection<IISBN> isbns) {
        this.isbns = isbns;
    }

    @Column(name="EDITION")
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}