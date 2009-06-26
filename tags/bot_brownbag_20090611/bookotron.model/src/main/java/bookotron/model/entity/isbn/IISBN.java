package bookotron.model.entity.isbn;

import bookotron.model.entity.IEntity;
import bookotron.model.entity.content.text.ITextContent;


/**
 * Date: May 19, 2009
 * Time: 10:18:32 PM
 */
public interface IISBN extends IEntity {

    String getValue();
    void setValue(String value);

    ITextContent getTextContent();
    void setTextContent(ITextContent content);
}
