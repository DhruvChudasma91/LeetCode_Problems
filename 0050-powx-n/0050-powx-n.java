class Solution {
    public double myPow(double x, int n) {
        
        long binaryForm = n;
        if(n < 0) {
            x = (1 / x);
            binaryForm *= (-1); 
        }

        double pow = 1;
        while(binaryForm > 0) {

            if(binaryForm % 2 == 1) {
                pow *= x;
            }

            x *= x;
            binaryForm /= 2;
        }

        return pow;
    }
}
