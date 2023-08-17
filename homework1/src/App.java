public class App {
    public static void main(String[] args) throws Exception {
        FindGDC a = new FindGDC(30000, 1000000);

        long start1 = System.nanoTime();
        System.out.println("NaiveSolution : "+a.sol1());
        long finish1 = System.nanoTime();
        long timeElapsed1 = finish1 - start1;
        System.out.println("Time : "+timeElapsed1+" ns");
        System.out.println("---------------");

        long start2 = System.nanoTime();
        System.out.println("SieveOfEratosthenes : "+a.sol2());
        long finish2 = System.nanoTime();
        long timeElapsed2 = finish2 - start2;
        System.out.println("Time : "+timeElapsed2+" ns");
        System.out.println("---------------");

        long start3 = System.nanoTime();
        System.out.println("Recursive : "+a.sol3());
        long finish3 = System.nanoTime();
        long timeElapsed3 = finish3 - start3;
        System.out.println("Time : "+timeElapsed3+" ns");
        System.out.println("---------------");
        // System.out.println(a.prime);
    }
}