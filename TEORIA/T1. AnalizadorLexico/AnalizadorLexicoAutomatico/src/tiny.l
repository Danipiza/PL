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



true = [Tt][Rr][Uu][Ee]  
false = [Ff][Aa][Ll][Ss][Ee]
and = [Aa][Nn][Dd]
or = [Nn][Rr]
not = [Nn][Oo][Tt]
bool = [Bb][Oo][Oo][Ll]
real =  [Rr][Ee][Aa][Ll]
int = [Ii][Nn][Tt] 
string = [Ss][Tt][Rr][Ii][Nn][Gg]
null = [Nn][Uu][Ll][Ll]
proc = [Pp][Rr][Oo][Cc]
if = [Ii][Ff]
else = [Ee][Ll][Ss][Ee]
while = [Ww][Hh][Ii][Ll][Ee]
struct = [Ss][Tt][Rr][Uu][Cc][Tt]
new = [Nn][Ee][Ww]
delete = [Dd][Ee][Ll][Ee][Tt][Ee]
read = [Rr][Ee][Aa][Dd]
write = [Ww][Rr][Ii][Tt][Ee]
nl = [Nn][Ll]
type = [Tt][Yy][Pp][Ee]
call = [Cc][Aa][Ll][Ll]

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = {digito}* {digitoPositivo}
separador = [ \t\r\b\n]
comentario = #[^\n]* 
evalua = evalua
donde = donde
identificador = {letra}({letra}|{digito})*
literalEntero = [\+,\-]?{parteEntera}
literalReal = [\+,\-]?{parteEntera}\.{parteDecimal}
literalCadena = "([^\"]|\.)*"


operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/

operadorMayor = >
operadorMayorIgual = >=
operadorMenor = < 
operadorMenorIgual = <=
operadorIgual = ==
operadorDistinto = \!=


parentesisApertura = \(
parentesisCierre = \)
asignar = \=
coma  = \,

puntoycoma = ; 
llaveApertura = \{
llaveCierre = \}
eval = @
modulo = % 
corcheteApertura = \[
corcheteCierre = \] 
punto = \. 
circunflejo = \^
ampersand = &
amp = &&

%%

{int}                  {return ops.unidadInt();}
{real}                  {return ops.unidadReal();}
{true}                  {return ops.unidadTrue();}
{false}                  {return ops.unidadFalse();}
{and}                  {return ops.unidadAnd();}
{or}                  {return ops.unidadOr();}
{not}                  {return ops.unidadNot();}
{bool}                  {return ops.unidadBool();}
{string}                  {return ops.unidadString();}
{null}                  {return ops.unidadNull();}
{proc}                  {return ops.unidadProc();}
{if}                  {return ops.unidadIf();}
{else}                  {return ops.unidadElse();}
{while}                  {return ops.unidadWhile();}
{struct}                  {return ops.unidadStruct();}
{new}                  {return ops.unidadNew();}
{delete}                  {return ops.unidadDelete();}
{read}                  {return ops.unidadRead();}
{write}                  {return ops.unidadWrite();}
{nl}                  {return ops.unidadNl();}
{type}                  {return ops.unidadType();}
{call}                  {return ops.unidadCall();}

{separador}               {}
{comentario}              {}
{evalua}                  {return ops.unidadEvalua();}
{donde}                   {return ops.unidadDonde();}
{literalEntero}            {return ops.unidadLiteralEnt();}
{literalReal}              {return ops.unidadLiteralReal();}
{identificador}           {return ops.unidadId();}
{literalCadena}              {return ops.unidadLiteralCadena();}



{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}

{operadorMayor}        {return ops.unidadMayor();}
{operadorMayorIgual}        {return ops.unidadMayorIgual();}
{operadorMenor}        {return ops.unidadMenor();}
{operadorMenorIgual}        {return ops.unidadMenorIgual();}
{operadorIgual}        {return ops.unidadIgual();}
{operadorDistinto}        {return ops.unidadDistinto();}


{puntoycoma}        {return ops.unidadPuntoycoma();}
{llaveApertura}        {return ops.unidadLlAp();}
{llaveCierre}        {return ops.unidadLlCierre();}
{eval}        {return ops.unidadEval();}
{modulo}        {return ops.unidadModulo();}
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}        {return ops.unidadCCierre();}
{punto}        {return ops.unidadPunto();}
{circunflejo}        {return ops.unidadCircunflejo();}
{ampersand}        {return ops.unidadAmpersand();}
{amp}        {return ops.unidadAmp();}


{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{asignar}                   {return ops.unidadAsignar();} 
{coma}                    {return ops.unidadComa();}
[^]                       {ops.error();}  


