public class Dna {
    char[] baseArray;
    char[] possibleBases = {'a', 't', 'c', 'g'};

    public Dna() {
        baseArray = new char[30];
        for (int i = 0; i < 30; i++) {
            baseArray[i] = possibleBases[(int) (Math.random() * 4)];
        }
    }

    public void matchPairs(Dna parentA, Dna parentB) {
        for (int i = 0; i < 30; i++) {
            if (parentA.baseArray[i] == 'a' && parentB.baseArray[29 - i] == 't') {
                parentA.baseArray[i] = 'a';
            } else if (parentA.baseArray[i] == 't' && parentB.baseArray[29 - i] == 'a') {
                parentA.baseArray[i] = 't';
            } else if (parentA.baseArray[i] == 'c' && parentB.baseArray[29 - i] == 'g') {
                parentA.baseArray[i] = 'c';
            } else if (parentA.baseArray[i] == 'g' && parentB.baseArray[29 - i] == 'c') {
                parentA.baseArray[i] = 'g';
            } else {
                parentA.baseArray[i] = possibleBases[(int) (Math.random() * 4)];
            }
        }
    }
}
