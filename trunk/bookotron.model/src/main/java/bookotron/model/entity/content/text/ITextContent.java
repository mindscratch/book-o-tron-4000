package bookotron.model.entity.content.text;

import bookotron.model.entity.content.IContent;

/**
 * Date: May 19, 2009
 * Time: 10:24:50 PM
 */
public interface ITextContent extends IContent {

    int getNumPages();
    void setNumPages(int value);

}