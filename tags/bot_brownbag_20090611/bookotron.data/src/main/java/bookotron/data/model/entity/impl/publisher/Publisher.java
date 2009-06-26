package bookotron.data.model.entity.impl.publisher;

import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.content.IContent;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.content.AbstractContent;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:26:44 PM
 */
@Entity
@Table(name = "PUBLISHER")
@XStreamAlias("Publisher")
public class Publisher extends AbstractEntity implements IPublisher {
    private String name;
    private String website;
    private Collection<IContent> content;

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "WEBSITE")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @JoinColumn(name = "CONTENT")
    @OneToMany(targetEntity = AbstractContent.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Collection<IContent> getContent() {
        return content;
    }

    public void setContent(Collection<IContent> content) {
        this.content = content;
    }
}