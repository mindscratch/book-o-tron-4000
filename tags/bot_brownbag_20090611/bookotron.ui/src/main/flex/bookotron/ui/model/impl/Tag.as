package bookotron.ui.model.impl {
import bookotron.ui.model.ITag;

import mx.collections.ListCollectionView;

public class Tag extends BaseEntity implements ITag{

    private var _name:String;
    private var _value:String;
    private var _content:ListCollectionView;

    public function Tag() {
        super();
    }
    
    public function get name():String {
        return _name;
    }

    public function set name(val:String):void {
        _name = val;
    }

    public function get value():String {
        return _value;
    }

    public function set value(val:String):void {
        _value = val;
    }

    public function get content():ListCollectionView {
        return _content;
    }

    public function set content(content:ListCollectionView):void {
        _content = content;
    }

}
}