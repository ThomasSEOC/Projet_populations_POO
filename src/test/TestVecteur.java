package test;

import main.Vecteur;

public class TestVecteur {
    public static void main(String[] args){
        Vecteur v1 = new Vecteur(1,1);
        Vecteur v2 = new Vecteur(2,2);

        v1.add(v2);
        System.out.println("v1+v2 = " +v1.toString());

        v2.mult(2);
        System.out.println("v2*2 : " +v2.toString());

        v1.div(3);
        System.out.println("v1/3 : " +v1.toString());

        v2.sub(v1);
        System.out.println("v2 - v1 : " +v2.toString());

        double n1 = v1.getNorm();
        System.out.println("Norme de v1 :"+ n1);

    }
}
