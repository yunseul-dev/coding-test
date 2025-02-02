class Solution {
    public String solution(String polynomial) {
        String answer = "";

        String[] words = polynomial.split(" ");
        int str = 0; 
        int num = 0; 

        for (int i = 0; i < words.length; i++) {
            if (words[i].contains("x")) {
                String number = words[i].replaceAll("[^0-9]", ""); 
                str += number.isEmpty() ? 1 : Integer.parseInt(number);
            } else if (!words[i].equals("+")) { 
                num += Integer.parseInt(words[i]);
            }
        }

        if (str > 0 && num > 0) {
            answer = (str == 1 ? "" : str) + "x + " + num;
        } else if (str > 0) {
            answer = (str == 1 ? "" : str) + "x";
        } else {
            answer = String.valueOf(num);
        }

        return answer;
    }
}
