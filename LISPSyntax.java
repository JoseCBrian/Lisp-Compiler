import java.util.*;
public class Syntax extends AST{
	String one;
	String two;
	String three;
	public Syntax(){ //default constructor
		one = null;
		two = null;
		three = null;
	}
	public Syntax(String o, String t, String th){ //primary constructor
		one = o;
		two = t;
		three = th;
		if(isOperator(one)) {
			if(checkOperation(two, three)){
				return "Incorrect Syntax";
			}
		}
	}
	public boolean checkList(String op, Node n){//checks if the operation is LIST? spelled right and the second object is a list
		if(op.equalsIgnoreCase("list?")){
			if(n.getClass == LIST()){return true;}
			else {return false;}
		}
		else {return false;}
	}
	public boolean checkNull(String op, Node n){ //checks if the operation is NULL? spelled correctly and the second object is null
		if(op.equalsIgnoreCase("NULL?")){
			if(n == null) {return true;}
			else {return false;}
		}
		else {return false;}
	}
	public boolean checkFirst(String op, Node n){
		if(op.equalsIgnoreCase("First")){
			if(n != null){return true;}
			else {return false;}
		}
		else {return false;}
	}
	public boolean checkCAR(String op, Node n){
		if(op.equalsIgnoreCase("car") || op.equalsIgnoreCase("cdr") || op.equalsIgnoreCase("cadr") || op.equalsIgnoreCase("cddr") || op.equalsIgnoreCase("caddr")){
			if(n.getClass == LIST() && n != null) {return true;}
			else {return false;}
		}
		else {return false;}
	}
	public boolean checkCONS(String op, Node x, Node n){
		if(op.equalsIgnoreCase("cons")){
			if(x != null){
				if(n.getClass == LIST() && n != null) {return true;}
				else {return false;}
			}
			else {return false;}
		}
		else {return false;}
	}
	public boolean checkDefine(String op, String x, Node n){
		if(op.equalsIgnoreCase("define") && x != null && n != null){return true;}
		else {return false;}
	}
	public boolean checkLambda(String op, Node l, Node e){
		if(op.equalsIgnoreCase("lambda") && l != null && e != null) {return true;}
		else {return false;}
	}
	public boolean checkOperation(String first, String second){ //checks if the operation sent in works
		if(isDigit(first) && isDigit(second)) {return true;}
		else {return false;}
	}
	public boolean isOperator(String c){ //checks if string sent in is an operator
		if(c.equals("+")) {return true;}
		else if(c.equals("-")) {return true;}
		else if(c.equals("/")) {return true;}
		else if(c.equals("*")) {return true;}
		else {return false;}
	}
	public boolean isDigit(String c){ //checks if string sent in is a digit
		try{        
			Integer.parseInt(c);    
		} 
		catch(NumberFormatException nfe) {        
			return false;    
		}    
		return true;
	}
	public boolean isAlpha(String c){ //checks if String sent in is alphabetic
		char[] regexes = new char[26];
		for(char c = 'a'; c <= 'z'; c++){
			regexes[c-'a'] = c;
		}
		for(int a = 0; a < 26; a++){
			if(c.equalsIgnoreCase(regexes[a])) {return true;}
		}
		return false;
	}
}