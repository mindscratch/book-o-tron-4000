package bookotron.model.exception;

import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.rental.ICheckOutReceipt;

/**
 * Thrown when an item is unable to be checked out.
 */
public class UnableToCheckInException extends AbstractRentalException {

    public UnableToCheckInException(String msg, ICheckOutReceipt receipt, ICheckOut checkOut) {
        super(msg, receipt, checkOut);
    }
}