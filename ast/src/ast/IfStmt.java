package ast;

public class IfStmt extends Node {
    BinaryOperator expression;
    CompoundStmt then_block;
    CompoundStmt else_block;

    IfStmt(int p) {
        super(p);
    }

    @Override
    public String toString() {
        return "IfStmt [childern=" + childern + ", pos=" + pos + "]";
    }

    public BinaryOperator getExpression() {
        return expression;
    }

    public void setExpression(BinaryOperator expression) {
        this.expression = expression;
    }

    public CompoundStmt getThen_block() {
        return then_block;
    }

    public void setThen_block(CompoundStmt then_block) {
        this.then_block = then_block;
    }

    public CompoundStmt getElse_block() {
        return else_block;
    }

    public void setElse_block(CompoundStmt else_block) {
        this.else_block = else_block;
    }

    @Override
    public String codeGen(Code c) {
        return "Test";
    }

    public Variable eval(Context c) {
        int sz = childern.size();
        System.out.println("DeclStmt - eval sz "+sz);
        Node n;
        for (int i=0;i<sz;i++) {
            n = childern.get(i);
            n.eval(c);
        }
        return null;
    }

}
