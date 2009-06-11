package bookotron.ui.events {
import bookotron.ui.model.IAuthor;

import flash.events.Event;

public class AuthorActionEvent extends Event{

    public static const CREATE_AUTHOR:String = "createAuthor";
    public static const AUTHOR_CREATED:String = "authorCreated";

    public static const RETRIEVE_AUTHORS:String = "retrieveAuthors";
    public static const AUTHORS_RETRIEVED:String = "authorsRetrieved";

    public static const UPDATE_AUTHOR:String = "updateAuthor";
    public static const AUTHOR_UPDATED:String = "authorUpdated";

    public static const DELETE_AUTHOR:String = "deleteAuthor";
    public static const AUTHOR_DELETED:String = "authorDeleted";

    private var _author:IAuthor;
    private var _authors:Array;

    public function AuthorActionEvent(type:String, author:IAuthor=null, authors:Array=null, bubbles:Boolean=false, cancelable:Boolean=false){
        super(type, bubbles, cancelable);
        _author = author;
        _authors = authors;
    }

    public function get author():IAuthor{
        return _author;
    }

    public function get authors():Array{
        return _authors;
    }

    public override function clone():Event{
        return new AuthorActionEvent(type, _author, _authors, bubbles, cancelable);
    }

}
}