public class DSAStackArray<E>
{
    //Class Constants
    //public static final int DEFAULT_CAPACITY = 100;
    
    //Class Fields
    private DSALinkedList<E> stack;
    private int count;

    //Default Constructor
    public DSAStackArray()
    {
        stack = new DSALinkedList<E>();
        count = 0;
    }

    //Alternate Constructor
    //public DSAStack(int maxCapacity)
    //{
    //    count = 0;
    //}

    //Accessors
    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    //public boolean isFull()
    //{
    //    boolean full;
    //    if (count == stack.length)
    //    {
    //        full = true;
    //    }
    //    else
    //    {
    //        full = false;
    //    }
    //    return full;
    //}

    public E top()
    {
        return stack.peekFirst();
    }

    //Mutators
    public void push(E inObj)
    {
        stack.insertFirst(inObj);
    }

    public E pop()
    {
        return stack.removeFirst();
        
    }
}

