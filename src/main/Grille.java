package main;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;


public class Grille{
  //protected int nbr_cellules_longueur;
  //protected int nbr_cellules_hauteur;
  public int[][] grille;
  protected int[][] previous_grille;

  public Grille(int h, int l){
    //this.nbr_cellules_hauteur = h;
    //this.nbr_cellules_longueur = l;

    int[][] grille;
    this.grille = new int[h][l];
    int[][] previous_grille;
    this.previous_grille = new int[h][l];

    int i,j;
    for (i = 0; i<this.grille.length ; i++ ) {
      for (j = 0; j<this.grille[i].length ; j++ ) {
          Random random = new Random();
          int var = random.nextInt(100);
          if(var<15){
            this.grille[i][j] = 1;
            this.previous_grille[i][j] = 1;
          }
          else{
            this.grille[i][j] = 0;
            this.previous_grille[i][j] = 0;
          }
          //this.grille[i][j] = random.nextInt(2);
          //this.previous_grille[i][j] = random.nextInt(2);
        }

      }

  }

  // public int detect_voisins(int[][] grille, int i, int j){
  //   int life=0;
  //   if ((i==0) && (j==0)){
  //     if (grille[grille.length-1][grille.length-1] == 1){life++;}
  //     if (grille[grille.length-1][j] == 1){life++;}
  //     if (grille[grille.length-1][j+1] == 1){life++;}
  //     if (grille[i][grille.length-1] == 1){life++;}
  //     if (grille[i][j+1] == 1){life++;}
  //     if (grille[i+1][grille.length-1] == 1){life++;}
  //     if (grille[i+1][j] == 1){life++;}
  //     if (grille[i+1][j+1] == 1){life++;}
  //   }
  //   else if ((i==grille.length-1) && (j==0)) {
  //     if (grille[i-1][grille.length-1] == 1){life++;}
  //     if (grille[i-1][j] == 1){life++;}
  //     if (grille[i-1][j+1] == 1){life++;}
  //     if (grille[i][grille.length-1] == 1){life++;}
  //     if (grille[i][j+1] == 1){life++;}
  //     if (grille[0][grille.length-1] == 1){life++;}
  //     if (grille[0][j] == 1){life++;}
  //     if (grille[0][j+1] == 1){life++;}
  //   }
  //   else if ((i==0) && (j==grille[i].length-1)) {
  //     if (grille[grille.length-1][grille.length-1] == 1){life++;}
  //     if (grille[grille.length-1][grille.length-1] == 1){life++;}
  //     if (grille[grille.length-1][0] == 1){life++;}
  //     if (grille[i][j-1] == 1){life++;}
  //     if (grille[i][0] == 1){life++;}
  //     if (grille[i+1][j-1] == 1){life++;}
  //     if (grille[i+1][j] == 1){life++;}
  //     if (grille[i+1][0] == 1){life++;}
  //   }
  //   else if ((i==grille.length-1) && (j==grille[i].length-1)) {
  //     if (grille[i-1][j-1] == 1){life++;}
  //     if (grille[i-1][j] == 1){life++;}
  //     if (grille[i-1][0] == 1){life++;}
  //     if (grille[i][j-1] == 1){life++;}
  //     if (grille[i][0] == 1){life++;}
  //     if (grille[0][grille.length-1] == 1){life++;}
  //     if (grille[0][grille.length-1] == 1){life++;}
  //     if (grille[0][0] == 1){life++;}
  //   }
  //   else {
  //     if (i==0){
  //       if (grille[grille.length-1][j-1] == 1){life++;}
  //       if (grille[grille.length-1][j] == 1){life++;}
  //       if (grille[grille.length-1][j+1] == 1){life++;}
  //       if (grille[i][j-1] == 1){life++;}
  //       if (grille[i][j+1] == 1){life++;}
  //       if (grille[i+1][j-1] == 1){life++;}
  //       if (grille[i+1][j] == 1){life++;}
  //       if (grille[i+1][j+1] == 1){life++;}
  //     }
  //
  //     else if (i==grille.length-1) {
  //       if (grille[i-1][j-1] == 1){life++;}
  //       if (grille[i-1][j] == 1){life++;}
  //       if (grille[i-1][j+1] == 1){life++;}
  //       if (grille[i][j-1] == 1){life++;}
  //       if (grille[i][j+1] == 1){life++;}
  //       if (grille[0][j-1] == 1){life++;}
  //       if (grille[0][j] == 1){life++;}
  //       if (grille[0][j+1] == 1){life++;}
  //     }
  //     else if (j==0) {
  //       if (grille[i-1][grille.length-1] == 1){life++;}
  //       if (grille[i-1][j] == 1){life++;}
  //       if (grille[i-1][j+1] == 1){life++;}
  //       if (grille[i][grille[i].length-1] == 1){life++;}
  //       if (grille[i][j+1] == 1){life++;}
  //       if (grille[i+1][grille[i].length-1] == 1){life++;}
  //       if (grille[i+1][j] == 1){life++;}
  //       if (grille[i+1][j+1] == 1){life++;}
  //     }
  //     else if (j==grille[i].length-1) {
  //       if (grille[i-1][j-1] == 1){life++;}
  //       if (grille[i-1][j] == 1){life++;}
  //       if (grille[i-1][0] == 1){life++;}
  //       if (grille[i][j-1] == 1){life++;}
  //       if (grille[i][0] == 1){life++;}
  //       if (grille[i+1][0] == 1){life++;}
  //       if (grille[i+1][0] == 1){life++;}
  //       if (grille[i+1][0] == 1){life++;}
  //     }
  //
  //     else{
  //
  //         if (grille[i-1][j-1] == 1){life++;}
  //         if (grille[i-1][j] == 1){life++;}
  //         if (grille[i-1][j+1] == 1){life++;}
  //         if (grille[i][j-1] == 1){life++;}
  //         if (grille[i][j+1] == 1){life++;}
  //         if (grille[i+1][j-1] == 1){life++;}
  //         if (grille[i+1][j] == 1){life++;}
  //         if (grille[i+1][j+1] == 1){life++;}
  //
  //     }
  //   }
  //   return life;
  // }

  public int detect_voisins(int[][] grille, int i, int j){
  int life=0;

  // Case [i-1][j-1]
  if( grille[(i-1 + grille.length)%grille.length][ (j-1 + grille.length)%grille.length] == 1 ) {life++;}

  // Case [i-1][j]
  if( grille[(i-1 + grille.length)%grille.length][ (j)%grille.length] == 1 ) {life++;}

  // Case [i-1][j+1]
  if( grille[(i-1 + grille.length)%grille.length][ (j+1)%grille.length] == 1 ) {life++;}

  // Case [i][j-1]
  if( grille[(i)%grille.length][(j-1 + grille.length)%grille.length] == 1 ) {life++;}

  // Case [i-1][j+1]
  if( grille[(i)%grille.length][(j+1)%grille.length] == 1 ) {life++;}

  // Case [i+1][j-1]
  if( grille[(i+1)%grille.length][(j-1 + grille.length)%grille.length] == 1 ) {life++;}

  // Case [i+1][j]
  if( grille[(i+1)%grille.length][(j)%grille.length] == 1 ) {life++;}

  // Case [i+1][j+1]
  if( grille[(i+1)%grille.length][(j+1)%grille.length] == 1 ) {life++;}


  return life;
  }

  public void copygrille(int[][] a, int[][] b){
    int i,j;
    for (i=0;i<a.length ; i++ ) {
      for (j=0; j<a[i].length; j++ ) {
        a[i][j] = b[i][j];
      }
    }

  }

  public void Init(){
    int i,j;
    for (i = 0; i<grille.length ; i++ ) {
      for (j = 0; j<grille[i].length ; j++ ) {
        // if(j == 0 || j == grille[i].length-1){
        //   grille[i][j] = 0;
        //   previous_grille[i][j] = 0;
        // }
        // else if (i == 0 || i == grille.length-1) {
        //   grille[i][j] = 0;
        //   previous_grille[i][j] = 0;
        // }
        // else{
          Random random = new Random();
          int var = random.nextInt(100);
          if(var<20){
            this.grille[i][j] = 1;
            this.previous_grille[i][j] = 1;
          }
          else{
            this.grille[i][j] = 0;
            this.previous_grille[i][j] = 0;
          }
        //}

      }

    }
  }
  public void next_gen(){
    int i,j;
    copygrille(this.previous_grille, this.grille);
    for (i = 0; i<this.grille.length ; i++ ) {
      for (j = 0; j<this.grille[i].length ; j++ ) {
        int life = detect_voisins(this.previous_grille,i,j);
        //System.out.println("life de " + i +" "+ j+ " " + life);

        if(this.previous_grille[i][j] == 1){
          if( life < 2 ){
            this.grille[i][j] = 0;
          }
          else if(life > 3){
            this.grille[i][j] = 0;
          }
          else{
            this.grille[i][j] = 1;
          }
        }
        else if (life == 3) {
          this.grille[i][j] = 1;
          //System.out.println("new life");
        }
      }
    }

  }



}
