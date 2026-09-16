import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public class PostfixVisitor extends ExprBaseVisitor<String> {

    @Override
    public String visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        String value = visit(ctx.expr());

        return id + "=" + value;
    }

    @Override
    public String visitPrintExpr(ExprParser.PrintExprContext ctx) {
        String value = visit(ctx.expr());
        System.out.println(value);

        return value;
    }

    @Override
    public String visitInt(ExprParser.IntContext ctx) {
        return ctx.INT().getText();
    }

    @Override
    public String visitId(ExprParser.IdContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitMulDiv(ExprParser.MulDivContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        return left + " " + right + " " + ctx.op.getText();
    }

    @Override
    public String visitAddSub(ExprParser.AddSubContext ctx) {
        String left = visit(ctx.expr(0));
        String right = visit(ctx.expr(1));

        return left + " " + right + " " + ctx.op.getText();
    }

    @Override
    public String visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
