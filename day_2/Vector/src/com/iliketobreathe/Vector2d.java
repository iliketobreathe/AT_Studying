package com.iliketobreathe;

import java.util.Arrays;

public final class Vector2d extends AbstractVector {
    private final double[] vector;

    public Vector2d(double x, double y) {
        this.vector = new double[]{x, y};
    }

    public Vector2d(double[] vector) {
        this.vector = vector;
    }

    public double[] getVector() {
        return vector;
    }

    @Override
    public AbstractVector add(AbstractVector abstractVector) {
        return new Vector2d(new double[] {this.vector[0] + ((Vector2d)abstractVector).getVector()[0], this.vector[1] + ((Vector2d)abstractVector).getVector()[1]});
    }

    @Override
    public AbstractVector subtract(AbstractVector abstractVector) {
        return new Vector2d(new double[] {this.vector[0] - ((Vector2d)abstractVector).getVector()[0], this.vector[1] - ((Vector2d)abstractVector).getVector()[1]});
    }

    @Override
    public double scalarMult(AbstractVector abstractVector) {
        return this.vector[0] * ((Vector2d)abstractVector).getVector()[0] + this.vector[1] * ((Vector2d)abstractVector).getVector()[1];
    }

    @Override
    public String toString() {
        return "Vector2d{" +
                "vector=" + Arrays.toString(vector) +
                '}';
    }
}
