package bookotron.model.entity.comment;

import bookotron.model.entity.AbstractEntity;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.user.IUser;

/**
 * Date: May 21, 2009
 * Time: 10:11:05 PM
 */
public class BaseComment extends AbstractEntity implements IComment {
    private IUser user;
    private IReview review;

    /**
     * @return  the {@link bookotron.model.entity.user.IUser} who wrote the comment.
     */
    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    /**
     * @return  the {@link bookotron.model.entity.review.IReview} that the comment was written for.
     */
    public IReview getReview() {
        return review;
    }

    public void setReview(IReview review) {
        this.review = review;
    }
}
