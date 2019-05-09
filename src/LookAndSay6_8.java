public class LookAndSay6_8 {

    //1 11 21 1211 111221

    public static String lookAndSay(String n) {
        int bound = Integer.parseInt(n);

        StringBuilder currStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();
        currStr.append('1');

        for (int i = 0; i < bound; i++) {
            int count = 1;
            char currChar = currStr.charAt(0);
            for(int j = 1; j < currStr.length(); j++) {
                if (currStr.charAt(j) != currChar) { //if different character
                    tempStr.append(count);
                    tempStr.append(currChar);
                    count = 1;
                    currChar = currStr.charAt(j);
                } else { //if same character; increment count
                    count++;
                }
            }
            //add last character
            tempStr.append(count);
            tempStr.append(currChar);

            currStr = tempStr;
            tempStr = new StringBuilder();
        }
        return currStr.toString();
    }

    public static void main(String[] args) {
        //1 11 21 1211 111221
        String inputStr = "5";
        System.out.println(lookAndSay(inputStr));
    }
}
