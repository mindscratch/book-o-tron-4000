package bookotron.model.entity.review;

import bookotron.model.entity.AbstractEntity;
import bookotron.model.entity.comment.IComment;
import bookotron.model.entity.content.IContent;
import bookotron.model.entity.user.IUser;

import java.util.Collection;

/**
 * Date: May 21, 2009
 * Time: 10:27:44 PM
 */
public class BaseReview extends AbstractEntity implements IReview {

    private IUser user;
    private IContent content;
    private String text;
    private Collection<IComment> comments;

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public IContent getContent() {
        return content;
    }

    public void setContent(IContent content) {
        this.content = content;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Collection<IComment> getComments() {
        return comments;
    }

    public void setComments(Collection<IComment> comments) {
        this.comments = comments;
    }
}
