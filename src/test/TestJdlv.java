package test;

import simulator.GrilleSimulator;

import main.Jdlv;



import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class TestJdlv {

	public static void main(String[] args) {
		Jdlv g = new Jdlv(100,100);
		GUISimulator gui = new GUISimulator (500, 500, Color.BLACK) ;
		gui.setSimulable(new GrilleSimulator (gui,g)) ;
		gui.reset();
		int i,j;
		for (i=0;i<g.grille.length; i++) {
			for (j=0;j<g.grille[i].length ; j++ ) {
				if(g.grille[i][j] == 1){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.BLUE, Color.BLUE,10));
				}
				if(g.grille[i][j] == 0){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.BLACK, Color.BLACK,10));
				}
			}
		}
	}
}
