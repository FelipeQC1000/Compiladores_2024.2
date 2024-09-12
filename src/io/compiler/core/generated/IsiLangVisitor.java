// Generated from /workspaces/compiladores-ufabc-2024.2/src/IsiLang.g4 by ANTLR 4.13.2
package io.compiler.core.generated;

    import io.compiler.core.ast.*;
import io.compiler.core.ast.commands.*;
import io.compiler.core.exceptions_warnings.*;
import io.compiler.core.operators.*;
import io.compiler.core.program.*;
    import io.compiler.types.*;
    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IsiLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IsiLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(IsiLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(IsiLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(IsiLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(IsiLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#repl_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepl_line(IsiLangParser.Repl_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#do_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_while(IsiLangParser.Do_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(IsiLangParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution(IsiLangParser.AttributionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#attributionl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributionl(IsiLangParser.AttributionlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(IsiLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(IsiLangParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(IsiLangParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(IsiLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(IsiLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#logical_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or(IsiLangParser.Logical_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#logical_orl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_orl(IsiLangParser.Logical_orlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#logical_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and(IsiLangParser.Logical_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#logical_andl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_andl(IsiLangParser.Logical_andlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(IsiLangParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#equalityl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityl(IsiLangParser.EqualitylContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(IsiLangParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#comparisonl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonl(IsiLangParser.ComparisonlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(IsiLangParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#terml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerml(IsiLangParser.TermlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(IsiLangParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#factorl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorl(IsiLangParser.FactorlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(IsiLangParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#grouped_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrouped_expression(IsiLangParser.Grouped_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(IsiLangParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(IsiLangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsiLangParser#unary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_op(IsiLangParser.Unary_opContext ctx);
}