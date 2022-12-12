package com.StackAccount;

public class Account {
    private static double balance = 120385.57;
    public static double getBalance() {
        return balance;
    }
    public static void setBalance(double currentBalance) {
        Account.balance = currentBalance;
    }

    public static void credit(double value)
    {
        double Amountbalance = balance + value;
        setBalance(Amountbalance);
        System.out.println("Amount Credited Successfully");
        viewBalance();

    }
    public static boolean debit(double value)
    {
        if (value <= 0)
        {
            System.out.println(" Enter Valid Amount");
        }
        else if (value > balance)
        {
            System.out.println("Insufficient Balance");
            return false;
        }
        else
        {
            System.out.println("amount debited successfully");
            double Amountbalance = balance - value;
            setBalance(Amountbalance);
            viewBalance();
        }
        return true;
    }
    public static void viewBalance()
    {
        System.out.println("\nCurrent Balance is : " + balance);
    }
}
