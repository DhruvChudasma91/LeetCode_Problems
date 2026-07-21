class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();

        int totalOnes = 0;
        int prevSegment = Integer.MIN_VALUE;
        int maxSegment = 0;

        int l = 0;
        while(l < n) {

            int r = l + 1;

            while(r < n && s.charAt(l) == s.charAt(r)) {
                r++;
            } 

            int currSegment = r - l;

            if(s.charAt(l) == '1') {
                totalOnes += currSegment;
            } else {

                maxSegment = Math.max(maxSegment, prevSegment + currSegment);
                prevSegment = currSegment;
            }

            l = r;
        }

        return maxSegment + totalOnes;
    }
}