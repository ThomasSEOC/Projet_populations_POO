package simulator;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;

import main.Immigration;

public class ImmigrationSimulator implements Simulable {

	private Immigration g;
	private GUISimulator gui;

	public ImmigrationSimulator(GUISimulator gui, Immigration g){

			this.gui = gui;
			this.g = g;
	}

	@Override
	public void next() {
		g.next_gen_immigration();
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
			}

		}

	}

	@Override
	public void restart() {
		g.Init_immigration();
		gui.reset();
		int i,j;
		for (i=0;i< g.grille.length; i++) {
			for (j=0;j< g.grille[i].length; j++ ) {
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
			}

		}
	}
}
