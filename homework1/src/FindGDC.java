import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class FindGDC {
    private int m;
    private int n;
    private int[] prime;
    
    public FindGDC(int m, int n) {
        this.m = Math.abs(m);
        this.n = Math.abs(n);
    }

    // private checkInput(){
    //     if(m == 0 && n == 0){
    //         return 0;
    //     }else if(m == 0){
    //         return n;
    //     }else if(n == 0){
    //         return m;
    //     }
    // }

    public int sol1() {
        // check input whether m or n == 0
        if(m == 0 && n == 0){
            return 0;
        }else if(m == 0){
            return n;
        }else if(n == 0){
            return m;
        }

        int ans=1;
        int[] set1=NaiveSolution(m);
        int[] set2=NaiveSolution(n);
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if(set1[i]==set2[j]){
                    ans*=set1[i];
                    i++;
                }
            }
        }
        return ans;
    }

    public int sol2() {
        // check input whether m or n == 0
        if(m == 0 && n == 0){
            return 0;
        }else if(m == 0){
            return n;
        }else if(n == 0){
            return m;
        }

        int ans=1;
        int[] set1=SieveOfEratosthenes(m);
        int[] set2=SieveOfEratosthenes(n);
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if(set1[i]==set2[j]){
                    ans*=set1[i];
                    i++;
                }
            }
        }
        return ans;
    }

    public int sol3() {
        // check input whether m or n == 0
        if(m == 0 && n == 0){
            return 0;
        }else if(m == 0){
            return n;
        }else if(n == 0){
            return m;
        }

        if (m % n == 0) {
            return n;
        }
        if (m > n) {
            m = m % n;
        } else {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return sol3();
    }
    

    public int[] NaiveSolution(int num) {
        List<Integer> set = new ArrayList<>();
        int factor=2;
        while (num>1) {
            if (num%factor==0) {
                set.add(factor);
                num=num/factor;
            }
            else{
                factor++;
            }
        }
        int[] ans = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            ans[i] = set.get(i);
        }
        return ans;
    }

    public int[] SieveOfEratosthenes(int num) {
        //add number to list
        List<Integer> set = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            set.add(i);
        }
        //remove multiple of prime
        for (int i = 2; i < set.size(); i++) {
            for (int j = 2; j < set.size(); j++) {
                set.remove(Integer.valueOf(i * j));
            }
        }
        for (int i = 0; i < set.size();) {
            if(num%set.get(i)==0){
                num/=set.get(i);
                ans.add(Integer.valueOf(set.get(i)));
            }
            else{
                i++;
            }
        }
        //convert arraylist to array
        int[] ans2 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans2[i] = ans.get(i);
        }

        return ans2;
    }
}