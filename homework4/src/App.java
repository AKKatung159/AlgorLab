import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int tempAmount;
        List<Integer> tempCoinsList;
        int[] tempCoins;
        CoinChange[] ArrayCoinChange = new CoinChange[14];
        CoinChange tempCoinChange;
        try {
            for (int i = 1; i < 15; i++) {
                File fileTest = new File("./testCase/4." + i + ".txt");
                Scanner inputScanner = new Scanner(fileTest);
                tempAmount = inputScanner.nextInt();
                tempCoinsList = new ArrayList<>();
                while (inputScanner.hasNextInt()) {
                    tempCoinsList.add(inputScanner.nextInt());
                }
                tempCoins = new int[tempCoinsList.size()];
                for (int j = 0; j < tempCoinsList.size(); j++) {
                    tempCoins[j] = tempCoinsList.get(j);
                }
                tempCoinChange = new CoinChange(tempAmount, tempCoins);
                ArrayCoinChange[i - 1] = tempCoinChange;
                inputScanner.close();
            }
        } catch (Exception e) {
            System.out.println("Done");
        }
        for (CoinChange coinChange : ArrayCoinChange) {
            // coinChange.WaysToMakeChange(coinChange.Amount, coinChange.Coins[coinChange.CoinIndex]);
            System.out.println(coinChange);
            System.out.println(coinChange.getBestSol());
        }
            // System.out.println(ArrayCoinChange[1]);
    }
}
