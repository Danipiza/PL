/* ConstructorASTsTiny.java */
/* Generated By:JavaCC: Do not edit this line. ConstructorASTsTiny.java */
package c_ast_descendente;
import asint.ClaseSemanticaTiny;
import asint.SintaxisAbstractaTiny.*;
public class ConstructorASTsTiny implements ConstructorASTsTinyConstants {
   public ClaseSemanticaTiny sem = new ClaseSemanticaTiny();

  final public Prog inicial() throws ParseException {
    trace_call("inicial");
    try {
Prog prog;
      prog = programa();
      jj_consume_token(0);
{if ("" != null) return prog;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("inicial");
    }
}

  final public Prog programa() throws ParseException {
    trace_call("programa");
    try {
Bloq bloq;
      bloq = bloque();
{if ("" != null) return sem.prog(bloq);}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("programa");
    }
}

  final public Bloq bloque() throws ParseException {
    trace_call("bloque");
    try {
DecsOp decsOp; InstrsOp instrsOp ;
      jj_consume_token(llaveApertura);
      decsOp = declaraciones_opt();
      instrsOp = instrucciones_opt();
      jj_consume_token(llaveCierre);
{if ("" != null) return sem.bloq(decsOp, instrsOp);}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("bloque");
    }
}

  final public DecsOp declaraciones_opt() throws ParseException {
    trace_call("declaraciones_opt");
    try {
Decs decs;
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
        decs = declaraciones();
        jj_consume_token(separador);
{if ("" != null) return sem.si_decs(decs);}
        break;
        }
      default:
        jj_la1[0] = jj_gen;
{if ("" != null) return sem.no_decs();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("declaraciones_opt");
    }
}

  final public InstrsOp instrucciones_opt() throws ParseException {
    trace_call("instrucciones_opt");
    try {
Instrs instrs;
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
        instrs = instrucciones();
{if ("" != null) return sem.si_instrs(instrs);}
        break;
        }
      default:
        jj_la1[1] = jj_gen;
{if ("" != null) return sem.no_instrs();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("instrucciones_opt");
    }
}

  final public Tipo tipo1() throws ParseException {
    trace_call("tipo1");
    try {
Tipo t2, rt1;
      t2 = tipo2();
      rt1 = rtipo1(t2);
{if ("" != null) return rt1;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("tipo1");
    }
}

  final public Tipo rtipo1(Tipo th0) throws ParseException {
    trace_call("rtipo1");
    try {
Token t; Tipo th1;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case corcheteApertura:{
        jj_consume_token(corcheteApertura);
        t = jj_consume_token(literalEntero);
        jj_consume_token(corcheteCierre);
        th1 = rtipo1((Tipo)sem.tipo_lista(th0, t.image).ponFila(t.beginLine).ponCol(t.beginColumn));
{if ("" != null) return th1;}
        break;
        }
      default:
        jj_la1[2] = jj_gen;
{if ("" != null) return th0;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("rtipo1");
    }
}

// TODO .ponFila(t.beginLine).ponCol(t.beginColumn);}?
  final public Tipo tipo2() throws ParseException {
    trace_call("tipo2");
    try {
Tipo t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case circunflejo:{
        jj_consume_token(circunflejo);
        t = tipo2();
{if ("" != null) return sem.tipo_circum(t);}
        break;
        }
      case bool:
      case real:
      case INT:
      case string:
      case struct:
      case identificador:{
        t = tipo3();
{if ("" != null) return t;}
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("tipo2");
    }
}

  final public Tipo tipo3() throws ParseException {
    trace_call("tipo3");
    try {
Tipo tipo; Campos c; Token t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:{
        tipo = tipoBasico();
{if ("" != null) return tipo;}
        break;
        }
      case struct:{
        t = jj_consume_token(struct);
        jj_consume_token(llaveApertura);
        c = Campos();
        jj_consume_token(llaveCierre);
{if ("" != null) return (Tipo) sem.tipo_struct(c).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case identificador:{
        t = jj_consume_token(identificador);
{if ("" != null) return (Tipo) sem.tipo_iden(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("tipo3");
    }
}

  final public Tipo tipoBasico() throws ParseException {
    trace_call("tipoBasico");
    try {
Token t;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INT:{
        t = jj_consume_token(INT);
{if ("" != null) return (Tipo)sem.tipo_int().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case real:{
        t = jj_consume_token(real);
{if ("" != null) return (Tipo)sem.tipo_real().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case bool:{
        t = jj_consume_token(bool);
{if ("" != null) return (Tipo)sem.tipo_bool().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case string:{
        t = jj_consume_token(string);
{if ("" != null) return (Tipo)sem.tipo_string().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("tipoBasico");
    }
}

  final public Campos Campos() throws ParseException {
    trace_call("Campos");
    try {
Campo campo; Campos campos;
      campo = Campo();
      campos = Rcampos(sem.un_campo(campo));
{if ("" != null) return campos ;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Campos");
    }
}

  final public Campos Rcampos(Campos camposh) throws ParseException {
    trace_call("Rcampos");
    try {
Campo campo; Campos campos;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case coma:{
        jj_consume_token(coma);
        campo = Campo();
        campos = Rcampos(sem.muchos_campos(camposh, campo));
{if ("" != null) return campos;}
        break;
        }
      default:
        jj_la1[6] = jj_gen;
{if ("" != null) return camposh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Rcampos");
    }
}

  final public Campo Campo() throws ParseException {
    trace_call("Campo");
    try {
Tipo tipo; Token t;
      tipo = tipo1();
      t = jj_consume_token(identificador);
{if ("" != null) return (Campo) sem.crea_campo(tipo,t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Campo");
    }
}

  final public Decs declaraciones() throws ParseException {
    trace_call("declaraciones");
    try {
Decs decs; Dec dec;
      dec = declaracion();
      decs = DR(sem.una_dec(dec));
{if ("" != null) return decs;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("declaraciones");
    }
}

  final public Decs DR(Decs dech) throws ParseException {
    trace_call("DR");
    try {
Dec dec; Decs decs;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case puntoycoma:{
        jj_consume_token(puntoycoma);
        dec = declaracion();
        decs = DR(sem.muchas_decs(dech,dec));
{if ("" != null) return decs;}
        break;
        }
      default:
        jj_la1[7] = jj_gen;
{if ("" != null) return dech;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("DR");
    }
}

  final public Dec declaracion() throws ParseException {
    trace_call("declaracion");
    try {
Tipo tipo; Token t; ParsFOp parsFOp; Bloq bloq;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:
      case struct:
      case identificador:
      case circunflejo:{
        tipo = tipo1();
        t = jj_consume_token(identificador);
{if ("" != null) return (Dec)sem.dec_variable(tipo,t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case type:{
        jj_consume_token(type);
        tipo = tipo1();
        t = jj_consume_token(identificador);
{if ("" != null) return (Dec)sem.dec_tipo(tipo,t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case proc:{
        jj_consume_token(proc);
        t = jj_consume_token(identificador);
        jj_consume_token(parentesisApertura);
        parsFOp = parametrosFormales_opt();
        jj_consume_token(parentesisCierre);
        bloq = bloque();
{if ("" != null) return (Dec)sem.dec_proc(t.image,parsFOp,bloq).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("declaracion");
    }
}

// TODO .ponFila(t.beginLine).ponCol(t.beginColumn);}?
  final public ParsFOp parametrosFormales_opt() throws ParseException {
    trace_call("parametrosFormales_opt");
    try {
ParsF parsF;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case bool:
      case real:
      case INT:
      case string:
      case struct:
      case identificador:
      case circunflejo:{
        parsF = parametrosFormales();
{if ("" != null) return sem.si_parsF(parsF);}
        break;
        }
      default:
        jj_la1[9] = jj_gen;
{if ("" != null) return sem.no_parsF();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("parametrosFormales_opt");
    }
}

  final public ParsF parametrosFormales() throws ParseException {
    trace_call("parametrosFormales");
    try {
ParsF parsF; ParF parF;
      parF = parametroFormal();
      parsF = RparametrosFormales(sem.un_parF(parF));
{if ("" != null) return parsF;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("parametrosFormales");
    }
}

  final public ParsF RparametrosFormales(ParsF parsFh) throws ParseException {
    trace_call("RparametrosFormales");
    try {
ParF parF; ParsF parsF;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case coma:{
        jj_consume_token(coma);
        parF = parametroFormal();
        parsF = RparametrosFormales(sem.muchos_parsF(parsFh, parF));
{if ("" != null) return parsF;}
        break;
        }
      default:
        jj_la1[10] = jj_gen;
{if ("" != null) return parsFh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("RparametrosFormales");
    }
}

  final public ParF parametroFormal() throws ParseException {
    trace_call("parametroFormal");
    try {
Tipo tipo; Token t, aux;
      tipo = tipo1();
{if ("" != null) return aux(tipo);}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("parametroFormal");
    }
}

  final public ParF aux(Tipo tipoh) throws ParseException {
    trace_call("aux");
    try {
Token t, aux;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case identificador:{
        t = jj_consume_token(identificador);
{if ("" != null) return (ParF)sem.param(t.image,tipoh).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case ampersand:{
        //tipo = tipo1() "&" t = <identificador>
                aux = jj_consume_token(ampersand);
        t = jj_consume_token(identificador);
{if ("" != null) return (ParF)sem.paramF(t.image,tipoh).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("aux");
    }
}

  final public Instrs instrucciones() throws ParseException {
    trace_call("instrucciones");
    try {
Instr instr; Instrs instrs;
      instr = instruccion();
      instrs = IR(sem.una_instr(instr));
{if ("" != null) return instrs;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("instrucciones");
    }
}

  final public Instrs IR(Instrs instrh) throws ParseException {
    trace_call("IR");
    try {
Instr instr; Instrs instrs;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case puntoycoma:{
        jj_consume_token(puntoycoma);
        instr = instruccion();
        instrs = IR(sem.muchas_instrs(instrh, instr));
{if ("" != null) return instrs;}
        break;
        }
      default:
        jj_la1[12] = jj_gen;
{if ("" != null) return instrh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("IR");
    }
}

// TODO .ponFila(t.beginLine).ponCol(t.beginColumn);}?
  final public Instr instruccion() throws ParseException {
    trace_call("instruccion");
    try {
Exp e; Bloq bloq; Token t; ParsReOp parsReOp; Instr i;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case eval:{
        jj_consume_token(eval);
        e = E0();
{if ("" != null) return sem.instr_eval(e);}
        break;
        }
      case IF:{
        jj_consume_token(IF);
        e = E0();
        bloq = bloque();
        i = IFR(e,bloq);
{if ("" != null) return i;}
        break;
        }
      case WHILE:{
        jj_consume_token(WHILE);
        e = E0();
        bloq = bloque();
{if ("" != null) return sem.instr_while(e, bloq);}
        break;
        }
      case read:{
        jj_consume_token(read);
        e = E0();
{if ("" != null) return sem.instr_read(e);}
        break;
        }
      case write:{
        jj_consume_token(write);
        e = E0();
{if ("" != null) return sem.instr_write(e);}
        break;
        }
      case nl:{
        jj_consume_token(nl);
{if ("" != null) return sem.instr_nl();}
        break;
        }
      case NEW:{
        jj_consume_token(NEW);
        e = E0();
{if ("" != null) return sem.instr_new(e);}
        break;
        }
      case delete:{
        jj_consume_token(delete);
        e = E0();
{if ("" != null) return sem.instr_del(e);}
        break;
        }
      case call:{
        jj_consume_token(call);
        t = jj_consume_token(identificador);
        jj_consume_token(parentesisApertura);
        parsReOp = parametrosReales_opt();
        jj_consume_token(parentesisCierre);
{if ("" != null) return (Instr) sem.instr_call(t.image,parsReOp).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case llaveApertura:{
        bloq = bloque();
{if ("" != null) return sem.instr_bloque(bloq);}
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("instruccion");
    }
}

  final public Instr IFR(Exp eh, Bloq bloqh) throws ParseException {
    trace_call("IFR");
    try {
Bloq bloq;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        bloq = bloque();
{if ("" != null) return sem.instr_ifelse(eh,bloqh,bloq);}
        break;
        }
      default:
        jj_la1[14] = jj_gen;
{if ("" != null) return sem.instr_if(eh,bloqh);}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("IFR");
    }
}

// TODO .ponFila(t.beginLine).ponCol(t.beginColumn);}?
  final public ParsReOp parametrosReales_opt() throws ParseException {
    trace_call("parametrosReales_opt");
    try {
ParsRe parsRe;
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
        parsRe = parametrosReales();
{if ("" != null) return sem.si_parsRe(parsRe);}
        break;
        }
      default:
        jj_la1[15] = jj_gen;
{if ("" != null) return sem.no_parsRe();}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("parametrosReales_opt");
    }
}

  final public ParsRe parametrosReales() throws ParseException {
    trace_call("parametrosReales");
    try {
Exp exp; ParsRe parsRe;
      exp = E0();
      parsRe = RparametrosReales(sem.un_parRe(exp));
{if ("" != null) return parsRe;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("parametrosReales");
    }
}

  final public ParsRe RparametrosReales(ParsRe parsReh) throws ParseException {
    trace_call("RparametrosReales");
    try {
Exp exp; ParsRe parsRe;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case coma:{
        jj_consume_token(coma);
        exp = E0();
        parsRe = RparametrosReales(sem.muchos_parsRe(parsReh, exp));
{if ("" != null) return parsRe;}
        break;
        }
      default:
        jj_la1[16] = jj_gen;
{if ("" != null) return parsReh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("RparametrosReales");
    }
}

/*
ParsRe parametrosReales()  : 
{ParRe parRe; ParsRe parsRe;} 
{
	parRe= parametroReal() parsRe = RparametrosReales(sem.un_parRe(parRe)) 
{return parsRe;}
}


ParsRe RparametrosReales(ParsRe parsReh)  : 
{ParRe parRe; ParsRe parsRe;} 
{
	parRe = parametroReal() parsRe = RparametrosReales(sem.muchos_parsRe(parsReh, parRe))
{return parsRe;}
|
{return parsReh;}
}

ParRe parametroReal ()  : //FALTA EN LA ESPECIFICACIÓN
{Tipo tipo; Token t;}
{
		tipo = tipo1() "&" t = <identificador>
{return (ParRe)sem.param(t.image,tipo).ponFila(t.beginLine).ponCol(t.beginColumn);}
|
tipo = tipo1()  t = <identificador>
{return (ParRe)sem.param(t.image,tipo).ponFila(t.beginLine).ponCol(t.beginColumn);}
}*/
  final public 

Exp E0() throws ParseException {
    trace_call("E0");
    try {
Exp e1,e2;
      e1 = E1();
      e2 = FE0(e1);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E0");
    }
}

  final public Exp FE0(Exp eh) throws ParseException {
    trace_call("FE0");
    try {
Exp e1; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case asignar:{
        op = jj_consume_token(asignar);
        e1 = E0();
{if ("" != null) return (Exp)sem.mkop("=",eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      default:
        jj_la1[17] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("FE0");
    }
}

  final public Exp E1() throws ParseException {
    trace_call("E1");
    try {
Exp e1,e2;
      e1 = E2();
      e2 = Re1(e1);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E1");
    }
}

  final public Exp Re1(Exp eh) throws ParseException {
    trace_call("Re1");
    try {
Token op; Exp e1,e2;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mayor:
      case mayorIgual:
      case menor:
      case menorIgual:
      case igual:
      case distinto:{
        op = OP1();
        e1 = E2();
        e2 = Re1((Exp)sem.mkop(op.image,eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn));
{if ("" != null) return e2;}
        break;
        }
      default:
        jj_la1[18] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Re1");
    }
}

  final public Token OP1() throws ParseException {
    trace_call("OP1");
    try {
Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case menor:{
        op = jj_consume_token(menor);
{if ("" != null) return op;}
        break;
        }
      case mayor:{
        op = jj_consume_token(mayor);
{if ("" != null) return op;}
        break;
        }
      case menorIgual:{
        op = jj_consume_token(menorIgual);
{if ("" != null) return op;}
        break;
        }
      case mayorIgual:{
        op = jj_consume_token(mayorIgual);
{if ("" != null) return op;}
        break;
        }
      case igual:{
        op = jj_consume_token(igual);
{if ("" != null) return op;}
        break;
        }
      case distinto:{
        op = jj_consume_token(distinto);
{if ("" != null) return op;}
        break;
        }
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("OP1");
    }
}

  final public Exp E2() throws ParseException {
    trace_call("E2");
    try {
Exp e1,e2,e3;
      e1 = E3();
      e2 = FE3(e1);
      e3 = Re2(e2);
{if ("" != null) return e3;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E2");
    }
}

  final public Exp Re2(Exp eh) throws ParseException {
    trace_call("Re2");
    try {
Exp e1,e2; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case suma:{
        op = jj_consume_token(suma);
        e1 = E3();
        e2 = Re2((Exp)sem.mkop("+",eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn));
{if ("" != null) return e2;}
        break;
        }
      default:
        jj_la1[20] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Re2");
    }
}

  final public Exp FE3(Exp eh) throws ParseException {
    trace_call("FE3");
    try {
Exp e1; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case resta:{
        op = jj_consume_token(resta);
        e1 = E3();
{if ("" != null) return (Exp)sem.mkop("-", eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      default:
        jj_la1[21] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("FE3");
    }
}

  final public Exp E3() throws ParseException {
    trace_call("E3");
    try {
Exp e1,e2;
      e1 = E4();
      e2 = Fe4(e1);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E3");
    }
}

  final public Exp Fe4(Exp eh) throws ParseException {
    trace_call("Fe4");
    try {
Exp e1; Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case and:{
        op = jj_consume_token(and);
        e1 = E3();
{if ("" != null) return (Exp)sem.mkop("and",eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      case or:{
        op = jj_consume_token(or);
        e1 = E4();
{if ("" != null) return (Exp)sem.mkop("or",eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn);}
        break;
        }
      default:
        jj_la1[22] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Fe4");
    }
}

  final public Exp E4() throws ParseException {
    trace_call("E4");
    try {
Exp e1,e2;
      e1 = E5();
      e2 = Re4(e1);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E4");
    }
}

  final public Exp Re4(Exp eh) throws ParseException {
    trace_call("Re4");
    try {
Token op; Exp e1,e2;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mul:
      case div:
      case modulo:{
        op = OP4();
        e1 = E5();
        e2 = Re4((Exp)sem.mkop(op.image,eh,e1).ponFila(op.beginLine).ponCol(op.beginColumn));
{if ("" != null) return e2;}
        break;
        }
      default:
        jj_la1[23] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Re4");
    }
}

//Exp OP4()  :
  final public Token OP4() throws ParseException {
    trace_call("OP4");
    try {
Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case mul:{
        op = jj_consume_token(mul);
{if ("" != null) return op;}
        break;
        }
      case div:{
        op = jj_consume_token(div);
{if ("" != null) return op;}
        break;
        }
      case modulo:{
        op = jj_consume_token(modulo);
{if ("" != null) return op;}
        break;
        }
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("OP4");
    }
}

  final public Exp E5() throws ParseException {
    trace_call("E5");
    try {
Token op; Exp e1;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case not:
      case resta:{
        op = OP5();
        e1 = E5();
{if ("" != null) return (Exp)sem.mkopUn(op.image, e1).ponFila(op.beginLine).ponCol(op.beginColumn);}
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
        e1 = E6();
{if ("" != null) return e1;}
        break;
        }
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E5");
    }
}

//Exp OP5()  :
  final public Token OP5() throws ParseException {
    trace_call("OP5");
    try {
Token op;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case not:{
        op = jj_consume_token(not);
{if ("" != null) return op;}
        break;
        }
      case resta:{
        op = jj_consume_token(resta);
{if ("" != null) return op;}
        break;
        }
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("OP5");
    }
}

  final public Exp E6() throws ParseException {
    trace_call("E6");
    try {
Exp e1,e2;
      e1 = E7();
      e2 = RFE6(e1);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E6");
    }
}

  final public Exp RFE6(Exp eh) throws ParseException {
    trace_call("RFE6");
    try {
Exp e1,e2;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case corcheteApertura:
      case punto:
      case circunflejo:{
        e1 = FE6(eh);
        e2 = RFE6(e1);
{if ("" != null) return e2;}
        break;
        }
      default:
        jj_la1[27] = jj_gen;
{if ("" != null) return eh;}
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("RFE6");
    }
}

  final public Exp FE6(Exp eh) throws ParseException {
    trace_call("FE6");
    try {
Token t; Exp e1;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case corcheteApertura:{
        t = jj_consume_token(corcheteApertura);
        e1 = E0();
        jj_consume_token(corcheteCierre);
{if ("" != null) return (Exp) sem.indexacion(eh, e1).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case punto:{
        jj_consume_token(punto);
        t = jj_consume_token(identificador);
{if ("" != null) return (Exp) sem.acceso(eh, t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case circunflejo:{
        t = jj_consume_token(circunflejo);
{if ("" != null) return (Exp) sem.indireccion(eh).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("FE6");
    }
}

  final public Exp E7() throws ParseException {
    trace_call("E7");
    try {
Token t; Exp e;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case identificador:{
        t = jj_consume_token(identificador);
{if ("" != null) return (Exp)sem.iden(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case literalEntero:{
        t = jj_consume_token(literalEntero);
{if ("" != null) return (Exp)sem.lit_ent(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case literalReal:{
        t = jj_consume_token(literalReal);
{if ("" != null) return (Exp)sem.lit_real(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case TRUE:{
        t = jj_consume_token(TRUE);
{if ("" != null) return (Exp)sem.lit_true().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case FALSE:{
        t = jj_consume_token(FALSE);
{if ("" != null) return (Exp)sem.lit_false().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case literalCadena:{
        t = jj_consume_token(literalCadena);
{if ("" != null) return (Exp)sem.lit_cadena(t.image).ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      case parentesisApertura:{
        jj_consume_token(parentesisApertura);
        e = E0();
        jj_consume_token(parentesisCierre);
{if ("" != null) return e;}
        break;
        }
      case NULL:{
        t = jj_consume_token(NULL);
{if ("" != null) return (Exp)sem.lit_null().ponFila(t.beginLine).ponCol(t.beginColumn);}
        break;
        }
      default:
        jj_la1[29] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("E7");
    }
}

  /** Generated Token Manager. */
  public ConstructorASTsTinyTokenManager token_source;
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
	   jj_la1_0 = new int[] {0xa08bc000,0x5f500000,0x0,0x8083c000,0x8083c000,0x3c000,0x0,0x0,0xa08bc000,0x8083c000,0x0,0x80000000,0x0,0x5f500000,0x200000,0x80042600,0x0,0x0,0x0,0x0,0x0,0x0,0x1800,0x0,0x0,0x80042600,0x2000,0x0,0x0,0x80040600,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x2000000,0xa0000,0x200000,0x2000000,0x0,0x0,0x1000000,0x4000,0x2000000,0x2000000,0x1000000,0x4000000,0x4000,0xa0000,0x0,0x8017,0x1000000,0x2000,0x1f80,0x1f80,0x8,0x10,0x0,0x100060,0x100060,0x8017,0x10,0x2a00000,0x2a00000,0x8007,};
	}

  {
      enable_tracing();
  }
  /** Constructor with InputStream. */
  public ConstructorASTsTiny(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ConstructorASTsTiny(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ConstructorASTsTinyTokenManager(jj_input_stream);
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
  public ConstructorASTsTiny(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ConstructorASTsTinyTokenManager(jj_input_stream);
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
 token_source = new ConstructorASTsTinyTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ConstructorASTsTiny(ConstructorASTsTinyTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ConstructorASTsTinyTokenManager tm) {
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
