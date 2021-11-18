
import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.util.Random;


class Immigration extends Grille{

  public Immigration(int h, int l){
    super(h,l);
    //this.nbr_cellules_hauteur = h;
    //this.nbr_cellules_longueur = l;

    int[][] grille;
    this.grille = new int[h][l];
    int[][] previous_grille;
    this.previous_grille = new int[h][l];

    
    int i,j;
    int i1 = 25;
    int i2 = 50;
    int i3 = 75;

    for (i = 0; i<this.grille.length/2 ; i++ ) {
      for (j = 0; j<this.grille[i].length/2 ; j++ ) {
          Random random = new Random();
          int var = random.nextInt(100);
          if(var<i1){
            this.grille[i][j] = 1;
            this.previous_grille[i][j] = 1;
          }
          else if(var<i2){
            this.grille[i][j] = 2;
            this.previous_grille[i][j] = 2;
          }
          else if(var<i3){
            this.grille[i][j] = 3;
            this.previous_grille[i][j] = 3;
          }
          else{
            this.grille[i][j] = 0;
            this.previous_grille[i][j] = 0;
          }
          //this.grille[i][j] = random.nextInt(2);
          //this.previous_grille[i][j] = random.nextInt(2);
        }

      }
      for (i = 0; i<this.grille.length/2; i++ ) {
        for (j = this.grille.length/2; j<this.grille[i].length ; j++ ) {
            Random random = new Random();
            int var = random.nextInt(100);
            if(var<i1){
              this.grille[i][j] = 0;
              this.previous_grille[i][j] = 0;
            }
            else if(var<i2){
              this.grille[i][j] = 1;
              this.previous_grille[i][j] = 1;
            }
            else if(var<i3){
              this.grille[i][j] = 2;
              this.previous_grille[i][j] = 2;
            }
            else{
              this.grille[i][j] = 3;
              this.previous_grille[i][j] = 3;
            }
            //this.grille[i][j] = random.nextInt(2);
            //this.previous_grille[i][j] = random.nextInt(2);
          }

        }
        for (i = this.grille.length/2; i<this.grille.length; i++ ) {
          for (j = 0; j<this.grille[i].length/2 ; j++ ) {
              Random random = new Random();
              int var = random.nextInt(100);
              if(var<i1){
                this.grille[i][j] = 3;
                this.previous_grille[i][j] = 3;
              }
              else if(var<i2){
                this.grille[i][j] = 0;
                this.previous_grille[i][j] = 0;
              }
              else if(var<i3){
                this.grille[i][j] = 1;
                this.previous_grille[i][j] = 1;
              }
              else{
                this.grille[i][j] = 2;
                this.previous_grille[i][j] = 2;
              }
              //this.grille[i][j] = random.nextInt(2);
              //this.previous_grille[i][j] = random.nextInt(2);
            }

          }
          for (i = this.grille.length/2; i<this.grille.length; i++ ) {
            for (j = this.grille.length/2; j<this.grille[i].length; j++ ) {
                Random random = new Random();
                int var = random.nextInt(100);
                if(var<i1){
                  this.grille[i][j] = 2;
                  this.previous_grille[i][j] = 2;
                }
                else if(var<i2){
                  this.grille[i][j] = 3;
                  this.previous_grille[i][j] = 3;
                }
                else if(var<i3){
                  this.grille[i][j] = 0;
                  this.previous_grille[i][j] = 0;
                }
                else{
                  this.grille[i][j] = 1;
                  this.previous_grille[i][j] = 1;
                }
                //this.grille[i][j] = random.nextInt(2);
                //this.previous_grille[i][j] = random.nextInt(2);
              }

            }

  }


  public int detect_voisins_migrant(int[][] grille, int i, int j, int n){

    int life=0;
    if ((i==0) && (j==0)){
      if (grille[grille.length-1][grille.length-1] == n){life++;}
      if (grille[grille.length-1][j] == n){life++;}
      if (grille[grille.length-1][j+1] == n){life++;}
      if (grille[i][grille.length-1] == n){life++;}
      if (grille[i][j+1] == n){life++;}
      if (grille[i+1][grille.length-1] == n){life++;}
      if (grille[i+1][j] == n){life++;}
      if (grille[i+1][j+1] == n){life++;}
    }
    else if ((i==grille.length-1) && (j==0)) {
      if (grille[i-1][grille.length-1] == n){life++;}
      if (grille[i-1][j] == n){life++;}
      if (grille[i-1][j+1] == n){life++;}
      if (grille[i][grille.length-1] == n){life++;}
      if (grille[i][j+1] == n){life++;}
      if (grille[0][grille.length-1] == n){life++;}
      if (grille[0][j] == n){life++;}
      if (grille[0][j+1] == n){life++;}
    }
    else if ((i==0) && (j==grille[i].length-1)) {
      if (grille[grille.length-1][grille.length-1] == n){life++;}
      if (grille[grille.length-1][grille.length-1] == n){life++;}
      if (grille[grille.length-1][0] == n){life++;}
      if (grille[i][j-1] == n){life++;}
      if (grille[i][0] == n){life++;}
      if (grille[i+1][j-1] == n){life++;}
      if (grille[i+1][j] == n){life++;}
      if (grille[i+1][0] == n){life++;}
    }
    else if ((i==grille.length-1) && (j==grille[i].length-1)) {
      if (grille[i-1][j-1] == n){life++;}
      if (grille[i-1][j] == n){life++;}
      if (grille[i-1][0] == n){life++;}
      if (grille[i][j-1] == n){life++;}
      if (grille[i][0] == n){life++;}
      if (grille[0][grille.length-1] == n){life++;}
      if (grille[0][grille.length-1] == n){life++;}
      if (grille[0][0] == n){life++;}
    }
    else {
      if (i==0){
        if (grille[grille.length-1][j-1] == n){life++;}
        if (grille[grille.length-1][j] == n){life++;}
        if (grille[grille.length-1][j+1] == n){life++;}
        if (grille[i][j-1] == n){life++;}
        if (grille[i][j+1] == n){life++;}
        if (grille[i+1][j-1] == n){life++;}
        if (grille[i+1][j] == n){life++;}
        if (grille[i+1][j+1] == n){life++;}
      }

      else if (i==grille.length-1) {
        if (grille[i-1][j-1] == n){life++;}
        if (grille[i-1][j] == n){life++;}
        if (grille[i-1][j+1] == n){life++;}
        if (grille[i][j-1] == n){life++;}
        if (grille[i][j+1] == n){life++;}
        if (grille[0][j-1] == n){life++;}
        if (grille[0][j] == n){life++;}
        if (grille[0][j+1] == n){life++;}
      }
      else if (j==0) {
        if (grille[i-1][grille.length-1] == n){life++;}
        if (grille[i-1][j] == n){life++;}
        if (grille[i-1][j+1] == n){life++;}
        if (grille[i][grille[i].length-1] == n){life++;}
        if (grille[i][j+1] == n){life++;}
        if (grille[i+1][grille[i].length-1] == n){life++;}
        if (grille[i+1][j] == n){life++;}
        if (grille[i+1][j+1] == n){life++;}
      }
      else if (j==grille[i].length-1) {
        if (grille[i-1][j-1] == n){life++;}
        if (grille[i-1][j] == n){life++;}
        if (grille[i-1][0] == n){life++;}
        if (grille[i][j-1] == n){life++;}
        if (grille[i][0] == n){life++;}
        if (grille[i+1][0] == n){life++;}
        if (grille[i+1][0] == n){life++;}
        if (grille[i+1][0] == n){life++;}
      }

      else{

          if (grille[i-1][j-1] == n){life++;}
          if (grille[i-1][j] == n){life++;}
          if (grille[i-1][j+1] == n){life++;}
          if (grille[i][j-1] == n){life++;}
          if (grille[i][j+1] == n){life++;}
          if (grille[i+1][j-1] == n){life++;}
          if (grille[i+1][j] == n){life++;}
          if (grille[i+1][j+1] == n){life++;}

      }
    }
    return life;
  }


  public void Init_immigration(){
    int i,j;
    int i1 = 25;
    int i2 = 50;
    int i3 = 75;

    for (i = 0; i<this.grille.length/2 ; i++ ) {
      for (j = 0; j<this.grille[i].length/2 ; j++ ) {
          Random random = new Random();
          int var = random.nextInt(100);
          if(var<i1){
            this.grille[i][j] = 1;
            this.previous_grille[i][j] = 1;
          }
          else if(var<i2){
            this.grille[i][j] = 2;
            this.previous_grille[i][j] = 2;
          }
          else if(var<i3){
            this.grille[i][j] = 3;
            this.previous_grille[i][j] = 3;
          }
          else{
            this.grille[i][j] = 0;
            this.previous_grille[i][j] = 0;
          }
          //this.grille[i][j] = random.nextInt(2);
          //this.previous_grille[i][j] = random.nextInt(2);
        }

      }
      for (i = 0; i<this.grille.length/2; i++ ) {
        for (j = this.grille.length/2; j<this.grille[i].length ; j++ ) {
            Random random = new Random();
            int var = random.nextInt(100);
            if(var<i1){
              this.grille[i][j] = 0;
              this.previous_grille[i][j] = 0;
            }
            else if(var<i2){
              this.grille[i][j] = 1;
              this.previous_grille[i][j] = 1;
            }
            else if(var<i3){
              this.grille[i][j] = 2;
              this.previous_grille[i][j] = 2;
            }
            else{
              this.grille[i][j] = 3;
              this.previous_grille[i][j] = 3;
            }
            //this.grille[i][j] = random.nextInt(2);
            //this.previous_grille[i][j] = random.nextInt(2);
          }

        }
        for (i = this.grille.length/2; i<this.grille.length; i++ ) {
          for (j = 0; j<this.grille[i].length/2 ; j++ ) {
              Random random = new Random();
              int var = random.nextInt(100);
              if(var<i1){
                this.grille[i][j] = 3;
                this.previous_grille[i][j] = 3;
              }
              else if(var<i2){
                this.grille[i][j] = 0;
                this.previous_grille[i][j] = 0;
              }
              else if(var<i3){
                this.grille[i][j] = 1;
                this.previous_grille[i][j] = 1;
              }
              else{
                this.grille[i][j] = 2;
                this.previous_grille[i][j] = 2;
              }
              //this.grille[i][j] = random.nextInt(2);
              //this.previous_grille[i][j] = random.nextInt(2);
            }

          }
          for (i = this.grille.length/2; i<this.grille.length; i++ ) {
            for (j = this.grille.length/2; j<this.grille[i].length; j++ ) {
                Random random = new Random();
                int var = random.nextInt(100);
                if(var<i1){
                  this.grille[i][j] = 2;
                  this.previous_grille[i][j] = 2;
                }
                else if(var<i2){
                  this.grille[i][j] = 3;
                  this.previous_grille[i][j] = 3;
                }
                else if(var<i3){
                  this.grille[i][j] = 0;
                  this.previous_grille[i][j] = 0;
                }
                else{
                  this.grille[i][j] = 1;
                  this.previous_grille[i][j] = 1;
                }
                //this.grille[i][j] = random.nextInt(2);
                //this.previous_grille[i][j] = random.nextInt(2);
              }

            }
  }


  public void next_gen_immigration(){
    int i,j;
    copygrille(this.previous_grille, this.grille);
    for (i = 0; i<this.grille.length ; i++ ) {
      for (j = 0; j<this.grille[i].length ; j++ ) {
        int n = grille[i][j];
        int life = detect_voisins_migrant(previous_grille,i,j,n);
        if(life>2){
         if(grille[i][j]==3 && life>2){
            grille[i][j]=0;
          }
          else{
          grille[i][j]=n+1;
          }
        }

        else{
          grille[i][j]=n;
        }
      }

    }

  }



}
