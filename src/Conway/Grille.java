
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

    int[][] grille;
    this.grille = new int[h][l];
    int[][] previous_grille;
    this.previous_grille = new int[h][l];

    int i,j;
    for (i = 0; i<this.grille.length ; i++ ) {
      for (j = 0; j<this.grille[i].length ; j++ ) {
          Random random = new Random();
          this.grille[i][j] = random.nextInt(2);
          this.previous_grille[i][j] = random.nextInt(2);
        }

      }

  }

  public int detect_voisins(int[][] grille, int i, int j){
    int life=0;
    if ((i==0) && (j==0)){
      if (grille[grille.length-1][grille.length-1] == 1){life++;}
      if (grille[grille.length-1][j] == 1){life++;}
      if (grille[grille.length-1][j+1] == 1){life++;}
      if (grille[i][grille.length-1] == 1){life++;}
      if (grille[i][j+1] == 1){life++;}
      if (grille[i+1][grille.length-1] == 1){life++;}
      if (grille[i+1][j] == 1){life++;}
      if (grille[i+1][j+1] == 1){life++;}
    }
    if (i==grille.length-1 && j==0) {
      if (grille[i-1][grille.length-1] == 1){life++;}
      if (grille[i-1][j] == 1){life++;}
      if (grille[i-1][j+1] == 1){life++;}
      if (grille[i][grille.length-1] == 1){life++;}
      if (grille[i][j+1] == 1){life++;}
      if (grille[0][grille.length-1] == 1){life++;}
      if (grille[0][j] == 1){life++;}
      if (grille[0][j+1] == 1){life++;}
    }
    if (i==0 && j==grille[i].length-1) {
      if (grille[grille.length-1][grille.length-1] == 1){life++;}
      if (grille[grille.length-1][grille.length-1] == 1){life++;}
      if (grille[grille.length-1][0] == 1){life++;}
      if (grille[i][j-1] == 1){life++;}
      if (grille[i][0] == 1){life++;}
      if (grille[i+1][j-1] == 1){life++;}
      if (grille[i+1][j] == 1){life++;}
      if (grille[i+1][0] == 1){life++;}
    }
    if (i==grille.length-1 && j==grille[i].length-1) {
      if (grille[i-1][j-1] == 1){life++;}
      if (grille[i-1][j] == 1){life++;}
      if (grille[i-1][0] == 1){life++;}
      if (grille[i][j-1] == 1){life++;}
      if (grille[i][0] == 1){life++;}
      if (grille[0][grille.length-1] == 1){life++;}
      if (grille[0][grille.length-1] == 1){life++;}
      if (grille[0][0] == 1){life++;}
    }
    else {
      if (i==0){
        if (grille[grille.length-1][j-1] == 1){life++;}
        if (grille[grille.length-1][j] == 1){life++;}
        if (grille[grille.length-1][j+1] == 1){life++;}
        if (grille[i][j-1] == 1){life++;}
        if (grille[i][j+1] == 1){life++;}
        if (grille[i+1][j-1] == 1){life++;}
        if (grille[i+1][j] == 1){life++;}
        if (grille[i+1][j+1] == 1){life++;}
      }

      if (i==grille.length-1) {
        if (grille[i-1][j-1] == 1){life++;}
        if (grille[i-1][j] == 1){life++;}
        if (grille[i-1][j+1] == 1){life++;}
        if (grille[i][j-1] == 1){life++;}
        if (grille[i][j+1] == 1){life++;}
        if (grille[0][j-1] == 1){life++;}
        if (grille[0][j] == 1){life++;}
        if (grille[0][j+1] == 1){life++;}
      }
      if (j==0) {
        if (grille[i-1][grille.length-1] == 1){life++;}
        if (grille[i-1][j] == 1){life++;}
        if (grille[i-1][j+1] == 1){life++;}
        if (grille[i][grille[i].length-1] == 1){life++;}
        if (grille[i][j+1] == 1){life++;}
        if (grille[i+1][grille[i].length-1] == 1){life++;}
        if (grille[i+1][j] == 1){life++;}
        if (grille[i+1][j+1] == 1){life++;}
      }
      if (j==grille[i].length-1) {
        if (grille[i-1][j-1] == 1){life++;}
        if (grille[i-1][j] == 1){life++;}
        if (grille[i-1][0] == 1){life++;}
        if (grille[i][j-1] == 1){life++;}
        if (grille[i][0] == 1){life++;}
        if (grille[i+1][0] == 1){life++;}
        if (grille[i+1][0] == 1){life++;}
        if (grille[i+1][0] == 1){life++;}
      }

      else{
        if(i>0 && j>0 && i<grille.length-1 && j<grille[i].length-1){
          if (grille[i-1][j-1] == 1){life++;}
          if (grille[i-1][j] == 1){life++;}
          if (grille[i-1][j+1] == 1){life++;}
          if (grille[i][j-1] == 1){life++;}
          if (grille[i][j+1] == 1){life++;}
          if (grille[i+1][j-1] == 1){life++;}
          if (grille[i+1][j] == 1){life++;}
          if (grille[i+1][j+1] == 1){life++;}
        }
      }
    }
    return life;
  }

  public void copygrille(int[][] a, int[][] b){
    int i,j;
    for (i=1;i<a.length-1 ; i++ ) {
      for (j=1; j<a[i].length-1; j++ ) {
        a[i][j] = b[i][j];
      }
    }

  }

  public void Init(){
    int i,j;
    for (i = 0; i<grille.length ; i++ ) {
      for (j = 0; j<grille[i].length ; j++ ) {
        if(j == 0 || j == grille[i].length-1){
          grille[i][j] = 0;
          previous_grille[i][j] = 0;
        }
        else if (i == 0 || i == grille.length-1) {
          grille[i][j] = 0;
          previous_grille[i][j] = 0;
        }
        else{
          Random random = new Random();
          grille[i][j] = random.nextInt(2);
          previous_grille[i][j] = random.nextInt(2);
        }

      }

    }
  }

  public void next_gen(){
    int i,j;
    copygrille(previous_grille, grille);
    for (i = 0; i<grille.length ; i++ ) {
      for (j = 0; j<grille[i].length ; j++ ) {
        int life = detect_voisins(grille,i,j);
        if(((grille[i][j] == 1) && (life<2))){
          grille[i][j] = 0;
          }
        else if (((grille[i][j]==0) && (life == 3))) {
          grille[i][j] = 1;
          }
      }

    }
  }



}
