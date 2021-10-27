
import java.awt.geom.Point2D.Double;
import java.awt.geom.Point2D;
//import java.lang.Math;
import java.awt.geom.Point2D;

public class Balls {

	public  static  final  double Max = 5;
	public  static  final  double Min = -5;

	public Point2D.Double p1 = new Point2D.Double(100,100);
	public Point2D.Double p2 = new Point2D.Double(200,200);
	public Point2D.Double p3 = new Point2D.Double(200,100);
	public Point2D.Double p4 = new Point2D.Double(100,200);

	public void translatePoint(int dx, int dy) {
		this.p1.setLocation(this.p1.getX() + dx, this.p1.getY() + dy);
		this.p2.setLocation(this.p2.getX() + dx, this.p2.getY() + dy);
		this.p3.setLocation(this.p3.getX() + dx, this.p3.getY() + dy);
		this.p4.setLocation(this.p4.getX() + dx, this.p4.getY() + dy);

	}

	public void reInit() {
		this.p1.setLocation(1,100);
		this.p2.setLocation(-1,-1);
		this.p3.setLocation(1,-1);
		this.p4.setLocation(-1,1);

	}

	@Override
	public String toString() {
		String ch = new String();
		ch = "balle 1 : (" + this.p1.getX() + " ; " + this.p1.getY() + "); ";
		ch = ch + "balle 2 : (" + this.p2.getX() + " ; " + this.p2.getY() + "); ";
		ch = ch + "balle 3 : (" + this.p3.getX() + " ; " + this.p3.getY() + "); ";
		ch = ch + "balle 4 : (" + this.p4.getX() + " ; " + this.p4.getY() + "); ";
		return ch;

	}
}
