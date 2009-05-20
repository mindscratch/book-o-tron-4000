package bookotron.ui.model {
public class Publisher extends BaseEntity{

    private var _name:String;
    private var _website:String;

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

}
}