import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        DSABinarySearchTree<String> tree = new DSABinarySearchTree<String>();
        DSAQueueList<String> queue = new DSAQueueList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Press: ");
        System.out.println("1: readCSV");
        System.out.println("2: Display tree");
        System.out.println("3: writeCSV");
        System.out.println("4: Exit");
        String lineArray[] = new String[100];
        int option = sc.nextInt();

        while(option != 4)
        {
            //option = sc.nextInt();
            sc.nextLine();
            switch(option)
            {
                case 1:
                    System.out.println("Enter filename");
                    String filename = sc.nextLine();
                    lineArray = FileIO.readFile(filename);
                    for(int j=0; j<lineArray.length; j++)
                    {
                        System.out.println(lineArray[j]);
                    }
                    for(int i=0; i<lineArray.length; i++)
                    {
                        String treeArray [] = lineArray[i].split(",");
                        tree.insert(treeArray[0], treeArray[1]);
                    }
                    break;
                case 2:
                    queue = tree.traverseStart();
                    for(int I
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
            System.out.println("");
            System.out.println("Press: ");
            System.out.println("1: readCSV");
            System.out.println("2: Display tree");
            System.out.println("3: writeCSV");
            System.out.println("4: exit");
            option = sc.nextInt();
        }
    }
}
