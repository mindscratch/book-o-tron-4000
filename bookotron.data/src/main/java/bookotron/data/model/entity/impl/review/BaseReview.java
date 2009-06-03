package bookotron.data.model.entity.impl.review;

import bookotron.model.entity.review.IReview;
import bookotron.model.entity.comment.IComment;
import bookotron.model.entity.content.IContent;
import bookotron.model.entity.user.IUser;
import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.comment.BaseComment;
import bookotron.data.model.entity.impl.content.AbstractContent;
import bookotron.data.model.entity.impl.user.BaseUser;

import javax.persistence.*;
import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:27:44 PM
 */
@Entity
@Table(name = "REVIEW")
public class BaseReview extends AbstractEntity implements IReview {

    private IUser user;
    private IContent content;
    private String text;
    private Collection<IComment> comments;

    @JoinColumn(name = "USER")
    @ManyToOne(targetEntity = BaseUser.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    @JoinColumn(name = "CONTENT")
    @ManyToOne(targetEntity = AbstractContent.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public IContent getContent() {
        return content;
    }

    public void setContent(IContent content) {
        this.content = content;
    }

    @Column(name = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JoinColumn(name = "COMMENTS")
    @OneToMany(targetEntity = BaseComment.class, cascade = CascadeType.ALL)
    public Collection<IComment> getComments() {
        return comments;
    }

    public void setComments(Collection<IComment> comments) {
        this.comments = comments;
    }
}