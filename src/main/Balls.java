package main;

import java.awt.geom.Point2D.Double;
import java.awt.geom.Point2D;
//import java.lang.Math;
import java.awt.Point;
import java.util.*;

public class Balls {

	private static final Point DIRECTION = new Point(10, 10);

	public  static  final  double Max = 5;
	public  static  final  double Min = -5;

	private static int longueur=500;
	private static int hauteur=500;

	private LinkedList<Point> balls;
	private LinkedList<Point> dir;

	public Balls() {
		this.balls = new LinkedList<Point>();
		this.dir = new LinkedList<Point>();
	}

	public void addBall() {
		this.balls.add(new Point());
		this.dir.add(new Point(DIRECTION));
	}

	public void translate(int dx, int dy) {
		for (Point b : balls)
			b.translate(dx, dy);

	}


	public void translateBalls() {
		final int BALLSIZE = 10;
		Iterator<Point> itDir = dir.iterator();

		for(Point b : balls) {
			final Point dir = itDir.next();

			Random rand = new Random(); //instance of random class
			int upperbound = 50; //generate random values from 0-50
			int int_random1 = rand.nextInt(upperbound);
			int int_random2 = rand.nextInt(upperbound);
			final int dx = int_random1;
			final int dy = int_random2;

			// Traitement des collisions
			if (b.x + dir.x > longueur && b.y + dir.y > hauteur) {
					dir.setLocation(-dx, -dy);
					b.translate(longueur - b.x, hauteur - b.y);
				}
				else if (b.x + dir.x > longueur) {
					dir.setLocation(-dx, dir.y);
					b.translate(longueur - b.x, dir.y);
				}
				else if (b.y + dir.y > hauteur) {
					dir.setLocation(dir.x, -dy);
					b.translate(dir.x, hauteur - b.y);
				}
				else if (b.x + dir.x < BALLSIZE && b.y + dir.y < BALLSIZE){
					dir.setLocation(dx, dy);
					b.translate(BALLSIZE - b.x, BALLSIZE - b.y);
				}
				else if (b.x + dir.x < BALLSIZE) {
					dir.setLocation(dx, dir.y);
					b.translate(BALLSIZE - b.x, dir.y);
				}
				else if (b.y + dir.y < BALLSIZE) {
					dir.setLocation(dir.x, dy);
					b.translate(dir.x, BALLSIZE - b.y);
				}
				else if (b.x + dir.x > longueur && b.y + dir.y < BALLSIZE) {
					dir.setLocation(-dx, dy);
					b.translate(longueur - b.x, BALLSIZE - b.y);
				}
				else if (b.x + dir.x < BALLSIZE && b.y + dir.y > hauteur) {
					dir.setLocation(dx, -dy);
					b.translate(BALLSIZE - b.x, hauteur - b.y);
				}
				else
					b.translate(dir.x, dir.y);
			}
	}

	public void reInit() {
		for (Point b : balls) {
			b.setLocation(0,0);
		}
	}

	public Iterator<Point> iterator(){
		return balls.iterator();
	}


	@Override
	public String toString() {
		String ch = new String();

		return ch;

	}
}
