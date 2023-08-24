import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class FindGDC {
    private int m;
    private int n;
    public static List<Integer> prime;

    public FindGDC(int m, int n) {
        this.m = Math.abs(m);
        this.n = Math.abs(n);
    }

    public int sol1() {
        // check input whether m or n == 0
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }

        int ans = 1;
        int[] set1 = NaiveSolution(m);
        int[] set2 = NaiveSolution(n);
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if (set1[i] == set2[j]) {
                    ans *= set1[i];
                    set2[j] = -1;
                    break;
                }
            }
        }
        return ans;
    }

    public int sol2() {
        // check input whether m or n == 0
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }

        int ans = 1;
        int[] set1 = SieveOfEratosthenes(m);
        int[] set2 = SieveOfEratosthenes(n);
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if (set1[i] == set2[j]) {
                    ans *= set1[i];
                    set2[j] = -1;
                    break;
                }
            }
        }
        return ans;
    }

    public int sol3() {
        // check input whether m or n == 0
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }

        // check m%n == 0
        if (m % n == 0) {
            return n;
        }
        // swap n=n m=m%n
        if (m > n) {
            m = m % n;
        }
        // swap n=m m=n%m
        else {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return sol3();
    }

    public int[] NaiveSolution(int num) {
        List<Integer> set = new ArrayList<>();
        int factor = 2;
        // divide num with 2 until can't do and +=1
        while (num > 1) {
            if (num % factor == 0) {
                set.add(factor);
                num = num / factor;
            } else {
                factor++;
            }
        }
        // convert list to array
        int[] ans = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            ans[i] = set.get(i);
        }
        return ans;
    }

    public int[] SieveOfEratosthenes(int num) {
        // get prime array when start or num is larger than prime
        if (prime == null || prime.get(prime.size() - 1) < num) {
            boolean[] isPrime = new boolean[num + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= num; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            prime = new ArrayList<>();
            for (int i = 2; i <= num; i++) {
                if (isPrime[i]) {
                    prime.add(i);
                }
            }
        }
        // divide num with prime from SieveOfEratosthenes
        List<Integer> factors = new ArrayList<>();
        for (Integer p : prime) {
            while (num % p == 0) {
                factors.add(p);
                num /= p;
            }
            if (num == 1) {
                break;
            }
        }
        // convert list to array
        int[] result = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            result[i] = factors.get(i);
        }

        return result;
    }

}