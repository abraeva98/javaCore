public class URLify {
    public static char[] replaceSpaces(char[] input, int n){
        int moveIdx = input.length - 1;
        for(int currIdx = n - 1; currIdx >= 0; currIdx --) {
            if(input[currIdx] != ' ') {
                input[moveIdx] = input[currIdx];
                moveIdx -= 1;
            } else {
                input[moveIdx] = '0';
                input[moveIdx - 1] = '2';
                input[moveIdx - 2] = '%';
                moveIdx -= 3;
            }
        }
        return input;
    }
    public static void main(String[] args) {
        char[] input = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'J', 'r', ' ', ' ', ' ', ' '};
        System.out.println(URLify.replaceSpaces(input, 10));;
    }
}