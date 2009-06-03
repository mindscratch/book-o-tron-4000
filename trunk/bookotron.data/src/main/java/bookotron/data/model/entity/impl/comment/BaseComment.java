package bookotron.data.model.entity.impl.comment;

import bookotron.model.entity.comment.IComment;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.user.IUser;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.review.BaseReview;

import javax.persistence.*;

/**
 * Date: May 21, 2009
 * Time: 10:11:05 PM
 */
@Entity
@Table(name="COMMENT")
public class BaseComment extends AbstractEntity implements IComment {
    private IUser user;
    private IReview review;

    /**
     * @return  the {@link bookotron.model.entity.user.IUser} who wrote the comment.
     */
    @Column(name="USER")
    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    /**
     * @return  the {@link bookotron.model.entity.review.IReview} that the comment was written for.
     */
    @JoinColumn(name="REVIEW")
    @ManyToOne(targetEntity = BaseReview.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public IReview getReview() {
        return review;
    }

    public void setReview(IReview review) {
        this.review = review;
    }
}