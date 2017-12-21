package ast;

public class WhileStmt extends Node{
    BinaryOperator expression;
    CompoundStmt then_block;

    WhileStmt(int p) {
        super(p);
    }

    @Override
    public String toString() {
        return "WhileStmt [childern=" + childern + ", pos=" + pos + "]";
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

    @Override
    public String codeGen(Code c) {
        return "filler";
    }
    @Override
    public Variable eval(Context c) {
        int sz = childern.size();
        Node n;
        System.out.print("while");
        for (int i=0;i<sz;i++) {
            n = childern.get(i);
            n.eval(c);
        }
        return null;
    }

}
