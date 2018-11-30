package com.company;

import java.util.HashSet;
import java.util.Set;

public class NN {

    private final double neuronCount;

    private final double initialWeight = 0.001;
    private final double initialBias = 0.001;

    private final String hiddenLayerActivation;
    private final String outputLayerActivation;

    private Set<Neuron> hiddenNeurons;
    private Neuron outputNeuron;

    public NN(int neuronCount, String hLA, String oLA){

        if(((hLA.equals("reLu")||hLA.equals("sigmoid")) && (oLA.equals("reLu")||oLA.equals("sigmoid"))) == false){
            throw new RuntimeException("Wrong activation String!");
        }

        this.neuronCount = neuronCount;
        this.hiddenLayerActivation = hLA;
        this.outputLayerActivation = oLA;

        this.hiddenNeurons = new HashSet<>(neuronCount-1);

        double [] outputNeuronInitialWeights = new double[neuronCount-1];

        for(int i = 0; i < outputNeuronInitialWeights.length; i++){
            outputNeuronInitialWeights[i] = initialWeight;
        }


        this.outputNeuron = new Neuron(initialBias,outputLayerActivation,"o1",false,outputNeuronInitialWeights);

        hiddenLayerInint();
    }

    private void hiddenLayerInint(){

        double[] hiddenLayerInitialWeights = new double[81];

        for(int i = 0; i < hiddenLayerInitialWeights.length; i++){
            hiddenLayerInitialWeights[i] = initialWeight;
        }

        int idIndex = 1;
        for(Neuron n : hiddenNeurons){
            String ID = "h"+String.valueOf(idIndex++);
            n = new Neuron(initialBias,hiddenLayerActivation,ID,true,hiddenLayerInitialWeights);
        }
    }
}
