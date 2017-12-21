package ast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
HashMap<String,VarDecl> symboltable = new HashMap<String,VarDecl>();
HashMap<String,Node> parent = new HashMap<String,Node>();
BufferedReader reader;
Node head,n;
int oldpos=0;
n=null;
Code code = new Code();
Context context = new Context();
try {
	reader = new BufferedReader(new FileReader(
			"test.txt"));
	String line = reader.readLine();
	System.out.println(line);
	head=null;
	String name,type;
	while ((line = reader.readLine()) != null) {
		//System.out.println(line);
		// read next line
		n=null;
		int pos = line.indexOf('-');
		String str1 = line.substring(pos, line.length());
		int pos1 = str1.indexOf(' ');
		String ast = str1.substring(1, pos1);
	//	System.out.println("ast "+ast);
		String[] strs =str1.split(" ");
	//	for (int i=0;i<strs.length;i++)
		//	System.out.println("split["+i+"] ="+strs[i]+"=");
	
		switch (ast) {
			case "IfStmt":
				n=new IfStmt(pos);
				break;
			case "WhileStmt":
				n=new WhileStmt(pos);
				break;
		case "DeclRefExpr":
		   name = strs[strs.length-2].substring(1, strs[strs.length-2].length()-1);
		   type = strs[strs.length-1].substring(1, strs[strs.length-1].length()-1);
	       n = new DeclRefExpr(pos,name,type);
	 //      System.out.println(n);
	       break;
		case "BinaryOperator":
			  // type = strs[strs.length-2].substring(1, strs[strs.length-2].length()-1);
			   String op = strs[strs.length-1].substring(1, strs[strs.length-1].length()-1);
		       n = new BinaryOperator(pos,op);
		//       System.out.println(n);
		       break;
		case "IntegerLiteral":
			  // type = strs[strs.length-2].substring(1, strs[strs.length-2].length()-1);
			   String theint = strs[strs.length-1];
		       n = new IntegerLiteral(pos,Integer.parseInt(theint));
		   //    System.out.println(n);
		       break;
		case "CompoundStmt":
			  // work with compound statments
		       n = new CompoundStmt(pos);
		       if (head == null)
		    	   head = n;
		 //      System.out.println(n);
		       break;
		case "ImplicitCastExpr":
			  
		       n = new ImplicitCastExpr(pos);
		   //    System.out.println(n);
		       break;
		case "DeclStmt":
			  
		       n = new DeclStmt(pos);
		  //     System.out.println(n);
		       break;
		case "ReturnStmt":
			  
		       n = new ReturnStmt(pos);
		   //    System.out.println(n);
		       break;
		case "VarDecl":
			   name = strs[strs.length-2];
			   type = strs[strs.length-1].substring(1, strs[strs.length-1].length()-1);
		       n = new VarDecl(pos,name,type);
		       symboltable.put(name, (VarDecl)n);
		 //      System.out.println(n);
		       break;
		}
		Node parent1 = parent.get(""+(pos-2));
		if (parent1 != null) {
			
			parent1.add(n);
		//	System.out.println("parent "+parent1);
		}
		if (n!=null)
		parent.put(""+pos, n);
			
	}

	int sz = head.childern.size();

	for (int i=0;i<sz;i++) {
		code.resetRegisters();
	    n = head.childern.get(i);
		System.out.println(" codegen "+n);
		n.codeGen(code);
	}
	code.Print();
	for (int i=0;i<sz;i++) {
		n = head.childern.get(i);
		System.out.println(" eval "+n);
		n.eval(context);
	}
	reader.close();
} catch (IOException e) {
	e.printStackTrace();
}
	}
	
}
