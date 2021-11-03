
import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;


public class GrilleSimulator implements Simulable {

	private Grille g;
	private GUISimulator gui;

	public GrilleSimulator(GUISimulator gui, Grille g){

			this.gui = gui;
			this.g = g;
	}

	@Override
	public void next() {
		g.next_gen();
		gui.reset();
		int i,j;
		for (i=0;i<g.nbr_cellules_hauteur-1; i++) {
			for (j=0;i<g.nbr_cellules_longueur-1 ; j++ ) {
				if(g.grille[i][j] == 1){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.BLUE, Color.BLUE,10));
				}
				if(g.grille[i][j] == 0){
					gui.addGraphicalElement(new Rectangle(i*10+5,j*10+5, Color.BLACK, Color.BLACK,10));
				}
			}

		}

	}

	@Override
	public void restart() {
		this.g.Init();
		gui.reset();
		int i,j;
		for (i=0;i<this.g.nbr_cellules_hauteur; i++) {
			for (j=0;i<this.g.nbr_cellules_longueur ; j++ ) {
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
