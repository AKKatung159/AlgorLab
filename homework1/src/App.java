public class App {
    public static void main(String[] args) throws Exception {
        int[] test = { 504857673, 354879547, 30, 15, 20, 72, 72, 88, 58, 77, 92, 80, 286, 544, 985, 716, 839, 433, 471,
                561, 269, 749, 1888, 1224, 3164, 6996, 6253, 5431, 4390, 2874, 5017, 7615, 76241, 57606, 74766, 64553,
                12322, 50440, 34726, 92155, 14785, 19817, 672270, 431511, 694404, 256785, 975922, 532283, 279392,
                946230, 906443, 392685, 2226412, 8648878, 6061228, 5546440, 1691980, 1414558, 3234496, 7268362, 8356954,
                3705742, 81786288, 61052652, 21535993, 91675657, 26586591, 78851391, 68575643, 45017255, 45991767,
                77583796, 459917672, 775837965, 265865917, 788513914, 685756433, 450172557, 785756437, 102475659
        };

        for (int i = 0; i <= 78; i += 2) {
            FindGDC a = new FindGDC(test[i], test[i + 1]);
            long start1 = System.nanoTime();
            // System.out.println("NaiveSolution : " + a.sol1());
            a.sol2();
            long finish1 = System.nanoTime();
            long timeElapsed1 = finish1 - start1;
            System.out.println("" + timeElapsed1 + "");
            // System.out.println("---------------");

            // long start2 = System.nanoTime();
            // System.out.println("SieveOfEratosthenes : " + a.sol2());
            // long finish2 = System.nanoTime();
            // long timeElapsed2 = finish2 - start2;
            // System.out.println("Time : " + timeElapsed2 + " ns");
            // System.out.println("---------------");

            // long start3 = System.nanoTime();
            // System.out.println("Recursive : " + a.sol3());
            // long finish3 = System.nanoTime();
            // long timeElapsed3 = finish3 - start3;
            // System.out.println("Time : " + timeElapsed3 + " ns");
            // System.out.println("---------------");

        }
        // FindGDC a = new FindGDC(742271756, 606228865);

        // long start1 = System.nanoTime();
        // System.out.println("NaiveSolution : " + a.sol1());
        // long finish1 = System.nanoTime();
        // long timeElapsed1 = finish1 - start1;
        // System.out.println("Time : " + timeElapsed1 + " ns");
        // System.out.println("---------------");

        // long start2 = System.nanoTime();
        // System.out.println("SieveOfEratosthenes : " + a.sol2());
        // long finish2 = System.nanoTime();
        // long timeElapsed2 = finish2 - start2;
        // System.out.println("Time : " + timeElapsed2 + " ns");
        // System.out.println("---------------");

        // long start3 = System.nanoTime();
        // System.out.println("Recursive : " + a.sol3());
        // long finish3 = System.nanoTime();
        // long timeElapsed3 = finish3 - start3;
        // System.out.println("Time : " + timeElapsed3 + " ns");
        // System.out.println("---------------");
        // System.out.println(a.prime);
    }
}