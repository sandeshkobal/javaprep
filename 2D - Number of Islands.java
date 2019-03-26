https://leetcode.com/problems/number-of-islands/
1 is land and 0 is water 

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
// I have used another grid to track visited which I dint need and I could just modify original grid

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length ==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' ){
                    traverse(grid,i,j);
                    count++; 
                }
            }
        }
        return count;
    }
    
    void traverse(char[][] grid, int m,int n){
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        if(m<0 || n <0 || m>=grid.length || n >=grid[0].length || grid[m][n] == '0')
            return;
        grid[m][n]='0';
        for(int[] dir1 : dir){
            traverse(grid,m+dir1[0],n+dir1[1]);
        }
    }
}