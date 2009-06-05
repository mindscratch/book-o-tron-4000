package bookotron.data.model.entity.impl.content;

import bookotron.model.entity.content.IContent;
import bookotron.model.entity.content.rating.IRating;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.author.IAuthor;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.review.Review;
import bookotron.data.model.entity.impl.tag.Tag;
import bookotron.data.model.entity.impl.author.Author;
import bookotron.data.model.entity.impl.publisher.Publisher;

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
    private IRating rating;

    @Column(name="TITLE", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JoinColumn(name="AUTHORS", nullable = false)
    @ManyToMany(targetEntity = Author.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
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
    @ManyToMany(targetEntity = Tag.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Collection<ITag> getTags() {
        return tags;
    }

    public void setTags(Collection<ITag> tags) {
        this.tags = tags;
    }

    @JoinColumn(name="PUBLISHER")
    @ManyToOne(targetEntity = Publisher.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
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
    @ManyToMany(targetEntity = Review.class, cascade = CascadeType.ALL)
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

    @Column(name="RATING")
    public IRating getRating() {
        return rating;
    }

    public void setRating(IRating rating) {
        this.rating = rating;
    }
}