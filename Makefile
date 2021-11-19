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

all: testBallsSimulator testGrille testGrilleSimulator testJDLV testSchelling testSchellingGrille testBoidsSimulator testImmigration

testBallsSimulator: 
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBallsSimulator.java
testGrille:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGrille.java
testGrilleSimulator:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGrilleSimulator.java
testJDLV: 
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestJDLV.java
testSchelling: 
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestSchelling.java
testSchellingGrille:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestSchellingGrille.java
testBoidsSimulator: 
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBoidsSimulator.java
testImmigration:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestImmigration.java

# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exeBalls: testBallsSimulator
	java -classpath bin:bin/gui.jar TestBallsSimulator

exeGrille: testGrille
	java -classpath bin:bin/gui.jar TestGrille
	
exeGrilleSimulator: testGrilleSimulator
	java -classpath bin:bin/gui.jar TestGrilleSimulator

exeJDLV: testJDLV
	java -classpath bin:bin/gui.jar TestJDLV

exeSchelling: testSchelling
	java -classpath bin:bin/gui.jar TestSchelling

exeSchellingGrille: testSchellingGrille
	java -classpath bin:bin/gui.jar TestSchellingGrille

exeBoids: testBoidsSimulator
	java -classpath bin:bin/gui.jar TestBoidsSimulator

exeImm: testImmigration
	java -classpath bin:bin/gui.jar TestImmigration

clean:
	rm -rf bin/*.class
