class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int a = word1.length();
        int b = word2.length();

        while(a > 0 && b > 0){
            res += word1.charAt(word1.length() - a);
            res += word2.charAt(word2.length() - b);
            --a;
            --b;
        }

        while(a > 0){
            res += word1.charAt(word1.length() - a);
            --a;
        }
        while(b > 0){
            res += word2.charAt(word2.length() - b);
            --b;
        }

        return res;
    }
}