package ast;

public class CompoundStmt extends Node {

	public CompoundStmt(int p) {
		super(p);
	}

	@Override
	public String toString() {
		return "CompoundStmt [childern=" + childern + ", pos=" + pos + "]";
	}
}
