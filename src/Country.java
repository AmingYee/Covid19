public class Country implements Comparable<Country>

{

    private String country_name;
    private int population;
    private String continent;
    private int total_cases;
    private int total_deaths;

    public Country(String country_name,
                   int population,
                   String continent,
                   int total_cases,
                   int total_deaths)
    {
        this.country_name = country_name;
        this.population = population;
        this.continent = continent;
        this.total_cases = total_cases;
        this.total_deaths = total_deaths;
    }

    public String getCountry_name() {
        return country_name;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public int getTotal_cases() {
        return total_cases;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    @Override
    public String toString() {
        return String.format("%s \t \t %d \t \t %s \t \t %d \t \t %d\n",
                getCountry_name(),
                getPopulation(),
                getContinent(),
                getTotal_cases(),
                getTotal_deaths());
    }
    @Override
    public int compareTo(Country c ) {
        int r = Integer.valueOf(population).compareTo(c.getPopulation());
        return r;
    }
}