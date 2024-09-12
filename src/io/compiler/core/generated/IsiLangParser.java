// Generated from /workspaces/compiladores-ufabc-2024.2/src/IsiLang.g4 by ANTLR 4.13.2
package io.compiler.core.generated;

    import io.compiler.core.ast.*;
    import io.compiler.core.ast.commands.*;
    import io.compiler.core.operators.*;
    import io.compiler.core.exceptions_warnings.*;
    import io.compiler.core.program.*;
    import io.compiler.types.*;
    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, END_OF_LINE=15, TRUE=16, 
		FALSE=17, IDENTIFIER=18, NUM=19, STRING=20, OP_OR=21, OP_AND=22, OP_COMP=23, 
		OP_REL=24, OP_TERM=25, OP_FACTOR=26, OP_NOT=27, DOT=28, OPEN_PAREN=29, 
		CLOSE_PAREN=30, OPEN_BRACE=31, CLOSE_BRACE=32, WS=33;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_block = 2, RULE_assignment = 3, 
		RULE_statement = 4, RULE_repl_line = 5, RULE_print = 6, RULE_read = 7, 
		RULE_while = 8, RULE_do_while = 9, RULE_attribution = 10, RULE_attributionl = 11, 
		RULE_if = 12, RULE_expression = 13, RULE_logical_or = 14, RULE_logical_orl = 15, 
		RULE_logical_and = 16, RULE_logical_andl = 17, RULE_equality = 18, RULE_equalityl = 19, 
		RULE_comparison = 20, RULE_comparisonl = 21, RULE_term = 22, RULE_terml = 23, 
		RULE_factor = 24, RULE_factorl = 25, RULE_unary = 26, RULE_grouped_expression = 27, 
		RULE_boolean_literal = 28, RULE_identifier = 29, RULE_unary_op = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "block", "assignment", "statement", "repl_line", 
			"print", "read", "while", "do_while", "attribution", "attributionl", 
			"if", "expression", "logical_or", "logical_orl", "logical_and", "logical_andl", 
			"equality", "equalityl", "comparison", "comparisonl", "term", "terml", 
			"factor", "factorl", "unary", "grouped_expression", "boolean_literal", 
			"identifier", "unary_op"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fimprog'", "'inteiro'", "'flutuante'", 
			"'texto'", "'booleano'", "'='", "'imprima'", "'receba'", "'enquanto'", 
			"'faca'", "'se'", "'senao'", "';'", "'verdadeiro'", "'falso'", null, 
			null, null, "'||'", "'&&'", null, null, null, null, "'!'", "'.'", "'('", 
			"')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "END_OF_LINE", "TRUE", "FALSE", "IDENTIFIER", "NUM", 
			"STRING", "OP_OR", "OP_AND", "OP_COMP", "OP_REL", "OP_TERM", "OP_FACTOR", 
			"OP_NOT", "DOT", "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private Program program;
	    private HashMap<String, Binding> symbols = new HashMap<String, Binding>();

	    private Stack<AstNode> stack = new Stack<AstNode>();
	    private AstNode root = null;

	    public AstNode getRoot(){
	        if (root == null) {
	            root = stack.pop();
	        }

	        return root;
	    }

	    private ArrayList<StatementNode> statements = new ArrayList<StatementNode>();
	    private ArrayList<BindingNode> declarations = new ArrayList<BindingNode>();

	    public ArrayList<StatementNode> getStatements() {
	        return statements;
	    }

	    public ArrayList<BindingNode> getDeclarations() {
	        return declarations;
	    }

	    private void addStatement(StatementNode statement) {
	        statements.add(statement);
	    }

	    private void addDeclaration(BindingNode declaration) {
	        declarations.add(declaration);
	    }

	    private boolean isInitializingVariable = false;
	    private boolean hasElseBranch = false;

	    public Program getProgram() {
	        return program;
	    }

	    public void setSymbols(HashMap<String, Binding> symbols) {
	        this.symbols = symbols;
	    }

	    public HashMap<String, Binding> getSymbols() {
	        return symbols;
	    }

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IsiLangParser.DOT, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(63);
			declaration();
			setState(64);
			match(T__1);
			setState(65);
			block();
			setState(66);
			match(T__2);
			setState(67);
			match(DOT);

			    for (var declaration : declarations) {
			        var identifier = declaration.getIdentifier();
			        var symbol = symbols.get(identifier);

			        if (!symbol.isUsed()) {
			            var warning = new UnusedVariableWarning(identifier);
			            System.out.println("AVISO: " + warning.getMessage());
			        }
			    }

			    var program_ = new Program(declarations, statements, symbols);
			    this.program = program_;

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) {
				{
				{
				setState(70);
				assignment();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				statement();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 278016L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(IsiLangParser.IDENTIFIER, 0); }
		public TerminalNode END_OF_LINE() { return getToken(IsiLangParser.END_OF_LINE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			    var typeString = _input.LT(-1).getText();
			    var type = Type.fromString(typeString);

			setState(83);
			match(IDENTIFIER);

			    var identifierString = _input.LT(-1).getText();
			    var identifier = new IdentifierNode(identifierString);

			    if (symbols.containsKey(identifier.getName())) {
			        throw new AlreadyDeclaredVariableException(identifier.getName());
			    }

			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(85);
				match(T__7);

				    isInitializingVariable = true;

				setState(87);
				expression();
				}
			}


			    var initializer = isInitializingVariable ? stack.pop() : null;

			    if (isInitializingVariable && initializer.getType() != type) {
			        throw new DeclarationTypeMismatchException(identifier.getName(), type, initializer.getType());
			    }

			    var binding = new BindingNode(identifier.getName(), type, initializer);
			    addDeclaration(binding);

			    symbols.put(identifier.getName(), binding.asBinding());
			    isInitializingVariable = false;

			setState(91);
			match(END_OF_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public AttributionContext attribution() {
			return getRuleContext(AttributionContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public Do_whileContext do_while() {
			return getRuleContext(Do_whileContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				print();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				read();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				if_();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				attribution();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				while_();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				do_while();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Repl_lineContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Repl_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repl_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterRepl_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitRepl_line(this);
		}
	}

	public final Repl_lineContext repl_line() throws RecognitionException {
		Repl_lineContext _localctx = new Repl_lineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_repl_line);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{

				    statements.clear();
				    declarations.clear();

				setState(102);
				assignment();

				    var lastDeclaration = declarations.get(declarations.size() - 1);
				    declarations.remove(declarations.size() - 1);

				    var declarationStatement = new Expression(lastDeclaration);
				    statements.add(declarationStatement);

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				expression();

				    var expression = stack.pop();
				    var expressionCom = new Expression(expression);

				    addStatement(expressionCom);

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(IsiLangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(IsiLangParser.CLOSE_PAREN, 0); }
		public TerminalNode END_OF_LINE() { return getToken(IsiLangParser.END_OF_LINE, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__8);
			setState(112);
			match(OPEN_PAREN);
			setState(113);
			expression();
			setState(114);
			match(CLOSE_PAREN);
			setState(115);
			match(END_OF_LINE);

			    var printCom = new Print(stack.pop());
			    addStatement(printCom);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(IsiLangParser.OPEN_PAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(IsiLangParser.CLOSE_PAREN, 0); }
		public TerminalNode END_OF_LINE() { return getToken(IsiLangParser.END_OF_LINE, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitRead(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__9);
			setState(119);
			match(OPEN_PAREN);
			setState(120);
			identifier();

			    var identifier = (IdentifierNode)stack.pop();
			    var symbol = symbols.get(identifier.getName());
			    var symbolType = symbol.getType();

			setState(122);
			match(CLOSE_PAREN);
			setState(123);
			match(END_OF_LINE);

			    var read = new Read(identifier.getName(), symbolType);
			    addStatement(read);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(IsiLangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(IsiLangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(IsiLangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(IsiLangParser.CLOSE_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitWhile(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__10);
			setState(127);
			match(OPEN_PAREN);
			setState(128);
			expression();

			    var condition = stack.pop();
			    var body = new ArrayList<StatementNode>();

			setState(130);
			match(CLOSE_PAREN);
			setState(131);
			match(OPEN_BRACE);
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				statement();

				    var lastStatement = statements.get(statements.size() - 1);
				    statements.remove(statements.size() - 1);

				    body.add(lastStatement);

				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 278016L) != 0) );
			setState(139);
			match(CLOSE_BRACE);

			    var whileCom = new While(condition, body);
			    addStatement(whileCom);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Do_whileContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(IsiLangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(IsiLangParser.CLOSE_BRACE, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(IsiLangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(IsiLangParser.CLOSE_PAREN, 0); }
		public TerminalNode END_OF_LINE() { return getToken(IsiLangParser.END_OF_LINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Do_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDo_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDo_while(this);
		}
	}

	public final Do_whileContext do_while() throws RecognitionException {
		Do_whileContext _localctx = new Do_whileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_do_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__11);

			    var body = new ArrayList<StatementNode>();

			setState(144);
			match(OPEN_BRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 278016L) != 0)) {
				{
				{
				setState(145);
				statement();

				    var lastStatement = statements.get(statements.size() - 1);
				    statements.remove(statements.size() - 1);

				    body.add(lastStatement);

				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(CLOSE_BRACE);
			setState(154);
			match(T__10);
			setState(155);
			match(OPEN_PAREN);
			setState(156);
			expression();

			    var condition = stack.pop();

			setState(158);
			match(CLOSE_PAREN);
			setState(159);
			match(END_OF_LINE);

			    var doWhile = new DoWhile(body, condition);
			    addStatement(doWhile);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributionContext extends ParserRuleContext {
		public AttributionlContext attributionl() {
			return getRuleContext(AttributionlContext.class,0);
		}
		public TerminalNode END_OF_LINE() { return getToken(IsiLangParser.END_OF_LINE, 0); }
		public AttributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterAttribution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitAttribution(this);
		}
	}

	public final AttributionContext attribution() throws RecognitionException {
		AttributionContext _localctx = new AttributionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			attributionl();
			setState(163);
			match(END_OF_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributionlContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(IsiLangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributionlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributionl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterAttributionl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitAttributionl(this);
		}
	}

	public final AttributionlContext attributionl() throws RecognitionException {
		AttributionlContext _localctx = new AttributionlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributionl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IDENTIFIER);

			    var identifierString = _input.LT(-1).getText();
			    var identifier = new IdentifierNode(identifierString);

			    if (!symbols.containsKey(identifier.getName())) {
			       throw new UndeclaredVariableException(identifier.getName());
			    }

			    var symbol = symbols.get(identifier.getName());
			    var symbolType = symbol.getType();
			    
			setState(167);
			match(T__7);
			setState(168);
			expression();

			    var expression = stack.pop();

			    if (symbolType != expression.getType()) {
			       throw new AssignmentTypeMismatchException(symbolType, expression.getType());
			    }

			    var assignment = new Assignment(identifier.getName(), expression);
			    symbol.setInitialized();

			    addStatement(assignment);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(IsiLangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(IsiLangParser.CLOSE_PAREN, 0); }
		public List<TerminalNode> OPEN_BRACE() { return getTokens(IsiLangParser.OPEN_BRACE); }
		public TerminalNode OPEN_BRACE(int i) {
			return getToken(IsiLangParser.OPEN_BRACE, i);
		}
		public List<TerminalNode> CLOSE_BRACE() { return getTokens(IsiLangParser.CLOSE_BRACE); }
		public TerminalNode CLOSE_BRACE(int i) {
			return getToken(IsiLangParser.CLOSE_BRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitIf(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__12);
			setState(172);
			match(OPEN_PAREN);
			setState(173);
			expression();

			    var condition = stack.pop();

			    var thenBranch = new ArrayList<StatementNode>();
			    var elseBranch = new ArrayList<StatementNode>();

			setState(175);
			match(CLOSE_PAREN);
			setState(176);
			match(OPEN_BRACE);
			setState(180); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(177);
				statement();

				    var lastStatement = statements.get(statements.size() - 1);
				    statements.remove(statements.size() - 1);

				    thenBranch.add(lastStatement);

				}
				}
				setState(182); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 278016L) != 0) );
			setState(184);
			match(CLOSE_BRACE);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(185);
				match(T__13);

				    hasElseBranch = true;

				setState(187);
				match(OPEN_BRACE);
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(188);
					statement();

					    if (hasElseBranch) {
					        var lastStatement = statements.get(statements.size() - 1);
					        statements.remove(statements.size() - 1);

					        elseBranch.add(lastStatement);
					    }

					}
					}
					setState(193); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 278016L) != 0) );
				setState(195);
				match(CLOSE_BRACE);
				}
			}


			    var ifCom = new If(condition, thenBranch, elseBranch);
			    addStatement(ifCom);

			    hasElseBranch = false;

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			logical_or();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_orContext extends ParserRuleContext {
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public Logical_orlContext logical_orl() {
			return getRuleContext(Logical_orlContext.class,0);
		}
		public Logical_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterLogical_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitLogical_or(this);
		}
	}

	public final Logical_orContext logical_or() throws RecognitionException {
		Logical_orContext _localctx = new Logical_orContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logical_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			logical_and();
			setState(204);
			logical_orl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_orlContext extends ParserRuleContext {
		public List<EqualityContext> equality() {
			return getRuleContexts(EqualityContext.class);
		}
		public EqualityContext equality(int i) {
			return getRuleContext(EqualityContext.class,i);
		}
		public List<TerminalNode> OP_OR() { return getTokens(IsiLangParser.OP_OR); }
		public TerminalNode OP_OR(int i) {
			return getToken(IsiLangParser.OP_OR, i);
		}
		public Logical_orlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_orl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterLogical_orl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitLogical_orl(this);
		}
	}

	public final Logical_orlContext logical_orl() throws RecognitionException {
		Logical_orlContext _localctx = new Logical_orlContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logical_orl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_OR) {
				{
				{
				{
				setState(206);
				match(OP_OR);
				}

				    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
				    var binaryOperation = new BinaryExpression(operator);

				    binaryOperation.setLeft(stack.pop());

				setState(208);
				equality();

				    binaryOperation.setRight(stack.pop());
				    stack.push(binaryOperation);

				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_andContext extends ParserRuleContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public Logical_andlContext logical_andl() {
			return getRuleContext(Logical_andlContext.class,0);
		}
		public Logical_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterLogical_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitLogical_and(this);
		}
	}

	public final Logical_andContext logical_and() throws RecognitionException {
		Logical_andContext _localctx = new Logical_andContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logical_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			equality();
			setState(217);
			logical_andl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_andlContext extends ParserRuleContext {
		public List<EqualityContext> equality() {
			return getRuleContexts(EqualityContext.class);
		}
		public EqualityContext equality(int i) {
			return getRuleContext(EqualityContext.class,i);
		}
		public List<TerminalNode> OP_AND() { return getTokens(IsiLangParser.OP_AND); }
		public TerminalNode OP_AND(int i) {
			return getToken(IsiLangParser.OP_AND, i);
		}
		public Logical_andlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_andl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterLogical_andl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitLogical_andl(this);
		}
	}

	public final Logical_andlContext logical_andl() throws RecognitionException {
		Logical_andlContext _localctx = new Logical_andlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logical_andl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_AND) {
				{
				{
				{
				setState(219);
				match(OP_AND);
				}

				    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
				    var binaryOperation = new BinaryExpression(operator);

				    binaryOperation.setLeft(stack.pop());

				setState(221);
				equality();

				    binaryOperation.setRight(stack.pop());
				    stack.push(binaryOperation);

				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public EqualitylContext equalityl() {
			return getRuleContext(EqualitylContext.class,0);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitEquality(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_equality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			comparison();
			setState(230);
			equalityl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualitylContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public List<TerminalNode> OP_COMP() { return getTokens(IsiLangParser.OP_COMP); }
		public TerminalNode OP_COMP(int i) {
			return getToken(IsiLangParser.OP_COMP, i);
		}
		public EqualitylContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterEqualityl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitEqualityl(this);
		}
	}

	public final EqualitylContext equalityl() throws RecognitionException {
		EqualitylContext _localctx = new EqualitylContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_equalityl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_COMP) {
				{
				{
				{
				setState(232);
				match(OP_COMP);
				}

				    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
				    var binaryOperation = new BinaryExpression(operator);

				    binaryOperation.setLeft(stack.pop());

				setState(234);
				comparison();

				    binaryOperation.setRight(stack.pop());
				    stack.push(binaryOperation);

				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ComparisonlContext comparisonl() {
			return getRuleContext(ComparisonlContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitComparison(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			term();
			setState(243);
			comparisonl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonlContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> OP_REL() { return getTokens(IsiLangParser.OP_REL); }
		public TerminalNode OP_REL(int i) {
			return getToken(IsiLangParser.OP_REL, i);
		}
		public ComparisonlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterComparisonl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitComparisonl(this);
		}
	}

	public final ComparisonlContext comparisonl() throws RecognitionException {
		ComparisonlContext _localctx = new ComparisonlContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comparisonl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_REL) {
				{
				{
				{
				setState(245);
				match(OP_REL);
				}

				    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
				    var binaryOperation = new BinaryExpression(operator);

				    binaryOperation.setLeft(stack.pop());

				setState(247);
				term();

				    binaryOperation.setRight(stack.pop());
				    stack.push(binaryOperation);

				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			factor();
			setState(256);
			terml();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermlContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> OP_TERM() { return getTokens(IsiLangParser.OP_TERM); }
		public TerminalNode OP_TERM(int i) {
			return getToken(IsiLangParser.OP_TERM, i);
		}
		public TermlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTerml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTerml(this);
		}
	}

	public final TermlContext terml() throws RecognitionException {
		TermlContext _localctx = new TermlContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_terml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_TERM) {
				{
				{
				{
				setState(258);
				match(OP_TERM);
				}

				    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
				    var binaryOperation = new BinaryExpression(operator);

				    binaryOperation.setLeft(stack.pop());

				setState(260);
				factor();

				    binaryOperation.setRight(stack.pop());
				    stack.push(binaryOperation);

				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public FactorlContext factorl() {
			return getRuleContext(FactorlContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			unary();
			setState(269);
			factorl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorlContext extends ParserRuleContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public List<TerminalNode> OP_FACTOR() { return getTokens(IsiLangParser.OP_FACTOR); }
		public TerminalNode OP_FACTOR(int i) {
			return getToken(IsiLangParser.OP_FACTOR, i);
		}
		public FactorlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFactorl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFactorl(this);
		}
	}

	public final FactorlContext factorl() throws RecognitionException {
		FactorlContext _localctx = new FactorlContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_factorl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_FACTOR) {
				{
				{
				{
				setState(271);
				match(OP_FACTOR);
				}

				    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
				    var binaryOperation = new BinaryExpression(operator);

				    if (stack.peek().isLiteral() || stack.peek().isIdentifier()) {
				        binaryOperation.setLeft(stack.pop());
				    } else {
				        var other = (BinaryExpression)stack.pop();

				        if (other.getOperator().getValue() < operator.getValue()) {
				            binaryOperation.setLeft(other.getRight());
				            other.setRight(binaryOperation);
				        } else {
				            binaryOperation.setLeft(other);
				            stack.push(binaryOperation);
				        }
				    }

				setState(273);
				unary();

				    binaryOperation.setRight(stack.pop());
				    stack.push(binaryOperation);

				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public Grouped_expressionContext grouped_expression() {
			return getRuleContext(Grouped_expressionContext.class,0);
		}
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
		}
		public TerminalNode NUM() { return getToken(IsiLangParser.NUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(IsiLangParser.STRING, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_unary);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				grouped_expression();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				boolean_literal();
				}
				break;
			case OP_NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				unary_op();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(284);
				match(NUM);

				    if (_input.LT(-1).getText().contains(".")) {
				        var floatLiteral = new FloatLiteral(Float.parseFloat(_input.LT(-1).getText()));
				        stack.push(floatLiteral);
				    } else {
				        var intLiteral = new IntegerLiteral(Integer.parseInt(_input.LT(-1).getText()));
				        stack.push(intLiteral);
				    }

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(286);
				identifier();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(287);
				match(STRING);

				    var stringLiteral = new StringLiteral(_input.LT(-1).getText());
				    stack.push(stringLiteral);

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Grouped_expressionContext extends ParserRuleContext {
		public TerminalNode OPEN_PAREN() { return getToken(IsiLangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(IsiLangParser.CLOSE_PAREN, 0); }
		public Grouped_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouped_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterGrouped_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitGrouped_expression(this);
		}
	}

	public final Grouped_expressionContext grouped_expression() throws RecognitionException {
		Grouped_expressionContext _localctx = new Grouped_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_grouped_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(OPEN_PAREN);
			setState(292);
			expression();
			setState(293);
			match(CLOSE_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(IsiLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(IsiLangParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			    var booleanLiteral = new BooleanLiteral(_input.LT(-1).getText().equals("verdadeiro"));
			    stack.push(booleanLiteral);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(IsiLangParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(IDENTIFIER);

			    var identifier = new IdentifierNode(_input.LT(-1).getText());

			    if (symbols.containsKey(identifier.getName())) {
			     var binding = symbols.get(identifier.getName());
			     identifier.setType(binding.getType());

			     var isInitialized = binding.isInitialized();
			     if (!isInitialized) {
			         var warning = new VariableUsedWithoutInitializationWarning(identifier.getName());
			         System.out.println("AVISO: " + warning.getMessage());
			     }

			     binding.setUsed();
			    }

			    stack.push(identifier);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_opContext extends ParserRuleContext {
		public TerminalNode OP_NOT() { return getToken(IsiLangParser.OP_NOT, 0); }
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterUnary_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitUnary_op(this);
		}
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_unary_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(OP_NOT);

			    var operator = UnaryOperator.fromString(_input.LT(-1).getText());
			    var unaryOperation = new UnaryExpression(operator);

			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				{
				setState(303);
				boolean_literal();
				}
				break;
			case IDENTIFIER:
				{
				setState(304);
				identifier();

				    unaryOperation.setOperand(stack.pop());
				    stack.push(unaryOperation);

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u0136\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001H\b\u0001\n\u0001\f\u0001"+
		"K\t\u0001\u0001\u0002\u0004\u0002N\b\u0002\u000b\u0002\f\u0002O\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003Y\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004d\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005n\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0088\b\b\u000b\b\f\b\u0089\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0095\b\t\n\t\f\t\u0098\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00b5"+
		"\b\f\u000b\f\f\f\u00b6\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0004\f\u00c0\b\f\u000b\f\f\f\u00c1\u0001\f\u0001\f\u0003\f\u00c6"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00d4\b\u000f\n\u000f\f\u000f\u00d7\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u00e1\b\u0011\n\u0011\f\u0011\u00e4\t\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00ee\b\u0013\n\u0013\f\u0013\u00f1\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u00fb\b\u0015\n\u0015\f\u0015\u00fe\t\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u0108\b\u0017\n\u0017\f\u0017\u010b\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u0115\b\u0019\n\u0019\f\u0019\u0118\t\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u0122\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0134\b\u001e\u0001\u001e\u0000\u0000"+
		"\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<\u0000\u0002\u0001\u0000\u0004\u0007"+
		"\u0001\u0000\u0010\u0011\u0131\u0000>\u0001\u0000\u0000\u0000\u0002I\u0001"+
		"\u0000\u0000\u0000\u0004M\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000"+
		"\u0000\bc\u0001\u0000\u0000\u0000\nm\u0001\u0000\u0000\u0000\fo\u0001"+
		"\u0000\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000"+
		"\u0000\u0012\u008e\u0001\u0000\u0000\u0000\u0014\u00a2\u0001\u0000\u0000"+
		"\u0000\u0016\u00a5\u0001\u0000\u0000\u0000\u0018\u00ab\u0001\u0000\u0000"+
		"\u0000\u001a\u00c9\u0001\u0000\u0000\u0000\u001c\u00cb\u0001\u0000\u0000"+
		"\u0000\u001e\u00d5\u0001\u0000\u0000\u0000 \u00d8\u0001\u0000\u0000\u0000"+
		"\"\u00e2\u0001\u0000\u0000\u0000$\u00e5\u0001\u0000\u0000\u0000&\u00ef"+
		"\u0001\u0000\u0000\u0000(\u00f2\u0001\u0000\u0000\u0000*\u00fc\u0001\u0000"+
		"\u0000\u0000,\u00ff\u0001\u0000\u0000\u0000.\u0109\u0001\u0000\u0000\u0000"+
		"0\u010c\u0001\u0000\u0000\u00002\u0116\u0001\u0000\u0000\u00004\u0121"+
		"\u0001\u0000\u0000\u00006\u0123\u0001\u0000\u0000\u00008\u0127\u0001\u0000"+
		"\u0000\u0000:\u012a\u0001\u0000\u0000\u0000<\u012d\u0001\u0000\u0000\u0000"+
		">?\u0005\u0001\u0000\u0000?@\u0003\u0002\u0001\u0000@A\u0005\u0002\u0000"+
		"\u0000AB\u0003\u0004\u0002\u0000BC\u0005\u0003\u0000\u0000CD\u0005\u001c"+
		"\u0000\u0000DE\u0006\u0000\uffff\uffff\u0000E\u0001\u0001\u0000\u0000"+
		"\u0000FH\u0003\u0006\u0003\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0003"+
		"\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LN\u0003\b\u0004\u0000"+
		"ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000P\u0005\u0001\u0000\u0000\u0000QR\u0007"+
		"\u0000\u0000\u0000RS\u0006\u0003\uffff\uffff\u0000ST\u0005\u0012\u0000"+
		"\u0000TX\u0006\u0003\uffff\uffff\u0000UV\u0005\b\u0000\u0000VW\u0006\u0003"+
		"\uffff\uffff\u0000WY\u0003\u001a\r\u0000XU\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0006\u0003\uffff\uffff"+
		"\u0000[\\\u0005\u000f\u0000\u0000\\\u0007\u0001\u0000\u0000\u0000]d\u0003"+
		"\f\u0006\u0000^d\u0003\u000e\u0007\u0000_d\u0003\u0018\f\u0000`d\u0003"+
		"\u0014\n\u0000ad\u0003\u0010\b\u0000bd\u0003\u0012\t\u0000c]\u0001\u0000"+
		"\u0000\u0000c^\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000c`\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000\u0000"+
		"d\t\u0001\u0000\u0000\u0000ef\u0006\u0005\uffff\uffff\u0000fg\u0003\u0006"+
		"\u0003\u0000gh\u0006\u0005\uffff\uffff\u0000hn\u0001\u0000\u0000\u0000"+
		"in\u0003\b\u0004\u0000jk\u0003\u001a\r\u0000kl\u0006\u0005\uffff\uffff"+
		"\u0000ln\u0001\u0000\u0000\u0000me\u0001\u0000\u0000\u0000mi\u0001\u0000"+
		"\u0000\u0000mj\u0001\u0000\u0000\u0000n\u000b\u0001\u0000\u0000\u0000"+
		"op\u0005\t\u0000\u0000pq\u0005\u001d\u0000\u0000qr\u0003\u001a\r\u0000"+
		"rs\u0005\u001e\u0000\u0000st\u0005\u000f\u0000\u0000tu\u0006\u0006\uffff"+
		"\uffff\u0000u\r\u0001\u0000\u0000\u0000vw\u0005\n\u0000\u0000wx\u0005"+
		"\u001d\u0000\u0000xy\u0003:\u001d\u0000yz\u0006\u0007\uffff\uffff\u0000"+
		"z{\u0005\u001e\u0000\u0000{|\u0005\u000f\u0000\u0000|}\u0006\u0007\uffff"+
		"\uffff\u0000}\u000f\u0001\u0000\u0000\u0000~\u007f\u0005\u000b\u0000\u0000"+
		"\u007f\u0080\u0005\u001d\u0000\u0000\u0080\u0081\u0003\u001a\r\u0000\u0081"+
		"\u0082\u0006\b\uffff\uffff\u0000\u0082\u0083\u0005\u001e\u0000\u0000\u0083"+
		"\u0087\u0005\u001f\u0000\u0000\u0084\u0085\u0003\b\u0004\u0000\u0085\u0086"+
		"\u0006\b\uffff\uffff\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0084"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005 \u0000\u0000\u008c\u008d\u0006"+
		"\b\uffff\uffff\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u008f\u0005"+
		"\f\u0000\u0000\u008f\u0090\u0006\t\uffff\uffff\u0000\u0090\u0096\u0005"+
		"\u001f\u0000\u0000\u0091\u0092\u0003\b\u0004\u0000\u0092\u0093\u0006\t"+
		"\uffff\uffff\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094\u0091\u0001"+
		"\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0001"+
		"\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009a\u0005"+
		" \u0000\u0000\u009a\u009b\u0005\u000b\u0000\u0000\u009b\u009c\u0005\u001d"+
		"\u0000\u0000\u009c\u009d\u0003\u001a\r\u0000\u009d\u009e\u0006\t\uffff"+
		"\uffff\u0000\u009e\u009f\u0005\u001e\u0000\u0000\u009f\u00a0\u0005\u000f"+
		"\u0000\u0000\u00a0\u00a1\u0006\t\uffff\uffff\u0000\u00a1\u0013\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0003\u0016\u000b\u0000\u00a3\u00a4\u0005\u000f"+
		"\u0000\u0000\u00a4\u0015\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0012"+
		"\u0000\u0000\u00a6\u00a7\u0006\u000b\uffff\uffff\u0000\u00a7\u00a8\u0005"+
		"\b\u0000\u0000\u00a8\u00a9\u0003\u001a\r\u0000\u00a9\u00aa\u0006\u000b"+
		"\uffff\uffff\u0000\u00aa\u0017\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\r\u0000\u0000\u00ac\u00ad\u0005\u001d\u0000\u0000\u00ad\u00ae\u0003\u001a"+
		"\r\u0000\u00ae\u00af\u0006\f\uffff\uffff\u0000\u00af\u00b0\u0005\u001e"+
		"\u0000\u0000\u00b0\u00b4\u0005\u001f\u0000\u0000\u00b1\u00b2\u0003\b\u0004"+
		"\u0000\u00b2\u00b3\u0006\f\uffff\uffff\u0000\u00b3\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00c5\u0005 \u0000\u0000"+
		"\u00b9\u00ba\u0005\u000e\u0000\u0000\u00ba\u00bb\u0006\f\uffff\uffff\u0000"+
		"\u00bb\u00bf\u0005\u001f\u0000\u0000\u00bc\u00bd\u0003\b\u0004\u0000\u00bd"+
		"\u00be\u0006\f\uffff\uffff\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf"+
		"\u00bc\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005 \u0000\u0000\u00c4\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c5\u00b9\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0006\f\uffff\uffff\u0000\u00c8\u0019\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0003\u001c\u000e\u0000\u00ca\u001b\u0001\u0000\u0000\u0000\u00cb\u00cc"+
		"\u0003 \u0010\u0000\u00cc\u00cd\u0003\u001e\u000f\u0000\u00cd\u001d\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0005\u0015\u0000\u0000\u00cf\u00d0\u0006"+
		"\u000f\uffff\uffff\u0000\u00d0\u00d1\u0003$\u0012\u0000\u00d1\u00d2\u0006"+
		"\u000f\uffff\uffff\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u001f"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0003$\u0012\u0000\u00d9\u00da\u0003\"\u0011\u0000\u00da!\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0005\u0016\u0000\u0000\u00dc\u00dd\u0006\u0011"+
		"\uffff\uffff\u0000\u00dd\u00de\u0003$\u0012\u0000\u00de\u00df\u0006\u0011"+
		"\uffff\uffff\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00db\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3#\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003(\u0014"+
		"\u0000\u00e6\u00e7\u0003&\u0013\u0000\u00e7%\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0005\u0017\u0000\u0000\u00e9\u00ea\u0006\u0013\uffff\uffff\u0000"+
		"\u00ea\u00eb\u0003(\u0014\u0000\u00eb\u00ec\u0006\u0013\uffff\uffff\u0000"+
		"\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\'\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0003,\u0016\u0000\u00f3\u00f4"+
		"\u0003*\u0015\u0000\u00f4)\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0018"+
		"\u0000\u0000\u00f6\u00f7\u0006\u0015\uffff\uffff\u0000\u00f7\u00f8\u0003"+
		",\u0016\u0000\u00f8\u00f9\u0006\u0015\uffff\uffff\u0000\u00f9\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f5\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd+\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u00030\u0018\u0000\u0100\u0101\u0003.\u0017\u0000"+
		"\u0101-\u0001\u0000\u0000\u0000\u0102\u0103\u0005\u0019\u0000\u0000\u0103"+
		"\u0104\u0006\u0017\uffff\uffff\u0000\u0104\u0105\u00030\u0018\u0000\u0105"+
		"\u0106\u0006\u0017\uffff\uffff\u0000\u0106\u0108\u0001\u0000\u0000\u0000"+
		"\u0107\u0102\u0001\u0000\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000"+
		"\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000"+
		"\u010a/\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u00034\u001a\u0000\u010d\u010e\u00032\u0019\u0000\u010e1\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0005\u001a\u0000\u0000\u0110\u0111\u0006"+
		"\u0019\uffff\uffff\u0000\u0111\u0112\u00034\u001a\u0000\u0112\u0113\u0006"+
		"\u0019\uffff\uffff\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u010f"+
		"\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116\u0114"+
		"\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u01173\u0001"+
		"\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u0122\u0003"+
		"6\u001b\u0000\u011a\u0122\u00038\u001c\u0000\u011b\u0122\u0003<\u001e"+
		"\u0000\u011c\u011d\u0005\u0013\u0000\u0000\u011d\u0122\u0006\u001a\uffff"+
		"\uffff\u0000\u011e\u0122\u0003:\u001d\u0000\u011f\u0120\u0005\u0014\u0000"+
		"\u0000\u0120\u0122\u0006\u001a\uffff\uffff\u0000\u0121\u0119\u0001\u0000"+
		"\u0000\u0000\u0121\u011a\u0001\u0000\u0000\u0000\u0121\u011b\u0001\u0000"+
		"\u0000\u0000\u0121\u011c\u0001\u0000\u0000\u0000\u0121\u011e\u0001\u0000"+
		"\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u01225\u0001\u0000\u0000"+
		"\u0000\u0123\u0124\u0005\u001d\u0000\u0000\u0124\u0125\u0003\u001a\r\u0000"+
		"\u0125\u0126\u0005\u001e\u0000\u0000\u01267\u0001\u0000\u0000\u0000\u0127"+
		"\u0128\u0007\u0001\u0000\u0000\u0128\u0129\u0006\u001c\uffff\uffff\u0000"+
		"\u01299\u0001\u0000\u0000\u0000\u012a\u012b\u0005\u0012\u0000\u0000\u012b"+
		"\u012c\u0006\u001d\uffff\uffff\u0000\u012c;\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0005\u001b\u0000\u0000\u012e\u0133\u0006\u001e\uffff\uffff\u0000"+
		"\u012f\u0134\u00038\u001c\u0000\u0130\u0131\u0003:\u001d\u0000\u0131\u0132"+
		"\u0006\u001e\uffff\uffff\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133"+
		"\u012f\u0001\u0000\u0000\u0000\u0133\u0130\u0001\u0000\u0000\u0000\u0134"+
		"=\u0001\u0000\u0000\u0000\u0012IOXcm\u0089\u0096\u00b6\u00c1\u00c5\u00d5"+
		"\u00e2\u00ef\u00fc\u0109\u0116\u0121\u0133";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}