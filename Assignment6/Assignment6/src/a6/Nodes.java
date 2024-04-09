/*
Nicholas Krzysiak
04/08/2024
Assignment 6

This program generates nodes and 3d nodes, the user can select from 7 choices
for what they want to do with the nodes. These include...

Fill
Clear
Count Nodes
Count ThreeDNodes
Sort
Display
Exit

 */


package a6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import static a6.NodeFactory.getNode;
import static a6.NodeFactory.getThreeDNode;

public class Nodes {

    private ArrayList<INode> nodeList;


    //Default
    public Nodes() throws Exception {
        this.nodeList = new ArrayList<>();

    }


    /**
     * fill method
     *
     * @param size amount of nodes to create
     * @throws Exception
     */
    public void fill(int size) throws Exception {
        Random rng = new Random();

        //rng generates num 1 or 0 which randomly selects Node type
        int random = 0;
        for (int i = 0; i < size; i++) {
            random = rng.nextInt(2);
            if (random == 1)
                nodeList.add(getThreeDNode());
            if (random == 0) {
                nodeList.add(getNode());


            }

        }
    }


//counts # of nodes
    public int countNodes(){
        int nodeCount = 0;
        int threeDNodeCount = 0;
        for (INode node : nodeList){
            if (node instanceof Node){
                nodeCount ++;
            } if (node instanceof ThreeDNode){
                threeDNodeCount++;
            }
        }
    return nodeCount - threeDNodeCount;


    }




    //counts # of 3d nodes
    public int countThreeDNodes(){
        int nodeCount = 0;
        for (INode node : nodeList){
            if (node instanceof ThreeDNode){
                nodeCount ++;
            }
        }
        return nodeCount;

    }




//sorts arrays by their sums
    public void sort() {
        Collections.sort(nodeList, new Sorter());
    }


    //converts to string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (INode node : nodeList) {
            sb.append(node.toString());
            sb.append(System.lineSeparator()); // Adds a new line after each node
        }
        return sb.toString();
    }




//clears array list
    public void clear() {
        nodeList.clear();
    }




}


//sorts array list
class Sorter implements Comparator<INode> {
    @Override
    public int compare(INode node1, INode node2) {
        double sum1 = getSum(node1);
        double sum2 = getSum(node2);

        return Double.compare(sum1, sum2);
    }

    private double getSum(INode node) {
        double sum = 0;
        if (node instanceof Node) {
            Node n = (Node) node;
            sum = n.getX() + n.getY();
            if (node instanceof ThreeDNode) {
                ThreeDNode tn = (ThreeDNode) node;
                sum += tn.getZ();
            }
        }
        return sum;
    }
}
