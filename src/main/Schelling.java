package main;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;
import java.awt.Point;
import java.util.Stack;
import java.lang.Object;


//==================
//
//Pour changer le paramètre K, il faut aller modifier le 2 en ligne 283 
//
//==================

public class Schelling extends Grille{


  int color_nbr;
  //Stack<Point> list_homes;
  LinkedList<Point> list_homes;
  public Schelling(int h, int l, int color_nbr){
    super(h,l);
    //this.list_homes = new Stack<Point>();
    this.list_homes = new LinkedList<Point>();
    this.color_nbr = color_nbr ;

    //this.nbr_cellules_hauteur = h;
    //this.nbr_cellules_longueur = l;

    int[][] grille;
    this.grille = new int[h][l];
    int[][] previous_grille;
    this.previous_grille = new int[h][l];


    // int i,j;
    //
    // for (i = 0; i<this.grille.length; i++ ) {
    //   for (j = 0; j<this.grille[i].length; j++ ) {
    //       Random random = new Random();
    //       int c = random.nextInt(color_nbr);
    //       if(c == 0){
    //         //System.out.println("here");
    //         Point p = new Point(i,j);
    //         System.out.println(p.toString());
    //         this.list_homes.addFirst(p);
    //
    //       }
    //       this.grille[i][j] = c;
    //       this.previous_grille[i][j] = c;
    //     }
    //   }

      int i,j;

      for (i = 0; i<this.grille.length; i++ ) {
        for (j = 0; j<this.grille[i].length; j++ ) {
          Random random = new Random();
          int c = random.nextInt(this.color_nbr);
          if(c == 0){
            //c = random.nextInt(color_nbr);
            Point p = new Point(i,j);
            if (list_homes.size()<=0) {
              this.list_homes.addFirst(p);
            }
            int a = random.nextInt(list_homes.size());
            this.list_homes.add(a,p);
          }
          this.grille[i][j] = c;
          this.previous_grille[i][j] = c;
        }
      }
  }


  // public int detect_voisins_Schelling(int[][] grille, int i, int j, int n){
  //
  //   int life=0;
  //   if ((i==0) && (j==0)){
  //     if (grille[grille.length-1][grille.length-1] != n && grille[grille.length-1][grille.length-1] != 0){life++;}
  //     if (grille[grille.length-1][j] != n && grille[grille.length-1][j] != 0){life++;}
  //     if (grille[grille.length-1][j+1] != n && grille[grille.length-1][j+1] != 0){life++;}
  //     if (grille[i][grille.length-1] != n && grille[i][grille.length-1] != 0){life++;}
  //     if (grille[i][j+1] != n && grille[i][j+1] != 0){life++;}
  //     if (grille[i+1][grille.length-1] != n && grille[i+1][grille.length-1] != n){life++;}
  //     if (grille[i+1][j] != n && grille[i+1][j] != 0){life++;}
  //     if (grille[i+1][j+1] != n && grille[i+1][j+1] != 0){life++;}
  //   }
  //   else if ((i==grille.length-1) && (j==0)) {
  //     if (grille[i-1][grille.length-1] != n && grille[i-1][grille.length-1] != 0){life++;}
  //     if (grille[i-1][j] != n && grille[i-1][j] != 0){life++;}
  //     if (grille[i-1][j+1] != n && grille[i-1][j+1] != 0){life++;}
  //     if (grille[i][grille.length-1] != n && grille[i][grille.length-1] != 0){life++;}
  //     if (grille[i][j+1] != n && grille[i][j+1] != 0){life++;}
  //     if (grille[0][grille.length-1] != n && grille[0][grille.length-1] != 0){life++;}
  //     if (grille[0][j] != n && grille[0][j] != 0){life++;}
  //     if (grille[0][j+1] != n && grille[0][j+1] != 0){life++;}
  //   }
  //   else if ((i==0) && (j==grille[i].length-1)) {
  //     if (grille[grille.length-1][grille.length-1] != n && grille[grille.length-1][grille.length-1] != 0){life++;}
  //     if (grille[grille.length-1][grille.length-1] != n && grille[grille.length-1][grille.length-1] != 0){life++;}
  //     if (grille[grille.length-1][0] != n && grille[grille.length-1][0] != 0){life++;}
  //     if (grille[i][j-1] != n && grille[i][j-1] != 0){life++;}
  //     if (grille[i][0] != n && grille[i][0] != 0){life++;}
  //     if (grille[i+1][j-1] != n && grille[i+1][j-1] != 0){life++;}
  //     if (grille[i+1][j] != n && grille[i+1][j] != 0){life++;}
  //     if (grille[i+1][0] != n && grille[i+1][0] != 0){life++;}
  //   }
  //   else if ((i==grille.length-1) && (j==grille[i].length-1)) {
  //     if (grille[i-1][j-1] != n && grille[i-1][j-1] != 0){life++;}
  //     if (grille[i-1][j] != n && grille[i-1][j] != 0){life++;}
  //     if (grille[i-1][0] != n && grille[i-1][0] != 0){life++;}
  //     if (grille[i][j-1] != n && grille[i][j-1] != 0){life++;}
  //     if (grille[i][0] != n && grille[i][0] != 0){life++;}
  //     if (grille[0][grille.length-1] != n && grille[0][grille.length-1] != 0){life++;}
  //     if (grille[0][grille.length-1] != n && grille[0][grille.length-1] != 0){life++;}
  //     if (grille[0][0] != n && grille[0][0] != 0){life++;}
  //   }
  //   else {
  //     if (i==0){
  //       if (grille[grille.length-1][j-1] != n && grille[grille.length-1][j-1] != 0){life++;}
  //       if (grille[grille.length-1][j] != n && grille[grille.length-1][j] != 0){life++;}
  //       if (grille[grille.length-1][j+1] != n && grille[grille.length-1][j+1] != 0){life++;}
  //       if (grille[i][j-1] != n && grille[i][j-1] != 0){life++;}
  //       if (grille[i][j+1] != n && grille[i][j+1] != 0){life++;}
  //       if (grille[i+1][j-1] != n && grille[i+1][j-1] != 0){life++;}
  //       if (grille[i+1][j] != n && grille[i+1][j] != 0){life++;}
  //       if (grille[i+1][j+1] != n && grille[i+1][j+1] != 0){life++;}
  //     }
  //
  //     else if (i==grille.length-1) {
  //       if (grille[i-1][j-1] != n && grille[i-1][j-1] != 0){life++;}
  //       if (grille[i-1][j] != n && grille[i-1][j] != 0){life++;}
  //       if (grille[i-1][j+1] != n && grille[i-1][j+1] != 0){life++;}
  //       if (grille[i][j-1] != n && grille[i][j-1] != 0){life++;}
  //       if (grille[i][j+1] != n && grille[i][j+1] != 0){life++;}
  //       if (grille[0][j-1] != n && grille[0][j-1] != 0){life++;}
  //       if (grille[0][j] != n && grille[0][j] != 0){life++;}
  //       if (grille[0][j+1] != n && grille[0][j+1] != 0){life++;}
  //     }
  //     else if (j==0) {
  //       if (grille[i-1][grille.length-1] != n && grille[i-1][grille.length-1] != 0){life++;}
  //       if (grille[i-1][j] != n && grille[i-1][j] != 0){life++;}
  //       if (grille[i-1][j+1] != n && grille[i-1][j+1] != 0){life++;}
  //       if (grille[i][grille[i].length-1] != n && grille[i][grille[i].length-1] != 0){life++;}
  //       if (grille[i][j+1] != n && grille[i][j+1] != n){life++;}
  //       if (grille[i+1][grille[i].length-1] != n && grille[i+1][grille[i].length-1] != 0){life++;}
  //       if (grille[i+1][j] != n && grille[i+1][j] != 0){life++;}
  //       if (grille[i+1][j+1] != n && grille[i+1][j+1] != 0){life++;}
  //     }
  //     else if (j==grille[i].length-1) {
  //       if (grille[i-1][j-1] != n && grille[i-1][j-1] != 0){life++;}
  //       if (grille[i-1][j] != n && grille[i-1][j] != 0){life++;}
  //       if (grille[i-1][0] != n && grille[i-1][0] != 0){life++;}
  //       if (grille[i][j-1] != n && grille[i][j-1] != 0){life++;}
  //       if (grille[i][0] != n && grille[i][0] != 0){life++;}
  //       if (grille[i+1][0] != n && grille[i+1][0] != 0){life++;}
  //       if (grille[i+1][0] != n && grille[i+1][0] != 0){life++;}
  //       if (grille[i+1][0] != n && grille[i+1][0] != 0){life++;}
  //     }
  //
  //     else{
  //
  //         if (grille[i-1][j-1] != n && grille[i-1][j-1] != 0){life++;}
  //         if (grille[i-1][j] != n && grille[i-1][j] != 0){life++;}
  //         if (grille[i-1][j+1] != n && grille[i-1][j+1] != 0){life++;}
  //         if (grille[i][j-1] != n && grille[i][j-1] != 0){life++;}
  //         if (grille[i][j+1] != n && grille[i][j+1] != 0){life++;}
  //         if (grille[i+1][j-1] != n && grille[i+1][j-1] != 0){life++;}
  //         if (grille[i+1][j] != n && grille[i+1][j] != 0){life++;}
  //         if (grille[i+1][j+1] != n && grille[i+1][j+1] != 0){life++;}
  //
  //     }
  //   }
  //   return life;
  // }

  public int detect_voisins_Schelling(int[][] grille, int i, int j, int n){
  int life=0;

  // Case [i-1][j-1]
  if( grille[(i-1 + grille.length)%grille.length][ (j-1 + grille.length)%grille.length] != n && grille[(i-1 + grille.length)%grille.length][ (j-1 + grille.length)%grille.length] != 0 ) {life++;}

  // Case [i-1][j]
  if( grille[(i-1 + grille.length)%grille.length][ (j)%grille.length] != n  && grille[(i-1 + grille.length)%grille.length][ (j)%grille.length] != 0) {life++;}

  // Case [i-1][j+1]
  if( grille[(i-1 + grille.length)%grille.length][ (j+1)%grille.length] != n && grille[(i-1 + grille.length)%grille.length][ (j+1)%grille.length] != 0 ) {life++;}

  // Case [i][j-1]
  if( grille[(i)%grille.length][(j-1 + grille.length)%grille.length] != n && grille[(i)%grille.length][(j-1 + grille.length)%grille.length] != 0 ) {life++;}

  // Case [i-1][j+1]
  if( grille[(i)%grille.length][(j+1)%grille.length] != n && grille[(i)%grille.length][(j+1)%grille.length] != 0 ) {life++;}

  // Case [i+1][j-1]
  if( grille[(i+1)%grille.length][(j-1 + grille.length)%grille.length] != n && grille[(i+1)%grille.length][(j-1 + grille.length)%grille.length] != 0 ) {life++;}

  // Case [i+1][j]
  if( grille[(i+1)%grille.length][(j)%grille.length] != n && grille[(i+1)%grille.length][(j)%grille.length] != 0 ) {life++;}

  // Case [i+1][j+1]
  if( grille[(i+1)%grille.length][(j+1)%grille.length] != n && grille[(i+1)%grille.length][(j+1)%grille.length] != 0 ) {life++;}


  return life;
  }


  // public Stack<Point> seekhome(int[][] grille, int i, int j, Stack<Point> list_homes, int color){
  //   //System.out.println("seekhome");
  //   // Point ph = new Point(i,j);
  //   // list_homes.add(ph); //l'ancienne maison est vacante.
  //   //System.out.println(color);
  //   Point home = new Point();
  //   home = list_homes.pop();
  //   //System.out.println((int)home.getX());
  //   //System.out.println((int)home.getY());
  //   //System.out.println("couleur");
  //   grille[(int)(home.getX())][(int)(home.getY())] = color;
  //   //System.out.println(grille[(int)(home.getX())][(int)(home.getY())]);
  //   //System.out.println(" ");
  //   //grille[i][j] = 0;
  //   Point p = new Point(i,j);
  //   list_homes.push(p);
  //   return list_homes;
  // }

  public LinkedList<Point> seekhome(int[][] grille, int i, int j, LinkedList<Point> list_homes, int color){
    int z;
    //System.out.println("list_homes");
    // for (z=0;z<list_homes.size() ;z++ ) {
    //   System.out.println(list_homes.get(z).toString());
    // }
    Point home = new Point();
    Random random = new Random();
    int a = random.nextInt(list_homes.size());
    home = list_homes.remove(a);
    grille[(int)(home.getX())][(int)(home.getY())] = color;
    grille[i][j] = 0;
    Point p = new Point(i,j);
    list_homes.add(p);
    return list_homes;
  }

  public void Init_Schelling(){
    int i,j;
    this.list_homes.clear();
    for (i = 0; i<this.grille.length; i++ ) {
      for (j = 0; j<this.grille[i].length; j++ ) {
        Random random = new Random();
        int c = random.nextInt(this.color_nbr);
        if(c == 0){
          //c = random.nextInt(color_nbr);
          Point p = new Point(i,j);
          if (list_homes.size()<=0) {
            this.list_homes.addFirst(p);
          }
          int a = random.nextInt(list_homes.size());
          this.list_homes.add(a,p);
        }
        this.grille[i][j] = c;
        this.previous_grille[i][j] = c;
      }
    }

  }


  public void next_gen_Schelling(){
    int i,j;
    copygrille(this.previous_grille, this.grille);
    for (i = 0; i<this.grille.length ; i++ ){
      //System.out.println("nouvelle iteration");
      for (j = 0; j<this.grille[i].length ; j++ ) {
        int n = this.grille[i][j];
        if(n!=0){
          int life = detect_voisins_Schelling(this.previous_grille,i,j,n);
          if(life>2){
            this.list_homes = seekhome(this.grille,i,j,this.list_homes,n);
          //System.out.println("nouveau seekhome");
          }
        }
      }

    }
  //System.out.println("fin next");
  }



}
