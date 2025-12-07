import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public final int checkPatterns() {
        String dnaString = new String(dna.baseArray); // try making this an attribute later
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
