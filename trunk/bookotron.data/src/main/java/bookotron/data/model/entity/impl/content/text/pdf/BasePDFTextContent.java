package bookotron.data.model.entity.impl.content.text.pdf;

import bookotron.model.entity.content.text.pdf.IPDFTextContent;
import bookotron.data.model.entity.impl.content.text.AbstractTextContent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Date: May 21, 2009
 * Time: 10:17:28 PM
 */
@Entity
@Table(name = "PDF")
public class BasePDFTextContent extends AbstractTextContent implements IPDFTextContent {

    private long fileSize;

    @Column(name = "FILE_SIZE")
    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}