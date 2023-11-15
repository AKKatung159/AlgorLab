import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringMatching {
    String[] setStrings;
    int numPatterns;
    int numText;
    String[] patterns;
    String[] text;

    public StringMatching(String[] setStrings, int numPatterns, int numText, String[] patterns, String[] text) {
        this.setStrings = setStrings;
        this.numPatterns = numPatterns;
        this.numText = numText;
        this.patterns = patterns;
        String[] ans =new String[text.length*2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = text[i%text.length];
        };
        this.text = ans;
    }

    public String toString() {
        String patternString = String.join("", patterns);
        String textString = String.join("", text);
        // String reverseTextString = new StringBuilder(textString).reverse().toString();
        kmpMatcher();
        naiveStringMatching();
        return "Pattern : \t" + patternString + " \nText : \t\t" + "textString" + "\nReverse Text : \t" + "reverseTextString"+ "\n";
    }

    public void kmpMatcher() {
        String patternString = String.join("", patterns);
        String textString = String.join("", text);
        int[] lps = computeLPSArray(patternString);
        System.out.println("KMP Matcher : ");
        List<Integer> matchesLR = kmpSearch(patternString, textString, lps);
        System.out.print("Prefix pi[] for pattern " + patternString + ": ");
        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();
        for (int match : matchesLR) {
            System.out.println((match + 1)%(textString.length()/2) + " LR");
        }
        String reversedTextString = new StringBuilder(textString).reverse().toString();

        List<Integer> matchesRL = kmpSearch(patternString, reversedTextString, lps);
        Collections.sort(matchesRL, Collections.reverseOrder());
        for (int match : matchesRL) {
            int matchPosition = textString.length() - match - 1;
            System.out.println((matchPosition + 1)%(textString.length()/2) + " RL");
        }

    }
    private List<Integer> kmpSearch(String pat, String txt, int[] lps) {
        List<Integer> matches = new ArrayList<>();
        int indexText = 0;
        int indexPattern = 0;
        while (indexText < txt.length()) {
            if (pat.charAt(indexPattern) == txt.charAt(indexText)) {
                indexPattern++;
                indexText++;
            }
            if (indexPattern == pat.length()) {
                matches.add(indexText - indexPattern);
                indexPattern = lps[indexPattern - 1];
            } else if (indexText < txt.length() && pat.charAt(indexPattern) != txt.charAt(indexText)) {
                if (indexPattern != 0) {
                    indexPattern = lps[indexPattern - 1];
                } else {
                    indexText = indexText + 1;
                }
            }
        }
        return matches;
    }

    private int[] computeLPSArray(String pattern) {
        int len = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public void naiveStringMatching() {
        String patternString = String.join("", patterns);
        String textString = String.join("", text);
        System.out.println("Naive String Matching : ");
        List<Integer> matchesLR = naiveSearch(patternString, textString);

        for (int match : matchesLR) {
            System.out.println((match + 1)%(textString.length()/2) + " LR");
        }

        String reversedTextString = new StringBuilder(textString).reverse().toString();

        List<Integer> matchesRL = naiveSearch(patternString, reversedTextString);

        Collections.sort(matchesRL, Collections.reverseOrder());

        for (int match : matchesRL) {
            int matchPosition = textString.length() - match-1;
            System.out.println((matchPosition + 1)%(textString.length()/2) + " RL");
        }
    }

    private List<Integer> naiveSearch(String pat, String txt) {
        List<Integer> matches = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                matches.add(i);
            }
        }
        return matches;
    }
}
