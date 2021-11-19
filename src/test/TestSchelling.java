package test;

import main.Schelling;
import simulator.SchellingSimulator;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;


// Pour changer le nombre de couleur, changer le 4 ligne 19 par un nombre compris entre 2 et 6


public class TestSchelling {

	public static void main(String[] args) {
		Schelling g = new Schelling(50,50,6);
		GUISimulator gui = new GUISimulator (500, 500, Color.BLACK) ;
		gui.setSimulable(new SchellingSimulator (gui,g)) ;
		gui.reset();
		int i,j;
		for (i=0;i<g.grille.length; i++) {
			for (j=0;j<g.grille[i].length ; j++ ) {
				if(g.grille[i][j] == 1){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.BLUE, Color.BLUE,10));
				}
				else if(g.grille[i][j] == 0){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.BLACK, Color.BLACK,10));
				}
        else if(g.grille[i][j] == 2){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.RED, Color.RED,10));
				}
        else if(g.grille[i][j] == 3){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.GREEN, Color.GREEN,10));
				}
				else if(g.grille[i][j] == 4){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.ORANGE, Color.ORANGE,10));
				}
				else if(g.grille[i][j] == 5){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.WHITE, Color.WHITE,10));
				}
				else if(g.grille[i][j] == 6){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.GRAY, Color.GRAY,10));
				}
			}
		}
	}
}
