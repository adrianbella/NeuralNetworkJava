package com.company.neuralnetwork.functions;

/***
 * Represent's the output activation function of a Neuron
 */

public interface ActivationFunction {

    /***
     *
     * @param summedInput summed input of the neuron
     * @return the output of the neuron
     */
    double calcualteOutput(double summedInput);

    /***
     *
     * @param summedInput summed input of the neuron
     * @return the derivates of the neurons output
     */
    double getDerivative(double summedInput);
}
