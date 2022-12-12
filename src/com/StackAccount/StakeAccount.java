package com.StackAccount;

import java.util.Scanner;

public class StakeAccount {
    public static void main(String[] args) {
        System.out.println("\n******************* Welcome To Stock Management System ***********************************");
        StockManagementOperation();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPress Y to continue");
        String next = sc.next();
        if (next.equalsIgnoreCase("Y"))
        {
            StockManagementOperation();
        }
    }
    public static void StockManagementOperation() {
        Scanner sc = new Scanner(System.in);
        StokeOperation stockOperation = new StokeOperation();

        while (true) {
            System.out.println("\n1. For Buy Share" );
            System.out.println( "2.For Sell Share");
            System.out.println( "3 Credit amount");
            System.out.println( "4. Debit amount");
            System.out.println( "5. Check Balance");
            System.out.println( "6. View Stock Data");
            System.out.println("7. Exit");
            System.out.println("\nEnter your choice : ");
            int input = sc.nextInt();
            String symbol;
            switch (input) {
                case 1:
                    System.out.println("Buying Shares:");
                    System.out.println("Enter the stock symbol  : ");
                    symbol = sc.next();
                    System.out.println("Enter total amount for buy shares");
                    int moneyAmount = sc.nextInt();
                    stockOperation.buy(moneyAmount, symbol);
                    break;

                case 2:
                    System.out.println("Selling Shares:");
                    System.out.println("Enter stock symbol to sell : ");
                    symbol = sc.next();
                    System.out.println("Enter value of share for sell : ");
                    moneyAmount = sc.nextInt();
                    stockOperation.sell(moneyAmount, symbol);
                    break;

                case 3:
                    System.out.println("Credit Amount");
                    System.out.println("Enter amount for credit in account : ");
                    moneyAmount = sc.nextInt();
                    Account.credit(moneyAmount);
                    System.out.println("Thanking you");
                    break;

                case 4:
                    System.out.println("Debit Amount");
                    System.out.println("Enter amount to Debit from account :");
                    moneyAmount = sc.nextInt();
                    Account.debit(moneyAmount);
                    System.out.println("Thanking you ");
                    break;

                case 5:
                    stockOperation.valueOf();
                    break;

                case 6:
                    stockOperation.printStockData();
                    break;

                case 7:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Enter input between 1 - 7");
            }
            break;
        }

    }
}
