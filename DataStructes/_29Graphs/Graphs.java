package _29Graphs;

// Vertice/Vertex = Node
// Edge = Line
// Unweighted graph = Herhangi bir kenarla ilişkili ağırlığı olmayan bir graph, yani edge üzerinde yazan bir sayı yok
// Undirected graph = edge üzerinde yön olmayan graphlardır, yön olmayanlarda iki yöne de hareket edilebilir
// Directed graph = edge üzerinde yön belirten işaretleri olan
// Cyclic graph = en az bir loop'a sahip olan graph, yani bir graphtan çıkıp tekrar gelebiliyorsak Cyclic Graph oluyor
// Acyclic graph = loop'a sahip olmayan graph 
// Tree = özel bir graph şeklidir aynı tree'ler gibi gözükür ve yönlüdür 

// Adjacency matrix = graphs'ın gösterim şekillerinden birisidir
//  A   B   C   D 
//A 0   1   1   0 
//B 0   0   1   1 

// Adjacency List = graphs'ın gösterim şekillerinden birisidir
//A-> B D
//B-> A C D
//C->


// A forest is an undirected graph without cycles
// The connected components of a forest are trees

// Dijkstra Algorithm:

import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;


public class Graphs {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPath(graph, nodeA);

    }
    
    
}



class Graph {
    private Set<Node> nodes;

    public Graph(){
        nodes = new HashSet<>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}


class Dijkstra {

    public static Graph calculateShortestPath(
            Graph graph,
            Node source) {

        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(Comparator.comparingInt(t -> t.getDistance()));
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            for (Entry<Node, Integer> e : currentNode.getAdjVertices().entrySet()) {
                Node adjNode = e.getKey();
                int distance = e.getValue();

                if (!settledNodes.contains(adjNode)) {
                    calculateMinimumDistance(currentNode, adjNode, distance);
                    unsettledNodes.add(adjNode);
                }
            }
            settledNodes.add(currentNode);
        }

        return graph;
    }

    public static void calculateMinimumDistance(
            Node sourceNode,
            Node destinationNode,
            int distance) {

        int sourceDistance = sourceNode.getDistance();
        if ((sourceDistance + distance) < destinationNode.getDistance()) {
            destinationNode.setDistance(sourceDistance + distance);

            // Homework: implement shortest path
            LinkedList<Node> shortest = new LinkedList<>(sourceNode.getShortestPath());
            shortest.add(sourceNode);
            destinationNode.setShortestPath(shortest);
        }
    }
}



class Node{

    private String name;
    private int distance;
    private LinkedList<Node> shortestPath;
    private Map<Node, Integer> adjVertices;


    public Node(String name){
        this.name = name;
        distance = Integer.MAX_VALUE;
        shortestPath = new LinkedList<>();
        adjVertices = new HashMap<>();
    }
    
    public void addDestination(Node node, int distance){
        adjVertices.put(node, distance);
    }
   

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }
    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
    public Map<Node, Integer> getAdjVertices() {
        return adjVertices;
    }
    public void setAdjVertices(Map<Node, Integer> adjVertices) {
        this.adjVertices = adjVertices;
    }
}
