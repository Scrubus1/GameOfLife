import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representation of each cell within the grid
 */
public class Cell {

    boolean isAlive;
    Dna dna;
    int patternCount;
    private static final String[] patterns = {
        "agct",
        "gcgatc",
        "tata",
        "cgcgcg",
        "atgcgt",
        "tagc",
        "ctagcga",
        "gcgtacg",
        "tgcg",
        "ctag"
    };


    public Cell() {
        isAlive = false;
        dna = new Dna();
        patternCount = this.checkPatterns();
    }

    /**
     * Checks the DNA sequence for patterns that make characteristics
     * @return Number of characteristics found
     */
    public final int checkPatterns() {
        String dnaString = new String(dna.baseArray);
        int count = 0;
        for (String pattern: patterns) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(dnaString);
            
            if (m.find()) {
                count++;
            }
        }

        return count;
    }


    @Override
    public String toString() {
        return isAlive ? String.valueOf(patternCount) : ".";
    }
    
}
