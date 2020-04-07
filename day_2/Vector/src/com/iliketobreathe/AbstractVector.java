package com.iliketobreathe;

public abstract class AbstractVector {

    public abstract double[] add(AbstractVector abstractVector);

    public abstract double[] subtract(AbstractVector abstractVector);

    public abstract double scalarMult(AbstractVector abstractVector);
}
