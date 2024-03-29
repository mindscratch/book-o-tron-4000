package bookotron.model.entity.content;

import bookotron.model.entity.author.IAuthor;
import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.IEntity;
import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.rental.ICheckOutReceipt;
import bookotron.model.entity.content.rating.IRating;
import bookotron.model.exception.UnableToCheckOutException;
import bookotron.model.exception.UnableToCheckInException;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Date: May 19, 2009
 * Time: 10:17:49 PM
 */
public interface IContent extends IEntity {

    ////////////////////////////////////////////
    // Properties
    /////////////////////////////////////////////

    String getTitle();
    void setTitle(String value);

    Collection<IAuthor> getAuthors();
    void setAuthors(Collection<IAuthor> value);

    Date getPublicationDate();
    void setPublicationDate(Date value);

    Collection<ITag> getTags();
    void setTags(Collection<ITag> value);

    IPublisher getPublisher();
    void setPublisher(IPublisher value);

    String getDescription();
    void setDescription(String value);

    Collection<IReview> getReviews();
    void setReviews(Collection<IReview> value);

    Date getAcquiredDate();
    void setAcquiredDate(Date value);

    float getPrice();
    void setPrice(float value);

    IRating getRating();
    void setRating(IRating rating);

    Collection<ICheckOutReceipt> getCheckOutReceipts();
    void setCheckOutReceipts(Collection<ICheckOutReceipt> checkOuts);

    /////////////////////////////////////////////
    // Behavior
    /////////////////////////////////////////////
    /**
     * Checks out this content and returns the receipt.
     *
     * @return
     */
    ICheckOutReceipt checkout(ICheckOutReceipt receipt) throws UnableToCheckOutException;

    /**
     * Checks in the book and returns the updated receipt
     * @param receipt
     * @return
     */
    ICheckOutReceipt checkin(ICheckOutReceipt receipt) throws UnableToCheckInException;
}
