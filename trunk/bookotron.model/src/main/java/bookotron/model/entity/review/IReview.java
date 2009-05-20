package bookotron.model.entity.review;

import bookotron.model.entity.user.IUser;
import bookotron.model.entity.content.IContent;
import bookotron.model.entity.comment.IComment;

import java.util.Collection;

/**
 * Date: May 19, 2009
 * Time: 10:19:12 PM
 */
public interface IReview {

    IUser getUser();
    void setUser(IUser value);

    IContent getContent();
    void setContent(IContent value);

    String getText();
    void setText(String value);

    Collection<IComment> getComments();
    void setComments(Collection<IComment> value);
    
}
