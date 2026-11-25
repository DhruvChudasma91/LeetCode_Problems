class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        for(int i = 1; i < numRows; i++) {

            List<Integer> prevRow = ans.get(i-1);
            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);

            for(int j = 1; j < prevRow.size(); j++) {
                int sum = prevRow.get(j-1) + prevRow.get(j);
                currRow.add(sum);
            }

            currRow.add(1);

            ans.add(currRow);
        }

        return ans;


        /**

        ans = [[1]]
           2^0 = 1 -> [1]
           2^1 = 2 -> [1, 1]
           2^2 = 4 -> [1, 2, 1]
           2^3 = 8 -> [1, 3, 3, 1]
           2^4 = 16 -> [1, 4, 6, 4, 1]
           2^5 = 32 -> [1, 5, 10, 10, 5, 1]
        
         */
    }
}