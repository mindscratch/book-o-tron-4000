package bookotron.ui.model {
import mx.collections.ListCollectionView;

public interface IUser extends IEntity{
    function get name():String;
    function set name(name:String):void;

    function get email():String;
    function set email(email:String):void;

    function get lastLogin():Date;
    function set lastLogin(lastLogin:Date):void;

    function get comments():ListCollectionView;
    function addComment(comment:IComment):void;

    function get reviews():ListCollectionView;
    function addReview(review:IReview):void;
}
}