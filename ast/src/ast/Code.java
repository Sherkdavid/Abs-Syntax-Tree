package ast;

import java.util.Stack;

public class Code {

	String data;
	String code;
	Stack allocatedRegs;
	String[] registers = {"r0","r1","r2","r3","r4","r5"};
	int noregs;
	int sp;
	
	Code(){
		data="\n";
		code="\n";
		allocatedRegs=new Stack();
		sp=0;
		
	}
	void resetRegisters() {
		noregs=0;
		allocatedRegs.clear();
	}
	int getStackVar() {
		sp+=4;
		return sp-4;
	}
	String getRegister() {
		return registers[noregs++];
	}
	void Print(){
		System.out.println("data "+data);
		System.out.println("code "+code);
	}
}
