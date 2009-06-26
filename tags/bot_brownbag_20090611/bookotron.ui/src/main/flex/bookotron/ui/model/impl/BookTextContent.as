package bookotron.ui.model.impl {
import bookotron.ui.model.IBookTextContent;

import mx.collections.ListCollectionView;

public class BookTextContent extends BaseTextContent implements IBookTextContent{

    private var _isbns:ListCollectionView;
    private var _edition:String;

    public function BookTextContent() {
        super();
    }

    public function get edition():String {
        return _edition;
    }

    public function set edition(edition:String):void {
        _edition = edition;
    }

    public function get ISBNs():ListCollectionView {
        return _isbns;
    }

    public function set ISBNs(isbns:ListCollectionView):void {
        _isbns = isbns;
    }
}
}