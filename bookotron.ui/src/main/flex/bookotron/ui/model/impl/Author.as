package bookotron.ui.model.impl {
import bookotron.ui.model.IAuthor;

import mx.collections.ListCollectionView;

import org.spicefactory.lib.xml.mapper.PropertyMapperBuilder;

public class Author extends BaseEntity implements IAuthor{

    private var _firstName:String;
    private var _lastName:String;
    private var _authored:ListCollectionView;

    [Embed(source="/assets/images/author_ico.png")]
    private var _authorIco:Class;

    public function Author() {
    }

    public function get firstName():String {
        return _firstName;
    }

    public function set firstName(firstName:String):void {
        _firstName = firstName;
    }

    public function get lastName():String {
        return _lastName;
    }

    public function set lastName(lastName:String):void {
        _lastName = lastName;
    }

    public function get fullName():String{
        return firstName + " " + lastName;
    }


    public function get authored():ListCollectionView {
        return _authored;
    }

    public function set authored(authored:ListCollectionView):void {
        _authored = authored;
    }

    public function get authorIco():Class{
        return _authorIco;
    }
}
}