package bookotron.model.entity.user;

import java.util.Date;

/**
 * A user is someone who uses the application to add books, checkout books, update book details, etc.
 *
 * Date: May 19, 2009
 * Time: 10:08:22 PM
 */
public interface IUser {

    String getName();
    void setName(String value);

    String getEmail();
    void setEmail(String value);

    Date getLastLogin();
    void setLastLogin(Date value);
}