package bookotron.data.model.entity.impl.content.text.book;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import bookotron.data.model.entity.impl.content.text.AbstractTextContent;
import bookotron.data.model.entity.impl.isbn.AbstractISBN;
import bookotron.model.entity.content.text.book.IBookTextContent;
import bookotron.model.entity.isbn.IISBN;

/**
 * Date: May 21, 2009
 * Time: 10:19:17 PM
 */
@Entity
@Table(name="BOOK")
@XStreamAlias("Book")
public class BaseBookTextContent extends AbstractTextContent implements IBookTextContent {

    private Collection<IISBN> isbns;
    private String edition;

    @JoinColumn(name="ISBNS")
    @OneToMany(targetEntity = AbstractISBN.class, cascade = CascadeType.ALL)
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