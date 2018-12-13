package com.company.neuralnetwork.functions;

import com.company.neuralnetwork.neuron.NeuralConnection;

import java.util.List;

/**
 * Represent the input part of a neuron
 * */
public interface NeuronInputFunction {

    /***
     * @param inputNeuronConnection list of the connections to the neuron
     * @return sum of the inpust of the neuron
     */
    double calculateSummedInput(List<NeuralConnection> inputNeuronConnection);
}
