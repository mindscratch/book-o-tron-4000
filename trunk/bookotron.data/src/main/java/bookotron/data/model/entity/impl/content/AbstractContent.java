package bookotron.data.model.entity.impl.content;

import bookotron.model.entity.content.IContent;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.author.IAuthor;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.review.BaseReview;
import bookotron.data.model.entity.impl.tag.BaseTag;
import bookotron.data.model.entity.impl.author.BaseAuthor;
import bookotron.data.model.entity.impl.publisher.BasePublisher;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Date: May 21, 2009
 * Time: 10:13:23 PM
 */

@Entity
@MappedSuperclass
public abstract class AbstractContent extends AbstractEntity implements IContent {

    private String title;
    private Collection<IAuthor> authors;
    private Date publicationDate;
    private Collection<ITag> tags;
    private IPublisher publisher;
    private String description;
    private Collection<IReview> reviews;
    private Date acquiredDate;
    private float price;

    @Column(name="TITLE", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JoinColumn(name="AUTHORS", nullable = false)
    @ManyToMany(targetEntity = BaseAuthor.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Collection<IAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<IAuthor> authors) {
        this.authors = authors;
    }

    @Column(name="PUB_DATE")
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @JoinColumn(name="TAGS")
    @ManyToMany(targetEntity = BaseTag.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Collection<ITag> getTags() {
        return tags;
    }

    public void setTags(Collection<ITag> tags) {
        this.tags = tags;
    }

    @JoinColumn(name="PUBLISHER")
    @ManyToOne(targetEntity = BasePublisher.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public IPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(IPublisher publisher) {
        this.publisher = publisher;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JoinColumn(name="REVIEWS")
    @ManyToMany(targetEntity = BaseReview.class, cascade = CascadeType.ALL)
    public Collection<IReview> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<IReview> reviews) {
        this.reviews = reviews;
    }

    @Column(name="ACQUIRED_DATE")
    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    @Column(name="PRICE")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}