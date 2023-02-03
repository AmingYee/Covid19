import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Analyse {
    private FileInputStream file;
    private Map<String, Set<Country>> map;

    public Analyse() throws FileNotFoundException {
        this.map = new TreeMap(); // nøgler sorteres
        this.file = new FileInputStream(new File("C:\\Users\\wenmi\\Desktop\\Studie\\Untitled spreadsheet - Sheet1.csv"));
    }

    public Map<String, Set<Country>> getMap() {
        return map;
    }

    public void readFile() throws FileNotFoundException {
        Country CountryToAdd;
        Scanner input = new Scanner(file);
        input.nextLine();
        while (input.hasNextLine()) {
            String[] attributeList = input.nextLine().split(",");
            CountryToAdd = new Country(
                    attributeList[0],
                    Integer.parseInt(attributeList[3]),
                    attributeList[4],
                    Integer.parseInt(attributeList[5]),
                    Integer.parseInt(attributeList[6]));
            if (map.containsKey(CountryToAdd.getContinent())) {
                map.get(CountryToAdd.getContinent()).add(CountryToAdd);
            } else {
                map.put(CountryToAdd.getContinent(), new TreeSet<>(List.of(CountryToAdd)));
            }
        }
    }

    public Map<String, Integer> totalCasesPrContinent() {
        Map<String, Integer> returnlist = new HashMap<String, Integer>();
        int cases = 0;
        int continents = 0;
        for (Map.Entry<String, Set<Country>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<Country> countries = entry.getValue();
            for (Country country : countries) {
                cases += country.getTotal_cases();
            }
            returnlist.put(key, cases);
            if (returnlist.size() > continents) {
                cases = 0;
                continents++;
            }
        }
        return returnlist;
        // TODo
        // Metoden skal returnere et map, der indeholder “continent” som nøgle
        // og det samlede antal tilfælde for hvert kontinent som værdi
    }

    public String percentDenmark() {
       return null;
    }
}