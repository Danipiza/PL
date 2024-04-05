package asint_visit;

import asint_visit.SintaxisAbstractaEval.Dec;
import asint_visit.SintaxisAbstractaEval.Div;
import asint_visit.SintaxisAbstractaEval.Iden;
import asint_visit.SintaxisAbstractaEval.Lit_ent;
import asint_visit.SintaxisAbstractaEval.Lit_real;
import asint_visit.SintaxisAbstractaEval.Muchas_decs;
import asint_visit.SintaxisAbstractaEval.Mul;
import asint_visit.SintaxisAbstractaEval.No_decs;
import asint_visit.SintaxisAbstractaEval.Prog;
import asint_visit.SintaxisAbstractaEval.Resta;
import asint_visit.SintaxisAbstractaEval.Si_decs;
import asint_visit.SintaxisAbstractaEval.Suma;
import asint_visit.SintaxisAbstractaEval.Una_dec;

public interface Procesamiento {
    void procesa(Dec dec);
    void procesa(Muchas_decs decs);
    void procesa(Una_dec decs);
    void procesa(Si_decs decs);
    void procesa(No_decs decs);
    void procesa(Suma exp);
    void procesa(Resta exp);
    void procesa(Mul exp);
    void procesa(Div exp);
    void procesa(Lit_ent exp);
    void procesa(Lit_real exp);
    void procesa(Iden exp);
    void procesa(Prog prog);    
}
