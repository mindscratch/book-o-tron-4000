package bookotron.ui.actions.impl {
import bookotron.ui.actions.IAuthorAction;
import bookotron.ui.events.AuthorActionEvent;
import bookotron.ui.model.IAuthor;
import bookotron.ui.model.impl.Author;
import bookotron.ui.net.rest.RestService;
import bookotron.ui.util.mappers.AuthorMapper;
import bookotron.ui.view.vo.AuthorsVo;

import mx.logging.ILogger;
import mx.logging.Log;
import mx.utils.UIDUtil;

[Event(name="authorCreated",type="bookotron.ui.events.AuthorActionEvent")]
[Event(name="authorsRetrieved",type="bookotron.ui.events.AuthorActionEvent")]
[Event(name="authorUpdated",type="bookotron.ui.events.AuthorActionEvent")]
[Event(name="authorDeleted",type="bookotron.ui.events.AuthorActionEvent")]

[ManagedEvents("authorCreated,authorsRetrieved,authorUpdated,authorDeleted")]

public class AuthorAction extends BaseRestAction implements IAuthorAction{

    private static const logger:ILogger = Log.getLogger("AuthorAction");

    private var _authorsVo:AuthorsVo;

    private var _authorMapper:AuthorMapper;

    // injected
    [Inject]
    public function set authorsVo(authorsVo:AuthorsVo):void{
        logger.info("injecting AuthorsVo");
        _authorsVo = authorsVo;
    }

    [Inject]
    public function set authorMapper(authorMapper:AuthorMapper){
        logger.info("injecting AuthorsMapper");
        _authorMapper = authorMapper;
    }

    // message handlers

    [MessageHandler(selector="createAuthor")]
    public function createAuthor(ev:AuthorActionEvent):void {
        var author:IAuthor = new Author();
        author.firstName = "Sean";
        author.lastName = "Monaghan";

        logger.info("creating author");

        _authorsVo.addAuthor(author);

        var xml:XML = _authorMapper.toXml(author);

        // TODO: service call
        //_restService.doRestCall("rs/author/");

        dispatchEvent(new AuthorActionEvent(AuthorActionEvent.AUTHOR_CREATED, author));
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