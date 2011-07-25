public LispParser extends AST{
	LinkedList<Node> stack = new LinkedList<Node>();
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
				if(command[a].equalsIgnoreCase("LIST")){
					stack.add(new LIST());
				}
				else if(command[a].equalsIgnoreCase("ATOMS")){
					stack.add(new ATOMS());
				}
				else if(command[a].equalsIgnoreCase("CAR")){
					stack.add(new CAR());
				}
				else if(command[a].equalsIgnoreCase("CDR")){
					stack.add(new CDR());
				}
				else if(command[a].equalsIgnoreCase("CONS")){
					stack.add(new CONS());
				}
				else if(command[a].equalsIgnoreCase("NULL?")){
					stack.add(new NULL?());
				}
				else if(command[a].equalsIgnoreCase("LIST?")){
					stack.add(new LIST?());
				}
				else if(command[a].equalsIgnoreCase("FIRST")){
					stack.add(new FIRST());
				}
				else if(command[a].equalsIgnoreCase("CADR")){
					stack.add(new CADR());
				}
				else if(command[a].equalsIgnoreCase("CDDR")){
					stack.add(new CDDR());
				}
				else if(command[a].equalsIgnoreCase("CADDR")){
					stack.add(new CADDR());
				}
				else if(command[a].equalsIgnoreCase("DEFINE")){
					stack.add(new DEFINE());
				}
				else if(command[a].equalsIgnoreCase("LAMBDA")){
					stack.add(new LAMBDA());
				}
				else if(command[a].equalsIgnoreCase("CDR")){
					stack.add(new CDR());
				}
				else if(command[a].equalsIgnoreCase("+")){
					stack.add(new Plus());
				}
				else if(command[a].equalsIgnoreCase("-")){
					stack.add(new Minus());
				}
				else if(command[a].equalsIgnoreCase("*")){
					stack.add(new Times());
				}
				else if(command[a].equalsIgnoreCase("/")){
					stack.add(new Divide());
				}
				else if(isAlpha(command[a])){
					stack.add(new Id());
				}
				else if(isDigit(command[a])){
					stack.add(new Id());
				}
				else if(command[a].equals("(") || command[a].equals(")")){
					stack.add(new Loop());
				}
			}
		}
		return stack;
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
}