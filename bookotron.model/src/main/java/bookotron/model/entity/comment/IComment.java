package bookotron.model.entity.comment;

import bookotron.model.entity.user.IUser;
import bookotron.model.entity.review.IReview;

/**
 * Date: May 19, 2009
 * Time: 10:18:14 PM
 */
public interface IComment {

    IUser getUser();
    void setUser(IUser value);

    IReview getReview();
    void setReview(IReview value);

}
