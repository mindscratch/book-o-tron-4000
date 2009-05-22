package bookotron.model.entity.author;

import bookotron.model.entity.AbstractEntity;
import bookotron.model.entity.content.IContent;

import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:09:34 PM
 */
public class BaseAuthor extends AbstractEntity implements IAuthor {

    private String firstName;
    private String lastName;
    private Collection<IContent> authored;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return  the collection of content that was authored, or co-authored, by this author.
     */
    public Collection<IContent> getAuthored() {
        return authored;
    }

    public void setAuthored(Collection<IContent> authored) {
        this.authored = authored;
    }
}
