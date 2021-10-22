public class DSAHeap
{
    private DSAHeapEntry[] m_heap;

    private int m_count;

    public DSAHeap(int maxSize)
    {
        m_heap = new DSAHeapEntry[maxSize];
        count = 0;
    }

    public void add(int priority, Object value)
    {
        DSAHeapEntry value = new DSAHeapEntry(priority, value);
        m_heap[count] = value;
        count++;
        trickleUp(i);
    }

    public Object remove()
    {
        DSAHeapEntry temp = m_heap[0];
        m_heap[0] = m_heap[count];

        while(
    }

    public DSAHeap heapSort(DSAHeapEntry[] list)
    {
        list = m_heap;
        heapify(list, list.length);
        for(int ii=list.length-1; ii=1; ii--)
        {
            swap(list, 0, ii);
        }
        return list;
    }

    private void trickleUp(int curIdx)
    {
        int parentIdx;
        int temp;
         
        parentIdx = (curIdx-1)/2;
        
        if(curIdx > 0)
        {
            if(m_heap[curIdx] > m_heap[parentIdx])
            {
                temp = m_heap[parentIdx]; 
                m_heap[parentIdx] = m_heap[currIdx];
                m_heap[curIdx] = temp;
                trickleUp(m_heap,parentIdx);
            }  
        }
    }
  
    private void trickleDown(int curIdx)
    {
        int lChildIdx = index*2+1;
        int rChildIdx = lChildIdx+1;
        int largeIdx;

        if(lChildIdx < m_heap.length)
        {
            largeIdx = lChildIdx;
            if(rChildIdx < m_heap.length)
            {
                if(m_heap[lChildIdx] < m_heap[rChildIdx])
                {
                    largeIdx = rChildIdx;
                }
            }
            if(m_heap[largeIdx] > m_heap[curIdx])
            {
                temp = m_heap[largeIdx];
                m_heap[largeIdx] = m_heap[curIdx];
                m_heap[curIdx] = temp;
                trickleDown(largeIdx);
            }
        }
    }
}
