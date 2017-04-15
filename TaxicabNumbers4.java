import java.util.Hashtable;

public class TaxicabNumbers4 {

    public void calculate(long max) {
        Hashtable table = new Hashtable<Object, long[]>();
        long a3 = 0;
        for(long a = 1; (a3 = a * a * a) < max; a++) {
            long b3 = 0;
            for(long b = a; (b3 = b * b * b) <= max - a3; b++) {
                long ab3 = a3 + b3;
                long[] previous = (long[])table.get(ab3);
                if(previous == null) {
                    table.put(ab3, new long[] { a, b });
                }
                else if(previous[0] != 0) {
                    System.out.println(ab3 + " = " + a + "³ + " + b + "³ = " + previous[0] + "³ + " + previous[1] + "³");
                    table.put(ab3, new long[] { 0, 0 });
                }
            }
        }
    }
    //
    public static void main(String[] args) {
        TaxicabNumbers4 taxicabNumbers4 = new TaxicabNumbers4();
        try {
            taxicabNumbers4.calculate(Long.parseLong(args[0]));
        }
        catch(Exception exception) {
            System.err.println("Missing or invalid parameter!");
        }
    }
}
