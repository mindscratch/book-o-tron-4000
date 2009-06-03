package bookotron.data.model.entity.impl.user;

import bookotron.model.entity.user.IUser;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.comment.IComment;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.comment.BaseComment;
import bookotron.data.model.entity.impl.review.BaseReview;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:31:07 PM
 */
@Entity
@Table(name="USER")
public class BaseUser extends AbstractEntity implements IUser {
    private String name;
    private String email;
    private Date lastLogin;
    private Collection<IComment> comments;
    private Collection<IReview> reviews;

    @Column(name="NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "LAST_LOGIN")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JoinColumn(name = "COMMENTS")
    @OneToMany(targetEntity = BaseComment.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<IComment> getComments() {
        return comments;
    }

    public void setComments(Collection<IComment> comments) {
        this.comments = comments;
    }

    @JoinColumn(name = "REVIEWS")
    @OneToMany(targetEntity = BaseReview.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<IReview> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<IReview> reviews) {
        this.reviews = reviews;
    }
}