package com.tss.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.tss.entities.Board;
import com.tss.entities.Game;
import com.tss.entities.Player;
import com.tss.enumm.GameStatus;
import com.tss.exception.CellOccupiedException;
import com.tss.exception.InvalidPositionException;

import javax.security.auth.login.CredentialException;

public class GameService
{
    public void startGame(Game game, Scanner scanner)
    {
        while (game.getGameStatus() == GameStatus.IN_PROGRESS)
        {
            game.getBoard().printBoard();
            Player currentPlayer = game.getCurrentPlayer();
            char symbol = currentPlayer.getSymbol();
            System.out.println(currentPlayer.getNameOfPlayer() + "'s Turn");

            try
            {
                System.out.print("Enter Row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Enter Column (0-2): ");
                int column = scanner.nextInt();
                validateMove(game, row, column);
                game.getBoard().placeMark(row, column, symbol);

                if (checkWinner(game))
                {
                    handleWinner(game, currentPlayer);
                    continue;
                }
                if (isBoardFull(game))
                {
                    handleDraw(game);
                    continue;
                }
                game.switchPlayer();
            }
            catch (InvalidPositionException | CellOccupiedException exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Please Enter Numbers Only!");
                scanner.nextLine();
            }
        }
    }

    private void validateMove(Game game, int row, int column)
    {
        if (row < 0 || row >= Board.size || column < 0 || column >= Board.size)
        {
            throw new InvalidPositionException("Invalid Position!");
        }
        if (game.getBoard().getCell(row, column) != Board.empty_cell)
        {
            throw new CellOccupiedException("Cell Already Occupied!");
        }
    }


    private boolean checkWinner(Game game)
    {
        Player currentPlayer = game.getCurrentPlayer();
        char symbol = currentPlayer.getSymbol();
        Board board = game.getBoard();

        for (int row = 0; row < Board.size; row++)
        {
            if (board.getCell(row, 0) == symbol && board.getCell(row, 1) == symbol && board.getCell(row, 2) == symbol)
            {
                return true;   //row wise checking
            }
        }

        for (int column = 0; column < Board.size; column++)
        {
            if (board.getCell(0, column) == symbol && board.getCell(1, column) == symbol && board.getCell(2, column) == symbol)
            {
                return true;  //column wise checking
            }
        }

        if (board.getCell(0, 0) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 2) == symbol)
        {
            return true;
        }

        if (board.getCell(0, 2) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 0) == symbol)
        {
            return true;
        }

        return false;
    }

    private boolean isBoardFull(Game game)
    {
        Board board = game.getBoard();

        for (int row = 0; row < Board.size; row++)
        {
            for (int column = 0; column < Board.size; column++)
            {
                if (board.getCell(row, column) == Board.empty_cell)
                {
                    return false;
                }
            }
        }
        return true;
    }


    private void handleWinner(Game game, Player currentPlayer)
    {
        game.getBoard().printBoard();
        System.out.println(currentPlayer.getNameOfPlayer() + " Wins!");
        game.setGameStatus(GameStatus.WIN);
    }

    private void handleDraw(Game game)
    {
        game.getBoard().printBoard();
        System.out.println("Game Draw!");
        game.setGameStatus(GameStatus.DRAW);
    }
}