import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class TestGrilleSimulator {

	public static void main(String[] args) {
		Grille g = new Grille(10,10);
		GUISimulator gui = new GUISimulator (100, 100, Color.BLACK) ;
		gui.setSimulable(new GrilleSimulator (gui,g)) ;
		gui.reset();
		int i,j;
		for (i=0;i<g.nbr_cellules_hauteur; i++) {
			for (j=0;i<g.nbr_cellules_longueur ; j++ ) {
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
