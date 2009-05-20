package bookotron.ui.model {
public class BaseTextContent extends BaseContent implements ITextContent{

    private var _numPages:int;

    public function BaseTextContent() {
    }

    public function get numPages():int {
        return _numPages;
    }

    public function set numPages(numPages:int):void {
        _numPages = numPages;
    }
}
}