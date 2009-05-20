package ssig.ui.bookotron.model {
public class Comment extends BaseEntity{
    private var _user:User;
    private var _review:Review;

    public function Comment() {
        super();
    }

    public function get user():User {
        return _user;
    }

    public function set user(val:User):void {
        _user = val;
    }

    public function get review():Review {
        return _review;
    }

    public function set review(val:Review):void {
        _review = val;
    }
}
}