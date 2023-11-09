import java.util.Arrays;

public class Sort {
    private int[] number;

    public Sort(int[] number) {
        this.number = number;
    }

    public int[] sortNotDivideAndConQuer() {
        int[] tempNumber = number.clone();
        for (int i = 0; i < tempNumber.length; i++) {
            
        }
        return tempNumber;
    }
    public static void generateSwapCombinations(int[] array, int start) {
        boolean check=false;
        if(check){
            return;
        }
        if (start >= array.length) {
            System.out.println(Arrays.toString(array));
            int checkNum=0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (j<i) {
                        for (int k = j; k < i; k++) {
                            if(array[i]==(array[k]+array[j])/2){
                                checkNum++;
                            }
                        }
                    }else{
                        for (int k = j; k < i; k++) {
                            if(array[i]==(array[k]+array[j])/2){
                                checkNum++;
                            }
                        }
                    }
                }
            }
                // System.out.println("result: "+Arrays.toString(array));
                System.out.println("checkNum: "+checkNum);
                // System.out.println("answer");
                check=true;
            return;
        }

        for (int i = start; i < array.length; i++) {
            swap(array, start, i);
            generateSwapCombinations(array, start + 1);
            swap(array, start, i); // backtrack
        }

        if (start == 0) {
            System.out.println(Arrays.toString(array));
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] sortDivideAndConQuer() {
        int[] tempNumber = number.clone();

        return null;
    }
    public int[] merge(int[]left ,int[]right){
        int[] result = new int[left.length + right.length];
        for (int i = 0; i < result.length; i++) {
            if(i<left.length){
                result[i]=left[i];
            }else{
                result[i]=right[i-left.length];
            }
        }
        return result;
    }

    public String toString(int[] number) {
        if (number == null) {
            return "original"+toString(this.number);
        }
        String result = "";
        for (int i = 0; i < number.length; i++) {
            result += number[i] + " ";
        }
        return result;
    }
}
