package bookotron.ui.model.impl {

import bookotron.ui.model.IComment;
import bookotron.ui.model.IReview;
import bookotron.ui.model.IUser;

import mx.collections.ListCollectionView;

public class User extends BaseEntity implements IUser{

    private var _name:String;
    private var _email:String;
    private var _lastLogin:Date;
    private var _comments:ListCollectionView;
    private var _reviews:ListCollectionView;

    public function User(){
        super();
    }
    
    public function get name():String {
        return _name;
    }

    public function set name(val:String):void {
        _name = val;
    }

    public function get email():String {
        return _email;
    }

    public function set email(val:String):void {
        _email = val;
    }

    public function get lastLogin():Date {
        return _lastLogin;
    }

    public function set lastLogin(val:Date):void {
        _lastLogin = val;
    }

    public function get comments():ListCollectionView {
        return _comments;
    }

    public function get reviews():ListCollectionView {
        return _reviews;
    }

    public function addComment(comment:IComment):void {
        _comments.addItem(comment);
    }

    public function addReview(review:IReview):void {
        _reviews.addItem(review);
    }
}
}