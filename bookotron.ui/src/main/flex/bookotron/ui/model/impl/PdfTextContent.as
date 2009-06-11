package bookotron.ui.model.impl {
import bookotron.ui.model.IPDFTextContent;

public class PdfTextContent extends BaseTextContent implements IPDFTextContent{

    private var _fileSize:Number;

    public function PdfTextContent() {
        super();
    }

    public function get fileSize():Number {
        return _fileSize;
    }

    public function set fileSize(fileSize:Number):void {
        _fileSize = fileSize;
    }
}
}