/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.sql.ast;

import org.opensearch.sql.ast.expression.*;
import org.opensearch.sql.ast.statement.Explain;
import org.opensearch.sql.ast.statement.Query;
import org.opensearch.sql.ast.statement.Statement;
import org.opensearch.sql.ast.tree.*;

/**
 * AST nodes visitor Defines the traverse path.
 */
public abstract class AbstractNodeVisitor<T, C> {

    public T visit(Node node, C context) {
        return null;
    }

    /**
     * Visit child node.
     *
     * @param node    {@link Node}
     * @param context Context
     * @return Return Type.
     */
    public T visitChildren(Node node, C context) {
        T result = defaultResult();

        for (Node child : node.getChild()) {
            T childResult = child.accept(this, context);
            result = aggregateResult(result, childResult);
        }
        return result;
    }

    private T defaultResult() {
        return null;
    }

    private T aggregateResult(T aggregate, T nextResult) {
        return nextResult;
    }

    public T visitRelation(Relation node, C context) {
        return visitChildren(node, context);
    }

    public T visitTableFunction(TableFunction node, C context) {
        return visitChildren(node, context);
    }

    public T visitFilter(Filter node, C context) {
        return visitChildren(node, context);
    }

    public T visitLookup(Lookup node, C context) {
        return visitChildren(node, context);
    }

    public T visitCorrelation(Correlation node, C context) {
        return visitChildren(node, context);
    }

    public T visitCorrelationMapping(FieldsMapping node, C context) {
        return visitChildren(node, context);
    }

    public T visitJoin(Join node, C context) {
        return visitChildren(node, context);
    }

    public T visitSubqueryAlias(SubqueryAlias node, C context) {
        return visitChildren(node, context);
    }

    public T visitProject(Project node, C context) {
        return visitChildren(node, context);
    }

    public T visitAggregation(Aggregation node, C context) {
        return visitChildren(node, context);
    }

    public T visitEqualTo(EqualTo node, C context) {
        return visitChildren(node, context);
    }

    public T visitLiteral(Literal node, C context) {
        return visitChildren(node, context);
    }

    public T visitUnresolvedAttribute(UnresolvedAttribute node, C context) {
        return visitChildren(node, context);
    }

    public T visitAttributeList(AttributeList node, C context) {
        return visitChildren(node, context);
    }

    public T visitMap(Map node, C context) {
        return visitChildren(node, context);
    }

    public T visitNot(Not node, C context) {
        return visitChildren(node, context);
    }

    public T visitOr(Or node, C context) {
        return visitChildren(node, context);
    }

    public T visitAnd(And node, C context) {
        return visitChildren(node, context);
    }

    public T visitXor(Xor node, C context) {
        return visitChildren(node, context);
    }

    public T visitAggregateFunction(AggregateFunction node, C context) {
        return visitChildren(node, context);
    }

    public T visitFunction(Function node, C context) {
        return visitChildren(node, context);
    }

    public T visitIsEmpty(IsEmpty node, C context) {
        return visitChildren(node, context);
    }

    // TODO add case

    public T visitWindowFunction(WindowFunction node, C context) {
        return visitChildren(node, context);
    }

    public T visitIn(In node, C context) {
        return visitChildren(node, context);
    }

    public T visitCompare(Compare node, C context) {
        return visitChildren(node, context);
    }

    public T visitBetween(Between node, C context) {
        return visitChildren(node, context);
    }

    public T visitArgument(Argument node, C context) {
        return visitChildren(node, context);
    }

    public T visitField(Field node, C context) {
        return visitChildren(node, context);
    }

    public T visitQualifiedName(QualifiedName node, C context) {
        return visitChildren(node, context);
    }

    public T visitRename(Rename node, C context) {
        return visitChildren(node, context);
    }

    public T visitEval(Eval node, C context) {
        return visitChildren(node, context);
    }

    public T visitParse(Parse node, C context) {
        return visitChildren(node, context);
    }

    public T visitLet(Let node, C context) {
        return visitChildren(node, context);
    }

    public T visitSort(Sort node, C context) {
        return visitChildren(node, context);
    }

    public T visitDedupe(Dedupe node, C context) {
        return visitChildren(node, context);
    }

    public T visitHead(Head node, C context) {
        return visitChildren(node, context);
    }

    public T visitRareTopN(RareTopN node, C context) {
        return visitChildren(node, context);
    }

    public T visitValues(Values node, C context) {
        return visitChildren(node, context);
    }

    public T visitAlias(Alias node, C context) {
        return visitChildren(node, context);
    }

    public T visitAllFields(AllFields node, C context) {
        return visitChildren(node, context);
    }

    public T visitInterval(Interval node, C context) {
        return visitChildren(node, context);
    }

    public T visitCase(Case node, C context) {
        return visitChildren(node, context);
    }

    public T visitWhen(When node, C context) {
        return visitChildren(node, context);
    }

    public T visitUnresolvedArgument(UnresolvedArgument node, C context) {
        return visitChildren(node, context);
    }

    public T visitLimit(Limit node, C context) {
        return visitChildren(node, context);
    }

    public T visitSpan(Span node, C context) {
        return visitChildren(node, context);
    }

    public T visitKmeans(Kmeans node, C context) {
        return visitChildren(node, context);
    }

    public T visitStatement(Statement node, C context) {
        return visit(node, context);
    }

    public T visitQuery(Query node, C context) {
        return visitStatement(node, context);
    }

    public T visitExplain(Explain node, C context) {
        return visitStatement(node, context);
    }

    public T visitFlatten(Field node, C context) { return visitChildren(node, context); }
}
