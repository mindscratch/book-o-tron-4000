package bookotron.ui.model {
import mx.collections.ListCollectionView;

public interface IBookTextContent extends ITextContent{

    function get ISBNs():ListCollectionView;
    function set ISBNs(isbns:ListCollectionView):void;
    function get edition():String;
    function set edition(edition:String):void;
}
}