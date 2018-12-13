package com.company.neuralnetwork.neuron;

import com.company.neuralnetwork.functions.ActivationFunction;
import com.company.neuralnetwork.functions.NeuronInputFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class Neuron {

    /**
     * Neuron's identifier
     * */
    private final String ID;

    private double bias;

    private List<NeuralConnection> inputConnections;

    private List<NeuralConnection> outputConnections;

    private NeuronInputFunction inputFunction;

    private ActivationFunction activationFunction;

    public Neuron(String ID, NeuronInputFunction inputFunction, ActivationFunction activationFunction){
        this.ID = requireNonNull(ID);
        this.inputFunction = requireNonNull(inputFunction);
        this.activationFunction = requireNonNull(activationFunction);
        this.bias = Math.random();
        this.inputConnections = new ArrayList<>();
        this.outputConnections = new ArrayList<>();
    }

    public double calcuateOutput(){
        double summedInput = 0.0;
        if(inputConnections.size() != 0){
            inputFunction.calculateSummedInput(inputConnections);
        }
        double output = activationFunction.calcualteOutput(summedInput+bias);

        return output;
    }

    public void addInputConnection(NeuralConnection neuralConnection){
        inputConnections.add(neuralConnection);
    }

    public void addOutputConnection(NeuralConnection neuralConnection){
        outputConnections.add(neuralConnection);
    }

    public String getID() {
        return ID;
    }

    public double getBias() {
        return bias;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setBias(double bias){
        this.bias = bias;
    }
}
