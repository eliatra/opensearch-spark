package org.opensearch.sql.ast.tree;

import com.google.common.collect.ImmutableList;
import org.opensearch.sql.ast.AbstractNodeVisitor;
import org.opensearch.sql.ast.expression.Field;

import java.util.List;
import java.util.Objects;

public class IsPresent extends UnresolvedPlan {

    private final List<Field> presentFields;

    private UnresolvedPlan child;

    public IsPresent(List<Field> presentFields) {
        this.presentFields = Objects.requireNonNull(presentFields, "Present fields names are required");
    }

    @Override
    public UnresolvedPlan attach(UnresolvedPlan child) {
        this.child = child;
        return this;
    }

    @Override
    public List<UnresolvedPlan> getChild() {
        return ImmutableList.of(this.child);
    }

    @Override
    public <T, C> T accept(AbstractNodeVisitor<T, C> nodeVisitor, C context) {
        return nodeVisitor.visitIsPresent(this, context);
    }

    public List<Field> getPresentField() {
        return presentFields;
    }
}
