import java.io.*;
public class World implements Serializable
{
    private String name;
    private String shortName;
    private int area;
    private int population;
    private String popRef;

    public World(String inName, String inShortName, int inArea, int inPopulation, String inPopRef)
    {
        name = inName;
        shortName = inShortName;
        area = inArea;
        population = inPopulation;
        popRef = inPopRef;
    }

    public World(World inWorld)
    {
        name = inWorld.getName();
        shortName = inWorld.getShortName();
        area = inWorld.getArea();
        population = inWorld.getPopulation();
        popRef = inWorld.getPopRef();
    }
 
    public void setName(String inName)
    {
        name = inName;
    }
 
    public void setShortName(String inShortName)
    {
        shortName = inShortName;
    }
  
    public void setArea(int inArea)
    {
        area = inArea;
    }
  
    public void setPopulation(int inPopulation)
    {
        population = inPopulation;
    }
  
    public void setPopRef(String inPopRef)
    {
        popRef = inPopRef;
    }

    public String getName()
    {
        return name;
    }
  
    public String getShortName()
    {
        return shortName;
    }
  
    public int getArea()
    {
        return area;
    }
   
    public int getPopulation()
    {
        return population;
    }
  
    public String getPopRef()
    {
        return popRef;
    }

    public boolean equals(Object inObj)
    {
        boolean isEqual = false;
        if (inObj instanceof World)
        {
            World inWorld = (World)inObj;
            isEqual = (name.equals(inWorld.getName()))&&(shortName.equals(inWorld.getShortName())&&(area == inWorld.getArea())&&(population == inWorld.getPopulation())&&(popRef.equals(inWorld.getPopRef())));
        }
        return isEqual;
    }
}
   
