import java.util.*;
public class TestGraph
{
    public static void main(String [] args)
    {
        DSAGraph<String> graph = new DSAGraph<String>();
 
        System.out.println("Testing addVertex");
        try
        {
            graph.addVertex("A", "A");
            graph.addVertex("B", "B");
            graph.addVertex("C", "C");
            graph.addVertex("D", "D");
            graph.addVertex("E", "E");
            graph.addVertex("F", "F");
            System.out.println("PASS");
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }

        System.out.println("Testing addEdge");
        try
        {
            graph.addEdge(graph.getVertex("A"), graph.getVertex("B"));
            graph.addEdge(graph.getVertex("B"), graph.getVertex("C"));
            graph.addEdge(graph.getVertex("C"), graph.getVertex("D"));
            graph.addEdge(graph.getVertex("D"), graph.getVertex("E"));
            graph.addEdge(graph.getVertex("E"), graph.getVertex("F"));
            graph.addEdge(graph.getVertex("F"), graph.getVertex("A"));
            System.out.println("PASS");
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }

        System.out.println("Testing getVertexCount");
        if((graph.getVertexCount()) == 6)
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }

        System.out.println("Testing displayList");
        System.out.println("----------Expected AdjacencyList----------");
        System.out.println("A: BF");
        System.out.println("B: AC");
        System.out.println("C: BD");
        System.out.println("D: CE");
        System.out.println("E: DF");
        System.out.println("F: EA");
        System.out.println("----------Actual AdjacencyList------------");
        graph.displayList();
        System.out.println("------------------------------------------");
        System.out.println("");
        
        System.out.println("Testing displayMatrix");
        System.out.println("--------Expected Matrix-------------------");
        System.out.println("--A-B-C-D-E-F");
        System.out.println("A|0 1 0 0 0 1");
        System.out.println("B|1 0 1 0 0 0");
        System.out.println("C|0 1 0 1 0 0");
        System.out.println("D|0 0 1 0 1 0");
        System.out.println("E|0 0 0 1 0 1");
        System.out.println("F|1 0 0 0 1 0");
        System.out.println("--------Actual Matrix values--------------");
        graph.displayMatrix();
        System.out.println("------------------------------------------");
    }
}
