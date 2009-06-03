package bookotron.model.entity.user;

import bookotron.model.entity.IEntity;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.comment.IComment;

import java.util.Date;
import java.util.Collection;

/**
 * A user is someone who uses the application to add books, checkout books, update book details, etc.
 *
 * Date: May 19, 2009
 * Time: 10:08:22 PM
 */
public interface IUser extends IEntity {

    String getName();
    void setName(String value);

    String getEmail();
    void setEmail(String value);

    Date getLastLogin();
    void setLastLogin(Date value);
    
    Collection<IComment> getComments();
    void setComments(Collection<IComment> comments);

    Collection<IReview> getReviews();
    void setReviews(Collection<IReview> reviews);
}