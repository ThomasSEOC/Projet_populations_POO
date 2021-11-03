
import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;


public class Grille{
  public int nbr_cellules_longueur;
  public int nbr_cellules_hauteur;
  public int[][] grille;
  public int[][] previous_grille;

  public Grille(int h, int l){
    this.nbr_cellules_hauteur = h;
    this.nbr_cellules_longueur = l;

    int[][] grille = new int[h][l];
    int[][] previous_grille = new int[h][l];

    int i,j;
    for (i = 0; i<this.nbr_cellules_hauteur ; i++ ) {
      for (j = 0; j<this.nbr_cellules_longueur ; j++ ) {
        if(i == 0 || i == this.nbr_cellules_hauteur){
          grille[i][j] = 0;
          previous_grille[i][j] = 0;
        }
        if(j == 0 || j == this.nbr_cellules_longueur){
          grille[i][j] = 0;
          previous_grille[i][j] = 0;
        }
        else{
          Random random = new Random();
          grille[i][j] = random.nextInt(1);
          previous_grille[i][j] = random.nextInt(1);
        }

      }

    }
  }

  public int detect_voisins(int[][] grille, int i, int j){
    int life=0;
    int l,m;
    for (m=i-1; m<i+2; m++ ) {
      for (l=j-1; l<j+2; l++) {
        if( !(l == j && m == i)){
          if (grille[i][j] == 1) {
            life++;
          }
        }

      }

    }
    return life;
  }

  public void copygrille(int[][] a, int[][] b, int nbr_cellules_hauteur, int nbr_cellules_longueur){
    int i,j;
    for (i=1;i<nbr_cellules_hauteur-1 ; i++ ) {
      for (j=1; j<nbr_cellules_longueur-1; j++ ) {
        a[i][j] = b[i][j];
      }
    }

  }

  public void Init(){
    int i,j;
    for (i = 0; i<nbr_cellules_hauteur ; i++ ) {
      for (j = 0; j<nbr_cellules_longueur ; j++ ) {
        if(i == 0 || i == nbr_cellules_hauteur){
          grille[i][j] = 0;
          previous_grille[i][j] = 0;
        }
        if(j == 0 || j == nbr_cellules_longueur){
          grille[i][j] = 0;
          previous_grille[i][j] = 0;
        }
        else{
          Random random = new Random();
          grille[i][j] = random.nextInt(1);
          previous_grille[i][j] = random.nextInt(1);
        }

      }

    }
  }

  public void next_gen(){
    int i,j;
    for (i=1; i<nbr_cellules_hauteur-1 ; i++ ) {
      for (j=1; j<nbr_cellules_longueur-1; j++) {
        int voisins=detect_voisins(previous_grille,i,j);
        if(grille[i][j]==1){
          if(voisins<2){
            grille[i][j] = 0;
          }
        }
        else{
          if(voisins>2){
            grille[i][j] = 1;
          }
        }
      }

    }
    copygrille(previous_grille, grille, nbr_cellules_hauteur, nbr_cellules_longueur);
  }



}
