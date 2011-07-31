import java.util.*;
public class LISP{
	private interface Visitor {
	    void visit (Loop loop);
		void visit (LIST list);
		void visit (Plus op);
		void visit (Minus op);
		void visit (Times op);
		void visit (Divide op);
		void visit (Number num);
		void visit (Variable var);
		void visit (CAR car);
		void visit (CDR cdr);
		void visit (CONS cons);
		void visit (NULL? nul?);
		void visit (LIST? list?);
		void visit (FIRST first);
		void visit (CADR cadr);
		void visit (CDDR cddr);
		void visit (CADDR caddr);
		void visit (DEFINE define);
		void visit (LAMBDA lambda);
		void visit (ATOMS atoms);
		void visit (SQUARE square);
		void visit (Program program);
	}
	public interface Node {
	        void accept (Visitor v);
	}
	public class Plus implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Minus implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Times implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Divide implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Number implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Variable implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class CAR implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class CDR implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class CONS implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class NULL? implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class LIST? implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class FIRST implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class CADR implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class CDDR implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class CADDR implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class DEFINE implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class LAMBDA implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class SQUARE implements Node{
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Loop implements Node{
		public Node body;
		
		public Loop(Sequence a) {
			// TODO Auto-generated constructor stub
			body = a;
		}

		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class LIST implements Node{
		//list of nodes Linked List
		LinkedList<Node> stack = new LinkedList<Node>();
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			for(Node child : stack){
				child.accept(v);
			}
		}
		//create add node method
		public void addNode(Node n){
			stack.add(n);
		}
	}
	public class ATOMS implements Node{
		//list of nodes Linked List
		LinkedList<Node> stack = new LinkedList<Node>();
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			for(Node child : stack){
				child.accept(v);
			}
		}
		//create add node method
		public void addNode(Node n){
			stack.add(n);
		}
	}
	public static class Program implements Node{
		public Node body;
		Program(Sequence a){
			body = a;
		}
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visit(this);
		}
	}
	public class Sequence implements Node{
		//list of nodes Linked List
		LinkedList<Node> children = new LinkedList<Node>();
		@Override
		public void accept(Visitor v) {
			// TODO Auto-generated method stub
			for(Node child : children){
				child.accept(v);
			}
		}
		//create add node method
		public void addNode(Node n){
			children.add(n);
		}
	}
	public LinkedList<String> stack = new LinkedList<String>();
	public String[][] SymbolTable = new String[3000][3];
	public int SymbolTableSize = 0;
	public static Program parse (String str) {
	        return new Program (new LISP().doParse(str));
	}
	public static class PrintVisitor implements Visitor {
	        public void visit (Plus n) { System.out.print('+'); }
			public void visit (Minus n) { System.out.print('-');}
			public void visit (Times n) { System.out.print('*');}
			public void visit (Divide n) { System.out.print('/');}
			public void visit (CAR n) {System.out.print("car");}
			public void visit (CDR n) { System.out.print("cdr");}
			public void visit (CONS n) { System.out.print("cons");}
			public void visit (NULL? n) { System.out.print("null?");}
			public void visit (LIST? n) { System.out.print("list?");}
			public void visit (FIRST n) { System.out.print("first");}
			public void visit (CADR n) { System.out.print("cadr");}
			public void visit (CDDR n) { System.out.print("cddr");}
			public void visit (CADDR n) { System.out.print("caddr");}
			public void visit (DEFINE n) { System.out.print("define");}
			public void visit (LAMBDA n) { System.out.print("lambda");}
			public void visit (ATOMS n) { System.out.print("atoms");}
			public void visit (SQUARE n) { System.out.print("square");}
			public void visit (LIST n) { System.out.print("list");}
	        public void visit (Loop n) {
	                System.out.print('(');
	                n.body.accept(this);
	                System.out.print(')');
	        }
	        public void visit (Program n) { n.body.accept(this); }

	}
	public static class InterpreterVisitor implements Visitor {
		public byte[] array = new byte[10000];
		public int pos = 0;
		/*public InterpreterVisitor(){
			for(int a = pos; a < 10000; a++){
				array[a] = (byte)(array[a] + 65);
			}
		}*/
        public void visit (Left n) {pos--; 
        //System.out.println("Left " + pos);
        }
        public void visit (Right n) {pos++;
        //System.out.println("Right " + pos);
        }
        public void visit (Increment n) {array[pos]++; 
        //System.out.println("Increment " + pos + " " + (int)(array[pos]) + "\n" + (char)(array[pos]));
        }
        public void visit (Decrement n) {array[pos]--;
        //System.out.println("Decrement " + pos + " " + (int)(array[pos]) +"\n" + (char)(array[pos]));
        }
        public void visit (Input n) {
        	Scanner input = new Scanner(System.in);
        	byte in = input.nextByte();
        	array[pos] = in;
        }
        public void visit (Output n) { System.out.print((char)array[pos]); }
        public void visit (Loop n) {
                //System.out.print('[');
        		//while(n.equals(']')){
        		//int size = (int)array[pos];
        		//if(size < 0) {
        			//size = size*-1;
        		//}
        		/*for(int a = size; a > 0; a--){
        			//System.out.println("Loop " + a);
        			n.body.accept(this);
        		}*/
        		int size = (int) array[pos];
    			while(size != 0){
    				n.body.accept(this);
    				size = (int) array[pos];
    			}
        		//}
                //System.out.print(']');
        }
        public void visit (Program n) { n.body.accept(this); }

	}
	public static class CompilerVisitor implements Visitor {
		//compiler visitor that prints out C++ source code
        public void visit (Left n) { System.out.print("ptr--"); }
        public void visit (Right n) { System.out.print("ptr++"); }
        public void visit (Increment n) { System.out.print("*ptr++"); }
        public void visit (Decrement n) { System.out.print("*ptr--"); }
        public void visit (Input n) { System.out.print("cin >> ptr"); }
        public void visit (Output n) { System.out.print("cout << *ptr"); }
        public void visit (Loop n) {
                System.out.print("while (*ptr){");
                n.body.accept(this);
                System.out.print("}");
        }
        public void visit (Program n) { n.body.accept(this); }

	}
	public boolean isAlpha(String c){
		char[] regexes = new char[26];
		for(char c = 'a'; c <= 'z'; c++){
			regexes[c-'a'] = c;
		}
		for(int a = 0; a < 26; a++){
			if(c.equalsIgnoreCase(regexes[a])) {return true;}
		}
		return false;
	}
	public boolean isDigit(String c){
		try{        
			Integer.parseInt(c);    
		} 
		catch(NumberFormatException nfe) {        
			return false;    
		}    
		return true;
	}
	private Sequence doParse(String str){
		Sequence a = new Sequence();
		if(str.charAt(0) != '(' && input.charAt(str.length()-1) != ')'){ 
			System.out.printn("Incorrect syntax for Lisp command");
			return a;
		}
		else {
			String[] command;
			command = str.split("\\s+");
			for(int a = 0; a < command.length(); a++){
				if(command[a].equalsIgnoreCase("LIST")){
					stack.add(new LIST());
					CreateSymbolTable((a.getClass()).toString(),"LIST",command[a])
				}
				else if(command[a].equalsIgnoreCase("ATOMS")){
					a.add(new ATOMS());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"ATOMS",command[a])
				}
				else if(command[a].equalsIgnoreCase("CAR")){
					a.add(new CAR());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CAR",command[a])
				}
				else if(command[a].equalsIgnoreCase("CDR")){
					a.add(new CDR());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CDR",command[a])
				}
				else if(command[a].equalsIgnoreCase("CONS")){
					a.add(new CONS());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CONS",command[a])
				}
				else if(command[a].equalsIgnoreCase("NULL?")){
					a.add(new NULL?());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"NULL",command[a])
				}
				else if(command[a].equalsIgnoreCase("LIST?")){
					a.add(new LIST?());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"LIST?",command[a])
				}
				else if(command[a].equalsIgnoreCase("FIRST")){
					a.add(new FIRST());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"FIRST",command[a])
				}
				else if(command[a].equalsIgnoreCase("CADR")){
					a.add(new CADR());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CADR",command[a])
				}
				else if(command[a].equalsIgnoreCase("CDDR")){
					a.add(new CDDR());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CDDR",command[a])
				}
				else if(command[a].equalsIgnoreCase("CADDR")){
					a.add(new CADDR());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CADDR",command[a])
				}
				else if(command[a].equalsIgnoreCase("DEFINE")){
					a.add(new DEFINE());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"DEFINE",command[a])
				}
				else if(command[a].equalsIgnoreCase("LAMBDA")){
					a.add(new LAMBDA());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"LAMBDA",command[a])
				}
				else if(command[a].equalsIgnoreCase("CDR")){
					a.add(new CDR());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"CDR",command[a])
				}
				else if(command[a].equalsIgnoreCase("+")){
					a.add(new Plus());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"+",command[a])
				}
				else if(command[a].equalsIgnoreCase("-")){
					a.add(new Minus());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"-",command[a])
				}
				else if(command[a].equalsIgnoreCase("*")){
					a.add(new Times());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"*",command[a])
				}
				else if(command[a].equalsIgnoreCase("/")){
					a.add(new Divide());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"/",command[a])
				}
				else if(isAlpha(command[a])){
					a.add(new Variable());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"Variable",command[a])
				}
				else if(isDigit(command[a])){
					a.add(new Number());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"Number",command[a])
				}
				else if(command.equals("(") || command.equals(")")){
					a.add(new Loop());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"LOOP",command[a])
				}
				else if(command.equalsIgnoreCase("square")){
					a.add(new SQUARE());
					stack.add(command[a]);
					CreateSymbolTable((a.getClass()).toString(),"Square",command[a])
				}
			}
		}
		return a;
	}
	private Sequence CreateSymbolTable(String ref, String type, String name){
		SymbolTable[size][0] = ref;
		SymbolTable[size][1] = type;
		SymbolTable[size][2] = name;
		SymbolTableSize++;
	}
	public void PrintSymbolTable(){
		for(int a = 0; a < SymbolTableSize; a++){
			System.out.println("Reference#:" + SymbolTable[a][0] + ", Type:" + SymbolTable[a][1] + ", Name:" + SymbolTable[a][2]);
		}
	}
	public static void main (String[] args) {
	        Node hello = LISP.parse("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.");
			hello.accept(new LISP.PrintVisitor());
	        System.out.println(" ");
	        hello.accept(new LISP.InterpreterVisitor());
	        hello.accept(new LISP.CompilerVisitor());//compiler for C++ language
	        System.out.println("");
	        hello.accept(new LISP.CompilerVisitor2());//Next Steps create compiler for Python language
	        System.out.println(" ");
	        //Next Steps print your name in BrainFuck
	        Node name = LISP.parse("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>----.>++++++++++++++.---------.--------.+++++++++++++.>++.<<++++++++.>+.++++.--------------.");
	        name.accept(new LISP.PrintVisitor());
	        System.out.println(" ");
	        name.accept(new LISP.InterpreterVisitor());
	}
}