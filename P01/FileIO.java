import java.util.*;
import java.io.*;
public class FileIO
{
    public static String[] readFile(String inFilename)
    {
         InputStreamReader rdr = null;
         BufferedReader bufRdr = null;
         FileInputStream fileStrm = null;
         String lineArray[] = new String[0];
         int numLines = 0;

         try
         {
            fileStrm = new FileInputStream(inFilename);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            String line;

            line = bufRdr.readLine();
            while (line != null)
            {
                numLines = numLines + 1;
                line = bufRdr.readLine();
            }
 
            lineArray = new String[numLines];
     
            for(int ii=0; ii<=(lineArray.length-1); ii++)
            {
                lineArray[ii]=bufRdr.readLine();
            }
            fileStrm.close();
         }
         catch (IOException e)
         {
             if (fileStrm != null)
             {
                 try
                 {
                     fileStrm.close();
                 }//END TRY
                 catch (IOException ex2)
                 {
                 }//END CATCH
             }//ENDIF
         }
         return lineArray;
    }

    public static void WriteArray(String filename, String [] lineArray)
    {
        FileOutputStream fileStrm;
        PrintWriter pw;
  
        try
        {
            fileStrm = new FileOutputStream(filename);
            pw = new PrintWriter(fileStrm);

            for(int ii=0; ii<= lineArray.length-1; ii++)
            {
                pw.println(lineArray[ii]);
            }
            pw.close();
            fileStrm.close();
        }
        catch(IOException e)
        {
        }
    }   
}   
