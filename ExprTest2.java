import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExprTest2 {
    public static void main(String[] args) throws Exception {

    // Create a lexer that feeds off from file expr.txt // a + 3
    ExprLexer lexer = new ExprLexer(CharStreams.fromFileName("expr.txt"));

    // Create a buffer of tokens pulled from the lexer // ID ADD INT NEWLINE
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // Create a parser that feeds off the tokens buffer // verifie la grammaire
    ExprParser parser = new ExprParser(tokens);

    // Begin parsing at rule 'prog'
    ParseTree tree = parser.prog();
    
    // Print the parse tree (for debugging purposes)
    PostfixVisitor eval = new PostfixVisitor();
    eval.visit(tree);
    }
}