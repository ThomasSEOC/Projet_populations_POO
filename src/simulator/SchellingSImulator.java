
import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;


public class SchellingSimulator implements Simulable {

	private Schelling g;
	private GUISimulator gui;

	public SchellingSimulator(GUISimulator gui, Schelling g){

			this.gui = gui;
			this.g = g;
	}

	@Override
	public void next() {
		g.next_gen_Schelling();
		gui.reset();
		int i,j;
		for (i=1;i<g.grille.length-2; i++) {
			for (j=1;j<g.grille[i].length-2 ; j++ ) {
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
		g.Init_Schelling();
		gui.reset();
		int i,j;
		for (i=1;i< g.grille.length-2; i++) {
			for (j=1;j< g.grille[i].length-2; j++ ) {
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
