package bookotron.model.exception;

import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.rental.ICheckOutReceipt;

/**
 * Thrown when an item is unable to be checked out.
 */
public class UnableToCheckOutException extends AbstractRentalException {

    public UnableToCheckOutException(String msg, ICheckOutReceipt receipt, ICheckOut checkOut) {
        super(msg, receipt, checkOut);
    }
}
