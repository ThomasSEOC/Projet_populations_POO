import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class TestBoidsSimulator {

	public static void main(String[] args) {
		Boids boids = new Boids();
		GUISimulator gui = new GUISimulator (500, 500, Color.GRAY) ;
		gui.setSimulable(new BoidsSimulator (gui,boids)) ;
		gui.reset();

    boids.setLongueur(500);
    boids.setHauteur(500);

    Boid b1 = new Boid(7.,70,3,3,0,0);
    Boid b2 = new Boid(50,28,10,10,0,0);
    Boid b3 = new Boid(38,50,0,0,0,0);
    Boid b4 = new Boid(25,33,0,0,0,0);

    boids.addBoid(b1);
    boids.addBoid(b2);
    boids.addBoid(b3);
    boids.addBoid(b4);


		gui.addGraphicalElement(new Oval((int)b1.position.x, (int)b1.position.y, Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b2.position.x, (int)b2.position.y, Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b3.position.x, (int)b3.position.y, Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b4.position.x, (int)b4.position.y, Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;

	}

}
