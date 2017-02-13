package com.tacto.dhamini.tacto.network.model;

/**
 * Abstract entity class for all entity classes. This provides the unique id to
 * identify a row in SQL db
 * Created by plank-abhijit on 5/11/16.
 */
public class AbstractEntity {
    private String id;

    /*
     * Returns the identifier of the entity
     * @return id
     */
    public String getId() {
        return id;
    }

    /*
     * Checks equality of entities
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        AbstractEntity that = (AbstractEntity) obj;

        return this.id.equals(that.getId());
    }

    public AbstractEntity withId(String id) {
        this.id = id;
        return this;
    }

    /*
     * Returns hashcode of the entity
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}