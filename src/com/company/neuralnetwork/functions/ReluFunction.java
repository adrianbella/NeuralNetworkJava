package com.company.neuralnetwork.functions;

public class ReluFunction implements ActivationFunction {

    private final double alpha = 0.01;

    @Override
    public double calcualteOutput(double summedInput) {

        double output = 0.0;

        output =  Math.max(summedInput*alpha,summedInput);

        return output;
    }

    @Override
    public double getDerivative(double summedInput) {

        double derivative = 0.0;

        if(summedInput < 0){
            derivative = alpha;
        }else if(summedInput >= 0){
            derivative = 1;
        }
        return derivative;
    }
}
