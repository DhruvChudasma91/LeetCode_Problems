class Solution {
    static{
        int[][] a = new int[1][2];
        a[0][0]=1;
        a[0][1]=2;
        for(int i=0; i<501; i++){
            findJudge(2,a);
        }
    }
    public static int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] count = new int[n+1];

        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int i = 1; i<= n; i++){
            if(count[i] == n-1) return i;
        }

        return -1;
    }
}