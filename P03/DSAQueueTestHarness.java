import java.util.*;

public class DSAQueueTestHarness
{
    public static void main(String [] args)
    {
        DSAQueue testQueue = new DSAQueue(2);
        
        System.out.println("Testing isEmpty with unfilled queue");
        if(testQueue.isEmpty()== true)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing isFull with unfilled queue");
        if(testQueue.isFull() == false)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing enqueue of two objects onto queue");
        try
        {
            testQueue.enqueue("1");
            testQueue.enqueue("2");
            System.out.println("PASSED");
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing peek with 2 Objects in queue");
        if((testQueue.peek()).equals("1"))
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing isEmpty with filled queue");
        if(testQueue.isEmpty() == false)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing isFull with filled queue");
        if(testQueue.isFull() == true)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing dequeue");
        String temp = (String)testQueue.dequeue();
        if((temp.equals("1")) &&(((testQueue.getCount()) == 1)))
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }
 
    }
}
