package bookotron.data.model.entity.impl.author;

import bookotron.model.entity.author.IAuthor;
import bookotron.model.entity.content.IContent;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.content.AbstractContent;

import javax.persistence.*;
import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:09:34 PM
 */
@Entity
@Table(name="AUTHOR")
@NamedQuery(name="Author.findAll", query = "SELECT A FROM Author A")
public class Author extends AbstractEntity implements IAuthor {

    private String firstName;
    private String lastName;
    private Collection<IContent> authored;

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return  the collection of content that was authored, or co-authored, by this author.
     */
    @JoinColumn(name = "CONTENT")
    @ManyToMany(targetEntity = AbstractContent.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<IContent> getAuthored() {
        return authored;
    }

    public void setAuthored(Collection<IContent> authored) {
        this.authored = authored;
    }
}