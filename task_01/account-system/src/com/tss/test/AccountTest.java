package com.tss.test;

import com.tss.accountController.AccountController;
import com.tss.exception.AccountNotFoundException;
import com.tss.exception.InsufficientBalanceException;
import com.tss.exception.InvalidAmountException;
import com.tss.service.AccountService;
import com.tss.view.AccountMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AccountMenu accountMenu = new AccountMenu();
        AccountController accountController = new AccountController();

        while (true) {

            accountMenu.displayMenu();
            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();

            try {

                switch (choice) {

                    case 1 -> accountController.createAccount(scanner);
                    case 2 -> accountController.showAccount(scanner);
                    case 3 -> accountController.showTransactions(scanner);
                    case 4 -> accountController.deposit(scanner);
                    case 5 -> accountController.withdraw(scanner);
                    case 6 -> accountController.showTotalAccounts();
                    case 7 ->
                    {
                        System.out.println("Exit");
                        return;
                    }

                    default -> System.out.println("Invalid Choice");
                }

            }
            catch (InvalidAmountException | InsufficientBalanceException | AccountNotFoundException exception)
            {
                System.out.println("Exception: " + exception.getMessage());
            }
        }
    }
}