package bookotron.ui.model {
import mx.collections.ListCollectionView;
public class Book extends BaseTextContent{

    private var _isbns:ListCollectionView;
    private var _edition:String;

    public function Book() {
        super();
    }

    public function get isbns():ListCollectionView {
        return _isbns;
    }

    public function set isbns(val:ListCollectionView):void {
        _isbns = val;
    }

    public function get edition():String {
        return _edition;
    }

    public function set edition(val:String):void {
        _edition = val;
    }
}
}