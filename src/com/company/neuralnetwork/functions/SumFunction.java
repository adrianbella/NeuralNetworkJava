package com.company.neuralnetwork.functions;

import com.company.neuralnetwork.neuron.NeuralConnection;

import java.util.List;

public class SumFunction implements NeuronInputFunction{
    @Override
    public double calculateSummedInput(List<NeuralConnection> inputNeuronConnection) {
        double sum = 0.0;

        for(NeuralConnection nc : inputNeuronConnection){
            sum += nc.getWeightedInput();
        }

        return sum;
    }
}
