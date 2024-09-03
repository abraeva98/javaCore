public class OneAway{
    private static boolean isOneAway(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        boolean oneOffAllowed = true;
        int len = Math.min(str1.length(), str2.length());
        int i2 = 0;
        for(int i = 0; i < len; i ++) {
            char letter1 = str1.charAt(i);
            char letter2 = str2.charAt(i2);
            if(letter1 != letter2) {
                if(oneOffAllowed) {
                    if(i + 1 < len) {
                        if(str1.charAt(i + 1) == letter2) {
                            i += 1;
                        } else if(str2.charAt(i2 + 1) == letter2) {
                            i2 += 1;
                        } else if(str2.charAt(i2 + 1) == str1.charAt(i + 1)) {
                            i += 1;
                            i2 += 1;
                        }
                        else {
                            return false;
                        }
                    }
                    oneOffAllowed = false;
                } else {
                    return false;
                }
            }
            i2 += 1;
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