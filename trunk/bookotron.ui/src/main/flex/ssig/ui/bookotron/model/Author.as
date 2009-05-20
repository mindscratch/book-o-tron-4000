package ssig.ui.bookotron.model {
import mx.collections.ListCollectionView;
public class Author extends BaseEntity{

    private var _firstName:String;
    private var _lastName:String;
    private var _authored:ListCollectionView;

    public function Author() {
    }

    public function get firstName():String {
        return _firstName;
    }

    public function set firstName(val:String):void {
        _firstName = val;
    }

    public function get lastName():String {
        return _lastName;
    }

    public function set lastName(val:String):void {
        _lastName = val;
    }

    public function get authored():ListCollectionView {
        return _authored;
    }

    public function set authored(val:ListCollectionView):void {
        _authored = val;
    }
}
}