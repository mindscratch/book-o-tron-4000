package bookotron.model.entity.content.text.book;

import bookotron.model.entity.content.text.AbstractTextContent;
import bookotron.model.entity.isbn.IISBN;

import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:19:17 PM
 */
public class BaseBookTextContent extends AbstractTextContent implements IBookTextContent {

    private Collection<IISBN> isbns;
    private String edition;

    public Collection<IISBN> getISBNs() {
        return isbns;
    }

    public void setISBNs(Collection<IISBN> isbns) {
        this.isbns = isbns;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}