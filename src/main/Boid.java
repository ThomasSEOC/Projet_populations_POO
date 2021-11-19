package main;

import java.util.LinkedList;


public class Boid {

    public Vecteur position;
    protected Vecteur speed;
    protected Vecteur accel;

    protected double theta;

    public LinkedList<Boid> boids ;

    protected final int MINIMAL_DISTANCE = 5; // A tester
    protected final int TOO_CLOSE = 5;
    protected final int SPEED_LIMIT = 20 ;
    protected final int FORCE_LIMIT = 100 ;

    protected final int DIST_VISIBLE = 10;
    protected final double ANGLE_VISIBLE = 5*Math.PI/6;


    public Boid(double x, double y, double vx, double vy, double ax, double ay){
        this.position = new Vecteur(x,y);
        this.speed = new Vecteur(vx,vy);
        this.accel = new Vecteur(ax,ay);
    }

    public Vecteur getPosition(){
        return this.position;
    }

    public Vecteur getSpeed(){
        return this.speed;
    }

    public Vecteur getAccel(){
        return this.accel ;
    }

    public void setBoids(LinkedList<Boid> boids ){
        this.boids = boids ;
    }

    public double modulo2PI(double b){
        return b%(2*Math.PI) ;
    }

    public double modulo(double a, double b){
        return a%b ;
    }

    //Permet une representation "sphérique" du plan
    public void handlePos(){
        this.position.x %= Boids.getHauteur();
        this.position.y %= Boids.getLongueur();
    }

    public void handleCord(){
      this.position.x = Math.abs(this.position.x)%500;
      this.position.y = Math.abs(this.position.y)%500;
    }
    //Calcule l'angle vers lequel le Boid se dirige dans un repère orthogonal
    public void setAngle(){
        this.theta = modulo2PI(Math.atan2(this.speed.y,this.speed.x));
    }

    public boolean isVisible(Boid b){
        double eps = this.position.distance(b.position);

        //Calcul de l'angle relatif entre this et le voisin
        double relativePosX = b.position.x - this.position.x;
        double relativePosY = b.position.y - this.position.y;
        double relativeAngle = modulo2PI(Math.atan2(relativePosY, relativePosX));

        //Calcul du "champ de vision"
        double angle_maxi = modulo2PI(relativeAngle + ANGLE_VISIBLE);
        double angle_mini = modulo2PI(relativeAngle - ANGLE_VISIBLE);

        //Cas ou le modulo rend l'angle mini plus grand que le maxi et inversement
        if(angle_maxi < angle_mini){
            double save = angle_maxi;
            angle_maxi = angle_mini;
            angle_mini = save;
        }
        //Si le voisin est assez proche et dans le champ de vision, on le considère visible
        if(eps < DIST_VISIBLE && (angle_mini < relativeAngle && angle_maxi > relativeAngle) ){
            return true ;
        }

        return false ;
    }


    @Override
    public String toString(){
        return "Position : " + this.position.toString() +"\n"+
        "Vitesse : " + this.speed.toString()+"\n"+
        "Acceleration : " + this.accel.toString() +"\n\n"
        ;
    }

}
