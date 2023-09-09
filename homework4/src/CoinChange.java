import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
// import java.util.Map;

public class CoinChange {
    private int Amount;
    private int[] Coins;
    private List<List<String>> result;
    private List<Integer> listAmount;
    private List<Integer> listIndex;
    // private Map<String, List<List<String>>> memo = new HashMap<>();

    public CoinChange(int Amount, int[] Coins) {
        this.Amount = Amount;
        this.Coins = Coins;
        this.result = new ArrayList<>();
        this.listAmount = new ArrayList<>();
        this.listIndex = new ArrayList<>();
        // this.memo = new HashMap<>();
    }

    // private List<List<String>> WaysToMakeChange(int index, int amount,
    // List<Integer> current) {
    // String key = index + "," + amount;
    // if (memo.containsKey(key)) {
    // return copyList(memo.get(key));
    // }
    // List<List<String>> combinations = new ArrayList<>();
    // if (amount == 0) {
    // List<String> toAdd = new ArrayList<>();
    // for (int num : current) {
    // toAdd.add(Integer.toString(num));
    // }
    // combinations.add(toAdd);
    // } else if (index < Coins.length) {
    // key = index + "," + amount;
    // if (memo.containsKey(key)) {
    // return memo.get(key);
    // }
    // for (int cnt = 0; cnt <= amount / Coins[index]; cnt++) {
    // for (int j = 0; j < cnt; j++) {
    // current.add(Coins[index]);
    // }
    // combinations.addAll(WaysToMakeChange(index + 1, amount - Coins[index] * cnt,
    // current));
    // for (int j = 0; j < cnt; j++) {
    // current.remove(current.size() - 1);
    // }
    // }
    // memo.put(key, copyList(combinations));
    // }

    // return combinations;
    // }

    // private List<List<String>> copyList(List<List<String>> original) {
    // List<List<String>> copy = new ArrayList<>();
    // for (List<String> list : original) {
    // copy.add(new ArrayList<>(list));
    // }
    // return copy;
    // }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amount : ").append(Amount).append("\n");
        sb.append("coins [] : {");
        for (int i = 0; i < Coins.length; i++) {
            sb.append(Coins[i]);
            if (i != Coins.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}\n");

        List<Integer> currentCombination = new ArrayList<>();
        result = WaysToMakeChange(0, Amount, currentCombination);

        sb.append("Ways to make change : ").append(result.size()).append("\n");
        for (List<String> combination : result) {
            sb.append("{").append(String.join(",", combination)).append("} ");
        }

        if (result.size() == 0) {
            sb.append("\nBestSol : Don't have any solution");
        } else {
            sb.append("\nBest Solution is : ");
            List<String> min = null;
            for (int i = 0; i < result.size(); i++) {
                if (min == null) {
                    min = result.get(i);
                }
                if (min.size() > result.get(i).size()) {
                    min = result.get(i);
                }
            }
            sb.append("{").append(String.join(",", min)).append("} ");
        }

        return sb.toString();
    }

    // import java.util.ArrayList;
    // import java.util.List;

    // public class CoinChange {
    // private int Amount;
    // private int[] Coins;
    // private List<List<String>> result;

    // public CoinChange(int Amount, int[] Coins) {
    // this.Amount = Amount;
    // this.Coins = Coins;
    // this.result = new ArrayList<>();
    // }

    // public String WaysToMakeChangeEntry() {
    // List<Integer> currentCombination = new ArrayList<>();
    // WaysToMakeChange(0, Amount, currentCombination);

    // StringBuilder sb = new StringBuilder();
    // sb.append("Ways to make change = ").append(result.size()).append("\n");
    // for (List<String> combination : result) {
    // sb.append("{").append(String.join(",", combination)).append("} ");
    // }
    // return sb.toString().trim();
    // }

    private List<List<String>> WaysToMakeChange(int index, int amount, List<Integer> current) {
        // for (int i = 0; i < listAmount.size(); i++) {
        //     if (listAmount.get(i) == amount && listIndex.get(i) == index) {
        //         return result;
        //     }
        // }
        if (amount == 0) {
            List<String> toAdd = new ArrayList<>();
            for (int num : current) {
                toAdd.add(Integer.toString(num));
            }
            result.add(toAdd);
            return result;
        }
        if (index == Coins.length || amount < 0) {
            return result;
        }

        // Choose the current coin
        current.add(Coins[index]);
        WaysToMakeChange(index, amount - Coins[index], current);

        // Don't choose the current coin
        current.remove(current.size() - 1);
        WaysToMakeChange(index + 1, amount, current);

        listAmount.add(amount);
        listIndex.add(index);
        return result;
    }

    // public String toString() {
    // String line = "";
    // line += "Amount = " + Amount;
    // line += "\ncoins [] = {";
    // for (int i = 0; i < Coins.length; i++) {
    // line += Coins[i] + ",";
    // }
    // line += "}";
    // line += "\n" + WaysToMakeChangeEntry();
    // // for (int i = 0; i < 3; i++) {
    // // // line += memo[i][Amount];
    // // }
    // return line;
    // }
    // public String getBestSol(){
    // if(result.size()==0){
    // return "BestSol : Null";
    // }
    // return "BestSol : "+result.get(result.size()-1);
    // }
    // }
}