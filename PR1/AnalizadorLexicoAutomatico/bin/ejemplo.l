%%
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}





operadorMayor = >
operadorMayorIgual = >= 
operadorMenor = < 
operadorMenorIgual = <=
operadorIgual = ==
operadorDistinto = !=


{operadorMayor}        {return ops.unidadMayor();}
{operadorMayorIgual}        {return ops.unidadMayorIgual();}
{operadorMenor}        {return ops.unidadMenor();}
{operadorMenorIgual}        {return ops.unidadMenorIgual();}
{operadorIgual}        {return ops.unidadIgual();}
{operadorDistinto}        {return ops.unidadDistinto();}

puntoycoma = ; 

llaveApertura = \{
llaveCierre = \}
eval = @
modulo = % 
corcheteApertura = \[
corcheteCierre = \] 
punto = \. 
coma = \, 
circunflejo = \^
ampersand = &
amp = &&
%%


{e}                  {return ops.unidadE();}

{asginar}                  {return ops.unidadAsignar();}
{coma}                  {return ops.unidadComa();}


{operadorEval}        {return ops.unidadEval();}
{operadorEOF}        {return ops.unidadEOF();}

{greater}        {return ops.unidadGT();}
{greaterEq}        {return ops.unidadGE();}
{lower}        {return ops.unidadLT();}
{lowerEq}        {return ops.unidadLE();}
{Eq}        {return ops.unidadEQ();}
{notEq}        {return ops.unidadNE();}

{PYQ}        {return ops.unidadPYQ();}
{llaveApertura}        {return ops.unidadLLAP();}
{llaveCierre}        {return ops.unidadLLCIERRE();}
{amp}        {return ops.unidadSEP();}
[^]                       {ops.error();}  