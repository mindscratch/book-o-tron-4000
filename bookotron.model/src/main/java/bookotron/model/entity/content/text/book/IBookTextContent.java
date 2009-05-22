package bookotron.model.entity.content.text.book;

import bookotron.model.entity.isbn.IISBN;
import bookotron.model.entity.content.text.ITextContent;

import java.util.Collection;

/**
 * Date: May 19, 2009
 * Time: 10:25:58 PM
 */
public interface IBookTextContent extends ITextContent {

    Collection<IISBN> getISBNs();
    void setISBNs(Collection<IISBN> value);

    String getEdition();
    void setEdition(String value);
}
