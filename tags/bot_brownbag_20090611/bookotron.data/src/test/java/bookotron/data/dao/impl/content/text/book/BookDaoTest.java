package bookotron.data.dao.impl.content.text.book;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import bookotron.model.entity.rental.ICheckOutReceipt;
import bookotron.model.entity.content.text.book.IBookTextContent;
import bookotron.model.exception.UnableToCheckOutException;
import bookotron.model.exception.UnableToCheckInException;
import bookotron.model.exception.AbstractRentalException;
import bookotron.data.model.entity.impl.rental.CheckOutReceipt;
import bookotron.data.dao.IBaseDao;
import bookotron.data.dao.impl.author.AuthorDaoTest;
import bookotron.data.dao.impl.AbstractDaoTest;
import static org.junit.Assert.*;

import javax.annotation.Resource;

public class BookDaoTest extends AbstractDaoTest {

    private static final Log log = LogFactory.getLog(BookDaoTest.class);

    // JSR-250: Common Annotations for Java
    @Resource
    private IBaseDao<IBookTextContent> bookDao;

    // this would fail
//    @Resource
//    private IBaseDao<IBookTextContent> someDao;

    @Autowired
    @Qualifier("checkOutReceiptDao")
    private IBaseDao<ICheckOutReceipt> coReceiptDao;

    @Override
    protected List<String> getTestDataClassNames() {
        final List<String> names = super.getTestDataClassNames();
        names.add(AuthorDaoTest.class.getSimpleName());
        return names;
    }

    @Test
    public void testCheckOut() throws AbstractRentalException {
        IBookTextContent book = bookDao.find(1);
        checkOutBook(book);

        // save changes
        book = bookDao.update(book);
        assertEquals("Expected the book to be checked out once", 1, book.getCheckOutReceipts().size());
    }

    @Test
    public void testCheckIn() throws AbstractRentalException {
        IBookTextContent book = bookDao.find(1);
        ICheckOutReceipt receipt = checkOutBook(book);

        receipt = book.checkin(receipt);
        assertNotNull(receipt);
        assertEquals("Expected the receipt to have 0 check-outs", 0, receipt.getCheckOuts().size());
        assertEquals("Expected the book to no longer be checked out", 0, book.getCheckOutReceipts().size());
    }

    /**
     * Verify a single book can not be checked out twice on the same receipt
     */
    @Test(expected = UnableToCheckOutException.class)
    public void testDuplicateCheckOutAttempt() {
        IBookTextContent book = bookDao.find(1);
        ICheckOutReceipt receipt = checkOutBook(book);

        // try to add the same book to the receipt again
        receipt = book.checkout(receipt);
    }

    /**
     * Verify a book can not be checked out more than once
     */
    @Test(expected = UnableToCheckOutException.class)
    public void testAlreadyCheckedOut() {
        IBookTextContent book = bookDao.find(1);
        ICheckOutReceipt receipt = checkOutBook(book);

        // save the book and its checkout
        book = bookDao.update(book);

        // try to re-checkout the book
        checkOutBook(book);
    }

    private ICheckOutReceipt checkOutBook(IBookTextContent book) throws AbstractRentalException {
        assertNotNull("Expected a non-null book for check-out", book);

        ICheckOutReceipt receipt = new CheckOutReceipt();
        receipt = book.checkout(receipt);
        assertNotNull(receipt);

        return receipt;
    }
}
