package ssig.ui.bookotron.model {
public class Tag extends BaseEntity{

    private var _name:String;
    private var _value:String;

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

}
}