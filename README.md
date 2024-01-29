## Análisis Léxico

### El procesador siempre intenta leer la máxima cantidad de caracteres en una cadena.

# Implementación Manual. (Lenguaje-de-proposito-general)


## Especificación léxica
##### Tipos de cadenas. Caracteriza la clases léxicas:	
	- UnidadLexicaUnivaluada: Cadena leída solo tiene un carácter.
	Ejemplos: MAS "\+", MENOS "\-", POR "\*", DIV "\/", PAP "\(", PCIERRE "\)", IGUAL "=", COMA "\,", EOF	
	- UnidadLexicaMultivaluada: Si tiene más de un carácter.
	Ejemplos: número entero, real, una palabra (identificador).
	- Ignorables: caracteres que no se leen para el procesador.
	Ejemplos: espacio en blanco " ", salto de línea "\n", tabuladores "\t", o comentarios cadenas seguidas de un "#"
Hay caracteres especiales para operaciones fijas, por eso se usa " \ " para la multiplicación (*, es el cierre de Kleene), suma (+, cierre de Kleene abierto) y demás.

## Definiciones auxiliares 
#### Se utilizan para simplificar y clarificar las especificaciones. No definen clases de tokens, sino patrones que son utilizados para especificar patrones más complejos
## Palabras reservadas
#### A la hora crear la especificación léxica, se pueden definir palabras reservadas para que no se lean como tokens.


 ## EJEMPLO:
	- Definiciones auxiliares:
	letra ≡ [a-z,A-Z].   
	digitoPositivo ≡ [1-9]
	digito ≡ {digitoPositivo} | 0
	- Definiciones léxicas:
	identificador ≡ {letra}({letra}|{digito})*
	evalua ≡ evalua, # Palabra reservada
	donde ≡ donde
 
	evalua
	  166.386 * euros + 1.66386 * (centimos1 + centimos2)
	donde
	  euros = 567, # cantidad de euros
	  centimos1 = 456, # céntimos
	  centimos2 = 10 # más céntimos.

---
 
## Diagrama de Estados 
![Diagrama_de_Estados](https://github.com/Danipiza/PL/assets/98972125/d91f05be-485b-4006-87ff-8523944eef1c)
Este es el lenguaje descrito en el primer tema. Tiene 2 implementaciones.



### Buffer de Doble Entrada
Sirve para llevar un registro del último estado final alcanzado, para que en caso de error, el procesador vuelva al primer estado no final y vuelva a procesarlo. Tiene un coste Cuadrático, por lo que no lo implementamos. Se añaden 3 estados más: RecIDec, Rec0Dec, RecIDec.

Ejemplo de error: 5.100, 
Son 3 tokens, 5.1, 0 y 0. 

Llega al estado RecIDec, habiendo procesado 5.1. Está en estado final.

Se procesa 00 llegando a un estado no final Rec0Dec, se vuelve al estado guardado RecIDec, devolviendo un componente real "5.1", y vuelve a procesar 00.

No implementamos esta técnica por lo que da error.


---

# Implementación Automática. (Lenguaje de propósito específico)
Se aplican algoritmo para transformar, ER -> AFN -> AFD -> AFD mínimo

## Generador de analizador léxicos.
Que, tomando como entrada una especificación léxica, genera como salida una implementación del analizador léxico.
Cadenas léxicas (Eo, ..., En) y cadenas ignorables (Io, ..., In). Obteniendo una expresión regular común (I0| …|Im)* (E0| …|En), convirtiendo esta expresión regular a AFD mínimo.

## Programa de procesamiento 
Consiste en una secuencia ordenada de pares patrón – acción.
- Patrón, es una expresión regular que puede referir alguna de las definiciones realizadas.
- La acción, es código arbitrario en un lenguaje de propósito general.


El ciclo de procesamiento opera hasta que, bien se agota la entrada, bien alguna de las acciones devuelve explícitamente el control (return). 

En cada iteración se selecciona un par patrón - acción, que empareje con la entrada de mayor longitud. Si hay empate se elige el de más prioridad (el que antes se implementó), y se ejecuta la acción del par seleccionado.
| Definición | Patrón | Acción |
|--|:--:|--|
| Clase Léxica | c | << Componente léxico de clase c >> |
| Cadena Ignorable | i | << No hacer nada >> |
| Error Léxico | [^] | << Mensaje error>> |

Estas herramientas generan código que implementa la técnica del buffer doble, los analizadores generados no tendrán las limitaciones indicadas para los construidos manualmente

Usando JFlex. Un generador de código Java para procesamientos de texto dirigidos por patrones.


## Estructura JFlex

	(Seccion1)
	Estructura de una especificación JFlex 
	<<código java arbitrario>>   
	%% 
	(Seccion2)
	<<configuración del proceso de generación>>
	<<Definiciones regulares:
	Nombre = Expresión
	Nombre = Expresión
	...>>  
	%% 
	(Seccion3)
	<<Descripción del programa de procesamiento:
	Patrón Acción
	Patrón Acción
	...
	>>

## Seccion1
Incluir código java arbitrario. En particular, aquí podrá indicarse el paquete (package) en el que queremos que resida la implementación.
## Seccion2
Comienza con una serie de cláusulas, que permiten configurar el proceso
- %line, número de línea de comienzo del último token.
- %column, número de columna de comienzo del último token.
- %class, indicar el nombre de la clase que implementa el analizador léxico generado (por defecto, la clase generada se llama Yylex).
- %type, indicar el tipo del valor devuelto cada vez que se solicita el siguiente token (por defecto, se devuelve el código de la clase léxica).
- %unicode, indica que el juego de caracteres de la entrada es Unicode.
- %{...}, el código indicado entre estas marcas es añadido directamente a la clase generada
- %init{... %init}, el código indicado entre estas marcas es añadido directamente a los constructores de la clase generada
- %eofval{... %eofval}, expresión que determina el valor a devolver cuando se llega al fin de fichero
  
## Seccion3
- Patrones son expresiones regulares, que siguen las mismas normas que en las utilizadas en las definiciones regulares.
- Acciones son código arbitrario.
La prioridad es muy importante, depende de cómo estructures los pares, puede funcionar de manera muy distinta. (Antes = más prioridad)

#### Diferencias con manual se usa = (en vez de ≡), no se ponen "," en los conjuntos se debe escribir [a-z]|[A-Z] (en vez de [a-z,A-Z])

---
# Java
#### El procesador lee todo un fichero de texto "input.txt", y procesa las cadenas del fichero.

## Implementación Automática con JFlex
[Manual de JFlex](https://jflex.de/manual.html)

Para crear el Analizador Léxico de forma automática, hay que crear un fichero "ejemplo.l", en donde se describen las 3 secciones de la estructura JFlex. 

Una vez esté creado el fichero con la configuración deseada, se ejecuta jflex.jar.
![JFlex](https://github.com/Danipiza/Acepta-el-Reto/assets/98972125/78a3369a-11c7-4ab7-98cb-1ecf40ec0f9f)
Aparece esta ventana.
- Lexical specification. Es el archivo "ejemplo.l"
- Output directory. Es donde quieres que se cree el archivo AnalizadorLexicoTiny.java


## EJEMPLO, IDEN con más prioridad que evalúa.
![ID_con_mas_prioridad1](https://github.com/Danipiza/Acepta-el-Reto/assets/98972125/085efe65-fd24-4dd5-80dd-6f0b289f2c42)

Como se puede apreciar evalúa lo procesa como una palabra en vez de una palabra reservada. "Rule can never be matched".

![ID_con_mas prioridad2](https://github.com/Danipiza/Acepta-el-Reto/assets/98972125/57b15f64-2a88-46ce-acf3-e124b58470e8)

Al ejecutar jflex.jar se puede ver que muestra 2 warnings, ya que las palabras reservadas, "evalúa" y "donde", no se ejecutara el patrón nunca por tener menos prioridad que IDEN.

## Domjudge
No tenemos que imprimir los tokens, solo los lexemas. Y los errores solo hay que imprimir "error".
Se envía como un .zip con todo el proyecto.
