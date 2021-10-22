import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        DSAGraph<String> graph = new DSAGraph<String>();
        String [] nodeArray = new String[15];
        nodeArray = FileIO.readFile("prac6.csv");
   
        for(int i = 0; i < nodeArray.length; i++)
        {
            String [] nodeElements = nodeArray[i].split(",");
            graph.addVertex(nodeElements[0], nodeElements[1]);
        }

        String [] nodeEdges = new String[25];
        nodeEdges = FileIO.readFile("prac6Edges.csv");
        for(int j = 0; j < nodeEdges.length; j++)
        {
            String [] nodeLabels = nodeEdges[j].split(",");
            graph.addEdge(graph.getVertex(nodeLabels[0]), graph.getVertex(nodeLabels[1]));
        }

        System.out.println("Adjacency List-----------------------");
        graph.displayList();
        System.out.println("");
        System.out.println("Adjacency Matrix-----------------------");
        graph.displayMatrix();

        System.out.println("");
        System.out.println("Depth First Search---------------------");
        graph.depthFirstSearch(graph.getVertex("A"));
        System.out.println("");

        System.out.println("");
        System.out.println("Breath First Search"); 
        graph.breathFirstSearch(graph.getVertex("A"));
        System.out.println("");
    }
}
