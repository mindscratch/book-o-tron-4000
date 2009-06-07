package bookotron.data.model.entity.impl.tag;

import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.content.IContent;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.content.AbstractContent;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:29:49 PM
 */
@Entity
@Table(name = "TAG")
@XStreamAlias("Tag")
public class Tag extends AbstractEntity implements ITag {
    private String name;
    private String value;
    private Collection<IContent> content;

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "CONTENT")
    @ManyToMany(targetEntity = AbstractContent.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<IContent> getContent() {
        return content;
    }

    public void setContent(Collection<IContent> content) {
        this.content = content;
    }
}