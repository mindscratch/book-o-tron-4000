package bookotron.data.model.entity.impl.user;

import bookotron.model.entity.user.IUser;
import bookotron.model.entity.review.IReview;
import bookotron.model.entity.comment.IComment;
import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.rental.ICheckOutReceipt;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.rental.CheckOut;
import bookotron.data.model.entity.impl.rental.CheckOutReceipt;
import bookotron.data.model.entity.impl.comment.Comment;
import bookotron.data.model.entity.impl.review.Review;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Date;
import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:31:07 PM
 */
@Entity
@Table(name="USER")
@XStreamAlias("User")
public class User extends AbstractEntity implements IUser {
    private String name;
    private String email;
    private Date lastLogin;
    private Collection<IComment> comments;
    private Collection<IReview> reviews;
    private Collection<ICheckOutReceipt> checkOutReceipts;

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
    @OneToMany(targetEntity = Comment.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<IComment> getComments() {
        return comments;
    }

    public void setComments(Collection<IComment> comments) {
        this.comments = comments;
    }

    @JoinColumn(name = "REVIEWS")
    @OneToMany(targetEntity = Review.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<IReview> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<IReview> reviews) {
        this.reviews = reviews;
    }

    @JoinColumn(name = "CHECK_OUT_RECEIPTS")
    @OneToMany(targetEntity = CheckOutReceipt.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<ICheckOutReceipt> getCheckOutReceipts() {
        return checkOutReceipts;
    }

    public void setCheckOutReceipts(Collection<ICheckOutReceipt> checkOutReceipts) {
        this.checkOutReceipts = checkOutReceipts;
    }
}