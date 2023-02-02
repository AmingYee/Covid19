import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Analyse {
    private File file;
    private Map<String, Set<Country>> map;

    public Analyse(String fileName){
        this.map = new TreeMap(); // nøgler sorteres
        this.file = new File(fileName);
    }

    public Map<String, Set<Country>> getMap() {
        return map;
    }

    public void readFile() throws FileNotFoundException {
            Country CountryToAdd;
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                String[] attributeList = input.nextLine().split(",");
                CountryToAdd  = new Country(
                        attributeList[0],
                        Integer.parseInt(attributeList[3]),
                        attributeList[4],
                        Integer.parseInt(attributeList[5]),
                        Integer.parseInt(attributeList[6]));
                if (map.containsKey(CountryToAdd.getContinent())){
                    map.get(CountryToAdd.getContinent()).add(CountryToAdd);
                }else {
                map.put(CountryToAdd.getContinent(), new TreeSet<>(List.of(CountryToAdd)));
            }
        }
        // TODO
        // Indlæs hver linje i filen, skip linje 1
        // Parse relevante data og opret et country objekt
        // Hvis “continent” nøglen ikke eksisterer i map oprettes en ny nøgle
        // med et tomt TreeSet og Country objektet tilføjes til set-et
        // Hvis “continent” nøglen eksisterer i map tilføjes Country objektet
        // til set-et

    public Map<String, Integer> totalCasesPrContinent() {
        // TODo
        // Metoden skal returnere et map, der indeholder “continent” som nøgle
        // og det samlede antal tilfælde for hvert kontinent som værdi
    }
}