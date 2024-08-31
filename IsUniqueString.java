import java.util.HashSet;

public class IsUniqueString{
    public boolean checkIfUnique(String str){
        if(str.length() > 128){
            return false;
        }
        HashSet<Character> uniqueChar = new HashSet<Character>();
        for(int i = 0; i < str.length(); i ++){
            Character c = str.charAt(i);
            System.out.println((int)str.charAt(i)); // returns ASCII code
            if(uniqueChar.contains(c)){
                return false;
            } else {
                uniqueChar.add(c);
            }
        }
        return true;
    }
    public static void main(String[] args){
        IsUniqueString checkString = new IsUniqueString();
        System.out.println(checkString.checkIfUnique("abcdt"));
        System.out.println(checkString.checkIfUnique("aaaaa"));
        System.out.println(checkString.checkIfUnique(""));
    }
}