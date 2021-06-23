import java.util.HashMap;

public class Task1 {
    private static int res;

    /**
     * not effictive O(n^2) solution
     */
    private static void oN2(String testString){
        for (int i = 0, n = testString.length(); i < n; i++) {
            char c = testString.charAt(i);
            int mediumMax = 0;
            for(int j = 0, m = testString.length(); j < m; j++){
                char d = testString.charAt(j);
                if(d == c){
                    mediumMax ++;
                }
            }
            if(mediumMax > res){
                res = mediumMax;
            }
        }
        System.out.println(res);
    }

    /**
     * effictive O(n*k) solution
     */
    private static void oN(String testString){
        HashMap<Character,Integer> dictionary = new HashMap<>();
        char [] strArray = testString.toCharArray();
        for (char elem:strArray) {
            if (!dictionary.containsKey(elem)) {
                dictionary.put(elem, 1);
            } else {
                int val = dictionary.get(elem);
                dictionary.put(elem, val + 1);
            }
        }
        res = 0;
        for (Integer val:dictionary.values()){
            if(val>res){
                res = val;
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        String testString = "abbaac";
        oN2(testString);
        oN(testString);
    }
}
