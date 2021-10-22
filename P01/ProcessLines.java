import java.util.*;
public class ProcessLines
{
    public static void process(String [] lineArray)
    {
        String [] strArray1 = new String[0]; 
        String [] strArray2 = new String[0];
        String [] tempArr;
        for(int ii = 0; ii <= lineArray.length; ii++)
        {
            strArray1 = lineArray[ii].split(":");
            tempArr = new String[strArray1.length-1];
            
            for(int jj = 1; jj < strArray1.length; jj++)
            {
                int kk = 0;
                strArray2 = strArray1[jj].split("=");
                tempArr[kk] = strArray2[1];
                kk = kk + 1;
            }
 
            if(strArray1[0].equals("Country"))
            {
                int area = Integer.parseInt(tempArr[2]);
                int population = Integer.parseInt(tempArr[3]);
                Country newCountry = new Country(tempArr[0], tempArr[1], area, population, tempArr[4], tempArr[5]);
            }
            else if(strArray1[0].equals("State"))
            {
                int area = Integer.parseInt(tempArr[3]);
                int population = Integer.parseInt(tempArr[5]);
                State newState = new State(tempArr[0], tempArr[2], area, population, tempArr[6], tempArr[1], tempArr[4]);
            }
            else
            {
                Location newLocation = new Location(tempArr[0], tempArr[1], tempArr[2], tempArr[3], tempArr[4]);
            }
        }
    }
}

