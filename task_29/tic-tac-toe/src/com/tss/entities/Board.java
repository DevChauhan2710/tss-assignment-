package com.tss.entities;

public class Board
{
    public final char[][] board;
    public static final int size = 3;
    public static final char empty_cell = '-';


    public Board()
    {
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                board[row][column] = empty_cell;
            }
        }
    }


    public void placeMark(int row,int column,char symbol)
    {
        board[row][column] = symbol;
    }


    public char getCell(int row,int column)
    {
        return board[row][column];
    }


    public void printBoard()
    {
        System.out.println();

        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}