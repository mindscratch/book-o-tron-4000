package ssig.ui.bookotron.model {

import mx.collections.ListCollectionView;

public class BaseContent implements IContent{

    private var _title:String;
    private var _authors:ListCollectionView;
    private var _pubDate:Date;
    private var _tags:ListCollectionView;
    private var _publisher:Publisher;
    private var _description:String;
    private var _reviews:ListCollectionView;
    private var _acquiredDate:Date;
    private var _price:Number;

    public function BaseContent() {
    }
    
    public function get title():String {
        return _title;
    }

    public function set title(val:String):void {
        _title = val;
    }

    public function get authors():ListCollectionView {
        return _authors;
    }

    public function set authors(val:ListCollectionView):void {
        _authors = val;
    }

    public function get pubDate():Date {
        return _pubDate;
    }

    public function set pubDate(val:Date):void {
        _pubDate = val;
    }

    public function get tags():ListCollectionView {
        return _tags;
    }

    public function set tags(val:ListCollectionView):void {
        _tags = val;
    }

    public function get publisher():Publisher {
        return _publisher;
    }

    public function set publisher(val:Publisher):void {
        _publisher = val;
    }

    public function get description():String {
        return _description;
    }

    public function set description(val:String):void {
        _description = val;
    }

    public function get reviews():ListCollectionView {
        return _reviews;
    }

    public function set reviews(val:ListCollectionView):void {
        _reviews = val;
    }

    public function get acquiredDate():Date {
        return _acquiredDate;
    }

    public function set acquiredDate(val:Date):void {
        _acquiredDate = val;
    }

    public function get price():Number {
        return _price;
    }

    public function set price(val:Number):void {
        _price = val;
    }
}
}