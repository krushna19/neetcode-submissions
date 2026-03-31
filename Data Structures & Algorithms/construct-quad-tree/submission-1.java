/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return help(grid,grid.length,0,0);
    }
    private Node help(int[][] grid,int n,int r,int c){
        boolean isAllSame = true;
        int current = grid[r][c];
        
        for(int i = r; i < r+n; i++){
            for(int j = c; j < c+n; j++){
                if(current != grid[i][j]){
                    isAllSame = false;
                    break;
                }
            }
        }
        if(isAllSame){
            return new Node(current == 1,true);
        }
        Node tf = help(grid,n/2,r,c);
        Node tr = help(grid,n/2,r,c+n/2);
        Node bl = help(grid,n/2,r+n/2,c);
        Node br = help(grid,n/2,r+n/2,c+n/2);
        return new Node(false,false,tf,tr,bl,br);
    }
}