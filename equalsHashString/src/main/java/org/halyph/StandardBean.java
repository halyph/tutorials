package org.halyph;

import java.util.List;

public class StandardBean {
    private String name;
    private int id;
    private List<StandardBean> references;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<StandardBean> getReferences() {
        return references;
    }

    public void setReferences(List<StandardBean> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "StandardBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", references=" + references +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StandardBean that = (StandardBean) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (references != null ? !references.equals(that.references) : that.references != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (references != null ? references.hashCode() : 0);
        return result;
    }
}
