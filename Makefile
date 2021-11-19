# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: testBallsSimulator testGrille testGrilleSimulator testJdlv testSchelling testSchellingGrille testBoidsSimulator testImmigration

testBallsSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestBallsSimulator.java
testGrille:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestGrille.java
testGrilleSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestGrilleSimulator.java
testJdlv:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestJdlv.java
testSchelling:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestSchelling.java
testSchellingGrille:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestSchellingGrille.java
testBoidsSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestBoidsSimulator.java
testImmigration:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/test/TestImmigration.java

# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin testBallsSimulator
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeBalls
exeBalls: testBallsSimulator
	java -classpath bin:bin/gui.jar test/TestBallsSimulator

exeGrille: testGrille
	java -classpath bin:bin/gui.jar test/TestGrille

exeGrilleSimulator: testGrilleSimulator
	java -classpath bin:bin/gui.jar test/TestGrilleSimulator

exeJdlv: testJdlv
	java -classpath bin:bin/gui.jar test/TestJdlv

exeSchelling: testSchelling
	java -classpath bin:bin/gui.jar test/TestSchelling

exeSchellingGrille: testSchellingGrille
	java -classpath bin:bin/gui.jar test/TestSchellingGrille

exeBoids: testBoidsSimulator
	java -classpath bin:bin/gui.jar test/TestBoidsSimulator

exeImm: testImmigration
	java -classpath bin:bin/gui.jar test/TestImmigration

clean:
	rm -rf bin/*.class
