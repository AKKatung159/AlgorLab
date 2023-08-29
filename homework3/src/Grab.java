public class Grab {
    // Local variable
    private Character[] array;
    private int k;

    // Constructor
    public Grab(Character[] array, int k) {
        this.array = array;
        this.k = k;
    }

    public int greedySol() {
        int count = 0;
        boolean[] taken = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'G' && !taken[i]) {
                for (int j = Math.max(0, i - k); j < Math.min(array.length, i + k + 1); j++) {
                    if (array[j] == 'P' && !taken[j]) {
                        taken[i] = true;
                        taken[j] = true;
                        i = j;
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public int bruteForceEntry(){
        boolean[] taken=new boolean[array.length];
        return bruteForceSol(array, k, 0, 0, taken);
    }
    public int bruteForceSol(Character[] arr, int k, int index, int count, boolean[] taken) {
        if (index >= arr.length) {
            return count;
        }

        int maxCount = count;

        if (arr[index] == 'G') {
            for (int i = Math.max(0, index - k); i <= Math.min(arr.length - 1, index + k); i++) {
                if (arr[i] == 'P' && !taken[i]) {
                    taken[i] = true;
                    maxCount = Math.max(maxCount, bruteForceSol(arr, k, index + 1, count + 1, taken));
                    taken[i] = false;
                }
            }
        } else {
            maxCount = Math.max(maxCount, bruteForceSol(arr, k, index + 1, count, taken));
        }

        return maxCount;
    }

    // toString
    public String toString() {
        String line = "array:\t";
        for (int i = 0; i < array.length; i++) {
            line += array[i] + " ";
        }
        line += "\nk : \t" + k;
        return line;
    }
}
