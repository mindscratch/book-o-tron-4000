package bookotron.ui.model.impl {
import bookotron.ui.model.*;

import mx.collections.ListCollectionView;

public class Review extends BaseEntity implements IReview{

    private var _user:IUser;
    private var _book:BookTextContent;
    private var _text:String;
    private var _comments:ListCollectionView;
    private var _content:IContent;
    
    public function Review() {
        super();
    }

    public function get user():IUser {
        return _user;
    }

    public function set user(val:IUser):void {
        _user = val;
    }

    public function get book():BookTextContent {
        return _book;
    }

    public function set book(val:BookTextContent):void {
        _book = val;
    }

    public function get text():String {
        return text;
    }

    public function set text(val:String):void {
        text = val;
    }

    public function get comments():ListCollectionView {
        return _comments;
    }

    public function set comments(val:ListCollectionView):void {
        _comments = val;
    }

    public function get content():IContent {
        return _content;
    }

    public function set content(content:IContent):void {
        _content = content;
    }
}
}