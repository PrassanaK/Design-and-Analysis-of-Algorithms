public class DSAQueueList<E>
{
    //Class Constants
    //private static final int DEFAULT_CAPACITY = 100;
    
    //Class Fields
    private DSALinkedList<E> queue;
    private int count;

    //Default Constructor
    public DSAQueueList()
    {
        queue = new DSALinkedList<E>();
        count = 0;
    }

    //Alternate Constructor
    //public DSAQueue(int maxCapacity)
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
        return queue.isEmpty();
    }

    //public boolean isFull()
    //{
    //    boolean full;
    //    if (count == queue.length)
    //    {
    //        full = true;
    //    }
    //    else
    //    {
    //        full = false;
    //    }
    //    return full;
    //}

    public E peek()
    {
        return queue.peekFirst();
    }

    //Mutators
    public void enqueue(E inObj)
    {
        queue.insertLast(inObj);
        count++;
    }

    

    public E dequeue()
    {
        count--;
        return queue.removeLast();
    }

    //public String toString()
    //{
    //    queue.toString();        
    //}
}

