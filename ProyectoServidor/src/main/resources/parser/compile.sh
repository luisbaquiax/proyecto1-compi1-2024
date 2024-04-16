#! /bin/bashecho "STARTING JFLEX COMPILING"
echo "STARTING JFLEX COMPILING"
java -jar "jflex-full-1.9.1.jar" -d "..\..\java\com\luis\proyectoservidor\lexer" "acciones.jflex"

echo "STARTING CUP COMPILING"
java -jar "java-cup-11.jar" -parser AccionesParser "acciones.cup"
move AccionesParser.java "..\..\java\com\luis\proyectoservidor\parser\AccionesParser.java"
move sym.java "..\..\java\com\luis\proyectoservidor\parser\sym.java"
