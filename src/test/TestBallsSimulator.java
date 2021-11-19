package test;

import main.Balls;
import simulator.BallsSimulator;

import gui.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;

public class TestBallsSimulator {

	public static void main(String[] args) {
		Balls balls = new Balls();
		GUISimulator gui = new GUISimulator (500, 500, Color.BLACK) ;
		gui.setSimulable(new BallsSimulator (gui,balls)) ;
		gui.reset();

		balls.addBall();
		balls.addBall();
		balls.addBall();
		balls.addBall();

		Iterator<Point> balls_main = balls.iterator();
		while(balls_main.hasNext()) {
			Point b = balls_main.next();
			gui.addGraphicalElement(new Oval((int)b.getX(), (int)b.getY(), Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;
		}
	}

}
