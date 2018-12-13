package com.company;

import com.company.neuralnetwork.NeuralNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agent {

    private double batch;
    private double epoch;
    private double learningRate;

    private final NeuralNetwork network;

    public Agent(final NeuralNetwork network, double batchSize, double epochs, double learningRate){

        if(batchSize < 1 || epochs < 1){
            throw new IllegalArgumentException("Batch's size and epoch's count must be 1 or higher!");
        }
        this.network =  network;
        this.epoch = epochs;
        this.batch = batchSize;
        this.learningRate = learningRate;
    }

    public void processTrainingSet(List<String[]> input){

    }

    public void train(double maximalAcceptableErrorRate){


    }

    private double[] normalizeInput(double[] inputs){
        double sum = 0.0;
        double squareSum = 0.0;
        double u;
        double sigma;

        for(int i = 0; i < inputs.length; i++){
            sum += inputs[i];
        }

        u = sum / (double)inputs.length;

        for(int i = 0; i < inputs.length;i++){
            inputs[i] = inputs[i] - u;
        }

        for(int i = 0; i < inputs.length;i++){
            squareSum += Math.pow(inputs[i], 2);
        }

        sigma = squareSum /(double)inputs.length;

        for (int i = 0; i < inputs.length;i++){
            inputs[i] = inputs[i] / sigma;
        }

        return inputs;
    }
}
