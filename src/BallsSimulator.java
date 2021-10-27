import java.util.Random;
import gui.*;
import java.awt.Color;


public class BallsSimulator implements Simulable {
	Balls b = new Balls();

	@Override
	public void next() {
		Random rand = new Random(); //instance of random class
	  int upperbound = 50; //generate random values from 0-50
    int int_random1 = rand.nextInt(upperbound);
	  int int_random2 = rand.nextInt(upperbound);
		this.b.translatePoint(int_random1, int_random2);
		gui.reset();
		gui.addGraphicalElement(new Oval((int)b.p1.getX(), (int)b.p1.getY(), Color.decode("#1f77b4"), Color.decode("#1f77b4"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p2.getX(), (int)b.p2.getY(), Color.decode("#26b41f"), Color.decode("#26b41f"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p3.getX(), (int)b.p3.getY(), Color.decode("#b41f62"), Color.decode("#b41f62"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p4.getX(), (int)b.p4.getY(), Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
	}

	@Override
	public void restart() {
		this.b.reInit();
		gui.reset();
		gui.addGraphicalElement(new Oval((int)b.p1.getX(), (int)b.p1.getY(), Color.decode("#1f77b4"), Color.decode("#1f77b4"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p2.getX(), (int)b.p2.getY(), Color.decode("#26b41f"), Color.decode("#26b41f"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p3.getX(), (int)b.p3.getY(), Color.decode("#b41f62"), Color.decode("#b41f62"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p4.getX(), (int)b.p4.getY(), Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
	}

}
