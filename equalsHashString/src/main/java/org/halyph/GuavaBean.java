package org.halyph;

import com.google.common.base.Objects;

import java.util.List;

/**
 * See http://code.google.com/p/guava-libraries/wiki/CommonObjectUtilitiesExplained
 * http://docs.guava-libraries.googlecode.com/git-history/release/javadoc/index.html
 */
public class GuavaBean {
    private String name;
    private int id;
    private List<GuavaBean> references;

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

    public List<GuavaBean> getReferences() {
        return references;
    }

    public void setReferences(List<GuavaBean> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("id", id)
                .add("references", references)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (o instanceof GuavaBean) {
            final GuavaBean other = (GuavaBean) o;
            return Objects.equal(name, other.name)
                    && Objects.equal(id, other.id)
                    && Objects.equal(references, other.references);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, id, references);
    }

}
