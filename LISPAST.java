import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class AST {
	public interface Node {
		<T> T accept (Visitor<T> v);
	}
	public interface Visitor<T> {
		T visit (Loop loop);
		T visit (LIST list);
		T visit (Branch branch);
		T visit (Block block);
		T visit (Assign assign);
		T visit (Id id);
		T visit (Operator op);
		T visit (Plus op);
		T visit (Minus op);
		T visit (Times op);
		T visit (Divide op);
		T visit (Number num);
		T visit (CAR car);
		T visit (CDR cdr);
		T visit (CONS cons);
		T visit (NULL? nul?);
		T visit (LIST? list?);
		T visit (FIRST first);
		T visit (CADR cadr);
		T visit (CDDR cddr);
		T visit (CADDR caddr);
		T visit (DEFINE define);
		T visit (LAMBDA lambda);
		T visit (ATOMS atoms);
		T visit (SQUARE square);
	}
	public interface Statement extends Node {}
	public interface Expression extends Node {}
	public static class Id implements Expression {
		String id;
		public Id (String id) { this.id = id; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static Id id (String id) { return new Id (id); }
	public static class Assign implements Statement {
		Id variable; Expression value;
		public Assign (Id variable, Expression value) { this.variable = variable; this.value = value; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static Assign assign (Id var, Expression val) { return new Assign (var, val); }
	public static class Block implements Statement {
		Statement[] statements;
		public Block (Statement ... statements) { this.statements = statements; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static Block block (Statement... statements) { return new Block (statements); }
	public static class Branch implements Statement {
		Expression predicate; Statement ifBranch; Statement elseBranch;
		public Branch (Expression p, Statement a, Statement b) { predicate = p; ifBranch = a; elseBranch = b; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static Branch branch (Expression predicate, Statement ifBranch, Statement elseBranch) { return new Branch (predicate, ifBranch, elseBranch); }
	public static class Loop implements Statement {
		Expression predicate; Statement body;
		public Loop (Expression p, Statement body) { predicate = p; this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static Loop loop (Expression predicate, Statement body) { return new Loop (predicate, body); }
	public static class Number implements Expression {
		int n;
		public Number (int n) { this.n = n; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static Number number (int n) { return new Number (n); }
	public static class Operator implements Expression {
		Expression left; Expression right; 
		private Operator (Expression left, Expression right) {this.left = left; this.right = right; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static class Plus extends Operator {
		public Plus(Expression left, Expression right) { super(left, right); }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static Plus plus (Expression left, Expression right) { return new Plus (left, right); }
	public static class Minus extends Operator {
		public Minus (Expression left, Expression right) { super(left, right); }
		public <T> T accept (Visitor<T> v) { return v.visit(this); }
	}
	public static Minus minus (Expression left, Expression right) { return new Minus (left, right); }
	public static class Times extends Operator {
		public Times (Expression left, Expression right) { super(left, right); }
		public <T> T accept (Visitor<T> v) { return v.visit(this); }
	}
	public static Times times (Expression left, Expression right) { return new Times (left, right); }
	public static class Divide extends Operator {
		public Divide (Expression left, Expression right) { super(left, right); }
		public <T> T accept (Visitor<T> v) { return v.visit(this); }
	}
	public static Divide divide (Expression left, Expression right) { return new Divide (left, right); }
	public static class SQUARE extends Operator {
		public SQUARE (Expression left, Expression right) { super(left, right); }
		public <T> T accept (Visitor<T> v) { return v.visit(this); }
	}
	public static SQUARE square (Expression left, Expression right) { return new SQUARE (left, right); }
	
	public static class DEFINE implements Statement {
		Id variable; Expression value;
		public DEFINE (Id variable, Expression value) { this.variable = variable; this.value = value; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static DEFINE define (Id var, Expression val) { return new DEFINE (var, val); 
	
	public static class LIST implements Node {
		LinkedList<T> stack = new LinkedList<T>();
		//public Loop (Expression p, Statement body) { predicate = p; this.body = body; }
		public void T accept(Visitor v) { 
			for(<T> child : stack){
				child.accept(v);
			}
		}
		//create add node method
		public void addNode(<T> n){
			stack.add(n);
		}
	}
	public static LIST list (<T> n) { return new LIST(n); }
	public static class ATOMS implements Node {
		LinkedList<T> stack = new LinkedList<T>();
		//public Loop (Expression p, Statement body) { predicate = p; this.body = body; }
		public void T accept(Visitor v) { 
			for(<T> child : stack){
				child.accept(v);
			}
		}
		//create add node method
		public void addNode(<T> n){
			stack.add(n);
		}
	}
	public static ATOMS list (<T> n) { return new ATOMS(n); }
	
	public static class CAR implements LIST {
		Statement body;
		public CAR (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CAR car (Statement body) { return new CAR(body); }
	public static class CDR implements LIST {
		Statement body;
		public CDR (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CDR cdr (Statement body) { return new CDR(body); }
	public static class CONS implements LIST {
		Statement body;
		public CONS (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CONS cons (Statement body) { return new CONS(body); }
	public static class NULL? implements LIST {
		Statement body;
		public NULL? (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static NULL? nul? (Statement body) { return new NULL?(body); }
	public static class LIST? implements LIST {
		Statement body;
		public LIST? (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static LIST? list? (Statement body) { return new LIST?(body); }
	public static class FIRST implements LIST {
		Statement body;
		public FIRST (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static FIRST first (Statement body) { return new FIRST(body); }
	public static class CADR implements LIST {
		Statement body;
		public CADR (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CADR cadr (Statement body) { return new CADR(body); }
	public static class CADDR implements LIST {
		Statement body;
		public CADDR (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CADDR caddr (Statement body) { return new CADDR(body); }
	public static class CDDR implements LIST {
		Statement body;
		public CDDR (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CDDR cddr (Statement body) { return new CDDR(body); }
	public static class CAR implements LIST {
		Statement body;
		public CAR (Statement body) {this.body = body; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }
	}
	public static CAR car (Statement body) { return new CAR(body); }
	public static class LAMBDA implements Statement {
		Id variable; Expression value;
		public LAMBDA (Id variable, Expression value) { this.variable = variable; this.value = value; }
		public <T> T accept(Visitor<T> v) { return v.visit(this); }		
	}
	public static LAMBDA lambda (Id var, Expression val) { return new LAMBDA(var, val); }
	
	
	public static class ExpressionInterpreter implements Visitor<Integer> {
		Map<String, Integer> symbols;
		public ExpressionInterpreter(Map<String, Integer> symbols) {
			this.symbols = symbols;
		}
		public Integer visit(Id id) {
			if (symbols.containsKey(id.id))
				return symbols.get(id.id);
			else return 0;
		}
		public Integer visit(Operator op) {
			return null;
		}
		public Integer visit(Plus op) {
			return op.left.accept(this) + op.right.accept(this);
		}
		public Integer visit(Minus op) {
			return op.left.accept(this) - op.right.accept(this);
		}
		public Integer visit(Times op) {
			return op.left.accept(this) * op.right.accept(this);
		}
		public Integer visit(Divide op) {
			return op.left.accept(this) * op.right.accept(this);
		}
		public Integer visit(Number num) {
			return num.n;
		}
		public Integer visit(Loop loop) { return null; }
		public Integer visit(Branch branch) { return null; }
		public Integer visit(Block block) { return null; }
		public Integer visit(Assign assign) { return null; }
	}
	public static class StatementInterpreter implements Visitor<Void> {
		Map<String,Integer> symbols = new HashMap<String, Integer>();
		ExpressionInterpreter eval = new ExpressionInterpreter(symbols);
		public Void visit(Loop loop) {
			while (loop.predicate.accept(eval) != 0)
				loop.body.accept(this);
			return null;
		}
		public Void visit(Branch branch) {
			if (branch.predicate.accept(eval) != 0)
				branch.ifBranch.accept(this);
			else
				branch.elseBranch.accept(this);
			return null;
		}
		public Void visit(Block block) {
			for (Statement s : block.statements)
				s.accept(this);
			return null;
		}
		public Void visit(Assign assign) {
			symbols.put(assign.variable.id, assign.value.accept(eval));
			return null;
		}
		public Void visit(Id id) { return null; }
		public Void visit(Operator op) { return null; }
		public Void visit(Plus op) { return null; }
		public Void visit(Minus op) { return null; }
		public Void visit(Times op) { return null; }
		public Void visit(Divide op) { return null; }
		public Void visit(Number num) { return null; }
		public Void visit(CAR car) { return null; }
		public Void visit(CDR cdr) { return null; }
		public Void visit(CONS cons) { return null; }
		public Void visit(Null? nul?) { return null; }
		public Void visit(LIST? list?) { return null; }
		public Void visit(FIRST first) { return null; }
		public Void visit(CADR cadr) { return null; }
		public Void visit(CDDR cddr) { return null; }
		public Void visit(CADDR caddr) { return null; }
		public Void visit(DEFINE DEFINE) { return null; }
		public Void visit(LAMBDA lambda) { return null; }
		public Void visit(SQUARE square) { return null; }
		public Void visit(ATOMS atoms) { return null; }
	}
	public static void main (String[] args) {
		/*
		 * Example program from book
		 */
		Node program = branch(plus(id("x"),id("y")),
						block(
								loop(id("z"),
										assign(id("z"),plus(id("z"),number(1)))), 
								assign(id("x"), number(8))),
				assign(id("z"),number(7)));
		/*
		 * Factorial Program equivalent to:
		 * int factorial = 1;
		 * int i = 5;
		 * while (i != 0) {
		 * 		factorial = factorial * i;
		 * 		i = i - 1;
		 * }
		 */
		Node factorial = block(
				assign (id ("factorial"), number(1)),
				assign (id ("i"), number(5)),
				loop (id ("i"),
						block(assign (id("factorial"),times(id("factorial"), id("i"))),
							  assign (id ("i"), minus(id("i"), number(1)))))
				);
		StatementInterpreter runner = new StatementInterpreter();
		factorial.accept(runner);
		/* 
		 * Print the symbols in the interpreter.
		 */
		for (String s : runner.symbols.keySet())
			System.out.format("%s: %d\n", s, runner.symbols.get(s));
	}
}

