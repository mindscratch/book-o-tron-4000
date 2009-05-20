package ssig.ui.bookotron.model {
public class Pdf extends BaseTextContent{

    private var _fileSize:Number;

    public function Pdf() {
        super();
    }

    public function get fileSize():Number {
        return _fileSize;
    }

    public function set fileSize(val:Number):void {
        _fileSize = val;
    }
}
}