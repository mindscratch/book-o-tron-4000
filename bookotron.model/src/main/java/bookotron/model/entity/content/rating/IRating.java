package bookotron.model.entity.content.rating;

import bookotron.model.entity.IEntity;

/**
 * Created by IntelliJ IDEA.
 * User: craig
 * Date: Jun 4, 2009
 * Time: 8:03:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRating extends IEntity, Comparable {

    float getValue();
    void setValue(float value);

    String getLabel();
    void setLabel(String label);
}
