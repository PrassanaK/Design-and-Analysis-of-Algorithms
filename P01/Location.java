import java.io.*;
public class Location implements Serializable
{
    private String name; 
    private String state;
    private String country;
    private String coords;
    private String description;
    
    public Location(String inName, String inState, String inCountry, String inCoords, String inDescription)
    {
        name = inName;
        state = inState; 
        country = inCountry;
        coords = inCoords;
        description = inDescription;
    }
  
    public Location(Location inLocation)
    {
        name = inLocation.getName();
        state = inLocation.getState();
        country = inLocation.getCountry();
        coords = inLocation.getCoords();
        description = inLocation.getDescription();
    }

    public void setName(String inName)
    { 
        name = inName;
    }
    
    public void setState(String inState)
    {
        state = inState;
    }
    
    public void setCountry(String inCountry) 
    {
        country = inCountry;
    }

    public void setCoords(String inCoords)
    {
        coords = inCoords;
    }

    public void setDescription(String inDescription)
    {
        description = inDescription;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public String getCountry()
    {
        return country;
    }

    public String getCoords()
    {
        return coords;
    }

    public String getDescription()
    {
        return description;
    }
}


