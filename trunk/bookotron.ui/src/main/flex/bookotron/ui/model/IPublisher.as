package bookotron.ui.model {
import mx.collections.ListCollectionView;

public interface IPublisher extends IEntity{

    function get name():String;
    function set name(name:String):void;

    function get website():String;
    function set website(website:String):void;

    function get content():ListCollectionView;
    function set content(content:ListCollectionView):void;
}
}