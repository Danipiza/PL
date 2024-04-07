package c_ast_descendenteV;

import asint.ProcesamientoDef;
import asint.SintaxisAbstractaTinyJavaccV.*;

public class Impresion extends ProcesamientoDef {
    @Override
	public void procesa(Prog prog) {
		prog.bloq().procesa(this);
	}

	@Override
	public void procesa(Bloq bloq) {
		System.out.println("{");
		bloq.decsOp().procesa(this);
		bloq.instrsOp().procesa(this);
		System.out.println("}");
	}

	@Override
	public void procesa(Si_decs si_decs) {
		si_decs.decs().procesa(this);
	}

	@Override
	public void procesa(No_decs no_decs) {
		
	}

	@Override
	public void procesa(Si_instrs si_instrs) {
		si_instrs.instrs().procesa(this);
		
	}

	@Override
	public void procesa(No_instrs no_instrs) {
		
	}

	@Override
	public void procesa(Si_tipo si_tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(No_tipo no_tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_lista tipo_lista) {
		tipo_lista.tipo().procesa(this);
		System.out.print(" [" + tipo_lista.literalEntero() + "]");
		
	}

	@Override
	public void procesa(Tipo_circum tipo_circum) {
		System.out.print("^");
		tipo_circum.tipo().procesa(this);
		
	}

	@Override
	public void procesa(Tipo_struct tipo_struct) {
		System.out.println("struct {");
		tipo_struct.campos().procesa(this);
		System.out.print("}");
		
	}

	@Override
	public void procesa(Tipo_iden tipo_iden) {
		System.out.print(tipo_iden.identificador());		
	}

	@Override
	public void procesa(Tipo_int tipo_int) {
		System.out.print("int");		
	}

	@Override
	public void procesa(Tipo_real tipo_real) {
		System.out.print("real");
		
	}

	@Override
	public void procesa(Tipo_bool tipo_bool) {
		System.out.print("bool");
		
	}

	@Override
	public void procesa(Tipo_string tipo_string) {
		System.out.print("string");
		
	}

	@Override
	public void procesa(Muchos_campos muchos_campos) {
		muchos_campos.campos().procesa(this);
		muchos_campos.campo().procesa(this);
		System.out.println("");
		
	}

	@Override
	public void procesa(Un_campo un_campo) {
		un_campo.campo().procesa(this);
		System.out.println("");
		
	}

	@Override
	public void procesa(Crea_campo crea_campo) {
		crea_campo.tipo().procesa(this);
		System.out.print(crea_campo.identificador());		
	}

	@Override
	public void procesa(Muchas_decs muchas_decs) {
		muchas_decs.decs().procesa(this);
		muchas_decs.dec().procesa(this);		
	}

	@Override
	public void procesa(Una_dec una_dec) {
		una_dec.dec().procesa(this);
		System.out.println(";");		
	}

	@Override
	public void procesa(Dec_variable dec_variable) {
		dec_variable.tipo().procesa(this);
		System.out.println(dec_variable.iden());		
	}

	@Override
	public void procesa(Dec_tipo dec_tipo) {
		System.out.print("type");
		dec_tipo.tipo().procesa(this);
		System.out.println(";");		
	}

	@Override
	public void procesa(Dec_proc dec_proc) {
		System.out.print("proc");
		System.out.print(dec_proc.iden());
		System.out.print("(");
		dec_proc.parsfop().procesa(this);
		System.out.print(")");
		dec_proc.bloq().procesa(this);	
        	
	}

	@Override
	public void procesa(Si_parsF si_parsF) {
		si_parsF.parsf().procesa(this);
		
	}

	@Override
	public void procesa(No_parsF no_parsF) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Muchos_parsF muchos_parsF) {
		muchos_parsF.parsF().procesa(this);
		System.out.print(",");
		muchos_parsF.parF().procesa(this);
		
	}

	@Override
	public void procesa(Un_parF un_parF) {
		un_parF.parF().procesa(this);
		
	}

	@Override
	public void procesa(ParamF paramF) {
		paramF.tipo().procesa(this);
		System.out.print(paramF.iden());
		
	}

	@Override
	public void procesa(Muchas_instrs muchas_instrs) {
		muchas_instrs.instrs().procesa(this);
		System.out.println(";");
		muchas_instrs.instr().procesa(this);
		
	}

	@Override
	public void procesa(Una_instr una_instr) {
		una_instr.instr().procesa(this);
		
	}

	@Override
	public void procesa(Instr_eval instr_eval) {
			System.out.print("@");
			instr_eval.exp().procesa(this);
	}

	@Override
	public void procesa(Instr_if instr_if) {
		System.out.print("if");
		instr_if.exp().procesa(this);
		instr_if.bloq().procesa(this);	
		
	}

	@Override
	public void procesa(Instr_ifelse instr_ifelse) {
		System.out.print("if (");
		
		instr_ifelse.exp().procesa(this);
		System.out.print(") ");
		instr_ifelse.bloq1().procesa(this);
		System.out.println("else ");
		instr_ifelse.bloq2().procesa(this);
		
	}

	@Override
	public void procesa(Instr_while instr_while) {
		System.out.print("while (");
		instr_while.exp().procesa(this);
		System.out.print(") ");
		instr_while.bloq().procesa(this);
		
	}

	@Override
	public void procesa(Instr_read instr_read) {
		System.out.print("read ");
		instr_read.exp().procesa(this);
		
	}

	@Override
	public void procesa(Instr_write instr_write) {
		System.out.print("write ");
		instr_write.exp().procesa(this);
		
	}

	@Override
	public void procesa(Instr_nl instr_nl) {
		System.out.print("nl");
		
	}

	@Override
	public void procesa(Instr_new instr_new) {
		System.out.print("new ");
		instr_new.exp().procesa(this);
		
	}

	@Override
	public void procesa(Instr_del instr_del) {
		System.out.print("del ");
		instr_del.exp().procesa(this);
		
	}

	@Override
	public void procesa(Instr_call instr_call) {
		System.out.print("call " + instr_call.id() + "(");
		instr_call.parsreop().procesa(this);
		System.out.print(")");
		
	}

	@Override
	public void procesa(Instr_bloque instr_bloque) {
		instr_bloque.bloq().procesa(this);
		
	}

	@Override
	public void procesa(Si_parsRe si_parsRe) {
		si_parsRe.parsre().procesa(this);
		
	}

	@Override
	public void procesa(No_parsRe no_parsRe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Muchos_parsRe muchos_parsRe) {
		muchos_parsRe.parsF().procesa(this);
		System.out.print(",");
		muchos_parsRe.parF().procesa(this);
		
	}

	@Override
	public void procesa(Un_parRe un_parRe) {
		un_parRe.parsre().procesa(this);
		
	}
	
	private void imprimeOpnd(Exp opnd, int np) {
		if(opnd.prioridad() < np) { System.out.print("("); };
		opnd.procesa(this);
		if(opnd.prioridad() < np) { System.out.print(")"); };
	}
	
	private void imprimeExpBin(Exp opnd0, String op, Exp opnd1, int np0, int np1) {
		imprimeOpnd(opnd0,np0);
		System.out.print(" "+op+" ");
		imprimeOpnd(opnd1,np1);
	}

	@Override
	public void procesa(Suma suma) {
		imprimeExpBin(suma.opnd0(),"+",suma.opnd1(),2,3);
		
	}

	@Override
	public void procesa(Resta resta) {
		imprimeExpBin(resta.opnd0(),"-",resta.opnd1(),3,3);
		
	}

	@Override
	public void procesa(Mul mul) {
		imprimeExpBin(mul.opnd0(),"*",mul.opnd1(),4,5);
		
	}

	@Override
	public void procesa(Div div) {
		imprimeExpBin(div.opnd0(),"/",div.opnd1(),4,5);
		
	}
	
	@Override
	public void procesa(Mod mod) {
		imprimeExpBin(mod.opnd0(),"%",mod.opnd1(),4,5);
		
	}

	@Override
	public void procesa(Asig asig) {
		imprimeExpBin(asig.opnd0(),"=",asig.opnd1(),0,1);
		
	}

	@Override
	public void procesa(MenorI menorI) {
		imprimeExpBin(menorI.opnd0(),"<=",menorI.opnd1(),1,2);
		
	}

	@Override
	public void procesa(Menor menor) {
		imprimeExpBin(menor.opnd0(),"<",menor.opnd1(),1,2);
		
	}

	@Override
	public void procesa(MayorI mayorI) {
		imprimeExpBin(mayorI.opnd0(),">=",mayorI.opnd1(),1,2);
		
	}

	@Override
	public void procesa(Mayor mayor) {
		imprimeExpBin(mayor.opnd0(),">",mayor.opnd1(),1,2);
		
	}

	@Override
	public void procesa(Igual igual) {
		imprimeExpBin(igual.opnd0(),"==",igual.opnd1(),1,2);
		
	}

	@Override
	public void procesa(Distint distint) {
		imprimeExpBin(distint.opnd0(),"!=",distint.opnd1(),1,2);
		
	}

	@Override
	public void procesa(And and) {
		imprimeExpBin(and.opnd0(),"and",and.opnd1(),4,3);
		
	}

	@Override
	public void procesa(Or or) {
		imprimeExpBin(or.opnd0(),"or",or.opnd1(),4,4);
		
	}

	@Override
	public void procesa(Negacion negacion) {
		imprimeOpnd(negacion.opnd0(),5);
		
	}

	@Override
	public void procesa(MenosUnario menosUnario) {
		imprimeOpnd(menosUnario.opnd0(),5);
		
	}

	@Override
	public void procesa(Indexacion indexacion) {
		indexacion.opnd0().procesa(this);
		System.out.print("["); 
		indexacion.opnd1().procesa(this);
		System.out.println("]");
	}

	@Override
	public void procesa(Acceso acceso) {
		acceso.opnd0().procesa(this);
		System.out.println("."+ acceso.opnd0());		
	}

	@Override
	public void procesa(Indireccion indireccion) {
		indireccion.opnd0().procesa(this);
		System.out.print("^");		
	}

	@Override
	public void procesa(Iden iden) {
		System.out.print(iden.id());
		
	}

	@Override
	public void procesa(Lit_ent lit_ent) {
		System.out.print(lit_ent.valor());
		
	}

	@Override
	public void procesa(Lit_real lit_real) {
		System.out.print(lit_real.valor());
		
	}

	@Override
	public void procesa(TRUE true1) {
		System.out.print("true");
		
	}

	@Override
	public void procesa(FALSE false1) {
		System.out.print("false");
		
	}

	@Override
	public void procesa(Lit_cadena lit_cadena) {
		System.out.print(lit_cadena.valor());
		
	}

	@Override
	public void procesa(NULL null1) {
		System.out.print(null1.valor());
		
	}
}
