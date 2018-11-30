package com.company;

import java.util.List;
import java.util.Map;

public class Neuron {

    private final String ID;
    private final double bias;
    private final String activation;
    private final boolean isInputNeuron;

    private double[] weights;
    private double output;


    public Neuron(double bias,String activation, String ID, boolean isInputNeuron, double[] initWeights){
        this.bias = bias;
        this.activation = activation;
        this.ID = ID;
        this.isInputNeuron = isInputNeuron;
        this.weights = initWeights;
    }

    public void calculateOutput(double[] inputs){

        double sum = 0.0;
        double net = 0.0;

        if(inputs.length != weights.length){
            String error = ID + ": Neuron inputcount and weightcount does not match!";
            throw new RuntimeException(error);
        }

        if(isInputNeuron){
          inputs = normalizeInput(inputs);
        }

        if(activation == "sigmoid"){

            for(int i = 0; i < inputs.length; i++){
                sum += inputs[i] * weights[i];
            }

            net = sum + bias;
        }else if (activation == "relu"){
            //TODO: megírni a megfelelő aktivációs függvényt!
        }

        output = 1 / (1 + Math.exp(-net));
    }

    private double[] normalizeInput(double[] inputs){
        double sum = 0.0;
        double u = 0.0;
        double sigma = 0.0;

        for(int i = 0; i < inputs.length; i++){
            sum += inputs[i];
        }
        u = sum/(double)inputs.length;
        sum = 0.0;

        for(int i = 0; i < inputs.length;i++){
            inputs[i] = inputs[i] - u;
        }

        for(int i = 0; i < inputs.length;i++){
            sum += inputs[i]*inputs[i];
        }

        sigma = sum/(double)inputs.length;

        for (int i = 0; i < inputs.length;i++){
            inputs[i] = inputs[i]/sigma;
        }

        return inputs;
    }

    public String getID() {
        return ID;
    }

    public double getBias() {
        return bias;
    }

    public String getActivation() {
        return activation;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getDerivate() {
        return output * (1-output);
    }
}
