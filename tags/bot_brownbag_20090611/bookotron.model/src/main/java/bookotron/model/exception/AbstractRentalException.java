package bookotron.model.exception;

import bookotron.model.entity.rental.ICheckOutReceipt;
import bookotron.model.entity.rental.ICheckOut;
import org.springframework.dao.DataAccessException;

/**
 * This type of exception is thrown when a problem occurs during a rental process (i.e. check-out, check-in).
 */
public abstract class AbstractRentalException extends DataAccessException {

    private ICheckOutReceipt receipt;
    private ICheckOut checkOut;

    public AbstractRentalException(String msg, ICheckOutReceipt receipt, ICheckOut checkOut) {
        super(msg);
        this.receipt = receipt;
        this.checkOut = checkOut;
    }

    public ICheckOutReceipt getReceipt() {
        return receipt;
    }

    /**
     * Returns the item that was attempting to be checked in.
     * @return
     */
    public ICheckOut getCheckOut() {
        return checkOut;
    }

}
