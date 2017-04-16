import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Test {

    public static int[] numbers = { 1729, 4104, 13832, 20683, 32832, 39312, 40033, 46683, 64232, 65728, 110656, 110808, 134379, 149389, 165464, 171288, 195841, 216027, 216125, 262656, 314496, 320264, 327763, 373464, 402597, 439101, 443889, 513000, 513856, 515375, 525824, 558441, 593047, 684019, 704977, 805688, 842751, 885248, 886464, 920673, 955016, 984067, 994688, 1009736, 1016496, 1061424, 1073375, 1075032, 1080891, 1092728 };

    public Test() {
        super();
        System.out.println("max , class1 , class2 , class3 , class4 , class5");
        PrintStream systemOut = System.out;
        disableSystemOut();
        TaxicabNumbers1 taxicabNumbers1 = new TaxicabNumbers1();
        TaxicabNumbers2 taxicabNumbers2 = new TaxicabNumbers2();
        TaxicabNumbers3 taxicabNumbers3 = new TaxicabNumbers3();
        TaxicabNumbers4 taxicabNumbers4 = new TaxicabNumbers4();
        TaxicabNumbers5 taxicabNumbers5 = new TaxicabNumbers5();
        for(int x = 0; x < numbers.length; x++) {
            long max = numbers[x];
            long start_time = 0;
            long time1 = 0;
            long time2 = 0;
            long time3 = 0;
            long time4 = 0;
            long time5 = 0;
            int i = 0;
            for(i = 0; i < 1000; i++) {
                //
                start_time = System.nanoTime();
                taxicabNumbers1.calculate(max);
                time1 += (System.nanoTime() - start_time);
                //
                start_time = System.nanoTime();
                taxicabNumbers2.calculate(max);
                time2 += (System.nanoTime() - start_time);
                //
                start_time = System.nanoTime();
                taxicabNumbers3.calculate(max);
                time3 += (System.nanoTime() - start_time);
                //
                start_time = System.nanoTime();
                taxicabNumbers4.calculate(max);
                time4 += (System.nanoTime() - start_time);
                //
                start_time = System.nanoTime();
                taxicabNumbers5.calculate(max);
                time5 += (System.nanoTime() - start_time);
            }
            System.setOut(systemOut);
            System.out.println(max + " , " + (time1 / i) + " , " + (time2 / i) + " , " + (time3 / i) + " , " + (time4 / i) + " , " + (time5 / i));
            disableSystemOut();
        }
    }
    //
    private void disableSystemOut() {
        System.setOut(new PrintStream(new OutputStream() {

            @Override public void write(int b)
                throws IOException {}
        }));
    }

    public static void main(String[] args) {
        new Test();
    }
}
