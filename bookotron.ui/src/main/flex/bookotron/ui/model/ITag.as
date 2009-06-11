package bookotron.ui.model {
import mx.collections.ListCollectionView;

public interface ITag extends IEntity{

    function get name():String;
    function set name(name:String):void;

    function get value():String;
    function set value(value:String):void;

    function get content():ListCollectionView;
    function set content(content:ListCollectionView):void;
}
}