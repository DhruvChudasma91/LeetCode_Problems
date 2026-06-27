class Solution {
    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(matrix[i][j] == '1') {
                    height[j]++; 
                } else {
                    height[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, findMaxArea(height));
        }

        return maxArea;
    }

    public int findMaxArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);


        for (int i = 0; i < newHeights.length; i++) {

            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {

                int height = newHeights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}