public class TaxicabNumbers2 {

    public void calculate(long max) {
        long a3 = 0;
        for(long a = 1; (a3 = a * a * a) < max; a++) {
            long b3 = 0;
            for(long b = a; (b3 = b * b * b) <= max - a3; b++) {
                long ab3 = a3 + b3;
                long c3 = 0;
                for(long c = a + 1; (c3 = c * c * c) < ab3; c++) {
                    double d3 = ab3 - c3;
                    long d = (long)Math.cbrt(d3);
                    if(d >= c && d != a && d != b && d3 == d * d * d)
                        System.out.println(ab3 + " = " + a + "³ + " + b + "³ = " + c + "³ + " + d + "³");
                }
            }
        }
    }
    //
    public static void main(String[] args) {
        TaxicabNumbers2 taxicabNumbers2 = new TaxicabNumbers2();
        try {
            taxicabNumbers2.calculate(Long.parseLong(args[0]));
        }
        catch(Exception exception) {
            System.err.println("Missing or invalid parameter!");
        }
    }
}
