package ast;

public class ImplicitCastExpr extends Node {

	public ImplicitCastExpr(int p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ImplicitCastExpr []";
	}
	public String codeGen(Code c) {
		if (childern.size()!=1)
        	System.out.println("need an operands for Implicitcast");
		return childern.get(0).codeGen(c);
	}
	public Variable eval(Context c) {
		if (childern.size()!=1)
        	System.out.println("need an operands for Implicitcast");
		return childern.get(0).eval(c);
    }
}
