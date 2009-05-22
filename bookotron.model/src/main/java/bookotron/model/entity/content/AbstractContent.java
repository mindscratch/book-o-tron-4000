package bookotron.model.entity.content;

import bookotron.model.entity.AbstractEntity;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.author.IAuthor;

import java.util.Collection;
import java.util.Date;

/**
 * Date: May 21, 2009
 * Time: 10:13:23 PM
 */
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<IAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<IAuthor> authors) {
        this.authors = authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Collection<ITag> getTags() {
        return tags;
    }

    public void setTags(Collection<ITag> tags) {
        this.tags = tags;
    }

    public IPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(IPublisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<IReview> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<IReview> reviews) {
        this.reviews = reviews;
    }

    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}