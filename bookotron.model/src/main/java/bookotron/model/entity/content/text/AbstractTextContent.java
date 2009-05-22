package bookotron.model.entity.content.text;

import bookotron.model.entity.content.AbstractContent;

/**
 * Date: May 21, 2009
 * Time: 10:16:20 PM
 */
public abstract class AbstractTextContent extends AbstractContent implements ITextContent {
    private int numPages;

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}