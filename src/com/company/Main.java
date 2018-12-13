package com.company;

import com.company.neuralnetwork.NeuralNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*This is a Neural Network implementation for an Artificial Intelligence homework.
*Our neuralt network is learning the critical temperature of superconductors
*based on those material properties (81 for each).
 */

public class Main {

    /*
     * Input shape:
     * - 17011*81 training data
     * - 17011 labes (critical temperature)
     * - 4252*81 test data
     * SUM => 17011+17011+4252 = 38274 lines
     * */
    private static List<String[]> input = new ArrayList<>(38274);

    public static void main(String[] args) {

        Map<String, String> inputStructure = getInputStructure();

        try{
            NeuralNetwork neuralNetwork = new NeuralNetwork(inputStructure);
            Agent agent = new Agent(neuralNetwork,32,1,0.001);

            input = read();

            agent.processTrainingSet(input);

            agent.train(17.0);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    Reading the dataset from the standard input
    Every value separated by "\t"
     */
    public static List<String[]> read() throws IOException {
        String[] str = null;
        List<String[]> strInput = new ArrayList<>();

        try (InputStreamReader instream = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(instream)){
                String in;

                while ((in = buffer.readLine()) != null) {

                    str = in.split("\t");
                    strInput.add(str);

                }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return strInput;
    }

    //TODO:refactor it for being more flexible
    private static Map<String, String> getInputStructure(){
        String[] layerIDs = {"I","O"};
        String[] neuronCounts = {"81","1"};

        Map<String,String> struct = new HashMap<>();
        for(int i = 0; i < layerIDs.length; i++){
            struct.put(layerIDs[i],neuronCounts[i]);
        }
        return struct;
    }
}
