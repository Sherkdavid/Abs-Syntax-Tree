package ast;

public class CompoundStmt extends Node {

	public CompoundStmt(int p) {
		super(p);
	}

	@Override
	public String toString() {
		return "CompoundStmt [childern=" + childern + ", pos=" + pos + "]";
	}

	@Override
	public Variable eval(Context c) {
		int sz = childern.size();
		System.out.print("{");
		Node n;
		for (int i=0;i<sz;i++) {
			n = childern.get(i);
			n.eval(c);
		}
		System.out.print("}");
		return null;
	}
}
