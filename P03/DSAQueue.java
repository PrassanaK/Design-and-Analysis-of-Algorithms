public class DSAQueue
{
    //Class Constants
    private static final int DEFAULT_CAPACITY = 100;
    
    //Class Fields
    private Object [] queue;
    private int count;

    //Default Constructor
    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    //Alternate Constructor
    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
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
        if (count == queue.length)
        {
            full = true;
        }
        else
        {
            full = false;
        }
        return full;
    }

    public Object peek()
    {
        Object frontVal;
        if(isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty");
        }
        else
        {
            frontVal = queue[0];
        }
        return frontVal;
    }

    //Mutators
    public void enqueue(Object inObj)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Queue is full");
        }
        else
        {
            queue[count] = inObj;
            count = count + 1;
        }
    }

    public Object dequeue()
    {
        Object frontVal;
        frontVal = peek();
        count--;
	for (int ii = 0; ii < count; ii++)
        {
            queue[ii] = queue[ii + 1];
        }
        return frontVal;
    }
}

