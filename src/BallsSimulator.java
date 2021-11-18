
import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;


public class BallsSimulator implements Simulable {

	private Balls balls;
	private GUISimulator gui;

	public BallsSimulator(GUISimulator gui, Balls balls){

			this.gui = gui;
			this.balls = balls;
	}

	@Override
	public void next() {
		this.balls.translateBalls();
		Iterator<Point> itBalls = balls.iterator();
		gui.reset();
		while(itBalls.hasNext()) {
			Point b = itBalls.next();
			gui.addGraphicalElement(new Oval((int)b.getX(), (int)b.getY(), Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
		}

	}

	@Override
	public void restart() {
		this.balls.reInit();
		Iterator<Point> itBalls = balls.iterator();
		gui.reset();
		while(itBalls.hasNext()) {
			Point b = itBalls.next();
			gui.addGraphicalElement(new Oval((int)b.getX(), (int)b.getY(), Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
		}
	}
}
