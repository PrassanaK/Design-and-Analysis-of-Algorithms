public class DSAHeapEntry
{
    private int priority;
    private Object value;
  
    public DSAHeapEntry(int inPriority, Object inValue)
    {
        priority = inPriority;
        value = inValue;
    }

    public int getPriority()
    {
        return priority;
    }

    public Object getValue()
    {
        return value;
    }
}
