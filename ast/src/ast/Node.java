package ast;

import java.util.ArrayList;

public class Node {
      ArrayList<Node> childern;
      int pos; // position in line in outputed ast
      
      Node (int p){
    	  pos =p;
    	  childern = new ArrayList<Node>();
      }
      void add(Node n) {
    	  childern.add(n);
      }

	public String toString() {
		return "Node [childern=" + childern + ", pos=" + pos + "]";
	}
	public String codeGen(Code c) {
	//	System.out.println("Code Gen: "+this.getClass().getName());
		return null;
	}
	public Variable eval(Context c) {
	//	System.out.println("Eval: "+this.getClass().getName());
		return null;
	}
}
