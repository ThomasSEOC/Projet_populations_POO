package test;

import main.Boids;
import main.Boid;
import simulator.BoidsSimulator;

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

		Boid b1 = new Boid(10,10,1,-1,0,0);
    Boid b2 = new Boid(10,490,-1,-1,0,0);
    Boid b3 = new Boid(490,10,1,1,0,0);
    Boid b4 = new Boid(490,490,-1,1,0,0);

    boids.addBoid(b1);
    boids.addBoid(b2);
    boids.addBoid(b3);
    boids.addBoid(b4);


		gui.addGraphicalElement(new Oval((int)b1.position.x, (int)b1.position.y, Color.decode("#111111"), Color.decode("#111111"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b2.position.x, (int)b2.position.y, Color.decode("#222222"), Color.decode("#222222"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b3.position.x, (int)b3.position.y, Color.decode("#333333"), Color.decode("#333333"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b4.position.x, (int)b4.position.y, Color.decode("#444444"), Color.decode("#b4621f"), 10)) ;

	}

}
