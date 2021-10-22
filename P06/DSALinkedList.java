import java.util.*;
public class DSALinkedList <E> implements Iterable <E>
{ 
    public Iterator <E> iterator()
    {
        return new DSALinkedIterator <E> (this);
    }
    
    //Class fields
    private DSAListNode <E> head;
    private DSAListNode <E> tail;
    private int count;
    
    public DSALinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }

    public void insertFirst(E newValue)
    {   
        DSAListNode <E> newNd = new DSAListNode <E> (newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
            count = 1;
        }
        else
        {
            head.setPrev(newNd);//Makes newNd prev pointer point to head
            newNd.setNext(head);//makes newNd next pointer point to what head points to
            head = newNd;//Makes head point to newNd
            count = count + 1;
        }
    }

    public void insertLast(E newValue) 
    {
        DSAListNode <E> newNd = new DSAListNode <E> (newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
            count = 1;
        }
        else
        {
            tail.setNext(newNd);
            newNd.setPrev(tail);
            tail = newNd;
            count = count + 1;
        }//Endif
    } 
 
    public boolean isEmpty()
    {
        boolean empty;
        if(head == null)
        {
            empty = true;
        }
        else
        {
            empty = false;
        }
        return empty;
    }
 
    public E peekFirst()
    {
        E nodeValue;
        if (isEmpty())
        {
            throw new NoSuchElementException("node is empty");
        }
        else 
        {
            nodeValue = head.getValue();
        }
        return nodeValue;
    }
  
    public E peekLast()
    {
        E nodeValue;
        if (isEmpty())
        {
            throw new NoSuchElementException("Empty"); 
        }
        else
        {
            nodeValue = tail.getValue();  
        }
        return nodeValue;
    } 
 
    public E removeFirst()
    {
        E nodeValue;
        if (isEmpty())
        {
            throw new NoSuchElementException("empty");
        }
        else if(head == tail)
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
            count = count - 1;
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
            head.setPrev(null);
            count = count - 1;
        }
 
        return nodeValue;
    }

    public E removeLast() 
    {
        E nodeValue = null;
        if (isEmpty())
        {
            throw new NoSuchElementException("Empty");
        }
        else if(head.getNext() == null)
        {
            nodeValue = tail.getValue();
            head = null;
            tail = null;
            count = count - 1;
        }
        else
        {
            nodeValue = tail.getValue();
            tail = tail.getPrev();
            tail.setNext(null);
            count = count - 1;
        }
        return nodeValue;
    }

    public int getCount()
    {
        return count;
    }
//---PRIVATE INNER CLASS DSALinkedListIterator-----------------------------------//
    private class DSALinkedIterator<E> implements Iterator<E>
    {
        private DSALinkedList<E>.DSAListNode<E> iterNext;    

        public DSALinkedIterator(DSALinkedList<E> theList)
        {
            iterNext = theList.head;
        } 
 
        public boolean hasNext()
        {
            return (iterNext != null);
        }
      
        public E next()
        {
            E value;
            if (iterNext == null)
            {
                value = null; 
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("unsupported");
        }
    }
//---PRIVATE INNER CLASS DSAListNode---------------------------------------------//
    public class DSAListNode <E>
    {
        //Class fields
        private E value;
        private DSAListNode <E> next;
        private DSAListNode <E> prev;

        public DSAListNode (E inValue)
        {
            value = inValue;
            next = null;
            prev = null;
        }
  
        public E getValue()
        {
            return value;
        }

        public void setValue(E inValue)
        {
            value = inValue;
        }
 
        public DSAListNode<E> getNext()
        {
            return next;
        }
  
        public DSAListNode<E> getPrev()
        {
            return prev;
        }

        public void setNext(DSAListNode<E> newNode)
        {
            next = newNode;
        }

        public void setPrev(DSAListNode<E> newNode)
        {
            prev = newNode;
        }
    } 
}
