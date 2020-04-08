package com.iliketobreathe;

public abstract class AbstractVector {

    public abstract AbstractVector add(AbstractVector abstractVector);

    public abstract AbstractVector subtract(AbstractVector abstractVector);

    public abstract double scalarMult(AbstractVector abstractVector);
}
