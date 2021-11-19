package main;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;


public class Jdlv extends Grille{

  public Jdlv (int h, int l){
    super(h,l);
    int[][] grille;
    this.grille = new int[h][l];
    int[][] previous_grille;
    this.previous_grille = new int[h][l];

    int i,j;
		for (i=0;i<this.grille.length; i++) {
			for (j=0;j<this.grille[i].length ; j++ ) {
        this.grille[i][j] = 0;
        this.previous_grille[i][j] = 0;
			}
		}
	  this.grille[1][3]=1;
	  this.grille[2][3]=1;
	  this.grille[3][3]=1;
	  this.grille[2][1]=1;
	  this.grille[3][2]=1;
	  this.grille[2][3]=1;
  }

  @Override
  public void Init(){
    int i,j;
		for (i=0;i<grille.length; i++) {
			for (j=0;j<grille[i].length ; j++ ) {
        this.grille[i][j] = 0;
        this.previous_grille[i][j] = 0;
			}
		}
    this.grille[1][3]=1;
	  this.grille[2][3]=1;
	  this.grille[3][3]=1;
	  this.grille[2][1]=1;
	  this.grille[3][2]=1;
	  this.grille[2][3]=1;
  }
}
