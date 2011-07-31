import java.util.*;
public LispSymbolTable{
	String[][] SymbolTable = new String[3000][3];
	int size = 0;
	LispSymbolTable(){
		SymbolTable[size][0] = null;
		SymbolTable[size][1] = null;
		SymbolTable[size][2] = null;
	}
	LispSymbolTable(String ref, String type, String name){
		SymbolTable[size][0] = ref;
		SymbolTable[size][1] = type;
		SymbolTable[size][2] = name;
		size++;
	}
	public void printSymbolTable(){
		for(int a = 0; a < size; a++){
			System.out.println(SymbolTable[size][0] + ", " + SymbolTable[size][1] + ", " + SymbolTable[size][2] );
		}
	}
	public String getSymbolTable(){
		return SymbolTable;
	}
	public String getSymbolTable(int a){
		return SymbolTable[a][];
	}
	public String getSymbolTable(String name){
		for(int a = 0; a < size; a++){
			if(SymbolTable[a][2].equals(name)){
				return SymbolTable[a][];
			}
		}
		return null;
	}
}