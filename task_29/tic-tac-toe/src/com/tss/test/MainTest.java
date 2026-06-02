package com.tss.test;

import java.util.Scanner;
import com.tss.entities.Board;
import com.tss.entities.Game;
import com.tss.entities.Player;
import com.tss.enumm.MarkType;
import com.tss.service.GameService;

public class MainTest
{
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("Enter Player-1 Name (X) : ");
            String nameOfPlayer1 = scanner.nextLine();
            System.out.println("Enter Player-2 Name (O) : ");
            String nameOfPlayer2 = scanner.nextLine();
            Player player1 = new Player(nameOfPlayer1, MarkType.X);
            Player player2 = new Player(nameOfPlayer2, MarkType.O);
            Board board = new Board();
            Game game = new Game(board, player1, player2);
            GameService gameService = new GameService();
            gameService.startGame(game, scanner);
        }
    }
}