import java.io.*;

public class Serialization
{
    public static void save(World objToSave, String filename)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);

            objStrm.close();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }

    }
}
