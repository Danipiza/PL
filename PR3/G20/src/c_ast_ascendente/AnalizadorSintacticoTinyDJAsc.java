package c_ast_ascendente;

import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

public class AnalizadorSintacticoTinyDJAsc extends ConstructorAST {
    public void debug_message(String msg) {}
    public void debug_shift(sym token) {
       System.out.println(token);
    }
    public AnalizadorSintacticoTinyDJAsc(Scanner alex) {
        super(alex);
    }
}
