package com.company.neuralnetwork;

import com.company.neuralnetwork.functions.SigmoidFunction;
import com.company.neuralnetwork.functions.SumFunction;
import com.company.neuralnetwork.neuron.NeuralConnection;
import com.company.neuralnetwork.neuron.Neuron;

import java.util.*;

public class NeuralNetwork {

    private NeuralNetworkLayer inputLayer;
    private List<NeuralNetworkLayer> hiddenLayers;
    private NeuralNetworkLayer outputLayer;

    public NeuralNetwork(Map<String, String> structure){

        hiddenLayers = new ArrayList<>();

        if(structure.size() < 2){
            throw new IllegalArgumentException("Neural network need to have at least 2 layers (input, output)");
        }

        List<String> layerIDs = getLayerIDs(structure);
        List<String> neuronCounts = getNeuronCounts(structure);

        buildNetwork(layerIDs,neuronCounts,structure.size());

        buildNeuralConnections();

    }

    private List<String> getLayerIDs(Map<String, String> structure){
        List<String> layers = new ArrayList<>();

        for(Map.Entry entry:structure.entrySet()){
            layers.add((String)entry.getKey());
        }
        return layers;
    }

    private List<String> getNeuronCounts(Map<String, String> structure){
        List<String> neuronCounts = new ArrayList<>();

        for(Map.Entry entry:structure.entrySet()){
            neuronCounts.add((String)entry.getValue());
        }

        return  neuronCounts;
    }

    private List<Neuron> getNeuronList(double ncount, String layerID){
        List<Neuron> neurons = new ArrayList<>();

        for(int i = 0; i < ncount; i++){
            String neuronID = layerID + ":" + String.valueOf(i);
            Neuron neuron = new Neuron(neuronID, new SumFunction(),new SigmoidFunction());//TODO:Make it parametrizable
            neurons.add(neuron);
        }

        return neurons;
    }

    private void buildNetwork(List<String> layerIDs,List<String> neuronCounts,int layerCount){

        for(int i = 0; i < layerCount; i++){
            int neuronCount = Integer.parseInt(neuronCounts.get(i));
            String currentLayerID = layerIDs.get(i);
            List<Neuron> currentLayerNeurons = getNeuronList(neuronCount, currentLayerID);

            if(i == 0){
                if(currentLayerNeurons.size() != 81){//TODO: Delete this functionality later
                    throw new IllegalArgumentException("Input layer must have 81 neurons instead of: "+currentLayerNeurons.size());
                }else{
                    inputLayer = new NeuralNetworkLayer(currentLayerID,currentLayerNeurons);
                }

            }else if(i == layerCount-1){
                if(currentLayerNeurons.size() != 1){//TODO: Delete this functionality later
                    throw new IllegalArgumentException("Output layer must have 1 neuron instead of: "+currentLayerNeurons.size());
                }else{
                    outputLayer = new NeuralNetworkLayer(currentLayerID,currentLayerNeurons);
                }

            }else{
                hiddenLayers.add(new NeuralNetworkLayer(currentLayerID,currentLayerNeurons));
            }
        }

    }

    private void buildNeuralConnections(){
        if(hiddenLayers.size() == 0){
            for(int fromIndex = 0; fromIndex < inputLayer.getNeurons().size(); fromIndex++)
                for(int toIndex = 0; toIndex < outputLayer.getNeurons().size(); toIndex++){
                    Neuron fromNeuron = inputLayer.getNeurons().get(fromIndex);
                    Neuron toNeuron = outputLayer.getNeurons().get(toIndex);

                    NeuralConnection neuralConnection = new NeuralConnection(fromNeuron, toNeuron);

                    fromNeuron.addOutputConnection(neuralConnection);
                    toNeuron.addInputConnection(neuralConnection);
                }
        }else{
            //TODO: implement setting up of hidden layers
        }
    }
}
