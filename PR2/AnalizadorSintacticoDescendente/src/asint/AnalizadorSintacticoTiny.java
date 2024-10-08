/* AnalizadorSintacticoTiny.java */
/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny.java */
package asint;

public class AnalizadorSintacticoTiny implements AnalizadorSintacticoTinyConstants {
    protected void newToken(Token t) {}

  final public void programa() throws ParseException {
    trace_call("programa");
    try {

      bloque();
      jj_consume_token(0);
    } finally {
      trace_return("programa");
    }
}

  final public void bloque() throws ParseException {
    trace_call("bloque");
    try {

      jj_consume_token(llaveApertura);
      declaraciones_opt();
      instrucciones_opt();
      jj_consume_token(llaveCierre);
    } finally {
      trace_return("bloque");
    }
}

  final public void declaraciones_opt() throws ParseException {
    trace_call("declaraciones_opt");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:
      case proc:
      case struct:
      case type:
      case identificador:
      case circunflejo:{
        declaraciones();
        jj_consume_token(separador);
        break;
        }
      default:
        jj_la1[0] = jj_gen;

      }
    } finally {
      trace_return("declaraciones_opt");
    }
}

  final public void instrucciones_opt() throws ParseException {
    trace_call("instrucciones_opt");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case NEW:
      case delete:
      case read:
      case write:
      case nl:
      case call:
      case llaveApertura:
      case eval:{
        instrucciones();
        break;
        }
      default:
        jj_la1[1] = jj_gen;

      }
    } finally {
      trace_return("instrucciones_opt");
    }
}

  final public void tipo1() throws ParseException {
    trace_call("tipo1");
    try {

      tipo2();
      rtipo1();
    } finally {
      trace_return("tipo1");
    }
}

  final public void rtipo1() throws ParseException {
    trace_call("rtipo1");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case corcheteApertura:{
        jj_consume_token(corcheteApertura);
        jj_consume_token(literalEntero);
        jj_consume_token(corcheteCierre);
        rtipo1();
        break;
        }
      default:
        jj_la1[2] = jj_gen;

      }
    } finally {
      trace_return("rtipo1");
    }
}

  final public void tipo2() throws ParseException {
    trace_call("tipo2");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case circunflejo:{
        jj_consume_token(circunflejo);
        tipo2();
        break;
        }
      case bool:
      case real:
      case INT:
      case string:
      case struct:
      case identificador:{
        tipo3();
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("tipo2");
    }
}

  final public void tipo3() throws ParseException {
    trace_call("tipo3");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:{
        tipoBasico();
        break;
        }
      case struct:{
        jj_consume_token(struct);
        jj_consume_token(llaveApertura);
        typeDeclaracion();
        jj_consume_token(llaveCierre);
        break;
        }
      case identificador:{
        jj_consume_token(identificador);
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("tipo3");
    }
}

  final public void tipoBasico() throws ParseException {
    trace_call("tipoBasico");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INT:{
        jj_consume_token(INT);
        break;
        }
      case real:{
        jj_consume_token(real);
        break;
        }
      case bool:{
        jj_consume_token(bool);
        break;
        }
      case string:{
        jj_consume_token(string);
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("tipoBasico");
    }
}

  final public void typeDeclaracion() throws ParseException {
    trace_call("typeDeclaracion");
    try {

      variable();
      FtypeDeclaracion();
    } finally {
      trace_return("typeDeclaracion");
    }
}

  final public void FtypeDeclaracion() throws ParseException {
    trace_call("FtypeDeclaracion");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case coma:{
        jj_consume_token(coma);
        typeDeclaracion();
        break;
        }
      default:
        jj_la1[6] = jj_gen;

      }
    } finally {
      trace_return("FtypeDeclaracion");
    }
}

  final public void declaraciones() throws ParseException {
    trace_call("declaraciones");
    try {

      declaracion();
      DR();
    } finally {
      trace_return("declaraciones");
    }
}

  final public void DR() throws ParseException {
    trace_call("DR");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case puntoycoma:{
        jj_consume_token(puntoycoma);
        declaracion();
        DR();
        break;
        }
      default:
        jj_la1[7] = jj_gen;

      }
    } finally {
      trace_return("DR");
    }
}

  final public void declaracion() throws ParseException {
    trace_call("declaracion");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:
      case struct:
      case identificador:
      case circunflejo:{
        variable();
        break;
        }
      case type:{
        jj_consume_token(type);
        variable();
        break;
        }
      case proc:{
        header();
        bloque();
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("declaracion");
    }
}

  final public void header() throws ParseException {
    trace_call("header");
    try {

      jj_consume_token(proc);
      jj_consume_token(identificador);
      jj_consume_token(parentesisApertura);
      parametrosFormales_opt();
      jj_consume_token(parentesisCierre);
    } finally {
      trace_return("header");
    }
}

  final public void variable() throws ParseException {
    trace_call("variable");
    try {

      tipo1();
      jj_consume_token(identificador);
    } finally {
      trace_return("variable");
    }
}

  final public void parametrosFormales_opt() throws ParseException {
    trace_call("parametrosFormales_opt");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:
      case struct:
      case identificador:
      case circunflejo:{
        parametrosFormales();
        break;
        }
      default:
        jj_la1[9] = jj_gen;

      }
    } finally {
      trace_return("parametrosFormales_opt");
    }
}

  final public void parametrosFormales() throws ParseException {
    trace_call("parametrosFormales");
    try {

      parametroFormal();
      RparametrosFormales();
    } finally {
      trace_return("parametrosFormales");
    }
}

  final public void RparametrosFormales() throws ParseException {
    trace_call("RparametrosFormales");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case coma:{
        jj_consume_token(coma);
        parametroFormal();
        RparametrosFormales();
        break;
        }
      default:
        jj_la1[10] = jj_gen;

      }
    } finally {
      trace_return("RparametrosFormales");
    }
}

  final public void parametroFormal() throws ParseException {
    trace_call("parametroFormal");
    try {

      tipo1();
      referencia_opt();
      jj_consume_token(identificador);
    } finally {
      trace_return("parametroFormal");
    }
}

  final public void referencia_opt() throws ParseException {
    trace_call("referencia_opt");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ampersand:{
        jj_consume_token(ampersand);
        break;
        }
      default:
        jj_la1[11] = jj_gen;

      }
    } finally {
      trace_return("referencia_opt");
    }
}

  final public void instrucciones() throws ParseException {
    trace_call("instrucciones");
    try {

      instruccion();
      IR();
    } finally {
      trace_return("instrucciones");
    }
}

  final public void IR() throws ParseException {
    trace_call("IR");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case puntoycoma:{
        jj_consume_token(puntoycoma);
        instruccion();
        IR();
        break;
        }
      default:
        jj_la1[12] = jj_gen;

      }
    } finally {
      trace_return("IR");
    }
}

  final public void instruccion() throws ParseException {
    trace_call("instruccion");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case eval:{
        jj_consume_token(eval);
        E0();
        break;
        }
      case IF:{
        jj_consume_token(IF);
        E0();
        bloque();
        IFR();
        break;
        }
      case WHILE:{
        jj_consume_token(WHILE);
        E0();
        bloque();
        break;
        }
      case read:{
        jj_consume_token(read);
        E0();
        break;
        }
      case write:{
        jj_consume_token(write);
        E0();
        break;
        }
      case nl:{
        jj_consume_token(nl);
        break;
        }
      case NEW:{
        jj_consume_token(NEW);
        E0();
        break;
        }
      case delete:{
        jj_consume_token(delete);
        E0();
        break;
        }
      case call:{
        jj_consume_token(call);
        jj_consume_token(identificador);
        jj_consume_token(parentesisApertura);
        parametrosReales_opt();
        jj_consume_token(parentesisCierre);
        break;
        }
      case llaveApertura:{
        bloque();
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("instruccion");
    }
}

  final public void IFR() throws ParseException {
    trace_call("IFR");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        bloque();
        break;
        }
      default:
        jj_la1[14] = jj_gen;

      }
    } finally {
      trace_return("IFR");
    }
}

  final public void parametrosReales_opt() throws ParseException {
    trace_call("parametrosReales_opt");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TRUE:
      case FALSE:
      case not:
      case NULL:
      case identificador:
      case literalEntero:
      case literalReal:
      case literalCadena:
      case resta:
      case parentesisApertura:{
        parametrosReales();
        break;
        }
      default:
        jj_la1[15] = jj_gen;

      }
    } finally {
      trace_return("parametrosReales_opt");
    }
}

  final public void parametrosReales() throws ParseException {
    trace_call("parametrosReales");
    try {

      E0();
      RparametrosReales();
    } finally {
      trace_return("parametrosReales");
    }
}

  final public void RparametrosReales() throws ParseException {
    trace_call("RparametrosReales");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case coma:{
        jj_consume_token(coma);
        E0();
        RparametrosReales();
        break;
        }
      default:
        jj_la1[16] = jj_gen;

      }
    } finally {
      trace_return("RparametrosReales");
    }
}

  final public void E0() throws ParseException {
    trace_call("E0");
    try {

      E1();
      FE1();
    } finally {
      trace_return("E0");
    }
}

  final public void FE1() throws ParseException {
    trace_call("FE1");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case asignar:{
        jj_consume_token(asignar);
        E0();
        break;
        }
      default:
        jj_la1[17] = jj_gen;

      }
    } finally {
      trace_return("FE1");
    }
}

  final public void E1() throws ParseException {
    trace_call("E1");
    try {

      E2();
      RE1();
    } finally {
      trace_return("E1");
    }
}

  final public void RE1() throws ParseException {
    trace_call("RE1");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mayor:
      case mayorIgual:
      case menor:
      case menorIgual:
      case igual:
      case distinto:{
        OP1();
        E2();
        RE1();
        break;
        }
      default:
        jj_la1[18] = jj_gen;

      }
    } finally {
      trace_return("RE1");
    }
}

  final public void OP1() throws ParseException {
    trace_call("OP1");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mayor:{
        jj_consume_token(mayor);
        break;
        }
      case menor:{
        jj_consume_token(menor);
        break;
        }
      case menorIgual:{
        jj_consume_token(menorIgual);
        break;
        }
      case mayorIgual:{
        jj_consume_token(mayorIgual);
        break;
        }
      case igual:{
        jj_consume_token(igual);
        break;
        }
      case distinto:{
        jj_consume_token(distinto);
        break;
        }
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("OP1");
    }
}

  final public void E2() throws ParseException {
    trace_call("E2");
    try {

      E3();
      FE3();
      RE2();
    } finally {
      trace_return("E2");
    }
}

  final public void RE2() throws ParseException {
    trace_call("RE2");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case suma:{
        jj_consume_token(suma);
        E3();
        RE2();
        break;
        }
      default:
        jj_la1[20] = jj_gen;

      }
    } finally {
      trace_return("RE2");
    }
}

  final public void FE3() throws ParseException {
    trace_call("FE3");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case resta:{
        jj_consume_token(resta);
        E3();
        break;
        }
      default:
        jj_la1[21] = jj_gen;

      }
    } finally {
      trace_return("FE3");
    }
}

  final public void E3() throws ParseException {
    trace_call("E3");
    try {

      E4();
      FE4();
    } finally {
      trace_return("E3");
    }
}

  final public void FE4() throws ParseException {
    trace_call("FE4");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case and:{
        jj_consume_token(and);
        E3();
        break;
        }
      case or:{
        jj_consume_token(or);
        E4();
        break;
        }
      default:
        jj_la1[22] = jj_gen;

      }
    } finally {
      trace_return("FE4");
    }
}

  final public void E4() throws ParseException {
    trace_call("E4");
    try {

      E5();
      RE4();
    } finally {
      trace_return("E4");
    }
}

  final public void RE4() throws ParseException {
    trace_call("RE4");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mul:
      case div:
      case modulo:{
        OP4();
        E5();
        RE4();
        break;
        }
      default:
        jj_la1[23] = jj_gen;

      }
    } finally {
      trace_return("RE4");
    }
}

  final public void OP4() throws ParseException {
    trace_call("OP4");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mul:{
        jj_consume_token(mul);
        break;
        }
      case div:{
        jj_consume_token(div);
        break;
        }
      case modulo:{
        jj_consume_token(modulo);
        break;
        }
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("OP4");
    }
}

  final public void E5() throws ParseException {
    trace_call("E5");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case not:
      case resta:{
        OP5();
        E5();
        break;
        }
      case TRUE:
      case FALSE:
      case NULL:
      case identificador:
      case literalEntero:
      case literalReal:
      case literalCadena:
      case parentesisApertura:{
        E6();
        break;
        }
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("E5");
    }
}

  final public void OP5() throws ParseException {
    trace_call("OP5");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case not:{
        jj_consume_token(not);
        break;
        }
      case resta:{
        jj_consume_token(resta);
        break;
        }
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("OP5");
    }
}

  final public void E6() throws ParseException {
    trace_call("E6");
    try {

      E7();
      RE6();
    } finally {
      trace_return("E6");
    }
}

  final public void RE6() throws ParseException {
    trace_call("RE6");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case corcheteApertura:
      case punto:
      case circunflejo:{
        OP6();
        RE6();
        break;
        }
      default:
        jj_la1[27] = jj_gen;

      }
    } finally {
      trace_return("RE6");
    }
}

  final public void OP6() throws ParseException {
    trace_call("OP6");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case corcheteApertura:{
        jj_consume_token(corcheteApertura);
        E0();
        jj_consume_token(corcheteCierre);
        break;
        }
      case punto:{
        jj_consume_token(punto);
        jj_consume_token(identificador);
        break;
        }
      case circunflejo:{
        jj_consume_token(circunflejo);
        break;
        }
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("OP6");
    }
}

  final public void E7() throws ParseException {
    trace_call("E7");
    try {

      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case identificador:{
        jj_consume_token(identificador);
        break;
        }
      case literalEntero:{
        jj_consume_token(literalEntero);
        break;
        }
      case literalReal:{
        jj_consume_token(literalReal);
        break;
        }
      case TRUE:{
        jj_consume_token(TRUE);
        break;
        }
      case FALSE:{
        jj_consume_token(FALSE);
        break;
        }
      case literalCadena:{
        jj_consume_token(literalCadena);
        break;
        }
      case parentesisApertura:{
        jj_consume_token(parentesisApertura);
        E0();
        jj_consume_token(parentesisCierre);
        break;
        }
      case NULL:{
        jj_consume_token(NULL);
        break;
        }
      default:
        jj_la1[29] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("E7");
    }
}

  /** Generated Token Manager. */
  public AnalizadorSintacticoTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[30];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0xa08bc000,0x5f500000,0x0,0x8083c000,0x8083c000,0x3c000,0x0,0x0,0xa08bc000,0x8083c000,0x0,0x0,0x0,0x5f500000,0x200000,0x80042600,0x0,0x0,0x0,0x0,0x0,0x0,0x1800,0x0,0x0,0x80042600,0x2000,0x0,0x0,0x80040600,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x2000000,0xa0000,0x200000,0x2000000,0x0,0x0,0x1000000,0x4000,0x2000000,0x2000000,0x1000000,0x4000000,0x4000,0xa0000,0x0,0x8017,0x1000000,0x2000,0x1f80,0x1f80,0x8,0x10,0x0,0x100060,0x100060,0x8017,0x10,0x2a00000,0x2a00000,0x8007,};
	}

  {
      enable_tracing();
  }
  /** Constructor with InputStream. */
  public AnalizadorSintacticoTiny(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AnalizadorSintacticoTiny(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AnalizadorSintacticoTiny(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AnalizadorSintacticoTiny(AnalizadorSintacticoTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalizadorSintacticoTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   trace_token(token, "");
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	   trace_token(token, " (in getNextToken)");
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[60];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 30; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 60; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  private int trace_indent = 0;
/** Enable tracing. */
  final public void enable_tracing() {
	 trace_enabled = true;
  }

/** Disable tracing. */
  final public void disable_tracing() {
	 trace_enabled = false;
  }

  protected void trace_call(String s) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.println("Call:	" + s);
	 }
	 trace_indent = trace_indent + 2;
  }

  protected void trace_return(String s) {
	 trace_indent = trace_indent - 2;
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.println("Return: " + s);
	 }
  }

  protected void trace_token(Token t, String where) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.print("Consumed token: <" + tokenImage[t.kind]);
	   if (t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"")) {
		 System.out.print(": \"" + TokenMgrError.addEscapes(t.image) + "\"");
	   }
	   System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
	 }
  }

  protected void trace_scan(Token t1, int t2) {
	 if (trace_enabled) {
	   for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
	   System.out.print("Visited token: <" + tokenImage[t1.kind]);
	   if (t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"")) {
		 System.out.print(": \"" + TokenMgrError.addEscapes(t1.image) + "\"");
	   }
	   System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
	 }
  }

}
