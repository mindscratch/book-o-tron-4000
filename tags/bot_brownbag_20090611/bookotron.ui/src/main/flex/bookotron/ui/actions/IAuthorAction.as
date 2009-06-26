package bookotron.ui.actions {
import bookotron.ui.events.AuthorActionEvent;

public interface IAuthorAction{

    function createAuthor(ev:AuthorActionEvent):void;

    function retrieveAuthors(ev:AuthorActionEvent):void;

    function updateAuthor(ev:AuthorActionEvent):void;

    function deleteAuthor(ev:AuthorActionEvent):void;
}
}