package bookotron.data.model.entity.impl.author;

import bookotron.model.entity.author.IAuthor;
import bookotron.model.entity.content.IContent;
import bookotron.model.entity.user.IUser;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.content.AbstractContent;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:09:34 PM
 */
@Entity
@Table(name="AUTHOR")
@NamedQuery(name="Author.findAll", query = "SELECT A FROM Author A")
@XStreamAlias("Author")
public class Author extends AbstractEntity implements IAuthor {

	@XStreamAlias("firstName")
    private String firstName;
	@XStreamAlias("lastName")
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());
        sb.append("={id: ");
        sb.append(getId());
        sb.append(", firstName: ");
        sb.append(getFirstName());
        sb.append(", lastName: ");
        sb.append(getLastName());
        sb.append(", content: [");
        if (authored != null && authored.size() > 0) {
            for (IContent item : authored) {
                sb.append(item.getClass().getSimpleName());
                sb.append("={id: ");
                sb.append(item.getId());
                sb.append(", title: ");
                sb.append(item.getTitle());
            }
        }
        sb.append("], addDate: ");
        sb.append(getAddDate());
        sb.append("}");
        return sb.toString();
    }
}