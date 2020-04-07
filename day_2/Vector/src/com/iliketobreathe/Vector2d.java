package com.iliketobreathe;

import java.util.Arrays;

public final class Vector2d extends AbstractVector {
    private final double[] vector;

    public Vector2d(double x, double y) {
        this.vector = new double[]{x, y};
    }

    public double[] getVector() {
        return vector;
    }

    @Override
    public double[] add(AbstractVector abstractVector) {
        return new double[] {this.vector[0] + ((Vector2d)abstractVector).getVector()[0], this.vector[1] + ((Vector2d)abstractVector).getVector()[1]};
    }

    @Override
    public double[] subtract(AbstractVector abstractVector) {
        return new double[] {this.vector[0] - ((Vector2d)abstractVector).getVector()[0], this.vector[1] - ((Vector2d)abstractVector).getVector()[1]};
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
