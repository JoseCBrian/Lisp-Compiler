import java.util.*;
public LispParser extends AST{
	LinkedList<Node> stack = new LinkedList<Node>();
	LinkedList<String> stack2 = new LinkedList<String>();
	String input;
	LispParser(){//default constructor
		input = null;
	}
	LispParser(String line){//constructor that takes in a line of LISP (usually lisp command are one lined and start and end with parentheisi)
		input = line;
		if(input.charAt(0) != '(' && input.charAt(input.length()-1) != ')'){ return "Incorrect Syntax";}
		else{
			input = input.subString(1,input.length()-1);
			char item;
			String[] command;
			command = input.split("\\s+");
			for(int a = 0; a < command.length(); a++){
				stack2.add(command[a]);
				String p = Parse(command[a]);
			}
		}
		return stack;
	}
	public String Parse(String command){
		if(command[a].equalsIgnoreCase("LIST")){
					stack.add(new LIST());
				}
				else if(command.equalsIgnoreCase("ATOMS")){
					stack.add(new ATOMS());
				}
				else if(command.equalsIgnoreCase("CAR")){
					stack.add(new CAR());
				}
				else if(command.equalsIgnoreCase("CDR")){
					stack.add(new CDR());
				}
				else if(command.equalsIgnoreCase("CONS")){
					stack.add(new CONS());
				}
				else if(command.equalsIgnoreCase("NULL?")){
					stack.add(new NULL?());
				}
				else if(command.equalsIgnoreCase("LIST?")){
					stack.add(new LIST?());
				}
				else if(command.equalsIgnoreCase("FIRST")){
					stack.add(new FIRST());
				}
				else if(command.equalsIgnoreCase("CADR")){
					stack.add(new CADR());
				}
				else if(command.equalsIgnoreCase("CDDR")){
					stack.add(new CDDR());
				}
				else if(command.equalsIgnoreCase("CADDR")){
					stack.add(new CADDR());
				}
				else if(command.equalsIgnoreCase("DEFINE")){
					stack.add(new DEFINE());
				}
				else if(command.equalsIgnoreCase("LAMBDA")){
					stack.add(new LAMBDA());
				}
				else if(command.equalsIgnoreCase("CDR")){
					stack.add(new CDR());
				}
				else if(command.equalsIgnoreCase("+")){
					stack.add(new Plus());
				}
				else if(command.equalsIgnoreCase("-")){
					stack.add(new Minus());
				}
				else if(command.equalsIgnoreCase("*")){
					stack.add(new Times());
				}
				else if(command.equalsIgnoreCase("/")){
					stack.add(new Divide());
				}
				else if(isAlpha(command)){
					stack.add(new Id());
				}
				else if(isDigit(command)){
					stack.add(new Id());
				}
				else if(command.equals("(") || command.equals(")")){
					stack.add(new Loop());
				}
				else if(command.equalsIgnoreCase("square")){
					stack.add(new SQUARE());
				}
				else {
					return "Incorrect Syntax";
				}
				return "Parsed";
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
	
	public void print(){
		ListIterator<Node> listiter = stack.listIterator();
		ListIterator<String> list = stack2.listIterator();
		while(listiter.hasNext()) {
			Object current = listiter.next();
			System.out.print(current.toString() + " ");
		}
		System.out.println(" ");
		while(list.hasNext()) {
			Object current = listiter.next();
			System.out.print(current.toString() + " ");
		}
	}
}