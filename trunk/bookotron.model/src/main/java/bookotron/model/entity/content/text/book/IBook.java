package bookotron.model.entity.content.text.book;

import bookotron.model.entity.isbn.IISBN;

import java.util.Collection;

/**
 * Date: May 19, 2009
 * Time: 10:25:58 PM
 */
public interface IBook {

    Collection<IISBN> getISBNs();
    void setISBNs(Collection<IISBN> value);

    String getEdition();
    void setEdition(String value);
}
