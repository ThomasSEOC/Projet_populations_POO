import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class TestGrille {

	public static void main(String[] args) {
		Grille g = new Grille(10,10);

    int i, j;

    for (i = 0 ;i < g.grille.length; i++) {
			for (j = 0;j < g.grille[i].length; j++) {

	    	System.out.print(g.grille[i][j] + " ");
			}
		System.out.println();
    }
    System.out.println();

		System.out.println(g.detect_voisins(g.grille,1,1));
		System.out.println(g.detect_voisins(g.grille,1,2));
		System.out.println(g.detect_voisins(g.grille,1,3));

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
