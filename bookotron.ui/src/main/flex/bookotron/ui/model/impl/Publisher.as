package bookotron.ui.model.impl {
import bookotron.ui.model.IPublisher;

import mx.collections.ListCollectionView;

public class Publisher extends BaseEntity implements IPublisher{

    private var _name:String;
    private var _website:String;
    private var _content:ListCollectionView;

    public function Publisher() {
        super();
    }
    
    public function get name():String {
        return _name;
    }

    public function set name(val:String):void {
        _name = val;
    }

    public function get website():String {
        return _website;
    }

    public function set website(val:String):void {
        _website = val;
    }


    public function get content():ListCollectionView {
        return _content;
    }

    public function set content(content:ListCollectionView):void {
        _content = content;
    }
}
}