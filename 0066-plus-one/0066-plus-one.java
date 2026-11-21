class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int[] ans = digits;
        boolean isInc = false;

        for(int i = n - 1; i >= 0; i--) {

            if(ans[i] == 9) {
                ans[i] = 0;
                continue;
            } else {
                ans[i]++;
                isInc = true;
                break;
            }
        }

        if(isInc) return ans;

        int[] finalAns = new int[n+1];
        finalAns[0] = 1;
        
        return finalAns;
    }
}