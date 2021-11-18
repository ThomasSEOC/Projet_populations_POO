public class TestBoid {
    public static void main(String[] args) {
        Boids boids1 = new Boids();

        Boid b1 = new Boid(1,1,13,13,0,0);
        Boid b2 = new Boid(-1,-1,100,100,0,0);
        Boid b3 = new Boid(1,-1,0,0,0,0);
        Boid b4 = new Boid(-1,1,0,0,0,0);

        boids1.addBoid(b1);
        boids1.addBoid(b2);
        boids1.addBoid(b3);
        boids1.addBoid(b4);
        
        //b1.boids = boids1 ;

        //System.out.println(b1.toString());
        //System.out.println(boids1.toString());
        //System.out.println(b1.rule1());

        b1.speed.lim(b1.SPEED_LIMIT);
        System.out.println(b1.speed.toString());
        b2.speed.lim(b2.SPEED_LIMIT);
        System.out.println(b2.speed.toString());
    }
}
