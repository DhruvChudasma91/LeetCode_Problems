class Solution {
    public int minOperations(String s) {
        
        int n = s.length();

        int countZero = 0;
        int countOne = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(i % 2 == 0) {

                if(ch != '0') countZero++;
                if(ch != '1') countOne++;

            } else {

                if(ch != '1') countZero++;
                if(ch != '0') countOne++;
            }
        }

        return Math.min(countZero, countOne);
    }
}