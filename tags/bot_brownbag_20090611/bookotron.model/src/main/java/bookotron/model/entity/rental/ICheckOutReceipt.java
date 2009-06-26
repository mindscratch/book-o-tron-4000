package bookotron.model.entity.rental;

import bookotron.model.entity.IEntity;
import bookotron.model.entity.content.IContent;
import bookotron.model.entity.user.IUser;

import java.util.Collection;
import java.util.Map;
import java.util.Date;

public interface ICheckOutReceipt extends IEntity {

    Collection<ICheckOut> getCheckOuts();
    void setCheckOuts(Collection<ICheckOut> checkOuts);

    /**
     * Adds an item to be checked out.
     *
     * @param checkOut
     *
     * @return  true if the item was added, false otherwise
     */
    boolean addCheckOut(ICheckOut checkOut);

    /**
     * Removes the item from the check out list.
     *
     * @param checkOut
     *
     * @return  true if the item was removed, false otherwise
     */
    boolean removeCheckOut(ICheckOut checkOut);

    /**
     * Returns the {@code bookotron.model.entity.rental.ICheckOut} for the given content.
     *
     * @param content
     *
     * @return  the content or null if it can't be found.
     */
    ICheckOut getCheckOut(IContent content);

    IUser getUser();
    void setUser(IUser user);
}