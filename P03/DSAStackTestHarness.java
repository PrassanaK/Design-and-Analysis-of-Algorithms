import java.util.*;

public class DSAStackTestHarness
{
    public static void main(String [] args)
    {
        DSAStack testStack = new DSAStack(2);
        
        System.out.println("Testing isEmpty with unfilled stack");
        if(testStack.isEmpty()== true)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing isFull with unfilled stack");
        if(testStack.isFull() == false)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing push of two objects onto stack");
        try
        {
            testStack.push("1");
            testStack.push("2");
            System.out.println("PASSED");
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing top with 2 Objects in stack");
        if((testStack.top()).equals("2"))
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing isEmpty with filled stack");
        if(testStack.isEmpty() == false)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing isFull with filled stack");
        if(testStack.isFull() == true)
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }

        System.out.println("");

        System.out.println("Testing pop");
        String temp = (String)testStack.pop();
        if((temp.equals("2")) && (((testStack.getCount()) == 1)))
        {
            System.out.println("PASSED");
        }
        else
        {
            System.out.println("FAILED");
        }
 
    }
}
