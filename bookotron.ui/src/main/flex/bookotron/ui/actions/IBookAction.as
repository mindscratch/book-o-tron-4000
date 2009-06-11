package bookotron.ui.actions {
import bookotron.ui.model.IBookTextContent;

public interface IBookAction {

    function registerBook(book:IBookTextContent):void;

    function unregisterBook(book:IBookTextContent):void;
}
}