public class DSAGraph<E>
{
    private DSALinkedList<DSAGraphNode<E>> vertices;

    public DSAGraph()
    {
        vertices = new DSALinkedList<DSAGraphNode<E>>();
    }

    public void addVertex(String key, E value)
    {        
        DSAGraphNode<E> vertex = new DSAGraphNode<E>(key, value);
        vertices.insertLast(vertex);
    }

    public void addEdge(DSAGraphNode<E> vertex1, DSAGraphNode<E> vertex2)
    {
        for(DSAGraphNode<E> i : vertices)
        {
            if((vertex1.getLabel()).equals(i.getLabel()))
            {
                for(DSAGraphNode<E> j : vertices)
                {
                    if((vertex2.getLabel()).equals(j.getLabel()))
                    {
                        vertex1.addEdge(vertex2);
                        vertex2.addEdge(vertex1);
                    }
                }
            }
        }
    }

    public int getVertexCount()
    {
        return vertices.getCount();
    }

    public DSAGraphNode<E> getVertex(String key)
    {
        DSAGraphNode<E> value = null;

        for(DSAGraphNode<E> i : vertices)
        {
            if(key.equals(i.getLabel()))
            {
                value = i;
            }
        }
        return value;
    }

    public DSALinkedList<DSAGraphNode<E>> getAdjacent(DSAGraphNode<E> vertex) 
    {
        DSALinkedList<DSAGraphNode<E>> adjacentList = null;     

        for(DSAGraphNode<E> i : vertices)
        {
            if((vertex.getLabel()).equals(i.getLabel()))
            {
                 adjacentList = vertex.getAdjacent();
            }
        }
        return adjacentList;
    }

    public boolean isAdjacent(DSAGraphNode<E> vertex1, DSAGraphNode<E> vertex2)
    {
        boolean isAdjacent = false;    

        for(DSAGraphNode<E> i : vertices)
        {
            if((vertex1.getLabel()).equals(i.getLabel()))
            {
                for(DSAGraphNode<E> j : vertex1.getAdjacent())
                {
                    if((vertex2.getLabel()).equals(j.getLabel()))
                    {
                        isAdjacent = true;
                    }
                }
            }
        }
        return isAdjacent;
    }

    public void displayList()
    {
        String adjacencyList1;
        String adjacencyList2;
        for(DSAGraphNode<E> i : vertices)
        {
            System.out.print(i.getLabel() + ": ");
            for(DSAGraphNode<E> j : i.getAdjacent())
            {
                System.out.print(j.getLabel());
            }
            System.out.println("");
        }
    }

    public void displayMatrix()
    {
        System.out.print("--");
        for(DSAGraphNode<E> k : vertices)
        {
            System.out.print(k.getLabel() + "-");
        }
        System.out.println("");
        for(DSAGraphNode<E> i : vertices)
        {
            System.out.print(i.getLabel() + "|");
            for(DSAGraphNode<E> j : vertices)
            {
                if(isAdjacent(i, j))
                {
                    System.out.print("1 ");
                }
                else
                {
                    System.out.print("0 ");
                }
            }
            System.out.println("");
        }
    }

    public void depthFirstSearch(DSAGraphNode<E> startNode)
    {
        for(DSAGraphNode<E> i : vertices)
        {
            i.clearVisited();
        }

        DSAStackList<DSAGraphNode<E>> dfsStack = new DSAStackList<DSAGraphNode<E>>();
   
        dfsStack.push(startNode);

        while(dfsStack.isEmpty() == false)
        {
            startNode = dfsStack.top();
            dfsStack.pop();

            if(startNode.getVisited() == false)
            {
                System.out.print(startNode.getLabel() + " ");
                startNode.setVisited();
            }

            for(DSAGraphNode<E> j : startNode.getAdjacent())
            {
                if(j.getVisited() == false)
                {
                    dfsStack.push(j);
                }
            } 
        }         
    }

    public void breathFirstSearch(DSAGraphNode<E> startNode)
    {
       for(DSAGraphNode<E> i : vertices)
       {
           i.clearVisited();
       }

       DSAQueueList<DSAGraphNode<E>> bfsQueue = new DSAQueueList<DSAGraphNode<E>>();

       startNode.setVisited();
       bfsQueue.enqueue(startNode);

       while(bfsQueue.isEmpty() == false)
       {
           startNode = bfsQueue.dequeue();
           System.out.print(startNode.getLabel() + " ");
           
           for(DSAGraphNode<E> j : startNode.getAdjacent())
           {
               if(j.getVisited() == false)
               {
                   j.setVisited();
                   bfsQueue.enqueue(j);
               }
           }
        }
    }
    
    //PRIVATE INNERCLASS----------------------------------------------
    private class DSAGraphNode<E>
    {
        private String label;
        private E value;
        private DSALinkedList<DSAGraphNode<E>> links;
        private boolean visited;

        public DSAGraphNode(String inLabel, E inValue)
        {
            if (inValue == null)
            {
                throw new IllegalArgumentException("No value");
            }
            else
            {
                label = inLabel;
                value = inValue;
                links = new DSALinkedList<DSAGraphNode<E>>();
                visited = false;
            }

        }

        public String getLabel()
        {
            return label;
        }

        public E getValue()
        {
            return value;
        }

        public DSALinkedList<DSAGraphNode<E>> getAdjacent()
        {
            return links;
        }

        public void addEdge(DSAGraphNode<E> vertex)
        {
            int val = 0;
      
            for(DSAGraphNode<E> i : links)
            {
                if((i.getLabel()).equals(vertex.getLabel()))
                {
                    val = 1;
                }
            }
            
            if(val == 1)
            {
                //do nothing
            }
            else
            {
                links.insertLast(vertex);
            }
        }

        public void setVisited()
        {
            visited = true;
        }

        public void clearVisited()
        {
            visited = false;
        }

        public boolean getVisited()
        {
            return visited;
        }
    }
}
