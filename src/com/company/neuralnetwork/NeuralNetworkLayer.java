package com.company.neuralnetwork;

import com.company.neuralnetwork.neuron.Neuron;
import com.sun.istack.internal.NotNull;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class NeuralNetworkLayer {

    private final String ID;

    private final List<Neuron> neurons;

    public NeuralNetworkLayer(@NotNull String ID, List<Neuron> neurons){
        this.ID = requireNonNull(ID, "Layer's ID can't be null!");
        this.neurons = neurons;
    }

    public String getID() {
        return ID;
    }

    public List<Neuron> getNeurons() {
         return neurons;
    }
}
