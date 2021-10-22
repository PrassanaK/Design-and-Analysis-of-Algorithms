import java.util.*;
public class DSABinarySearchTree<E>
{ 
//---PRIVATE-INNER-CLASS-------------------------------------------------   
    private class DSATreeNode<E>
    {
        private String key;
        private E value;
        private DSATreeNode<E> leftChild;
        private DSATreeNode<E> rightChild;

        public DSATreeNode(String inKey, E inVal)
        {
            if(inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            else
            {
                key = inKey;
                value = inVal;
                rightChild = null;
                leftChild = null;
            }
        }
 
        public String getKey()
        {
            return key;
        }

        public E getValue()
        {
            return value;
        }
  
        public DSATreeNode<E> getLeft()
        {
            return leftChild;
        }
  
        public void setLeft(DSATreeNode<E> newLeft)
        {
            leftChild = newLeft;
        }
 
        public DSATreeNode<E> getRight()
        {
            return rightChild;
        }
 
        public void setRight(DSATreeNode<E> newRight)
        {
            rightChild = newRight;
        }
    }
//---PRIVATE-INNER-CLASS-------------------------------------------------

    private DSATreeNode<E> root;

    public DSABinarySearchTree()
    {
        root = null;
    }

    public E find(String key)
    {
        return findRecursive(key, root);
    }

    private E findRecursive(String key, DSATreeNode<E> currNode)                
    {                                                                             
        E val = null;                                                        
                                                                                  
        if (currNode == null)                                                     
        {
            throw new NoSuchElementException("Key: " + key + " not found");
        }
        else if (key.equals(currNode.getKey()))
        {
            val = currNode.getValue();
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {
            val = findRecursive(key, currNode.getLeft());
        }
        else
        {
            val = findRecursive(key, currNode.getRight());
        }
        return val;
    }

    public void insert(String key, E value)
    {
        root = insertRecursive(key, value, root); 
    }

    public DSATreeNode<E> insertRecursive(String key, E data, DSATreeNode<E> currNode)
    {
        DSATreeNode<E> updateNode = null;
 
        updateNode = currNode;
        if (currNode == null)
        {
            DSATreeNode<E> newNode = new DSATreeNode<E>(key, data);
            updateNode = newNode;
        }
        else if(key.equals(currNode.getKey()))
        {
            throw new IllegalArgumentException("Node is filled");
        }
        else if(key.compareTo(currNode.getKey())<0)
        {
            currNode.setLeft(insertRecursive(key, data, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(insertRecursive(key, data, currNode.getRight()));
        }
        return updateNode;
    }

    public void delete(String key)
    {
        deleteRecursive(key, root);
    }
    
    public DSATreeNode<E> deleteRecursive(String key, DSATreeNode<E> currNode)
    {
        DSATreeNode<E> updateNode = null;
         
        updateNode = currNode;
        if (currNode == null)
        {
            throw new IllegalArgumentException("No node to delete");
        }
        else if(key.equals(currNode.getKey()))
        {
            updateNode = delNode(key, currNode);
        }
        else if(key.compareTo(currNode.getKey())<0)
        {
            currNode.setLeft(deleteRecursive(key, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(deleteRecursive(key, currNode.getRight()));
        }
        return updateNode;
    }

    public DSATreeNode<E> delNode(String key, DSATreeNode<E> delNode)
    {
        DSATreeNode<E> updateNode = null;
        if ((delNode.getLeft() == null)&&(delNode.getRight() == null))
        {
            updateNode = null;
        }
        else if ((delNode.getLeft() != null) && (delNode.getRight() == null))
        {
            updateNode = delNode.getLeft();
        }
        else if ((delNode.getLeft() == null) && (delNode.getRight() != null))
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            if (!updateNode.equals(delNode.getRight()))
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }

    public DSATreeNode<E> promoteSuccessor(DSATreeNode<E> currNode) 
    {
        DSATreeNode<E> successor = null;
        
        successor = currNode; 
        if (currNode.getLeft() == null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if (successor == currNode.getLeft())
            {
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
    }

    public int height()
    {
       return heightRecursive(root);
    }

    public int heightRecursive(DSATreeNode<E> currNode)
    {
        int htSoFar, iLeftHt, iRightHt;
        if (currNode == null)
        {
             htSoFar = -1; 
        }
        else
        {
            iLeftHt = heightRecursive(currNode.getLeft()); 
            iRightHt = heightRecursive(currNode.getRight()); 

            if (iLeftHt > iRightHt)
            {
                htSoFar = iLeftHt + 1;
            }
            else 
            {
                htSoFar = iRightHt + 1;
            }
        }
        return htSoFar;
    }   

    public DSAQueueList<E> traverseStart()
    {
        DSAQueueList<E> queue = new DSAQueueList<E>();
        Scanner sc = new Scanner(System.in);
        //char traverseOption = sc.nextLine().charAt(0);       
        System.out.println("1: inOrder 2: postOrder 3: preOrder e: Exit");
        char traverseOption = sc.nextLine().charAt(0); 

        switch (traverseOption)
        {
            case '1':
                queue = inOrder(queue, root);
                break;
            case '2':
                queue = postOrder(queue, root);
                break;
            case '3':
                queue = preOrder(queue, root);
                break;
            case 'e':
                System.out.println("");
                break;
            default:
                System.out.println("Invalid option");
        }
        return queue;
    }

    private DSAQueueList<E> inOrder(DSAQueueList<E> queue, DSATreeNode<E> currNode)
    {
        //DSAQueueArray<E> queue = new DSAQueueArray<E>();
        if(currNode != null) 
        {
            inOrder(queue, currNode.getLeft());
            queue.enqueue(currNode.getValue());
            inOrder(queue, currNode.getRight());
        }
        return queue;
    }

    private DSAQueueList<E> postOrder(DSAQueueList<E> queue, DSATreeNode<E> currNode)
    {
        //DSAQueueArray<E> queue = new DSAQueueArray<E>();
        if (currNode != null)
        { 
            postOrder(queue, currNode.getLeft());
            postOrder(queue, currNode.getRight());
            queue.enqueue(currNode.getValue());
        }
        return queue;
    }

    private DSAQueueList<E> preOrder(DSAQueueList<E> queue, DSATreeNode<E> currNode)
    {
        //DSAQueueArray<E> queue = new DSAQueueArray<E>();
        if(currNode != null)
        {
           queue.enqueue(currNode.getValue());
           preOrder(queue, currNode.getLeft());
           preOrder(queue, currNode.getRight());
        }
        return queue;
    }

    public String toCSV()
    {
        return toCSVRecursive(root);
    }

    private String toCSVRecursive(DSATreeNode<E> curr)
    {
        String str = "";
        if (curr != null)
        {
            str += curr.key + "," + curr.value.toString() + "\n";
            toCSVRecursive(curr.leftChild);
            toCSVRecursive(curr.rightChild);
        }
        return str;
    }

    
}//END CLASS    
