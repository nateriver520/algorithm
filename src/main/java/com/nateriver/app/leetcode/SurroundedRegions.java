package com.nateriver.app.leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/surrounded-regions/
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class SurroundedRegions {
    class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Stack<Point> s = new Stack<>();

    public void solve(char[][] board) {
        if(board == null || board.length <=2) return;

        int i =0, j =0;
        for(; j < board[0].length; j++)
            mark(board,i,j);
        j--;

        for(; i < board.length; i++)
            mark(board,i,j);
        i--;

        for(;j>=0;j--)
            mark(board,i,j);
        j++;

        for(;i>=0;i--)
            mark(board,i,j);

        while (!s.isEmpty()){
            Point p = s.pop();
            travel(board,p,1,0);
            travel(board,p,-1,0);
            travel(board,p,0,1);
            travel(board,p,0,-1);
        }

        //use '$' to mark the point should keep O
        for(i =0 ; i < board.length; i++){
            for(j=0; j< board[1].length; j ++){
                if(board[i][j] == '$')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }

    }

    public void travel(char[][] board, Point p, int offsetX, int offsetY){
        int x = p.x + offsetX;
        int y = p.y + offsetY;
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length -1) return;
        mark(board,x,y);
    }

    public void mark(char[][] board, int x, int y){
        if(board[x][y] == 'O'){
            board[x][y] = '$';
            s.push(new Point(x,y));
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = new char[][]{
                { 'X', 'X' , 'X' , 'X'},
                { 'X', 'O' , 'O' , 'X'},
                { 'X', 'X' , 'O' , 'X'},
                { 'X', 'O' , 'X' , 'X'},
        };

        sr.solve(board);
    }
}

