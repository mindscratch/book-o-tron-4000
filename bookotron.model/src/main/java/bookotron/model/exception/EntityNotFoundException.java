package bookotron.model.exception;

/**
 * Thrown when an entity can not be found, typically would be thrown from the data layer.
 */
public class EntityNotFoundException extends RuntimeException {

    private long entityId;
    private Class entityType;

    public EntityNotFoundException(String msg, long entityId) {
        this(msg, entityId, null);
    }

    public EntityNotFoundException(String msg, long entityId, Class entityType) {
        super(msg);
        this.entityId = entityId;
        this.entityType = entityType;
    }

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public Class getEntityType() {
        return entityType;
    }

    public void setEntityType(Class entityType) {
        this.entityType = entityType;
    }
}
