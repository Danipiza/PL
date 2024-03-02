/*package alex;

public enum ClaseLexica {
 IDEN, 
 ENT, 
 REAL, 
 PAP("("), 
 PCIERRE(")"), 
 IGUAL("="), 
 COMA(","), 
 MAS("+"), 
 MENOS("-"), 
 POR("*"), 
 DIV("/"), 
 EVALUA("<evalua>"), 
 DONDE("<donde>"), 
 EOF("EOF");
private String image;
public String getImage() {
     return image;
 }
 private ClaseLexica() {
     image = toString();
 }
 private ClaseLexica(String image) {
    this.image = image;  
 }

}*/


package alex;

public enum ClaseLexica {
	// De Tiny(0)
	IDEN, PAP, PCIERRE, ASIG, COMA, 
	MAS, MENOS, POR, DIV, EVAL, EOF, 
	
	GT, GE, LT, LE, EQ, NE, PYC, LLAP, LLCIERRE, SEP, E, LITERALENTERO, LITERALREAL,
	
	TRUE, FALSE, AND, OR, NOT, BOOL,ENT, REAL,

	// Nuevo
	MOD, CAP, CCIERRE, PUNTO, CIRCUNFLEJO, AMP,

	LITERALCADENA,

	STRING, NULL, PROC, IF, ELSE, WHILE, STRUCT, NEW, DELETE, READ, WRITE, NL, TYPE, CALL,
}
