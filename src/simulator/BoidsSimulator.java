package simulator;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

import main.Boids;
import main.Boid;

public class BoidsSimulator implements Simulable {

	private Boids boids;
	private GUISimulator gui;

	public BoidsSimulator(GUISimulator gui, Boids boids){

			this.gui = gui;
			this.boids = boids;
	}

	@Override
	public void next() {
    gui.reset();
    int i=0;
		while( i<this.boids.boids.size() ) {
			boids.move_boids_to_new_position();
      Boid a = this.boids.boids.get(i);
      String ch = new String();
      ch = "#"+i+i+i+i+i+i;
			gui.addGraphicalElement(new Oval((int)(Math.abs(a.position.x)%500), (int)(Math.abs(a.position.y)%500), Color.decode(ch), Color.decode(ch), 10)) ;
      i++;
    }
		System.out.println(boids.toString());

	}

	@Override
	public void restart() {
    gui.reset();
    Boid b1 = new Boid(10,10,1,-1,0,0);
    Boid b2 = new Boid(10,490,-1,-1,0,0);
    Boid b3 = new Boid(490,10,1,1,0,0);
    Boid b4 = new Boid(490,490,-1,1,0,0);
    gui.addGraphicalElement(new Oval((int)b1.position.x, (int)b1.position.y, Color.decode("#111111"), Color.decode("#111111"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b2.position.x, (int)b2.position.y, Color.decode("#222222"), Color.decode("#222222"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b3.position.x, (int)b3.position.y, Color.decode("#333333"), Color.decode("#333333"), 10)) ;
    gui.addGraphicalElement(new Oval((int)b4.position.x, (int)b4.position.y, Color.decode("#444444"), Color.decode("#444444"), 10)) ;
		System.out.println(boids.toString());


	}
}
