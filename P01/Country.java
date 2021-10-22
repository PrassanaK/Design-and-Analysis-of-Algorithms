public class Country extends World
{
    private String language;

    public Country(String inName, String inShortName, int inArea, int inPopulation, String inPopRef, String inLanguage)
    {
        super(inName, inShortName, inArea, inPopulation, inPopRef);
        language = inLanguage;
    }    

    public Country(Country inCountry)
    {
        super(inCountry);
        language = inCountry.getLanguage();
    }

    public void setLanguage(String inLanguage)
    { 
        language = inLanguage;
    }
 
    public String getLanguage()
    {
        return language;
    }
  
}
