import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class TestSchellingGrille {

	public static void main(String[] args) {
		Schelling g = new Schelling(10,10,3);

    int i, j;

    for (i = 0 ;i < g.grille.length; i++) {
			for (j = 0;j < g.grille[i].length; j++) {

	    	System.out.print(g.grille[i][j] + " ");
			}
		System.out.println();
    }
    System.out.println();
		System.out.println(g.detect_voisins_Schelling(g.grille,0,0,g.grille[0][0]));
		System.out.println(g.detect_voisins_Schelling(g.grille,1,1,g.grille[1][1]));
		System.out.println(g.detect_voisins_Schelling(g.grille,1,2,g.grille[1][2]));
		System.out.println(g.detect_voisins_Schelling(g.grille,1,3,g.grille[1][3]));

		g.next_gen();

		System.out.println();
		System.out.println("nouvelle generation");
		System.out.println();

		for (i = 0 ;i < g.grille.length; i++) {
			for (j = 0;j < g.grille[i].length; j++) {

				System.out.print(g.grille[i][j] + " ");
			}
		System.out.println();
		}
		System.out.println();


		g.next_gen();

		System.out.println();
		System.out.println("nouvelle generation 2");
		System.out.println();

		for (i = 0 ;i < g.grille.length; i++) {
			for (j = 0;j < g.grille[i].length; j++) {

				System.out.print(g.grille[i][j] + " ");
			}
		System.out.println();
		}
		System.out.println();



	}

}
