import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StringCompression {
    private static StringCompression instance = null;
    private StringCompression() {}

    public static StringCompression getInstance() {
        // Singleton 
        if (instance == null) {
            synchronized (StringCompression.class) {
                System.out.println(StringCompression.class);
                // checks again in case the state has changed while waiting for lock
                if (instance == null) {
                    instance = new StringCompression();
                }
            }
        } 
        return instance;
    }
    private String compress(String str) {
        int currCount = 1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < str.length() + 1; i ++) {
            if(i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                currCount += 1;
            } else {
                res.append(str.charAt(i - 1));
                res.append(currCount);
                currCount = 1;
            }
        }
        return res.toString();
    }
    /* 
    private String compress(String str) {
        Map<Character, Integer> occurence = new HashMap<>();
        for (int i = 0; i < str.length(); i ++) {
            occurence.put(str.charAt(i), occurence.getOrDefault(str.charAt(i), 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i ++) {
            res.append(str.charAt(i));
            res.append(occurence.get(str.charAt(i)));           
        }
        return res.toString();
    }*/
    public static void main(String[] args) {
        StringCompression s = StringCompression.getInstance();
        System.out.println(s.compress("aaaaabbccck"));
    }
}