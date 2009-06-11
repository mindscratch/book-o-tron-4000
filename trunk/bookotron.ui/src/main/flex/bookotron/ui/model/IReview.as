package bookotron.ui.model {
import mx.collections.ListCollectionView;

public interface IReview extends IEntity{

    function get user():IUser;
    function set user(user:IUser):void;

    function get content():IContent;
    function set content(content:IContent):void;

    function get text():String;
    function set text(text:String):void;

    function get comments():ListCollectionView;
    function set comments(comments:ListCollectionView):void;
}
}