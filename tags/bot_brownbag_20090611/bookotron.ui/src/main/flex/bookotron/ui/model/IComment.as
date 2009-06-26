package bookotron.ui.model {
public interface IComment extends IEntity{

    function get user():IUser;
    function set user(user:IUser):void;

    function get review():IReview;
    function set review(review:IReview):void;
}
}