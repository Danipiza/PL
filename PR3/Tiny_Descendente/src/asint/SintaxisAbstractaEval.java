package asint;



public class SintaxisAbstractaEval {
	
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
    public static class Si_tipo extends Nodo { // TODO extends ?
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
    public static class No_tipo extends Nodo { // TODO extends ?
        public No_tipo() {
           super();
        }   
        public String toString() {
             return "no_tipo()";
         } 
    }
    public static class Tipo_lista extends Tipo { // TODO extends Tipo?
 	   	private Tipo tipo;
 	    private String literalEntero;
        public Tipo_lista(Tipo tipo, String literalEntero) {
 		   super();
 		   this.tipo = tipo;
 		   this.literalEntero = literalEntero;
        }   
        public Tipo tipo() {return tipo;}
        public String literalEntero() {return literalEntero;}
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
 	    private String identificador;
        public Tipo_iden(String identificador) {
 		   super();
 		   this.identificador = identificador;
        }   
        public String identificador() {return identificador;}
        public String toString() {
             return "tipo_iden("+identificador+")";
         } 
    }
    public static class Tipo_int extends Tipo { // TODO extends Tipo? 	   	
        public Tipo_int() {
 		   super();
        }   
        public String toString() { // TODO
             return "tipo_int()";
        } 
    }
    public static class Tipo_real extends Tipo { // TODO extends Tipo?
 	   	public Tipo_real() {
 		   super();
        }   
        public String toString() { // TODO
             return "tipo_real()";
        }
    }
    public static class Tipo_bool extends Tipo { // TODO extends Tipo?
 	    public Tipo_bool(Tipo tipo, String literalEntero) {
        	super();
        }   
        public String toString() { // TODO
             return "tipo_bool()";
        } 
    }
    public static class Tipo_string extends Tipo { // TODO extends Tipo?
 	   	public Tipo_string(Tipo tipo, String literalEntero) {
 		   super(); 		   
        }           
        public String toString() { // TODO
             return "tipo_string()";
        } 
    }
    public static class Muchos_campos extends Nodo { // TODO extends ?
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
    public static class Un_campo extends Nodo { // TODO extends ?
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
    public static class Crea_campo extends Nodo { // TODO extends ?
 	   	private Tipo tipo;
    	private String identificador;
        public Crea_campo(Tipo tipo, String identificador) {
 		   super();
 		   this.tipo = tipo;
 		   this.identificador = identificador;
        }   
        public Tipo tipo() {return tipo;}
        public String indentificador() {return identificador;}
        public String toString() {
        	return "crea_campo("+tipo+","+identificador+")";
         } 
    }
    
    
    
    
    /*public static class Muchas_decs extends LDecs {
        private LDecs decs;
        private Dec dec;
        public Muchas_decs(LDecs decs, Dec dec) {
           super();
           this.dec = dec;
           this.decs = decs;
        }
        public LDecs ldecs() {return decs;}
        public Dec dec() {return dec;}
        public String toString() {
             return "muchas_decs("+decs+","+dec+")";
         } 
     }
    public static class Una_dec extends LDecs {
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
	public static class Dec extends Nodo {
        private String id;
        private Exp exp;
        public Dec(String id, Exp exp) {
            this.id = id;
            this.exp = exp;
        }
        public String iden() {return id;}
        public Exp exp() {return exp;}
        public String toString() {
            return "dec("+id+"["+leeFila()+","+leeCol()+"],"+exp+")";
        } 
    }*/
    
	public static abstract class Decs extends Nodo {
       public Decs() {
       }
       // TODO
       //public LDecs ldecs() {throw new UnsupportedOperationException();}

    }
	public static abstract class Instrs extends Nodo {
       public Instrs() {
       }
       // TODO
       // public LDecs ldecs() {throw new UnsupportedOperationException();}

    }	
    /*public static abstract class LDecs extends Nodo {
       public LDecs() {
		   super();
       }
       public Dec dec() {throw new UnsupportedOperationException();}
       public LDecs ldecs() {throw new UnsupportedOperationException();}
    }*/
    
    // Nuevo
    public static abstract class DecsOp extends Nodo {
        public DecsOp() {
        }        
     // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }
    public static abstract class InstrsOp extends Nodo {
        public InstrsOp() {
        }        
     // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
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
    public static class Acceso extends ExpBin {
        public Acceso(Exp opnd0, Exp opnd1) {
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
    // Nuevo TODO null?
    public static class Lit_true extends Exp {
        private String num;
        public Lit_true(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_true("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_false extends Exp {
        private String num;
        public Lit_false(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_false("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_cadena extends Exp {
        private String num;
        public Lit_cadena(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_cadena("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
	//
    
    // -----------------------------------------------------------------------------------------
    // -- Constructoras ------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    
    public Prog prog(Bloq bloq) { return new Prog(bloq); }
    public Bloq bloq(DecsOp decsop,InstrsOp instrsop) { return new Bloq(decsop,instrsop); }
    public Si_decs Si_decs(Decs decs) { return new Si_decs(decs); }
    public No_decs no_decs() { return new No_decs(); }
    public Si_instrs si_instrs(Instrs instrs) { return new Si_instrs(instrs); }
    public No_instrs no_instrs() { return new No_instrs(); }
    public No_instrs siTipo(/*1*/) { return null; }
    public No_instrs noTipo() { return null; }
    public No_instrs tipoLista(/*2*/) { return null; }
    public No_instrs tipoCircum(/*1*/) { return null; }
    public No_instrs tipoStruct(/*1*/) { return null; }
    public No_instrs tipoIden(/*1*/) { return null; }
    public No_instrs tipoInt() { return null; }
    public No_instrs tipoReal() { return null; }
    public No_instrs tipoBool() { return null; }
    public No_instrs tipoString() { return null; }
    public No_instrs muchosCampos(/*2*/) { return null; }
    public No_instrs unCampo(/*1*/) { return null; }
    public No_instrs creaCampo(/*2*/) { return null; }
    public No_instrs muchasDecs(/*2*/) { return null; }
    public No_instrs unaDec(/*1*/) { return null; }
    public No_instrs decVariable(/*2*/) { return null; }
    public No_instrs decTipo(/*2*/) { return null; }
    public No_instrs decProc(/*3*/) { return null; }
    public No_instrs siParsF(/*1*/) { return null; }
    public No_instrs noParsF() { return null; }
    public No_instrs muchosParsF(/*2*/) { return null; }
    public No_instrs unParF(/*1*/) { return null; }
    public No_instrs paramF(/*2*/) { return null; }
    public No_instrs param(/*2*/) { return null; }
    public No_instrs muchasInstrs(/*2*/) { return null; }
    public No_instrs unaInstr(/*1*/) { return null; }
    public No_instrs instrEval(/*1*/) { return null; }
    public No_instrs instrIf(/*2*/) { return null; }
    public No_instrs instrIfElse(/*3*/) { return null; }
    public No_instrs instrWhile(/*2*/) { return null; }
    public No_instrs instrRead(/*1*/) { return null; }
    public No_instrs intrWrite(/*1*/) { return null; }
    public No_instrs instrNl() { return null; }
    public No_instrs instrNew(/*1*/) { return null; }
    public No_instrs instrDel(/*1*/) { return null; }
    public No_instrs instrCall(/*2*/) { return null; }
    public No_instrs instrBloque(/*1*/) { return null; }
    public No_instrs siParsRe(/*1*/) { return null; }
    public No_instrs noParsRe() { return null; }
    public No_instrs muchasParsRe(/*2*/) { return null; }
    public No_instrs unParRe(/*1*/) { return null; }
    
    
    
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
    public Exp and(Exp opnd0, Exp opnd1) { return new And(opnd0,opnd1); }
    public Exp or(Exp opnd0, Exp opnd1) { return new Or(opnd0,opnd1); }
    public Exp negacion(Exp opnd0) {
        return new Negacion(opnd0);
    }
    public Exp menosUnario(Exp opnd0) {
        return new MenosUnario(opnd0);
    }
    public Exp indexacion(Exp opnd0, Exp opnd1) {
        return new Indexacion(opnd0,opnd1);
    }
    public Exp acceso(Exp opnd0, Exp opnd1) {
        return new Acceso(opnd0,opnd1);
    }
    public Exp indireccion(Exp opnd0) {
        return new Indireccion(opnd0);
    }
    //
    
    
    
    // TODO Cambiar por otros nombres int, real...?
    public Exp iden(String num) { return new Iden(num); }
    public Exp lit_ent(String num) {
        return new Lit_ent(num);
    }
    public Exp lit_real(String num) {
        return new Lit_real(num);
    }
    // Nuevo
    public Exp lit_true(String num) { return new Lit_ent(num); }
    public Exp lit_false(String num) { return new Lit_ent(num); }
    public Exp lit_cadena(String num) { return new Lit_ent(num);}
    
}
