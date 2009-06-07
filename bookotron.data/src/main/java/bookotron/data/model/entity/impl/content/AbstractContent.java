package bookotron.data.model.entity.impl.content;

import bookotron.model.entity.content.IContent;
import bookotron.model.entity.content.rating.IRating;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.author.IAuthor;
import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.rental.ICheckOutReceipt;
import bookotron.model.exception.UnableToCheckOutException;
import bookotron.model.exception.UnableToCheckInException;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.rental.CheckOut;
import bookotron.data.model.entity.impl.rental.CheckOutReceipt;
import bookotron.data.model.entity.impl.review.Review;
import bookotron.data.model.entity.impl.tag.Tag;
import bookotron.data.model.entity.impl.author.Author;
import bookotron.data.model.entity.impl.publisher.Publisher;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Date: May 21, 2009
 * Time: 10:13:23 PM
 */

@Entity
@Table(name = "BASE_CONTENT")
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
    private Collection<ICheckOutReceipt> checkOutReceipts;

    public AbstractContent() {
        setAuthors(new ArrayList<IAuthor>());
        setTags(new ArrayList<ITag>());
        setReviews(new ArrayList<IReview>());
        setCheckOutReceipts(new ArrayList<ICheckOutReceipt>());
    }

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
        if (authors == null) {
            authors = new ArrayList<IAuthor>();
        }
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
        if (tags == null) {
            tags = new ArrayList<ITag>();
        }
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
        if (reviews == null) {
            reviews = new ArrayList<IReview>();
        }
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

    @JoinColumn(name = "CHECK_OUT_RECEIPTS")
    @ManyToMany(targetEntity = CheckOutReceipt.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<ICheckOutReceipt> getCheckOutReceipts() {
        return checkOutReceipts;
    }

    public void setCheckOutReceipts(Collection<ICheckOutReceipt> checkOutReceipts) {
        if (checkOutReceipts == null) {
            checkOutReceipts = new ArrayList<ICheckOutReceipt>();
        }
        this.checkOutReceipts = checkOutReceipts;
    }

    /**
     * Checks out this content.
     *
     * @param receipt
     * @return
     *
     * @throws UnableToCheckOutException    if the content is not able to be checked out
     * @throw java.lang.IllegalArgumentException if receipt is null
     */
    public ICheckOutReceipt checkout(ICheckOutReceipt receipt) throws UnableToCheckOutException {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt can not be null during checkout of content.");
        }

        // prevent the content from being checked out multiple times on the same receipt
        if (isContentAlreadyInReceipt(receipt)) {
            throw new UnableToCheckOutException("Content [id=" + getId() + ", title=" + getTitle() + "] is already on the receipt.", receipt, receipt.getCheckOut(this));
        }

        // make sure this content is not already checked out
        if (isContentAlreadyCheckedOut()) {
            throw new UnableToCheckOutException("Content [id=" + getId() + ", title=" + getTitle() + "] is already checked out.", receipt, null);
        }

        final ICheckOut checkOut = new CheckOut();
        checkOut.setContent(this);

        // 14 day checkout period
        final Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, 14);
        checkOut.setDueDate(now.getTime());

        boolean added = receipt.addCheckOut(checkOut);
        if (!added) {
            throw new UnableToCheckOutException("Unable to add content to check-out receipt", receipt, checkOut);
        }

        checkOutReceipts.add(receipt);

        return receipt;
    }

    protected boolean isContentAlreadyInReceipt(ICheckOutReceipt receipt) {
        if (receipt == null) {
            return false;
        }

        final ICheckOut checkOut = receipt.getCheckOut(this);
        if (checkOut != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Transient // marked Transient b/c JPA believes it's a property
    protected boolean isContentAlreadyCheckedOut() {
        return (checkOutReceipts != null && checkOutReceipts.size() > 0);
    }

    /**
     * Checks in this content.
     *
     * @param receipt
     * @return
     *
     * @throws UnableToCheckInException if the content can not be checked in
     * @throws IllegalArgumentException if receipt is null
     */
    public ICheckOutReceipt checkin(ICheckOutReceipt receipt) throws UnableToCheckInException {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt can not be null during checkin of content.");
        }

        ICheckOut checkOut = receipt.getCheckOut(this);
        if (checkOut == null) {
            throw new UnableToCheckInException("Unable to identify a check-out record for content=" + this, receipt, null);
        }

        // remove the receipt from our list
        if (checkOutReceipts.contains(receipt)) {
            checkOutReceipts.remove(receipt);
        }

        boolean removed = receipt.removeCheckOut(checkOut);
        if (!removed) {
            throw new UnableToCheckInException("Unable to check-in content, content=" + this, receipt, checkOut);
        }

        return receipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractContent that = (AbstractContent) o;

        if (!authors.equals(that.authors)) return false;
        if (!publicationDate.equals(that.publicationDate)) return false;
        if (!title.equals(that.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + publicationDate.hashCode();
        return result;
    }
}