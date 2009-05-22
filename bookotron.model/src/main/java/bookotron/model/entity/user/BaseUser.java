package bookotron.model.entity.user;

import bookotron.model.entity.AbstractEntity;

import java.util.Date;

/**
 * Date: May 21, 2009
 * Time: 10:31:07 PM
 */
public class BaseUser extends AbstractEntity implements IUser {
    private String name;
    private String email;
    private Date lastLogin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
