package bookotron.model.entity.comment;

import bookotron.model.entity.user.IUser;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.IEntity;

/**
 * Date: May 19, 2009
 * Time: 10:18:14 PM
 */
public interface IComment extends IEntity {

    IUser getUser();
    void setUser(IUser value);

    IReview getReview();
    void setReview(IReview value);

}
