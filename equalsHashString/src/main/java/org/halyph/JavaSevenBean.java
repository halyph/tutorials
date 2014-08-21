package org.halyph;

import java.util.List;
import java.util.Objects;

public class JavaSevenBean {
    private String name;
    private int id;
    private List<JavaSevenBean> references;

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

    public List<JavaSevenBean> getReferences() {
        return references;
    }

    public void setReferences(List<JavaSevenBean> references) {
        this.references = references;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaSevenBean that = (JavaSevenBean) o;

        return Objects.equals(name, that.name)
                &&  Objects.equals(id, that.id)
                && Objects.equals(references, that.references);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, references);
    }
}
