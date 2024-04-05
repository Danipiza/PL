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


public class ProcesamientoDef implements Procesamiento {
    public void procesa(Dec dec) {}
    public void procesa(Muchas_decs decs) {}
    public void procesa(Una_dec decs) {}
    public void procesa(Si_decs decs) {}
    public void procesa(No_decs decs) {}
    public void procesa(Suma exp) {}
    public void procesa(Resta exp) {}
    public void procesa(Mul exp) {}
    public void procesa(Div exp) {}
    public void procesa(Lit_ent exp) {}
    public void procesa(Lit_real exp) {}
    public void procesa(Iden exp) {}
    public void procesa(Prog prog) {}
}
