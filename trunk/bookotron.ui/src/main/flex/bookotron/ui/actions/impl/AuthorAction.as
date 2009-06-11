package bookotron.ui.actions.impl {
import bookotron.ui.actions.IAuthorAction;
import bookotron.ui.events.AuthorActionEvent;
import bookotron.ui.model.IAuthor;
import bookotron.ui.model.impl.Author;
import bookotron.ui.view.vo.AuthorsVo;

import mx.logging.ILogger;
import mx.logging.Log;

[Event(name="authorCreated",type="bookotron.ui.events.AuthorActionEvent")]
[Event(name="authorsRetrieved",type="bookotron.ui.events.AuthorActionEvent")]
[Event(name="authorUpdated",type="bookotron.ui.events.AuthorActionEvent")]
[Event(name="authorDeleted",type="bookotron.ui.events.AuthorActionEvent")]

[ManagedEvents("authorCreated,authorsRetrieved,authorUpdated,authorDeleted")]

public class AuthorAction extends BaseRestAction implements IAuthorAction{

    private static const logger:ILogger = Log.getLogger("AuthorAction");

    private var _authorsVo:AuthorsVo;

    // injected
    [Inject]
    public function set authorsVo(authorsVo:AuthorsVo):void{
        logger.info("injecting AuthorsVo");
        _authorsVo = authorsVo;
    }

    // message handlers

    [MessageHandler(selector="createAuthor")]
    public function createAuthor(ev:AuthorActionEvent):void {
        //var author:IAuthor = ev.author;

        logger.info("creating author");

        // TODO: service call
        dispatchEvent(new AuthorActionEvent(AuthorActionEvent.AUTHOR_CREATED, new Author()));
    }

    [MessageHandler(selector="retrieveAuthors")]
    public function retrieveAuthors(ev:AuthorActionEvent):void {
        logger.info("retrieving authors");
        // TODO: service call
        dispatchEvent(new AuthorActionEvent(AuthorActionEvent.AUTHORS_RETRIEVED, null,[]));
    }

    [MessageHandler(selector="updateAuthor")]
    public function updateAuthor(ev:AuthorActionEvent):void {
        var author:IAuthor = ev.author;
        logger.info("updating author " + author.id);
        dispatchEvent(new AuthorActionEvent(AuthorActionEvent.AUTHOR_UPDATED, author));
    }

    [MessageHandler(selector="deleteAuthor")]
    public function deleteAuthor(ev:AuthorActionEvent):void {
        var author:IAuthor = ev.author;
        logger.info("deleting author " + author.id);
        dispatchEvent(new AuthorActionEvent(AuthorActionEvent.AUTHOR_DELETED, author));
    }
}
}