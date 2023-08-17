public class App {
    public static void main(String[] args) throws Exception {
        FindGDC a = new FindGDC(7, 21);

        long start1 = System.nanoTime();
        System.out.println(a.sol1());
        long finish1 = System.nanoTime();
        long timeElapsed1 = finish1 - start1;
        System.out.println("time: "+timeElapsed1+" nanosecond");
        System.out.println("---------------");

        long start2 = System.nanoTime();
        System.out.println(a.sol1());
        long finish2 = System.nanoTime();
        long timeElapsed2 = finish2 - start2;
        System.out.println("time: "+timeElapsed2+" nanosecond");
        System.out.println("---------------");

        long start3 = System.nanoTime();
        System.out.println(a.sol1());
        long finish3 = System.nanoTime();
        long timeElapsed3 = finish3 - start3;
        System.out.println("time: "+timeElapsed3+" nanosecond");
        System.out.println("---------------");
    }
}