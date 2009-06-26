package bookotron.ui.model {
public interface IISBN {

    function get value():String;
    function set value(value:String):void;

    function get textContent():ITextContent;
    function set textContent(textContent:ITextContent):void;
}
}