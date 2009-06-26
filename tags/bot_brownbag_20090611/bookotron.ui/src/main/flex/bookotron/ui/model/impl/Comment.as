package bookotron.ui.model.impl {
import bookotron.ui.model.*;

public class Comment extends BaseEntity implements IComment{
    private var _user:IUser;
    private var _review:IReview;

    public function Comment() {
        super();
    }

    public function get user():IUser {
        return _user;
    }

    public function set user(user:IUser):void {
        _user = user;
    }

    public function get review():IReview {
        return _review;
    }

    public function set review(review:IReview):void {
        _review = review;
    }
}
}