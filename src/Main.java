import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Analyse anal = new Analyse();
        anal.readFile();
        //System.out.println(anal.getMap());
        System.out.println(anal.totalCasesPrContinent());
    }
}