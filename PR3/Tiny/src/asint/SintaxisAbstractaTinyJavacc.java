package asint;


import c_ast_descendente.Token;

public class SintaxisAbstractaTinyJavacc {
	
	// Default (No hay que tocar)
    public static abstract class Nodo  {
       public Nodo() {
		   fila=col=-1;
       }   
	   private int fila;
	   private int col;
	   public Nodo ponFila(int fila) {
		    this.fila = fila;
            return this;			
	   }
	   public Nodo ponCol(int col) {
		    this.col = col;
            return this;			
	   }
	   public int leeFila() {
		  return fila; 
	   }
	   public int leeCol() {
		  return col; 
	   }
    }
    
    // Expresiones
    public static abstract class Exp  extends  Nodo {
       public Exp() {
		   super();
       }   
       public String iden() {throw new UnsupportedOperationException();}
       public String valor() {throw new UnsupportedOperationException();}
       public Exp opnd0() {throw new UnsupportedOperationException();}
       public Exp opnd1() {throw new UnsupportedOperationException();}
    }
    private static abstract class ExpBin extends Exp {
        protected Exp opnd0;
        protected Exp opnd1;
        public ExpBin(Exp opnd0, Exp opnd1) {
            super();
            this.opnd0 = opnd0;
            this.opnd1 = opnd1;
        }
        public Exp opnd0() {return opnd0;}
        public Exp opnd1() {return opnd1;}

    }
    // Nuevo
    private static abstract class ExpUna extends Exp {
        protected Exp opnd0;
        public ExpUna(Exp opnd0) {
            super();
            this.opnd0 = opnd0;
        }
        public Exp opnd0() {return opnd0;}

    }
    // acceso
    private static abstract class ExpBin2 extends Exp {
        protected Exp opnd0;
        protected String opnd1;
        public ExpBin2(Exp opnd0, String opnd1) {
            super();
            this.opnd0=opnd0;
            this.opnd1=opnd1;
        }
        public Exp opnd0() {return opnd0;}
        //public Exp opnd1() {return opnd1;}

    }
    //
    
    // Nuevo
    public static class Prog extends Nodo {
	   private Bloq bloq;
       public Prog(Bloq bloq) {
		   super();
		   this.bloq = bloq;
       }   
       public Bloq decs() {return bloq;}
       public String toString() {
            return "prog("+bloq+")";
        } 
    }    
    public static class Bloq extends Nodo { // TODO extends Prog?
 	   	private DecsOp decsOp;
 	   	private InstrsOp instrsOp;
        public Bloq(DecsOp decsOp, InstrsOp instrsOp) {
 		   super();
 		   this.decsOp = decsOp;
 		   this.instrsOp = instrsOp;
        }   
        public DecsOp decsOp() {return decsOp;}
        public InstrsOp instrsOp() {return instrsOp;}
        public String toString() {
             return "bloq("+decsOp+","+instrsOp+")";
         } 
    }
    public static class Si_decs extends DecsOp {
    	private Decs decs; 
        public Si_decs(Decs decs) {
 		   super();
 		   this.decs = decs;
        }   
        public Decs decs() {return decs;}
        public String toString() {
             return "si_decs("+decs+")";
         } 
    }    
    public static class No_decs extends DecsOp {
        public No_decs() {
           super();
        }   
        public String toString() {
             return "no_decs()";
         } 
    }
    public static class Si_instrs extends InstrsOp {
    	private Instrs instrs; 
        public Si_instrs(Instrs  instrs) {
 		   super();
 		   this.instrs = instrs;
        }   
        public Instrs instrs() {return instrs;}
        public String toString() {
             return "si_intrs("+instrs+")";
         } 
    }    
    public static class No_instrs extends InstrsOp {
        public No_instrs() {
           super();
        }   
        public String toString() {
             return "no_intrs()";
         } 
    }
    
    public static class Si_tipo extends Tipo { // TODO extends ?
 	   	private Tipo tipo;
 	   	
        public Si_tipo(Tipo tipo) {
 		   super();
 		   this.tipo= tipo; 		   
        }   
        public Tipo tipo() {return tipo;}
        public String toString() {
             return "si_tipo("+tipo+")";
         } 
    }
    public static class No_tipo extends Tipo { // TODO extends ?
        public No_tipo() {
           super();
        }   
        public String toString() {
             return "no_tipo()";
         } 
    }
    public static class Tipo_lista extends Tipo { // TODO extends Tipo?
 	   	private Tipo tipo;
 	    private Token literalEntero;
        public Tipo_lista(Tipo tipo, Token literalEntero) {
 		   super();
 		   this.tipo = tipo;
 		   this.literalEntero = literalEntero;
        }   
        public Tipo tipo() {return tipo;}
        public Token literalEntero() {return literalEntero;}
        public String toString() {
             return "tipo_lista("+tipo+","+literalEntero+")";
         } 
    }
    public static class Tipo_circum extends Tipo { // TODO extends Tipo?
 	   	private Tipo tipo;
        public Tipo_circum(Tipo tipo) {
 		   super();
 		   this.tipo = tipo;
        }   
        public Tipo tipo() {return tipo;}
        public String toString() {
             return "tipo_circum("+tipo+")";
         } 
    }
    public static class Tipo_struct extends Tipo { // TODO extends Tipo?
 	   	private Campos campos;
        public Tipo_struct(Campos campos) {
 		   super();
 		   this.campos = campos;
        }   
        public Campos campos() {return campos;}
        public String toString() {
             return "tipo_struct("+campos+")";
         } 
    }
    public static class Tipo_iden extends Tipo { // TODO extends Tipo? 	   	
 	    private Token identificador;
        public Tipo_iden(Token identificador) {
 		   super();
 		   this.identificador = identificador;
        }   
        public Token identificador() {return identificador;}
        public String toString() {
             return "tipo_iden("+identificador+")";
         } 
    }
    public static class Tipo_int extends Tipo { // TODO extends Tipo? 	   	
        public Tipo_int() {
 		   super();
        }   
        public String toString() { // TODO
             return "tipo_int";
        } 
    }
    public static class Tipo_real extends Tipo { // TODO extends Tipo?
 	   	public Tipo_real() {
 		   super();
        }   
        public String toString() { // TODO
             return "tipo_real";
        }
    }
    public static class Tipo_bool extends Tipo { // TODO extends Tipo?
 	    public Tipo_bool() {
        	super();
        }   
        public String toString() { 
             return "tipo_bool";
        } 
    }
    public static class Tipo_string extends Tipo { // TODO extends Tipo?
 	   	public Tipo_string() {
 		   super(); 		   
        }           
        public String toString() { // TODO
             return "tipo_string";
        } 
    }
	
    /* Use "Campos"
    public static class Type_dec extends FTypeDec { 
 	   	private Tipo tipo;
 	   	private Token identificador;
 	   	private TypeDec typedec;
        public Type_dec(Tipo tipo, Token identificador, TypeDec typedec) {
 		   super();
 		   this.tipo = tipo;
 		   this.identificador = identificador;
 		   this.typedec = typedec;
        }   
        public Tipo tipo() {return tipo;}
        public Token identificador() {return identificador;}
        public TypeDec typedec() {return typedec;}
        public String toString() { // TODO ?
             return "typedec("+tipo+", "+identificador+", "+typedec+")";
         } 
    }
    public static class Si_FtypeDec extends FTypeDec  { // Si_decs, Si_parsRe
    	private TypeDec typedec; 
        public Si_FtypeDec(TypeDec typedec) {
 		   super();
 		   this.typedec = typedec;
        }   
        public TypeDec parsf() {return typedec;}
        public String toString() {
             return "si_FtypeDec("+typedec+")";
         } 
    }    
    public static class No_FtypeDec extends FTypeDec  { // No_decs, No_parsRe
        public No_FtypeDec() {
           super();
        }   
        public String toString() {
             return "no_FtypeDec()";
         } 
    }
    */
    

    public static class Muchos_campos extends Campos { // TODO extends ?
 	   	private Campos campos;
 	   	private Campo campo;
        public Muchos_campos(Campos campos, Campo campo) {
 		   super();
 		   this.campos = campos;
 		   this.campo = campo;
        }   
        public Campos decsOp() {return campos;}
        public Campo  instrsOp() {return campo;}
        public String toString() {
             return "muchos_campos("+campos+","+campo+")";
         } 
    }
    public static class Un_campo extends Campos { // TODO extends ?
 	   	private Campo campo;
        public Un_campo(Campo campo) {
 		   super();
 		   this.campo = campo;
        }   
        public Campo  instrsOp() {return campo;}
        public String toString() {
             return "un_campo("+campo+")";
         } 
    }
    public static class Crea_campo extends Campo { // TODO extends ?
 	   	private Tipo tipo;
    	private Token identificador;
        public Crea_campo(Tipo tipo, Token identificador) {
 		   super();
 		   this.tipo = tipo;
 		   this.identificador = identificador;
        }   
        public Tipo tipo() {return tipo;}
        public Token indentificador() {return identificador;}
        public String toString() {
        	return "crea_campo("+tipo+","+identificador+")";
         } 
    }
    
    public static class Muchas_decs extends Decs {
        private Decs decs;
        private Dec dec;
        public Muchas_decs(Decs decs, Dec dec) {
           super();
           this.dec = dec;
           this.decs = decs;
        }
        public Decs decs() {return decs;}
        public Dec dec() {return dec;}
        public String toString() {
             return "muchas_decs("+decs+","+dec+")";
         } 
    }
    public static class Una_dec extends Decs {
        private Dec dec;
        public Una_dec(Dec dec) {
           super();
           this.dec = dec;
        }
        public Dec dec() {return dec;}
        public String toString() {
             return "una_dec("+dec+")";
         } 
    }
    public static class Dec_variable extends Dec { // TODO Nodo en vez de Dec?
    	private Tipo tipo;
    	private Token id;
        
        public Dec_variable(Tipo tipo, Token id) {
            this.tipo=tipo;
        	this.id = id;
            
        }
        public Tipo tipo() {return tipo;}
        public Token iden() {return id;}        
        
        public String toString() {
            return "dec_variable("+id+"["+leeFila()+","+leeCol()+"],"+tipo+")";
        } 
    }
    public static class Dec_tipo extends Dec {// TODO Nodo en vez de Dec?
    	private Tipo tipo;
    	private Token id;
        
        public Dec_tipo(Tipo tipo, Token id) {
            this.tipo=tipo;
        	this.id = id;
            
        }
        public Tipo tipo() {return tipo;}
        public Token iden() {return id;}        
        
        public String toString() {
            return "dec_tipo("+id+"["+leeFila()+","+leeCol()+"],"+tipo+")";
        } 
    }
    public static class Dec_proc extends Dec { // TODO Nodo en vez de Dec?
    	
    	private Token id;
    	private ParsFOp parsfop;
    	private Bloq bloq;
        
        public Dec_proc(Token id, ParsFOp parsfop, Bloq bloq) {            
        	this.id = id;
        	this.parsfop=parsfop;
        	this.bloq=bloq;            
        }
        
        public Token iden() {return id;}
        public ParsFOp parsfop() {return parsfop;}
        public Bloq bloq() {return bloq;}
        
        public String toString() {
            return "dec_proc("+id+"["+leeFila()+","+leeCol()+"],"+parsfop + bloq +")";
        } 
    }
    
    public static class Si_parsF extends ParsFOp { // Si_decs, Si_parsRe
    	private ParsF parsf ; 
        public Si_parsF(ParsF parsf) {
 		   super();
 		   this.parsf = parsf;
        }   
        public ParsF parsf() {return parsf;}
        public String toString() {
             return "si_parsF("+parsf+")";
         } 
    }    
    public static class No_parsF extends ParsFOp { // No_decs, No_parsRe
        public No_parsF() {
           super();
        }   
        public String toString() {
             return "no_parsF()";
         } 
    }
    public static class Muchos_parsF extends ParsF { // Muchas_decs
        private ParsF parsF;
        private ParF parF;
        public Muchos_parsF(ParsF parsF, ParF parF) {
           super();
           this.parF = parF;
           this.parsF = parsF;
        }
        public ParsF parsF() {return parsF;}
        public ParF parF() {return parF;}
        public String toString() {
             return "muchos_parsF("+parsF+","+parF+")";
         } 
    }
    public static class Un_parF extends ParsF { // Una_dec, Un_parRe 
    	private ParF parF;
        public Un_parF(ParF parF) {
           super();
           this.parF = parF;
        }
        public ParF parF() {return parF;}
        public String toString() {
             return "un_parF("+parF+")";
         } 
    }
    public static class ParamF extends ParF { // TODO Param?
    	private String id;
    	private Tipo tipo;
    	
        
        public ParamF(String id, Tipo tipo) {
            this.tipo=tipo;
        	this.id = id;
            
        }
        public Tipo tipo() {return tipo;}
        public String iden() {return id;}        
        
        public String toString() {
            return "paramF("+id+"["+leeFila()+","+leeCol()+"],"+tipo+")";
        } 
    }
    public static class Param extends ParF {
    	private String id;
    	private Tipo tipo;
    	        
        public Param(String id, Tipo tipo) {
            this.tipo=tipo;
        	this.id = id;
            
        }
        public Tipo tipo() {return tipo;}
        public String iden() {return id;}        
        
        public String toString() {
            return "param("+id+"["+leeFila()+","+leeCol()+"],"+tipo+")";
        } 
    }
    
    public static class Muchas_instrs extends Instrs { // Muchas_decs
        private Instrs instrs;
        private Instr instr;
        public Muchas_instrs(Instrs instrs, Instr instr) {
           super();
           this.instr = instr;
           this.instrs = instrs;
        }
        public Instrs instrs() {return instrs;}
        public Instr instr() {return instr;}
        public String toString() {
             return "muchas_instrs("+instrs+","+instr+")";
         } 
    }
    public static class Una_instr extends Instrs { // Una_dec
    	private Instr instr;
        public Una_instr(Instr instr) {
           super();
           this.instr = instr;
        }
        public Instr instr() {return instr;}
        public String toString() {
             return "una_instr("+instr+")";
         } 
    }
    public static class Instr_eval extends Instr { // TODO Nodo en vez de Instr?
    	private Exp exp;
        
        public Instr_eval(Exp exp) {
            this.exp = exp;        	            
        }
        public Exp exp() {return exp;}       
        
        public String toString() {
            return "instr_eval("+exp+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Instr_if extends Instr { // TODO Nodo en vez de Instr?
    	
    	private Exp exp;
    	private Bloq bloq;
        
        public Instr_if(Exp exp,Bloq bloq) {
            this.exp = exp;
            this.bloq= bloq;    
        }
        public Exp exp() {return exp;}
        public Bloq bloq() {return bloq;} 
        
        public String toString() {
            return "instr_if("+exp+"["+leeFila()+","+leeCol()+"]" + bloq +")";
        } 
    }
    public static class Instr_ifelse extends Instr { // TODO Nodo en vez de Instr?
    	private Exp exp;
    	private Bloq bloq1, bloq2;
        
        public Instr_ifelse(Exp exp,Bloq bloq1, Bloq bloq2) {
            this.exp = exp;
            this.bloq1= bloq1;
            this.bloq2= bloq2; 
        }
        public Exp exp() {return exp;}
        public Bloq bloq1() {return bloq1;}
        public Bloq bloq2() {return bloq2;} 
        
        public String toString() {
            return "instr_ifelse("+exp+"["+leeFila()+","+leeCol()+"]" + bloq1 + "," + bloq2 +")";
        }  
    }
    public static class Instr_while extends Instr { // TODO Nodo en vez de Instr?
    	private Exp exp;
    	private Bloq bloq;
        
        public Instr_while(Exp exp,Bloq bloq) {
            this.exp = exp;
            this.bloq= bloq;    
        }
        public Exp exp() {return exp;}
        public Bloq bloq() {return bloq;} 
        
        public String toString() {
            return "instr_while("+exp+"["+leeFila()+","+leeCol()+"]" + bloq +")";
        }
    }
    public static class Instr_read extends Instr { // TODO Nodo en vez de Instr?
		private Exp exp;
        
        public Instr_read(Exp exp) {
            this.exp = exp;        	            
        }
        public Exp exp() {return exp;}       
        
        public String toString() {
            return "instr_read("+exp+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Instr_write extends Instr { // TODO Nodo en vez de Instr?
    	private Exp exp;
        
        public Instr_write(Exp exp) {
            this.exp = exp;        	            
        }
        public Exp exp() {return exp;}       
        
        public String toString() {
            return "instr_write("+exp+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Instr_nl extends Instr { // TODO Nodo en vez de Instr?    	    	
        
        public Instr_nl() {       	            
        }     
        
        public String toString() {
            return "instr_nl()";
        } 
    }
    public static class Instr_new extends Instr { // TODO Nodo en vez de Instr?
		private Exp exp;
        
        public Instr_new(Exp exp) {
            this.exp = exp;        	            
        }
        public Exp exp() {return exp;}       
        
        public String toString() {
            return "instr_new("+exp+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Instr_del extends Instr { // TODO Nodo en vez de Instr?
    	private Exp exp;
        
        public Instr_del(Exp exp) {
            this.exp = exp;        	            
        }
        public Exp exp() {return exp;}       
        
        public String toString() {
            return "instr_del("+exp+"["+leeFila()+","+leeCol()+"])";
        }
    }
    public static class Instr_call extends Instr { // TODO Nodo en vez de Instr?
    	private Token identificador;
    	private ParsReOp parsreop ;    	
        
        public Instr_call(Token identificador, ParsReOp parsreop ) {
            this.identificador = identificador;
        	this.parsreop = parsreop ;        	            
        }
        public Token identificador() {return identificador;}
        public ParsReOp parsreop () {return parsreop ;}
        
        public String toString() {
            return "instr_call("+identificador +"["+leeFila()+","+leeCol()+"] ,"+parsreop+")";
        } 
    }
    public static class Instr_bloque extends Instr { // TODO Nodo en vez de Instr?
    	private Bloq bloq;    	
        
        public Instr_bloque(Bloq bloq) {
            this.bloq = bloq;        	            
        }
        public Bloq bloq() {return bloq;}       
        
        public String toString() {
            return "instr_bloque("+bloq+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    
    public static class Si_parsRe extends ParsReOp { // Si_decs, Si_parsF
    	private ParsRe parsre;
        public Si_parsRe(ParsRe parsre) {
 		   super();
 		   this.parsre = parsre;
        }   
        public ParsRe parsre() {return parsre;}
        public String toString() {
             return "si_parsRE("+parsre+")";
         } 
    }    
    public static class No_parsRe extends ParsReOp { // No_decs, No_parsF
        public No_parsRe() {
           super();
        }   
        public String toString() {
             return "no_parsRe()";
         } 
    }
    public static class Muchos_parsRe extends ParsRe { // Muchas_decs
        private ParsRe parsRe;
        private Exp exp;
        public Muchos_parsRe(ParsRe parsRe, Exp exp) {
           super();
           this.parsRe = parsRe;
           this.exp = exp;           
        }
        public ParsRe parsF() {return parsRe;}
        public Exp parF() {return exp;}
        public String toString() {
             return "muchos_parsRe("+parsRe+","+exp+")";
         } 
    }
    public static class Un_parRe extends ParsRe { // Una_dec, Un_parF
    	private Exp exp;
        public Un_parRe(Exp exp) {
           super();
           this.exp = exp;
        }
        public Exp parsre() {return exp;}
        public String toString() {
             return "un_parRe("+exp+")";
         } 
    }
    
    
    
	public static abstract class Decs extends Nodo { // Instrs, ParsF
       public Decs() {
    	   super();
       }
       public Dec dec() {throw new UnsupportedOperationException();}
	   public Decs ldecs() {throw new UnsupportedOperationException();}
    }
	public static abstract class Instrs extends Nodo { // Decs, ParsF
       public Instrs() {
    	   super();
       }
       public Instr instr() {throw new UnsupportedOperationException();}
	   public Instrs instrs() {throw new UnsupportedOperationException();}

    }	
    public static abstract class ParsF extends Nodo { // Decs, Instrs, ParsRe
        public ParsF() {
        	super();
        }
        public ParF parf() {throw new UnsupportedOperationException();}
 	   	public ParsF parsf() {throw new UnsupportedOperationException();}
    }
    public static abstract class ParsRe extends Nodo { // Decs, Instrs, ParsF
        public ParsRe() {
        	super();
        }
        public ParRe parf() {throw new UnsupportedOperationException();}
 	   	public ParsRe parsf() {throw new UnsupportedOperationException();}
    }

    
    // Nuevo
    public static abstract class DecsOp extends Nodo {
        public DecsOp() {
        }        
        //public DecsOp decsop() {throw new UnsupportedOperationException();}
        public Decs decs() {throw new UnsupportedOperationException();}
    }
    public static abstract class InstrsOp extends Nodo {
        public InstrsOp() {
        }   
    	
        public Instrs instrs() {throw new UnsupportedOperationException();}
    }
    public static abstract class ParsFOp extends Nodo {
        public ParsFOp() {
        }
        public ParsF parsf() {throw new UnsupportedOperationException();}
    }
    public static abstract class ParsReOp extends Nodo { // ParsFOp 
        public ParsReOp() {
        }
        public ParsRe parsre() {throw new UnsupportedOperationException();}
    }
    
    
    public static abstract class Tipo extends Nodo {
        public Tipo() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}

    }
    
    public static abstract class Campos extends Nodo {
        public Campos() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}

    }
    public static abstract class Campo extends Nodo {
        public Campo() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}

    }
    
    public static abstract class Dec extends Nodo { // ParF
        public Dec() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }
    public static abstract class Instr extends Nodo { // Dec, ParF 
        public Instr() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }       
    public static abstract class ParF extends Nodo { // Dec, Instr, ParRe
        public ParF() {
        }
        public Tipo tipo() {throw new UnsupportedOperationException();}
        public String string() {throw new UnsupportedOperationException();}
    }           
    public static abstract class ParRe extends Nodo { // Dec, Instr, ParF
        public ParRe() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }
    
    /* Use "Campos"
    public static abstract class FTypeDec extends Nodo { // Dec, Instr, ParF?
        public FTypeDec () {
        }
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }
    public static abstract class TypeDec extends Nodo { // Decs, Instrs, ParsRe
        public TypeDec() {
        }
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }*/
    
    //
    
    // Operadores
    public static class Suma extends ExpBin {
        public Suma(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "suma("+opnd0+","+opnd1+")";
        } 
    }
    public static class Resta extends ExpBin {
        public Resta(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "resta("+opnd0+","+opnd1+")";
        } 
    }
    public static class Mul extends ExpBin {
        public Mul(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "mul("+opnd0+","+opnd1+")";
        } 
    }
    public static class Div extends ExpBin {
        public Div(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "div("+opnd0+","+opnd1+")";
        } 
    }
    // Nuevo (operadores binarios y unarios)
    public static class Asig extends ExpBin {
        public Asig(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "asig("+opnd0+","+opnd1+")";
        } 
    }
    public static class MenorI extends ExpBin {
        public MenorI(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "menorI("+opnd0+","+opnd1+")";
        } 
    }
    public static class Menor extends ExpBin {
        public Menor(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "menor("+opnd0+","+opnd1+")";
        } 
    }
    public static class MayorI extends ExpBin {
        public MayorI(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "mayorI("+opnd0+","+opnd1+")";
        } 
    }
    public static class Mayor extends ExpBin {
        public Mayor(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "mayor("+opnd0+","+opnd1+")";
        } 
    }
    public static class Igual extends ExpBin {
        public Igual(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "igual("+opnd0+","+opnd1+")";
        } 
    }
    public static class Distint extends ExpBin {
        public Distint(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "distint("+opnd0+","+opnd1+")";
        } 
    }
    public static class Mod extends ExpBin {
        public Mod(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "mod("+opnd0+","+opnd1+")";
        } 
    }
    public static class And extends ExpBin {
        public And(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "and("+opnd0+","+opnd1+")";
        } 
    }
    public static class Or extends ExpBin {
        public Or(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "or("+opnd0+","+opnd1+")";
        } 
    }
    public static class Negacion extends ExpUna {
        public Negacion(Exp opnd0) {
            super(opnd0);
        }
        public String toString() {
            return "negacion("+opnd0+")";
        } 
    }
    public static class MenosUnario extends ExpUna {
        public MenosUnario(Exp opnd0) {
            super(opnd0);
        }
        public String toString() {
            return "menosUnario("+opnd0+")";
        } 
    }
    public static class Indexacion extends ExpBin {
        public Indexacion(Exp opnd0, Exp opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "indexacion("+opnd0+","+opnd1+")";
        } 
    }
    public static class Acceso extends ExpBin2 {
        public Acceso(Exp opnd0, String opnd1) {
            super(opnd0,opnd1);
        }
        public String toString() {
            return "acceso("+opnd0+","+opnd1+")";
        } 
    }
    public static class Indireccion extends ExpUna {
        public Indireccion(Exp opnd0) {
            super(opnd0);
        }
        public String toString() {
            return "indireccion("+opnd0+")";
        } 
    }   
    //
    
    
    public static class Iden extends Exp {
        private String id;
        public Iden(String id) {
            super();
            this.id = id;
        }
        public String iden() {return id;}
        public String toString() {
            return "iden("+id+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_ent extends Exp {
        private String num;
        public Lit_ent(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_ent("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_real extends Exp {
        private String num;
        public Lit_real(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_real("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_bool extends Exp {
        private String num;
        public Lit_bool(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_bool("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    // Nuevo TODO null?
    public static class TRUE extends Exp {        
        public TRUE() {
            super();
        }
        public String toString() {
            return "true";
        } 
    }
    public static class FALSE extends Exp {
        public FALSE() {
            super();
        }
        public String toString() {
            return "false";
        } 
    }
    public static class NULL extends Exp {
        public NULL() {
            super();
        }
        public String toString() {
            return "null";
        } 
    }
    public static class Lit_cadena extends Exp {
        private String id;
        public Lit_cadena(String id) {
            super();
            this.id = id;
        }
        public String valor() {return id;}
        public String toString() {
            return "lit_cadena("+id+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    //
    
    // -----------------------------------------------------------------------------------------
    // -- Constructoras ------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    
    public Prog prog(Bloq bloq) { return new Prog(bloq); }
    public Bloq bloq(DecsOp decsop,InstrsOp instrsop) { return new Bloq(decsop,instrsop); }
    public Si_decs si_decs(Decs decs) { return new Si_decs(decs); }
    public No_decs no_decs() { return new No_decs(); }
    public Si_instrs si_instrs(Instrs instrs) { return new Si_instrs(instrs); }
    public No_instrs no_instrs() { return new No_instrs(); }
    
    public Si_tipo si_tipo(Tipo tipo) { return new Si_tipo(tipo); }
    public No_tipo no_tipo() { return new No_tipo(); }
    public Tipo_lista tipo_lista(Tipo tipo, Token literalEntero) { 
    	return new Tipo_lista(tipo, literalEntero); 
	}
    public Tipo_circum tipo_circum(Tipo tipo) { return new Tipo_circum(tipo); }
    public Tipo_struct tipo_struct(Campos campos) { return new Tipo_struct(campos); }
    public Tipo_iden tipo_iden(Token id) { return new Tipo_iden(id); }
    public Tipo_int tipo_int() { return new Tipo_int(); }
    public Tipo_real tipo_real() { return new Tipo_real(); }
    public Tipo_bool tipo_bool() { return new Tipo_bool(); }
    public Tipo_string tipo_string() { return new Tipo_string(); }
    
    /* Use "Campos"
     * public Type_dec type_dec(Tipo tipo, Token identificador, TypeDec typedec) { 
    	return new Type_dec(tipo, identificador, typedec); }
    public Si_FtypeDec si_FtypeDec(TypeDec typedec) { return new Si_FtypeDec(typedec); }
    public No_FtypeDec no_FtypeDec() { return new No_FtypeDec(); }
    */
    public Muchos_campos muchos_campos(Campos campos, Campo campo) { 
    	return new Muchos_campos(campos, campo); }
    public Un_campo un_campo(Campo campo) { return new Un_campo(campo); }
    public Crea_campo crea_campo(Tipo tipo, Token id) { return new Crea_campo(tipo, id); }
    
    public Muchas_decs muchas_decs(Decs decs, Dec dec) { return new Muchas_decs(decs, dec); }
    public Una_dec una_dec(Dec dec) { return new Una_dec(dec); }
    public Dec_variable dec_variable(Tipo tipo, Token id) { return new Dec_variable(tipo, id); }
    public Dec_tipo dec_tipo(Tipo tipo, Token id) { return new Dec_tipo(tipo, id); }
    public Dec_proc dec_proc(Token id, ParsFOp parsfop, Bloq bloq) { 
    	return new Dec_proc(id,parsfop,bloq); 
	}
    
    public Si_parsF si_parsF(ParsF parsf) { return new Si_parsF(parsf); }
    public No_parsF no_parsF() { return new No_parsF(); }
    public Muchos_parsF muchos_parsF(ParsF parsf, ParF parf) { return new Muchos_parsF(parsf,parf); }
    public Un_parF un_parF(ParF parf) { return new Un_parF(parf); }
    public ParamF paramF(String id, Tipo tipo) { return new ParamF(id,tipo); }
    public Param param(String id, Tipo tipo) { return new Param(id, tipo); }
    
    public Muchas_instrs muchas_instrs(Instrs instrs, Instr instr) { 
    	return new Muchas_instrs(instrs, instr); 
	}
    public Una_instr una_instr(Instr instr) { return new Una_instr(instr); }
    public Instr_eval instr_eval(Exp exp) { return new Instr_eval(exp); }
    public Instr_if instr_if(Exp exp, Bloq bloq) { return new Instr_if(exp, bloq); }
    public Instr_ifelse instr_ifelse(Exp exp, Bloq bloq1, Bloq bloq2) { 
    	return new Instr_ifelse(exp,bloq1,bloq2); 
	}
    public Instr_while instr_while(Exp exp, Bloq bloq) { return new Instr_while(exp,bloq); }
    public Instr_read instr_read(Exp exp) { return new Instr_read(exp); }
    public Instr_write instr_write(Exp exp) { return new Instr_write(exp); }
    public Instr_nl instr_nl() { return new Instr_nl(); }
    public Instr_new instr_new(Exp exp){ return new Instr_new(exp); }
    public Instr_del instr_del(Exp exp) { return new Instr_del(exp); }
    public Instr_call instr_call(Token id, ParsReOp parsreop) { return new Instr_call(id, parsreop); }
    public Instr_bloque instr_bloque(Bloq bloq) { return new Instr_bloque(bloq); }
    
    public Si_parsRe si_parsRe(ParsRe parsre) { return new Si_parsRe(parsre); }
    public No_parsRe no_parsRe() { return new No_parsRe(); }
    public Muchos_parsRe muchos_parsRe(ParsRe parsre, Exp exp) { return new Muchos_parsRe(parsre, exp); }
    public Un_parRe un_parRe(Exp exp) { return new Un_parRe(exp); }
    
    
    
    // Operadores
    public Exp suma(Exp opnd0, Exp opnd1) { return new Suma(opnd0,opnd1); }
    public Exp resta(Exp opnd0, Exp opnd1) { return new Resta(opnd0,opnd1);}
    public Exp mul(Exp opnd0, Exp opnd1) { return new Mul(opnd0,opnd1); }
    public Exp div(Exp opnd0, Exp opnd1) { return new Div(opnd0,opnd1); }
    // Nuevo
    public Exp asig(Exp opnd0, Exp opnd1) { return new Asig(opnd0,opnd1); }
    public Exp menorI(Exp opnd0, Exp opnd1) { return new MenorI(opnd0,opnd1); }
    public Exp menor(Exp opnd0, Exp opnd1) { return new Menor(opnd0,opnd1); }
    public Exp mayorI(Exp opnd0, Exp opnd1) { return new MayorI(opnd0,opnd1); }
    public Exp mayor(Exp opnd0, Exp opnd1) { return new Mayor(opnd0,opnd1); }
    public Exp igual(Exp opnd0, Exp opnd1) { return new Igual(opnd0,opnd1); }
    public Exp distint(Exp opnd0, Exp opnd1) { return new Distint(opnd0,opnd1); }
    public Exp mod(Exp opnd0, Exp opnd1) { return new Mod(opnd0,opnd1); }
    public Exp and(Exp opnd0, Exp opnd1) { return new And(opnd0,opnd1); }
    public Exp or(Exp opnd0, Exp opnd1) { return new Or(opnd0,opnd1); }
    public Exp negacion(Exp opnd0) { return new Negacion(opnd0); }
    public Exp menosUnario(Exp opnd0) { return new MenosUnario(opnd0); }
    public Exp indexacion(Exp opnd0, Exp opnd1) { return new Indexacion(opnd0,opnd1); }
    // Exp x string por lo que necesita otra clase
    public Nodo acceso(Exp opnd0, String opnd1) { return new Acceso(opnd0,opnd1); }
    public Exp indireccion(Exp opnd0) { return new Indireccion(opnd0); }
    //
    
    
    
    // TODO Cambiar por otros nombres int, real...?
    public Exp iden(String num) { return new Iden(num); }
    public Exp lit_ent(String num) { return new Lit_ent(num); }
    public Exp lit_real(String num) { return new Lit_real(num); }
    public Exp lit_bool(String num) { return new Lit_bool(num); }
    // Nuevo
    public Exp lit_true() { return new TRUE(); }
    public Exp lit_false() { return new FALSE(); }
    public Exp lit_cadena(String num) { return new Lit_cadena(num);}
    public Exp lit_null() { return new NULL(); }
    
}