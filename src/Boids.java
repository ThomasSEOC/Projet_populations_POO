import java.util.LinkedList;

public class Boids {

    private static int longueur;
    private static int hauteur;

    protected LinkedList<Boid> boids;
    
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

    

    @Override
    public String toString(){
        String ch = "";
        for(int i=0; i<this.boids.size();i++){
            ch += "Boid n°"+i+" :\n"+this.boids.get(i).toString()+"\n";
        }
        return ch ;
    }
}
