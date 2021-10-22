public class DSAHashTable
{
    private DSAHashEntry[] m_hashTable;
    private int count;
    private static int defaultSize = 11;

    public DSAHashTable()
    {
        m_hashTable = new DSAHashEntry[defaultSize];
        for(int ii=0; ii<defaultSize-1; ii++)
        {
            DSAHashEntry hashEntry = new DSAHashEntry();
            m_hashTable[ii]= null;
        }
        count = 0;
    }

    public DSAHashTable(int maxSize)
    {
        m_hashTable = new DSAHashEntry[maxSize];
        for(int ii=0; ii<maxSize-1; ii++)
        {
            DSAHashEntry hashEntry = new DSAHashEntry();
            m_hashTable[ii]= null;
        }
        count = 0;
    }

    public void put(String key, Object value)
    {
        int hashIdx = hash(key);
        int arrayIdx = hashIdx%(m_hashTable.length);

        DSAHashEntry entry = new DSAHashEntry(key, value);
        put(entry);
        count++;
    }
  
    public void put(DSAHashEntry entry)
    {
        int loadFactor;

        int hashIdx = hash(entry.getKey());
        int arrayIdx = hashIdx%(m_hashTable.length);
        m_hashTable[hashIdx] = entry;
        count++;

        loadFactor = (count)/(m_hashTable.length);

        if(loadFactor > 0.75)
        {
            reSize((m_hashTable.length)*2);
        }
        else if(loadFactor < 0.25)
        {
            reSize((m_hashTable.length)/2);
        }
    }

    public Object get(String key)
    {
        int hashIdx = hash(key);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while((!found)&&(!giveUp));
        {
            if((m_hashTable[hashIdx].getState() == 0))
            {
                giveUp = true;
            }
            else if((m_hashTable[hashIdx].getKey()).equals(key))
            {
                found = true;
            }
            else
            {
                hashIdx = (hashIdx+1)%(m_hashTable.length);
                if(hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }
  
        if (!found)
        {
            throw new IllegalArgumentException("");
        }

        Object retValue = m_hashTable[hashIdx].getValue();

        return retValue;
    }

    public Object remove(String key)
    {
        int removeIdx;

        if(key==null)
        {
            throw new IllegalArgumentException("Null keys not allowed in hashTables");
        }
        else
        {
            removeIdx = hash(key);
            m_hashTable[removeIdx].setState(-1);
            count--;
        }
        return m_hashTable[removeIdx].getValue();
    }

    public boolean containsKey(String key)
    { 
        boolean contains = false;
        int hashIdx = hash(key);
        int arrayIdx = hashIdx%(m_hashTable.length);
        for(int ii=0; ii<m_hashTable.length; ii++)
        {
            if(((hashIdx == (hash(m_hashTable[ii].getKey())))&&(key.equals(m_hashTable[ii].getKey()))))
            {
                contains = true;
            }
        }
        return contains;
    }
   
    private void reSize(int size)
    {
        //DSAHashTable tempHashTable = m_hashTable;

        DSAHashTable newHashTable = new DSAHashTable(size);

        for(int ii=0; ii<m_hashTable.length; ii++)
        {
            if((m_hashTable[ii] != null) && (m_hashTable[ii].getState() == 1))
            {
                newHashTable.put(m_hashTable[ii]);
            }
        }
    }

    public int findNextPrime(int startVal)
    {
        int primeVal;
        boolean isPrime;
        int ii;
        if(startVal % 2 == 0)
        {
            primeVal = startVal + 1;
        }
        else
        {
            primeVal = startVal;
        }

        primeVal = primeVal - 2;

        isPrime = false;
        while(!isPrime)
        {
            primeVal = primeVal + 2;
            ii = 3;
            isPrime = true;
            while((ii*ii <= primeVal) && (isPrime))
            {
                if(primeVal % ii == 0)
                {
                    isPrime = false;
                }
                else
                {
                    ii = ii+2;
                }
            }
        }
        return primeVal;
    }

    private int hash(String key)
    {
        int hashIdx = 0;
  
        for(int ii=0; ii<key.length(); ii++)
        {
            hashIdx = (31*hashIdx) + (key.charAt(ii));
        }
        return (hashIdx%m_hashTable.length);
    }
}
