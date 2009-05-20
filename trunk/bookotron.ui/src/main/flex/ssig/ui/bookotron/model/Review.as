package ssig.ui.bookotron.model {
import mx.collections.ListCollectionView;
public class Review extends BaseEntity{

    private var _user:User;
    private var _book:Book;
    private var _text:String;
    private var _comments:ListCollectionView;
    
    public function Review() {
        super();
    }

    public function get user():User {
        return _user;
    }

    public function set user(val:User):void {
        _user = val;
    }

    public function get book():Book {
        return _book;
    }

    public function set book(val:Book):void {
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
}
}