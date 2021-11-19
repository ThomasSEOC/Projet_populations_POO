package main;

import java.util.LinkedList;

public class Boids {

    protected final int TOO_CLOSE = 5;
    protected final int SPEED_LIMIT = 5 ;
    protected final int FORCE_LIMIT = 100 ;

    private static int longueur;
    private static int hauteur;

    public LinkedList<Boid> boids;

    public Boids(){
        this.boids = new LinkedList<Boid>() ;
    }

    public static void setLongueur(int l){
        Boids.longueur = l;
    }

    public static int getLongueur(){
        return longueur;
    }

    public static void setHauteur(int h){
        Boids.hauteur = h;
    }

    public static int getHauteur(){
        return hauteur;
    }


    public void addBoid(Boid b){
        this.boids.add(b);
    }

    // Règle n°1 : Calcul du centre de masse vers lequel le Boid se dirige
    public Vecteur rule1(Boid boid){
        Vecteur f1 = new Vecteur();
        for(Boid b : this.boids){
            if(b != boid){
                f1.add(b.position);
            }
        }
        f1.div(this.boids.size());
        return f1;
    }

    //Règle n°2 : les agents trop proches se repoussent pour éviter la colision
    public Vecteur rule2(Boid boid){
        Vecteur f2 = new Vecteur();
        for(Boid b : this.boids){
            if(b != boid){
                if(boid.position.distance(b.position) < TOO_CLOSE){
                    b.position.sub(boid.position);
                    f2.sub(b.position);
                }
            }
        }
        return f2;
    }

    //Règle n°3 : On adapte la vitesse du boid en fonction des boids voisins
    public Vecteur rule3(Boid boid){
        Vecteur f3 = new Vecteur();
        for(Boid b : this.boids){
            if(b!=boid && boid.isVisible(b)){
                f3.add(b.speed);
            }
        }
        f3.div(this.boids.size());
        f3.sub(boid.speed);
        f3.div(100);

        return f3;
    }

    public void accel_calc(Boid b,Vecteur f){
        int mass = 1; // Pour l'instant on définit la masse d'un Boid à 1 pour simplifier
        f.div(mass);
        f.lim(FORCE_LIMIT);

        b.accel.add(f);
    }

    public void move_boids_to_new_position(){

        for(Boid b : this.boids){

            Vecteur resultante = new Vecteur();
            resultante.add(rule1(b));
            resultante.add(rule2(b));
            resultante.add(rule3(b));

            accel_calc(b,resultante);
            b.speed.add(b.accel);
            b.speed.lim(SPEED_LIMIT);

            b.position.add(b.speed);

            b.handleCord();

            b.accel.reset();

        }
    }


    @Override
    public String toString(){
        String ch = "";
        for(int i=0; i<this.boids.size();i++){
            ch += "Boid n°"+i+" :\n"+this.boids.get(i).toString()+"\n";
        }
        return ch ;
    }
}
