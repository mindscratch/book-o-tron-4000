package bookotron.model.entity.tag;

import bookotron.model.entity.IEntity;
import bookotron.model.entity.content.IContent;

import java.util.Collection;

/**
 * Date: May 19, 2009
 * Time: 10:18:57 PM
 */
public interface ITag extends IEntity {

    String getName();
    void setName(String value);

    String getValue();
    void setValue(String value);
    
    Collection<IContent> getContent();
    void setContent(Collection<IContent> content);
}
