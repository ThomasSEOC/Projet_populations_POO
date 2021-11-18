import java.util.LinkedList;


public class Boid {

    protected Vecteur position;
    protected Vecteur speed;
    protected Vecteur accel;

    protected double theta;

    protected LinkedList<Boid> boids ;

    protected final int MINIMAL_DISTANCE = 2; // A tester
    protected final int TOO_CLOSE = 2;
    protected final int SPEED_LIMIT = 10 ;
    protected final int FORCE_LIMIT = 50 ;

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

    // public void setBoids(LinkedList<Boid> boids ){
    //     this.boids = boids ;
    // }

    public double modulo2PI(double b){
        return b%(2*Math.PI) ;
    }

    public double modulo(double a, double b){
        return a%b ;
    }

    //Permet une representation "sphérique" du plan
    public void debordement(Vecteur v){
        v.x = v.x%Boids.getHauteur();
        v.y = v.y%Boids.getLongueur();

        this.position = v;

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

    // Règle n°1 : Calcul du centre de masse vers lequel le Boid se dirige
    public Vecteur rule1(Boids boids){
        Vecteur f1 = new Vecteur();
        for(Boid b : boids.boids){
            if(b != this){
                f1.add(b.position);
            }
        }
        f1.div(boids.boids.size());
        return f1;
    }

    //Règle n°2 : les agents trop proches se repoussent pour éviter la colision
    public Vecteur rule2(Boids boids){
        Vecteur f2 = new Vecteur();
        for(Boid b : boids.boids){
            if(b != this){
                if(this.position.distance(b.position) < TOO_CLOSE){
                    b.position.sub(this.position);
                    f2.sub(b.position);
                }
            }
        }
        return f2;
    }

    //Règle n°3 : On adapte la vitesse du boid en fonction des boids voisins
    public Vecteur rule3(Boids boids){
        Vecteur f3 = new Vecteur();
        for(Boid b : boids.boids){
            if(b!=this && isVisible(b)){
                f3.add(b.speed);
            }
        }
        f3.div(boids.boids.size());
        f3.sub(this.speed);
        f3.div(8);

        return f3;
    }

    public void accel_calc(Vecteur f){
        int mass = 1; // Pour l'instant on définit la masse d'un Boid à 1 pour simplifier
        f.div(mass);
        f.lim(FORCE_LIMIT);

        this.accel.add(f);


    }


    public void move_boid_to_new_position(Boids boids){
        //Calcul de l'accélaration
        Vecteur resultante = rule1(boids);
        resultante.add(rule2(boids));
        resultante.add(rule3(boids));
        accel_calc(resultante);

        this.speed.add(this.accel);
        this.speed.lim(SPEED_LIMIT);
        setAngle();
        this.position.add(this.speed);
        debordement(this.position);

        //On remet l'accelération à zéro à la fin de l'itération car on elle change à chaque itératiion
        this.accel.reset();
    }

    @Override
    public String toString(){
        return "Position : " + this.position.toString() +"\n"+
        "Vitesse : " + this.speed.toString()+"\n"+
        "Acceleration : " + this.accel.toString() +"\n\n"
        ;
    }

}
