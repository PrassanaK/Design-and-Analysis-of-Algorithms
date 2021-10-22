public class DSAStack
{
    //Class Constants
    public static final int DEFAULT_CAPACITY = 100;
    
    //Class Fields
    private Object [] stack;
    private int count;

    //Default Constructor
    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    //Alternate Constructor
    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
        count = 0;
    }

    //Accessors
    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        boolean empty;
        if (count == 0)
        {
            empty = true;
        }
        else
        {
            empty = false;
        }
        return empty;
    }

    public boolean isFull()
    {
        boolean full;
        if (count == stack.length)
        {
            full = true;
        }
        else
        {
            full = false;
        }
        return full;
    }

    public Object top()
    {
        Object topVal;
        if(isEmpty())
        {
            throw new IllegalArgumentException("Stack is empty");
        }
        else
        {
            topVal = stack[count - 1];
        }
        return topVal;
    }

    //Mutators
    public void push(Object inObj)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Stack is full");
        }
        else
        {
            stack[count] = inObj;
            count = count + 1;
        }
    }

    public Object pop()
    {
        Object topVal; 
        topVal = top();
        count = count - 1;
        return topVal;
    }
}

