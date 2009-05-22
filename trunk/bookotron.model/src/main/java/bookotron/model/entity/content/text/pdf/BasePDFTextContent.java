package bookotron.model.entity.content.text.pdf;

import bookotron.model.entity.content.text.AbstractTextContent;

/**
 * Date: May 21, 2009
 * Time: 10:17:28 PM
 */
public class BasePDFTextContent extends AbstractTextContent implements IPDFTextContent {

    private long fileSize;

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}