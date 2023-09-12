// import java.io.File;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // int tempAmount;
        // List<Integer> tempCoinsList;
        // int[] tempCoins;
        // CoinChange[] ArrayCoinChange = new CoinChange[14];
        // CoinChange tempCoinChange;
        // try {
        //     for (int i = 1; i < 15; i++) {
        //         File fileTest = new File("./testCase/4." + i + ".txt");
        //         Scanner inputScanner = new Scanner(fileTest);
        //         tempAmount = inputScanner.nextInt();
        //         tempCoinsList = new ArrayList<>();
        //         while (inputScanner.hasNextInt()) {
        //             tempCoinsList.add(inputScanner.nextInt());
        //         }
        //         tempCoins = new int[tempCoinsList.size()];
        //         for (int j = 0; j < tempCoinsList.size(); j++) {
        //             tempCoins[j] = tempCoinsList.get(j);
        //         }
        //         tempCoinChange = new CoinChange(tempAmount, tempCoins);
        //         ArrayCoinChange[i - 1] = tempCoinChange;
        //         inputScanner.close();
        //     }
        // } catch (Exception e) {
        //     System.out.println("Done");
        // }
        // // System.out.println(ArrayCoinChange[2]);
        // for (CoinChange coinChange : ArrayCoinChange) {
        //     System.out.println(coinChange+"\n");
        // }
        
        int amount = 28;
        int[] coins = {2, 5, 7};
        int[] table = new int[amount + 1];

        // Initialization
        table[0] = 1;
        System.out.println("Initial table:");
        printTable(table, amount);

        // Update table for each coin
        for (int j = 0; j < coins.length; j++) {
            int coin = coins[j];
            for (int i = coin; i <= amount; i++) {
                table[i] += table[i - coin];
            }
            System.out.println("\nTable after considering coin of value " + coin + ":");
            printTable(table, amount);
        }
    }

    private static void printTable(int[] table, int amount) {
        for (int i = 0; i <= amount; i++) {
            System.out.println("Amount " + i + ": " + table[i] + " ways");
        }
    }
    }

//4 11 9 8 0 1 23 22 47 0 459 8177 4399