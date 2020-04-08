package com.iliketobreathe;

import java.util.Arrays;

public final class Vector3d extends AbstractVector implements VectorMultipliable{
    private final double[] vector;

    public Vector3d(double x, double y, double z) {
        this.vector = new double[]{x, y, z};
    }

    public Vector3d(double[] vector) {
        this.vector = vector;
    }

    public double[] getVector() {
        return vector;
    }

    @Override
    public AbstractVector add(AbstractVector abstractVector) {
        return new Vector3d(new double[] {this.vector[0] + ((Vector3d)abstractVector).getVector()[0], this.vector[1] + ((Vector3d)abstractVector).getVector()[1], this.vector[2] + ((Vector3d)abstractVector).getVector()[2]});
    }

    @Override
    public AbstractVector subtract(AbstractVector abstractVector) {
        return new Vector3d(new double[] {this.vector[0] - ((Vector3d)abstractVector).getVector()[0], this.vector[1] - ((Vector3d)abstractVector).getVector()[1], this.vector[2] - ((Vector3d)abstractVector).getVector()[2]});
    }

    @Override
    public double scalarMult(AbstractVector abstractVector) {
        return this.vector[0] * ((Vector3d)abstractVector).getVector()[0] + this.vector[1] * ((Vector3d)abstractVector).getVector()[1] + this.vector[2] * ((Vector3d)abstractVector).getVector()[2];
    }

    @Override
    public AbstractVector vectorMult(AbstractVector abstractVector) {
        double[] vector = ((Vector3d)abstractVector).getVector();
        return new Vector3d(new double[] {this.vector[1] * vector[2] - this.vector[2] * vector[1], this.vector[2] * vector[0] - this.vector[0] * vector[2], this.vector[0] * vector[1] - this.vector[1] * vector[0]});
    }

    @Override
    public String toString() {
        return "Vector3d{" +
                "vector=" + Arrays.toString(vector) +
                '}';
    }
}
