package ssig.ui.bookotron.model {
import mx.collections.ListCollectionView;
public interface IContent {

    function get title():String;
    function set title(title:String):void;
    function get authors():ListCollectionView;
    function set authors(authors:ListCollectionView):void;
    function get pubDate():Date;
    function set pubDate(date:Date):void;
    function get tags():ListCollectionView;
    function set tags(tags:ListCollectionView):void;
    function get publisher():Publisher;
    function set publisher(publisher:Publisher):void;
    function get description():String;
    function set description(description:String):void;
    function get reviews():ListCollectionView;
    function set reviews(reviews:ListCollectionView):void;
    function get acquiredDate():Date;
    function set acquiredDate(date:Date):void;
    function get price():Number;
    function set price(price:Number):void;

}
}