import java.util.HashMap;
import java.util.Map;

public abstract class UnidadLexica {
	
	private ClaseLexica clase;
	private int fila;
	private int columna;
	private Map<ClaseLexica, String> hashMap;
   
	public UnidadLexica(int fila, int columna, ClaseLexica clase) {
		this.fila = fila;
		this.columna = columna;
		this.clase = clase;
		init();
	}
	
	private void init() {
		hashMap = new HashMap<>();
		hashMap.put(ClaseLexica.PAP, "(");
		hashMap.put(ClaseLexica.PCIERRE, ")");
		hashMap.put(ClaseLexica.IGUAL, "=");		
		hashMap.put(ClaseLexica.MAS, "+");
		hashMap.put(ClaseLexica.MENOS, "-");
		hashMap.put(ClaseLexica.POR, "*");
		hashMap.put(ClaseLexica.DIV, "/");
		hashMap.put(ClaseLexica.COMA, ",");
		hashMap.put(ClaseLexica.EOF, "EOF");
		
		
		
	
		//hashMap.put(ClaseLexica.ENT, "<int>");
		//hashMap.put(ClaseLexica.REAL, "<real>");
		hashMap.put(ClaseLexica.EVALUA, "<evalua>");
		hashMap.put(ClaseLexica.DONDE, "<donde>");
		
		
		
		
		/*IDEN
		  
		 SEP, E,
		
		TRUE, FALSE, AND, OR, NOT, BOOL,ENT, REAL*/
	}
	
	public String print() {
		return hashMap.get(clase);
	}
   
	public ClaseLexica clase () { return clase; }   
	public abstract String lexema();   
	public int fila() { return fila; }   
	public int columna() { return columna; }
}
