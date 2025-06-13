class Solution {
    public int countGoodNumbers(long n) {
        
        long mod = 1000000007;
            
        long oddPower = n / 2;
        long evenPower = (n + 1) / 2;

        long oddPart = findPower(4, oddPower, mod);
        long evenPart = findPower(5, evenPower, mod);

        return (int) ((oddPart * evenPart) % mod);
    }

    public long findPower(long base, long expo, long mod) {

        long result = 1;
        base = base % mod;

        while(expo > 0) {

            if((expo & 1) == 1) {

                result = (result * base) % mod;
            } 

            base = (base * base) % mod;
            expo = expo >> 1;
        }

        return result;
    }
}