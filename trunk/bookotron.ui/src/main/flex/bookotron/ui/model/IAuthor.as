package bookotron.ui.model {
import mx.collections.ListCollectionView;

public interface IAuthor extends IEntity{

    function get firstName():String;
    function set firstName(firstName:String):void;

    function get lastName():String;
    function set lastName(lastName:String):void;

    function get authored():ListCollectionView;
    function set authored(authored:ListCollectionView):void;
}
}