package com.iliketobreathe;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    	Vector2d a = new Vector2d(1, 2);
    	Vector2d b = new Vector2d(4, 10);

		Vector3d c = new Vector3d(2, 5, 3);
		Vector3d d = new Vector3d(8, 8, 8);

    	System.out.println(a.scalarMult(b));
    	System.out.println(a.add(b).toString());
		System.out.println(a.subtract(b).toString());
		System.out.println();

		System.out.println(c.scalarMult(d));
		System.out.println(c.vectorMult(d).toString());
		System.out.println(c.add(d).toString());
		System.out.println(c.subtract(d).toString());
    }
}
