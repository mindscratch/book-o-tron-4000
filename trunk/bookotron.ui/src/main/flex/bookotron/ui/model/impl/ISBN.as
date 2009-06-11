package bookotron.ui.model.impl {
import bookotron.ui.model.IISBN;
import bookotron.ui.model.ITextContent;

public class ISBN extends BaseEntity implements IISBN{

    private var _value:String;
    private var _textConent:ITextContent;

    public function ISBN() {
        super();
    }
    
    public function get value():String {
        return _value;
    }

    public function set value(val:String):void {
        _value = val;
    }


    public function get textContent():ITextContent {
        return _textConent;
    }

    public function set textContent(textContent:ITextContent):void {
        _textConent = textContent;
    }
}
}