public class OneAway{
    private static boolean isOneAway(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        String shortStr = str1.length() > str2.length() ? str2 : str1;
        String longStr = str1.length() > str2.length() ? str1 : str2;
        int shortIdx = 0;
        int longIdx = 0;
        boolean oneOffAllowed = true;
        while(shortIdx < shortStr.length()) {
            char shortChar = shortStr.charAt(shortIdx);
            char longChar = longStr.charAt(longIdx);
            if(shortChar != longChar) {
                if(oneOffAllowed) {
                    oneOffAllowed = false;
                } else {
                    return false;
                }
                if(shortStr.length() == longStr.length()) {
                    shortIdx += 1;
                } 
            } else {
                shortIdx += 1;
            }
            longIdx += 1;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(OneAway.isOneAway("pale", "ple"));
        System.out.println(OneAway.isOneAway("pales", "pale"));
        System.out.println(OneAway.isOneAway("pale", "bale"));
        System.out.println(OneAway.isOneAway("pale", "bake"));
    }
}