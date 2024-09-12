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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsiLangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "END_OF_LINE", "TRUE", "FALSE", 
			"IDENTIFIER", "NUM", "STRING", "OP_OR", "OP_AND", "OP_COMP", "OP_REL", 
			"OP_TERM", "OP_FACTOR", "OP_NOT", "DOT", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACE", "CLOSE_BRACE", "WS"
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


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000!\u00fe\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u00ba\b\u0011\n"+
		"\u0011\f\u0011\u00bd\t\u0011\u0001\u0012\u0003\u0012\u00c0\b\u0012\u0001"+
		"\u0012\u0004\u0012\u00c3\b\u0012\u000b\u0012\f\u0012\u00c4\u0001\u0012"+
		"\u0001\u0012\u0004\u0012\u00c9\b\u0012\u000b\u0012\f\u0012\u00ca\u0003"+
		"\u0012\u00cd\b\u0012\u0001\u0013\u0001\u0013\u0005\u0013\u00d1\b\u0013"+
		"\n\u0013\f\u0013\u00d4\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00e2\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00e9\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0000\u0000!\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!\u0001\u0000\b\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u00000"+
		"9\u0003\u0000\n\n\r\r\"\"\u0002\u0000<<>>\u0002\u0000++--\u0002\u0000"+
		"**//\u0003\u0000\t\n\r\r  \u0106\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0001C\u0001\u0000\u0000\u0000"+
		"\u0003L\u0001\u0000\u0000\u0000\u0005S\u0001\u0000\u0000\u0000\u0007["+
		"\u0001\u0000\u0000\u0000\tc\u0001\u0000\u0000\u0000\u000bm\u0001\u0000"+
		"\u0000\u0000\rs\u0001\u0000\u0000\u0000\u000f|\u0001\u0000\u0000\u0000"+
		"\u0011~\u0001\u0000\u0000\u0000\u0013\u0086\u0001\u0000\u0000\u0000\u0015"+
		"\u008d\u0001\u0000\u0000\u0000\u0017\u0096\u0001\u0000\u0000\u0000\u0019"+
		"\u009b\u0001\u0000\u0000\u0000\u001b\u009e\u0001\u0000\u0000\u0000\u001d"+
		"\u00a4\u0001\u0000\u0000\u0000\u001f\u00a6\u0001\u0000\u0000\u0000!\u00b1"+
		"\u0001\u0000\u0000\u0000#\u00b7\u0001\u0000\u0000\u0000%\u00bf\u0001\u0000"+
		"\u0000\u0000\'\u00ce\u0001\u0000\u0000\u0000)\u00d7\u0001\u0000\u0000"+
		"\u0000+\u00da\u0001\u0000\u0000\u0000-\u00e1\u0001\u0000\u0000\u0000/"+
		"\u00e8\u0001\u0000\u0000\u00001\u00ea\u0001\u0000\u0000\u00003\u00ec\u0001"+
		"\u0000\u0000\u00005\u00ee\u0001\u0000\u0000\u00007\u00f0\u0001\u0000\u0000"+
		"\u00009\u00f2\u0001\u0000\u0000\u0000;\u00f4\u0001\u0000\u0000\u0000="+
		"\u00f6\u0001\u0000\u0000\u0000?\u00f8\u0001\u0000\u0000\u0000A\u00fa\u0001"+
		"\u0000\u0000\u0000CD\u0005p\u0000\u0000DE\u0005r\u0000\u0000EF\u0005o"+
		"\u0000\u0000FG\u0005g\u0000\u0000GH\u0005r\u0000\u0000HI\u0005a\u0000"+
		"\u0000IJ\u0005m\u0000\u0000JK\u0005a\u0000\u0000K\u0002\u0001\u0000\u0000"+
		"\u0000LM\u0005i\u0000\u0000MN\u0005n\u0000\u0000NO\u0005i\u0000\u0000"+
		"OP\u0005c\u0000\u0000PQ\u0005i\u0000\u0000QR\u0005o\u0000\u0000R\u0004"+
		"\u0001\u0000\u0000\u0000ST\u0005f\u0000\u0000TU\u0005i\u0000\u0000UV\u0005"+
		"m\u0000\u0000VW\u0005p\u0000\u0000WX\u0005r\u0000\u0000XY\u0005o\u0000"+
		"\u0000YZ\u0005g\u0000\u0000Z\u0006\u0001\u0000\u0000\u0000[\\\u0005i\u0000"+
		"\u0000\\]\u0005n\u0000\u0000]^\u0005t\u0000\u0000^_\u0005e\u0000\u0000"+
		"_`\u0005i\u0000\u0000`a\u0005r\u0000\u0000ab\u0005o\u0000\u0000b\b\u0001"+
		"\u0000\u0000\u0000cd\u0005f\u0000\u0000de\u0005l\u0000\u0000ef\u0005u"+
		"\u0000\u0000fg\u0005t\u0000\u0000gh\u0005u\u0000\u0000hi\u0005a\u0000"+
		"\u0000ij\u0005n\u0000\u0000jk\u0005t\u0000\u0000kl\u0005e\u0000\u0000"+
		"l\n\u0001\u0000\u0000\u0000mn\u0005t\u0000\u0000no\u0005e\u0000\u0000"+
		"op\u0005x\u0000\u0000pq\u0005t\u0000\u0000qr\u0005o\u0000\u0000r\f\u0001"+
		"\u0000\u0000\u0000st\u0005b\u0000\u0000tu\u0005o\u0000\u0000uv\u0005o"+
		"\u0000\u0000vw\u0005l\u0000\u0000wx\u0005e\u0000\u0000xy\u0005a\u0000"+
		"\u0000yz\u0005n\u0000\u0000z{\u0005o\u0000\u0000{\u000e\u0001\u0000\u0000"+
		"\u0000|}\u0005=\u0000\u0000}\u0010\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"i\u0000\u0000\u007f\u0080\u0005m\u0000\u0000\u0080\u0081\u0005p\u0000"+
		"\u0000\u0081\u0082\u0005r\u0000\u0000\u0082\u0083\u0005i\u0000\u0000\u0083"+
		"\u0084\u0005m\u0000\u0000\u0084\u0085\u0005a\u0000\u0000\u0085\u0012\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005r\u0000\u0000\u0087\u0088\u0005e\u0000"+
		"\u0000\u0088\u0089\u0005c\u0000\u0000\u0089\u008a\u0005e\u0000\u0000\u008a"+
		"\u008b\u0005b\u0000\u0000\u008b\u008c\u0005a\u0000\u0000\u008c\u0014\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005e\u0000\u0000\u008e\u008f\u0005n\u0000"+
		"\u0000\u008f\u0090\u0005q\u0000\u0000\u0090\u0091\u0005u\u0000\u0000\u0091"+
		"\u0092\u0005a\u0000\u0000\u0092\u0093\u0005n\u0000\u0000\u0093\u0094\u0005"+
		"t\u0000\u0000\u0094\u0095\u0005o\u0000\u0000\u0095\u0016\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0005f\u0000\u0000\u0097\u0098\u0005a\u0000\u0000\u0098"+
		"\u0099\u0005c\u0000\u0000\u0099\u009a\u0005a\u0000\u0000\u009a\u0018\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005s\u0000\u0000\u009c\u009d\u0005e\u0000"+
		"\u0000\u009d\u001a\u0001\u0000\u0000\u0000\u009e\u009f\u0005s\u0000\u0000"+
		"\u009f\u00a0\u0005e\u0000\u0000\u00a0\u00a1\u0005n\u0000\u0000\u00a1\u00a2"+
		"\u0005a\u0000\u0000\u00a2\u00a3\u0005o\u0000\u0000\u00a3\u001c\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0005;\u0000\u0000\u00a5\u001e\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0005v\u0000\u0000\u00a7\u00a8\u0005e\u0000\u0000\u00a8"+
		"\u00a9\u0005r\u0000\u0000\u00a9\u00aa\u0005d\u0000\u0000\u00aa\u00ab\u0005"+
		"a\u0000\u0000\u00ab\u00ac\u0005d\u0000\u0000\u00ac\u00ad\u0005e\u0000"+
		"\u0000\u00ad\u00ae\u0005i\u0000\u0000\u00ae\u00af\u0005r\u0000\u0000\u00af"+
		"\u00b0\u0005o\u0000\u0000\u00b0 \u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		"f\u0000\u0000\u00b2\u00b3\u0005a\u0000\u0000\u00b3\u00b4\u0005l\u0000"+
		"\u0000\u00b4\u00b5\u0005s\u0000\u0000\u00b5\u00b6\u0005o\u0000\u0000\u00b6"+
		"\"\u0001\u0000\u0000\u0000\u00b7\u00bb\u0007\u0000\u0000\u0000\u00b8\u00ba"+
		"\u0007\u0001\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bc$\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"+
		"\u0000\u0000\u0000\u00be\u00c0\u0005-\u0000\u0000\u00bf\u00be\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c3\u0007\u0002\u0000\u0000\u00c2\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00cc\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c8\u0005.\u0000\u0000\u00c7\u00c9\u0007\u0002\u0000"+
		"\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00c6\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd&\u0001\u0000\u0000\u0000"+
		"\u00ce\u00d2\u0005\"\u0000\u0000\u00cf\u00d1\b\u0003\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0005\"\u0000\u0000\u00d6(\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0005|\u0000\u0000\u00d8\u00d9\u0005|\u0000\u0000\u00d9*\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0005&\u0000\u0000\u00db\u00dc\u0005&\u0000\u0000"+
		"\u00dc,\u0001\u0000\u0000\u0000\u00dd\u00de\u0005=\u0000\u0000\u00de\u00e2"+
		"\u0005=\u0000\u0000\u00df\u00e0\u0005!\u0000\u0000\u00e0\u00e2\u0005="+
		"\u0000\u0000\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000"+
		"\u0000\u0000\u00e2.\u0001\u0000\u0000\u0000\u00e3\u00e9\u0007\u0004\u0000"+
		"\u0000\u00e4\u00e5\u0005<\u0000\u0000\u00e5\u00e9\u0005=\u0000\u0000\u00e6"+
		"\u00e7\u0005>\u0000\u0000\u00e7\u00e9\u0005=\u0000\u0000\u00e8\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e90\u0001\u0000\u0000\u0000\u00ea\u00eb\u0007\u0005"+
		"\u0000\u0000\u00eb2\u0001\u0000\u0000\u0000\u00ec\u00ed\u0007\u0006\u0000"+
		"\u0000\u00ed4\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005!\u0000\u0000\u00ef"+
		"6\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005.\u0000\u0000\u00f18\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0005(\u0000\u0000\u00f3:\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0005)\u0000\u0000\u00f5<\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0005{\u0000\u0000\u00f7>\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005"+
		"}\u0000\u0000\u00f9@\u0001\u0000\u0000\u0000\u00fa\u00fb\u0007\u0007\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0006 \u0000\u0000"+
		"\u00fdB\u0001\u0000\u0000\u0000\t\u0000\u00bb\u00bf\u00c4\u00ca\u00cc"+
		"\u00d2\u00e1\u00e8\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}