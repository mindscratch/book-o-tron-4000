package bookotron.ui.model {
public class ISBN extends BaseEntity{

    private var _value:String;

    public function ISBN() {
        super();
    }
    
    public function get value():String {
        return _value;
    }

    public function set value(val:String):void {
        _value = val;
    }
}
}