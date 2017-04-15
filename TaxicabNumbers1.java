public class TaxicabNumbers1 {

    public void calculate(long max) {
        long a3 = 0;
        for(long a = 1; (a3 = a * a * a) < max; a++) {
            long b3 = 0;
            for(long b = a; (b3 = b * b * b) <= max - a3; b++) {
                long ab3 = a3 + b3;
                long c3 = 0;
                for(long c = a + 1; (c3 = c * c * c) < ab3; c++) {
                    long d3 = 0;
                    for(long d = c; (d3 = d * d * d) <= ab3 - c3; d++) {
                        if(ab3 == c3 + d3)
                            System.out.println(ab3 + " = " + a + "³ + " + b + "³ = " + c + "³ + " + d + "³");
                    }
                }
            }
        }
    }
    //
    public static void main(String[] args) {
        TaxicabNumbers1 taxicabNumbers1 = new TaxicabNumbers1();
        try {
            taxicabNumbers1.calculate(Long.parseLong(args[0]));
        }
        catch(Exception exception) {
            System.err.println("Missing or invalid parameter!");
        }
    }
}
