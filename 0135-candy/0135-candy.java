class Solution {
    public int candy(int[] ratings) {
      int n = ratings.length;
      int[] candys = new int[n];

      for(int i=0; i<n; i++) {
        candys[i] = 1;
      }

      for(int i =1; i<n; i++) {
        if(ratings[i-1] < ratings[i]) {
            candys[i] = candys[i-1] + 1;
        }
      }

      for(int i = n - 2; i>=0; i--) {
        if(ratings[i] > ratings[i+1]) {
            if (candys[i] < candys[i+1] + 1) {
                candys[i] = candys[i+1] + 1;
            }
        }
      }

      int ans = 0;
      for(int candy : candys) {
        ans += candy;
      }

      return ans;
    }
}