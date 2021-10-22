public class TestTree
{
	public static void main(String [] args)
	{
	    DSABinarySearchTree<String> tree = new DSABinarySearchTree<String>();

	    System.out.print("Inserting 5 nodes: ");
	  	try
	  	{
                    tree.insert("1", "1");
		    tree.insert("2", "2");
		    tree.insert("3", "3");
		    tree.insert("4", "4");
		    tree.insert("5", "5");
		    System.out.println("PASSED");
	  	}
	  	catch (Exception e)
	  	{
	  		System.out.println("FAILED");
	  	}
	    
	    System.out.print("Finding a node: ");
	  	try
	  	{
	  		tree.find("3");
		    System.out.println("PASSED");
	  	}
	  	catch (Exception e)
	  	{
	  		System.out.println("FAILED");
	  	}

	  	System.out.print("Deleting node: ");
	  	try
	  	{
	  		tree.delete("4");
	  		System.out.println("PASSED");
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("FAILED");
	  	}

            System.out.print("Getting Height: ");
                if(tree.height() == 3)
                {	
                    System.out.println("PASSED");
                }
                else
                {
                    System.out.println("FAILED");
                }
        }
}
