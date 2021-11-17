
import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;
import java.awt.Point;
import java.util.stack;


class Schelling extends Grille{


  int color_nbr;
  Stack<Point> list_homes;

  public Schelling(int h, int l, int color_nbr){
    super(h,l);
    this.list_homes = new Stack<Point>();
    this.color_nbr = color_nbr ;

    //this.nbr_cellules_hauteur = h;
    //this.nbr_cellules_longueur = l;

    int[][] grille;
    this.grille = new int[h][l];
    int[][] previous_grille;
    this.previous_grille = new int[h][l];


    int i,j;

    for (i = 0; i<this.grille.length; i++ ) {
      for (j = 0; j<this.grille[i].length; j++ ) {
          Random random = new Random();
          int c = random.nextInt(color_nbr);
          if(c == 0){
            list_homes.push(Point(i,j));
          }
          this.grille[i][j] = c;
          this.previous_grille[i][j] = c;
        }
      }
  }

  public void seekhome(Schelling grille, int i, int j, LinkedList<Point> list_homes, int color){
    list_homes.add(Point(i,j)); //l'ancienne maison est vacante.

    Point home = new Point();
    home = list_homes.seek();
    grille[home.getX()][home.getY()] = color;
    grille[i][j] = 0;

  }

  public void Init_Schelling(){
    int i,j;

    for (i = 0; i<this.grille.length; i++ ) {
      for (j = 0; j<this.grille[i].length; j++ ) {
        Random random = new Random();
        int c = random.nextInt(color_nbr);
        this.grille[i][j] = c;
        this.previous_grille[i][j] = c;
      }
    }
  }


  public void next_gen_Schelling(){
    int i,j;
    copygrille(this.previous_grille, this.grille);
    for (i = 0; i<this.grille.length ; i++ ) {
      for (j = 0; j<this.grille[i].length ; j++ ) {
        int n = grille[i][j];
        int life = detect_voisins_migrant(previous_grille,i,j,n);
        if(life==8){
          seekhome(grille,i,j,list_homes,grille[i][j]);

        }
      }

    }

  }



}
