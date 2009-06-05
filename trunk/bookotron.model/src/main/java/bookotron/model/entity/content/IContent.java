package bookotron.model.entity.content;

import bookotron.model.entity.author.IAuthor;
import bookotron.model.entity.tag.ITag;
import bookotron.model.entity.publisher.IPublisher;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.IEntity;
import bookotron.model.entity.content.rating.IRating;

import java.util.Collection;
import java.util.Date;

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

    /////////////////////////////////////////////
    // Behavior
    /////////////////////////////////////////////
//    void checkout();               //TODO provide some sort of Checkout token
//    void checkin();
}
