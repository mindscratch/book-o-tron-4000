package ssig.ui.bookotron.model {
public class User extends BaseEntity{

    private var _name:String;
    private var _email:String;
    private var _lastLogin:Date;

    public function User(){
        super();
    }
    
    public function get name():String {
        return _name;
    }

    public function set name(val:String):void {
        _name = val;
    }

    public function get email():String {
        return _email;
    }

    public function set email(val:String):void {
        _email = val;
    }

    public function get lastLogin():Date {
        return _lastLogin;
    }

    public function set lastLogin(val:Date):void {
        _lastLogin = val;
    }
}
}