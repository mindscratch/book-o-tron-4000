package bookotron.ui.model.impl {

import bookotron.ui.model.IRating;

public class Rating extends BaseEntity implements IRating{

    private var _value:Number;
    private var _label:String;

    public function Rating() {
        super();
    }

    public function get value():Number {
        return _value;;
    }

    public function set value(value:Number):void {
        _value = value;
    }

    public function get label():String {
        return _label;
    }

    public function set label(label:String):void {
        _label = label;
    }
}
}