/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
       int pass, temp;
       boolean sorted;
       
       pass = 0;
       do
       {
           sorted = true;
           for (int ii = 0; ii <= (A.length-1-pass)-1; ii++) 
           {
               if (A[ii] > A[ii+1])
               {
                   temp = A[ii];
                   A[ii] = A[ii+1];
                   A[ii+1] = temp;
                   sorted = false;
               }
           }
           pass = pass +1;
       } while (sorted == false);

    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int minIdx;

        for (int nn = 0; nn <= A.length-1; nn++)
        {
            minIdx = nn;
            for (int jj = (nn+1); jj <= A.length-1; jj++)
            {
                if (A[jj] < A[minIdx])
                {
                    minIdx = jj;        
                }
            }

            int temp = A[minIdx];
            A[minIdx] = A[nn];
            A[nn] = temp;
        }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int ii;
        int temp;
        for (int nn = 1; nn <= A.length-1; nn++)
        {
            ii = nn;

            temp = A[ii];
            while ((ii > 0)&&(A[ii-1] > temp))
            {
                A[ii] = A[ii - 1];
                ii = ii-1;
            }
            A[ii] = temp;
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
            mergeSortRecurse(A, 0, A.length-1);
    }//mergeSort()
    
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int midIdx;
        if (leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx)/2;

            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx+1, rightIdx);
                                          
            merge(A, leftIdx, midIdx, rightIdx);
        }
    }//mergeSortRecurse()
    
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int[] tempArr = new int[rightIdx - leftIdx + 1];
        int ii = leftIdx;
        int jj = midIdx + 1;
        int kk = 0;

        while ((ii <= midIdx)&&(jj <= rightIdx))
        {
            if(A[ii] <= A[jj])
            {
                tempArr[kk] = A[ii];
                ii = ii + 1;
            }
            else
            {
                tempArr[kk] = A[jj];
                jj = jj + 1;
            }
            kk = kk + 1;
        }

        for (ii = ii; ii <= midIdx; ii++)
        {
            tempArr[kk] = A[ii];
            kk = kk + 1;
        }
        
        for (jj = jj; jj <= rightIdx; jj++)
        {
            tempArr[kk] = A[jj];
            kk = kk + 1;
        }

        for (kk = leftIdx; kk <= rightIdx; kk++)
        {
            A[kk] = tempArr[kk - leftIdx];
        }
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
            quickSortRecurse(A, 0, A.length-1);
        
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx;
        int newPivotIdx;
        if (rightIdx > leftIdx)
        {
            pivotIdx = (leftIdx + rightIdx)/2;
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
            
            quickSortRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRecurse(A, newPivotIdx + 1, rightIdx);
        }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {        
        int pivotVal = A[pivotIdx];
        int currIdx;
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;

        currIdx = leftIdx;

        for (int ii = leftIdx; ii<= rightIdx-1; ii++)
        {
            if (A[ii] < pivotVal)
            {
                int temp = A[ii];
                A[ii] = A[currIdx];
                A[currIdx] = temp;
                currIdx = currIdx + 1;
            }
        }

        int newPivotIdx = currIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;
		return newPivotIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
