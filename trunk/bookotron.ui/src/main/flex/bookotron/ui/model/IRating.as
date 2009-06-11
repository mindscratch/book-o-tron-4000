package bookotron.ui.model {
public interface IRating extends IEntity {
    function get value():Number;
    function set value(value:Number):void;
    function get label():String;
    function set label(label:String):void;
}
}