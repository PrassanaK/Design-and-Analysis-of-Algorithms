public class State extends World
{
    private String country;
    private String areaUnit;

    public State(String inName, String inShortName, int inArea, int inPopulation, String inPopRef, String inCountry, String inAreaUnit)
    {
        super(inName, inShortName, inArea, inPopulation, inPopRef);
        country = inCountry;
        areaUnit = inAreaUnit;
    }

    public State(State inState)
    {
        super(inState);
        areaUnit = inState.getAreaUnit();
        country = inState.getCountry();
    }

    public void setCountry(String inCountry)
    {
        country = inCountry;
    }

    public void setAreaUnit(String inAreaUnit)
    {
        areaUnit = inAreaUnit;
    }

    public String getCountry()
    {
        return country;
    }

    public String getAreaUnit()
    {  
        return areaUnit;
    }
}
