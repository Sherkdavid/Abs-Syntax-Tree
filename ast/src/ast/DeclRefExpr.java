package ast;

public class DeclRefExpr extends Node {
     String name;
     String type;
	public DeclRefExpr(int pos,String name, String type) {
		super(pos);
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return "DeclRefExpr [name=" + name + ", type=" + type + "]";
	}
	public String codeGen(Code c) {
		System.out.println("DeclRefExpr -codegen");
		String reg = c.getRegister();
		c.code += "ldr "+reg+", ="+name +"\n";
		return reg;
       
	    
	}
	public Variable eval(Context c) {
    	//System.out.println("DeclRefExpr -eval");
    	Variable v = c.getStackVar(name);
    	if (v == null)
    		System.out.println("v null in declrefexpr");
    	return v;
    }
}
