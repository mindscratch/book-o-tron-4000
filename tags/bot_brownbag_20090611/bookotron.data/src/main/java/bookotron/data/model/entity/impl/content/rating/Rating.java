package bookotron.data.model.entity.impl.content.rating;

import bookotron.model.entity.content.rating.IRating;
import bookotron.data.model.entity.impl.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@Table(name="RATING")
@XStreamAlias("Rating")
public class Rating extends AbstractEntity implements IRating {

    private float value;
    private String label;

    @Column(name="VALUE")
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Column(name="LABEL")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public int compareTo(Object o) {
        if (o instanceof IRating) {
            final IRating other = (IRating) o;
            if (getValue() == other.getValue()) {
                return 0;
            }
            else if (getValue() > other.getValue()) {
                return 1;
            }
            else {
                return -1;
            }
        }
        return -1;
    }
}
