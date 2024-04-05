package ebin;

public class SemOps {
    public int valorDe(String bit) {
        switch(bit) {
            case "0": return 0;
            case "1": return 1;
            default: throw new UnsupportedOperationException("Bad bit");
        }
    } 
}
