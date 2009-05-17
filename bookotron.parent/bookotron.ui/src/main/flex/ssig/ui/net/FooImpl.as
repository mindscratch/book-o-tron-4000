package ssig.ui.net {
public class FooImpl implements Foo{
    private var _name:String;
    private var _age:Number;
    public function FooImpl() {
    }

    public function set name(name:String):void {
        _name = name;
    }

    public function get name():String {
        return _name;
    }

    public function set age(age:Number):void {
        _age = age;
    }

    public function get age():Number {
        return _age;
    }

    public function kungFoo():String {
        return "KungFoo!";
    }
}
}