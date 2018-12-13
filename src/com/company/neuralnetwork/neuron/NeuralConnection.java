package com.company.neuralnetwork.neuron;

import com.sun.istack.internal.NotNull;

import static java.util.Objects.requireNonNull;

/***
 * Represents a connection between two neurons
 */
public class NeuralConnection {

    private Neuron fromNeuron;
    private Neuron toNeuron;

    private double weight;

    public NeuralConnection(@NotNull Neuron from,@NotNull Neuron to){
        this.fromNeuron = requireNonNull(from,"Neuron can't be null");
        this.toNeuron = requireNonNull(to,"Neuron can't be null");
        this.weight = Math.random();
    }

    public NeuralConnection(@NotNull Neuron from,@NotNull Neuron to, double weight){
        this.fromNeuron = requireNonNull(from,"Neuron can't be null");
        this.toNeuron = requireNonNull(to,"Neuron can't be null");
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getInput(){
        return fromNeuron.calcuateOutput();
    }

    public double getWeightedInput(){
        return fromNeuron.calcuateOutput()*weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
