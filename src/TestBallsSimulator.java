import gui.*;
import java.awt.Color;

public class TestBallsSimulator {

	public static void main(String[] args) {
		Balls b = new Balls();
		GUISimulator gui = new GUISimulator (500, 500, Color.BLACK) ;
		gui.setSimulable(new BallsSimulator ()) ;
		gui.addGraphicalElement(new Oval((int)b.p1.getX(), (int)b.p1.getY(), Color.decode("#1f77b4"), Color.decode("#1f77b4"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p2.getX(), (int)b.p2.getY(), Color.decode("#26b41f"), Color.decode("#26b41f"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p3.getX(), (int)b.p3.getY(), Color.decode("#b41f62"), Color.decode("#b41f62"), 10)) ;
		gui.addGraphicalElement(new Oval((int)b.p4.getX(), (int)b.p4.getY(), Color.decode("#b4621f"), Color.decode("#b4621f"), 10)) ;

	}

}
