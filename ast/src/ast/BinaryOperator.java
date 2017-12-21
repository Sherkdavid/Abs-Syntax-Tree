package ast;

public class BinaryOperator extends Node{
    String op;

	public BinaryOperator(int pos,String op) {
		super(pos);
		this.op = op;
	}

	@Override
	public String toString() {
		return "BinaryOperator [op=" + op + "]";
	}
	public String codeGen(Code c) {
		System.out.println("Binaryoperator -codegen");
        if (childern.size()!=2)
        	System.out.println("need to operands for "+op);
        String left=childern.get(0).codeGen(c);
        String right =childern.get(1).codeGen(c);
        switch (op) {
        case "=":
	    	c.code += "str "+right+",["+left+"]"+"\n";
	    	return null;
        case "+":
        	String reg = c.getRegister();
        	c.code += "add "+reg+","+left+","+right+"\n";
	    	return reg;
        
        	
        
        }
        
      return null;     	
		
	}
	public Variable eval(Context c) {
	//	System.out.println("Binaryoperator -eval");
        if (childern.size()!=2)
        	System.out.println("need to operands for "+op);
        Variable left=childern.get(0).eval(c);
        Variable right =childern.get(1).eval(c);
        switch (op) {
        case "=":
	    	left.set(right);
	    	System.out.println("assign "+left.name+" = "+left.val);
	    	return null;
        case "+":
        	Variable v = new Variable("",left.val+right.val);
        	
	    	return v;
			case "<":
				System.out.println("while ("+left.name + " < " + right.name+")");
				break;
			case ">":
				System.out.println("while ("+left.name + " > " + right.name+")");
        }
        
      return null;     	
		
	}
}
