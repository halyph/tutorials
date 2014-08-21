package org.halyph;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * http://commons.apache.org/proper/commons-lang//apidocs/org/apache/commons/lang3/builder/package-summary.html
 * http://commons.apache.org/proper/commons-lang//apidocs/org/apache/commons/lang3/builder/EqualsBuilder.html
 * http://commons.apache.org/proper/commons-lang//apidocs/org/apache/commons/lang3/builder/HashCodeBuilder.html
 * http://commons.apache.org/proper/commons-lang//apidocs/org/apache/commons/lang3/builder/ToStringBuilder.html
 * http://commons.apache.org/proper/commons-lang//apidocs/org/apache/commons/lang3/builder/ToStringStyle.html
 */
public class ApacheCommonsBean {
    private String name;
    private int id;
    private List<ApacheCommonsBean> references;

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

    public List<ApacheCommonsBean> getReferences() {
        return references;
    }

    public void setReferences(List<ApacheCommonsBean> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("id", id)
                .append("references", references)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApacheCommonsBean that = (ApacheCommonsBean) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, that.name)
                .append(id, that.id)
                .append(references, that.references)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(31, 17)
                .appendSuper(super.hashCode())
                .append(name)
                .append(id)
                .append(references)
                .toHashCode();
    }

}
