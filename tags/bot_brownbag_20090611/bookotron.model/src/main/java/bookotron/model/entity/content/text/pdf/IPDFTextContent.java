package bookotron.model.entity.content.text.pdf;

import bookotron.model.entity.content.text.ITextContent;

/**
 * Date: May 19, 2009
 * Time: 10:27:09 PM
 */
public interface IPDFTextContent extends ITextContent {

    long getFileSize();
    void setFileSize(long value);

}
