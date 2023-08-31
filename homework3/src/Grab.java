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
        // for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 'G' && !taken[i]) {
                // System.out.println("i"+i);
                for (int j = Math.max(0, i - k); j < Math.min(array.length, i + k + 1); j++){
                // for (int j = Math.min(array.length - 1, i + k); j >= Math.max(0, i - k); j--) {
                    // System.out.println("j"+j);
                    if (array[j] == 'P' && !taken[j]) {
                        taken[i] = true;
                        taken[j] = true;
                        count++;
                        break;
                    }
                }

                // boolean found = false;

                // // Check the nearest neighbors to the right of the current 'G'
                // for (int j = i + 1; j < Math.min(array.length, i + k + 1) && !found; j++) {
                //     if (array[j] == 'P' && !taken[j]) {
                //         taken[i] = true;
                //         taken[j] = true;
                //         count++;
                //         found = true;
                //     }
                // }

                // // If no match was found to the right, check the nearest neighbors to the left
                // // of the current 'G'
                // for (int j = i - 1; j >= Math.max(0, i - k) && !found; j--) {
                //     if (array[j] == 'P' && !taken[j]) {
                //         taken[i] = true;
                //         taken[j] = true;
                //         count++;
                //         found = true;
                //     }
                // }
            }
        }
        return count;
    }

    public int bruteForceEntry() {
        boolean[] taken = new boolean[array.length];
        return bruteForceSol(array, k, 0, 0, taken);
    }

    public int bruteForceSol(Character[] arr, int k, int index, int count, boolean[] taken) {
        if (index >= arr.length) {
            return count;
        }

        int maxCount = count;

        if (arr[index] == 'G') {
            maxCount = Math.max(maxCount, bruteForceSol(arr, k, index + 1, count, taken));

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
