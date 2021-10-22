import java.util.*;

public class TowersOfHanoi
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of disks: ");
        int n = sc.nextInt(); 
        
        System.out.println("Enter source peg: ");
        int src = sc.nextInt();
         
        System.out.println("Enter destination peg: ");
        int dest = sc.nextInt();
        
        towers(n, src, dest);
    }

    public static void towers(int n, int src, int dest)
    {
        int tmp;
 
        if (n == 1)
        {
            moveDisk(src, dest);
        }
        else
        {
            tmp = 6 - src - dest;
            towers(n-1, src, tmp);

            moveDisk(src, dest);
            towers(n-1, tmp, dest);
        }
    }

    public static void moveDisk(int src, int dest)
    {
        System.out.println("Moving top disk from peg " + src + " to peg " + dest);
    }
    
}
