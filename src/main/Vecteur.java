package main;

import java.awt.geom.Point2D ;

public class Vecteur extends Point2D.Double {

    public double x;
    public double y;

    public Vecteur(){
        this.x = 0;
        this.y = 0;
    }


    public Vecteur(double x, double y){
        this.x=x;
        this.y=y;
    }

    public void reset(){
        this.x = 0;
        this.y = 0;
    }
    public Vecteur copy(){
        //Permet de caster le point2D en vecteur
        return (Vecteur)super.clone() ;
    }

    public void add(Vecteur v){
        this.x+=v.x;
        this.y+=v.y;
    }

    public void sub(Vecteur v){
        this.x-=v.x;
        this.y-=v.y;
    }

    public void mult(double lambda){
        this.x*=lambda;
        this.y*=lambda;
    }

    public void div(double lambda){
        if(lambda == 0){
            throw new IllegalArgumentException("Division by zero is not not allowed");
        }
        this.x/=lambda;
        this.y/=lambda;
    }

    public double norm(Vecteur v){
        return Math.sqrt( (v.x*v.x) + (v.y*v.y) );
    }

    public double getNorm(){
        return Math.sqrt( (this.x*this.x) + (this.y*this.y));
    }

    //Si la norme du vecteur dépasse une norme limite, on lui attribue la norme limite en conservant la direction
    public void lim(int limite){
        double norm = this.getNorm();
        if(norm > limite){
            this.div(norm);
            this.mult(limite);
        }
    }


    @Override
    public String toString(){
        return ("("+this.x+";"+this.y+")");
    }

}
