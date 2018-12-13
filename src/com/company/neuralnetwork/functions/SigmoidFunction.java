package com.company.neuralnetwork.functions;

public class SigmoidFunction implements ActivationFunction {

    @Override
    public double calcualteOutput(double summedInput) {

        double output = 0.0;

        output = 1.0 / (1.0 + Math.exp(-summedInput));

        return  output;
    }

    @Override
    public double getDerivative(double summedInput) {

        double derivative = 0.0;

        derivative = summedInput * (1-summedInput);

        return summedInput;
    }
}
