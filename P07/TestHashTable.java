import java.util.*;
public class TestHashTable
{
    public static void main(String [] args)
    {
        DSAHashTable testHashTable = new DSAHashTable();

        System.out.println("Testing put");
        //try
        //{
            testHashTable.put("1","1");
            testHashTable.put("2","2");          
            testHashTable.put("3","3");
            testHashTable.put("4","4");
            testHashTable.put("5","5");
            testHashTable.put("6","6");
            testHashTable.put("7","7");
            testHashTable.put("8","8");
            System.out.println("PASS");
        //}
        //catch(Exception e)
        //{
            System.out.println("FAILED");
        //}

        System.out.println("Testing get");
        if((testHashTable.get("1")).equals("1"))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }
    }

    
}
