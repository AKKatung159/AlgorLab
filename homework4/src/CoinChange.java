import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    private int Amount;
    private int[] Coins;
    private List<List<String>> result;

    public CoinChange(int Amount, int[] Coins) {
        this.Amount = Amount;
        this.Coins = Coins;
        this.result = new ArrayList<>();
    }

    public String WaysToMakeChangeEntry() {
        List<Integer> currentCombination = new ArrayList<>();
        WaysToMakeChange(0, Amount, currentCombination);

        StringBuilder sb = new StringBuilder();
        sb.append("Ways to make change = ").append(result.size()).append("\n");
        for (List<String> combination : result) {
            sb.append("{").append(String.join(",", combination)).append("} ");
        }
        return sb.toString().trim();
    }

    private void WaysToMakeChange(int index, int amount, List<Integer> current) {
        if (amount == 0) {
            List<String> toAdd = new ArrayList<>();
            for (int num : current) {
                toAdd.add(Integer.toString(num));
            }
            result.add(toAdd);
            return;
        }
        if (index == Coins.length || amount < 0) {
            return;
        }

        // Choose the current coin
        current.add(Coins[index]);
        WaysToMakeChange(index, amount - Coins[index], current);

        // Don't choose the current coin
        current.remove(current.size() - 1);
        WaysToMakeChange(index + 1, amount, current);
    }

    public String toString() {
        String line = "";
        line += "Amount = " + Amount;
        line += "\ncoins [] = {";
        for (int i = 0; i < Coins.length; i++) {
            line += Coins[i] + ",";
        }
        line += "}";
        line += "\n" + WaysToMakeChangeEntry();
        // for (int i = 0; i < 3; i++) {
        //     // line += memo[i][Amount];
        // }
        return line;
    }
    public String getBestSol(){
        if(result.size()==0){
            return "BestSol : Null";
        }
        return "BestSol : "+result.get(result.size()-1);
    }
}