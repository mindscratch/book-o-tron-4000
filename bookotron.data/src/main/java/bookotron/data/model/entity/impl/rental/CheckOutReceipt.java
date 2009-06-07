package bookotron.data.model.entity.impl.rental;

import bookotron.data.model.entity.impl.AbstractEntity;
import bookotron.data.model.entity.impl.user.User;
import bookotron.model.entity.rental.ICheckOut;
import bookotron.model.entity.rental.ICheckOutReceipt;
import bookotron.model.entity.content.IContent;
import bookotron.model.entity.user.IUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "CHECK_OUT_RECEIPT")
public class CheckOutReceipt extends AbstractEntity implements ICheckOutReceipt {

    private Collection<ICheckOut> checkOuts;
    private IUser user;

    public CheckOutReceipt() {
        setCheckOuts(new HashSet());
    }

    public boolean addCheckOut(ICheckOut checkOut) {
        return checkOuts.add(checkOut);
    }

    public boolean removeCheckOut(ICheckOut checkOut) {
        if (checkOuts.contains(checkOut)) {
            return checkOuts.remove(checkOut);
        }
        return false;
    }

    public ICheckOut getCheckOut(IContent content) {
        if (content == null) {
            return null;
        }
        
        for (ICheckOut checkOut : checkOuts) {
            if (content.equals(checkOut.getContent())) {
                return checkOut;
            }
        }
        return null;
    }

    @JoinColumn(name = "CHECK_OUTS")
    @OneToMany(targetEntity = CheckOut.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Collection<ICheckOut> getCheckOuts() {
        return checkOuts;
    }

    public void setCheckOuts(Collection<ICheckOut> checkOuts) {
        if (checkOuts == null) {
            checkOuts = new HashSet();
        }
        this.checkOuts = checkOuts;
    }

    @JoinColumn(name = "USER")
    @ManyToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }
}