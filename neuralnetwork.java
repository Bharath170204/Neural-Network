// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Scanner;

public class NeuralNetwork {
    private int numLayers;
    private int[] nodesInEachLayer;
    private double[][][] weights;

    public NeuralNetwork(int numLayers, int[] nodesInEachLayer) {
        this.numLayers = numLayers;
        this.nodesInEachLayer = nodesInEachLayer;
        this.weights = new double[numLayers - 1][][];
        for (int i = 0; i < numLayers - 1; i++) {
            this.weights[i] = new double[nodesInEachLayer[i]][nodesInEachLayer[i + 1]];
        }
    }

    public void setWeights() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numLayers - 1; i++) {
            System.out.println("Enter weights for layer " + (i + 1) + " to layer " + (i + 2) + ":");
            for (int j = 0; j < nodesInEachLayer[i]; j++) {
                for (int k = 0; k < nodesInEachLayer[i + 1]; k++) {
                    System.out.print("Weight from node " + (j + 1) + " to node " + (k + 1) + ": ");
                    weights[i][j][k] = input.nextDouble();
                }
            }
        }
    }

    public double getWeight(int fromNode, int toNode) {
    // Assuming nodes are 1-indexed
    return weights[fromNode - 1][toNode - 1][0]; // Return the weight between the specified nodes
}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of layers: ");
        int numLayers = input.nextInt();
        int[] nodesInEachLayer = new int[numLayers];
        System.out.println("Enter the number of nodes in each layer:");
        for (int i = 0; i < numLayers; i++) {
            nodesInEachLayer[i] = input.nextInt();
        }

        NeuralNetwork nn = new NeuralNetwork(numLayers, nodesInEachLayer);
        nn.setWeights();

        System.out.print("Enter the fromNode: ");
        int fromNode = input.nextInt();
        System.out.print("Enter the toNode: ");
        int toNode = input.nextInt();
        System.out.println("Weight from node " + fromNode + " to node " + toNode + " is: " + nn.getWeight(fromNode, toNode));
    }
}
